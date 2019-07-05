package com.example.excercise.controller;

import com.example.excercise.application.payment.*;
import com.example.excercise.application.payment.dto.request.CreatePayment;
import com.example.excercise.application.payment.dto.request.UpdatePayment;
import com.example.excercise.application.payment.dto.response.PaymentDTO;
import com.example.excercise.domain.model.payment.Payment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/payments/{paymentId}")
public class PaymentController extends Controller{

    @Autowired
    private CreatePaymentService createPaymentService;

    @Autowired
    private DeletePaymentService deletePaymentService;

    @Autowired
    private ReadPaymentService readPaymentService;

    @Autowired
    private ReadAllPaymentsService readAllPaymentsService;

    @Autowired
    private UpdatePaymentService updatePaymentService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Get all payments
     *
     * @return The existing Payments
     */
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public List<PaymentDTO> getAllPayment(){
        //TODO add pagination, sorting,...
        Iterable<Payment> payments = this.readAllPaymentsService.execute();
        return StreamSupport.stream(payments.spliterator(), false).
                map(payment -> modelMapper.map(payment, PaymentDTO.class)).collect(Collectors.toList());
    }

    /**
     * Get a payment made by customer
     *
     * @param paymentId
     * @return The existing Payment
     */
    @RequestMapping(method = RequestMethod.GET)
    public PaymentDTO getPayment(@PathVariable(value = "paymentId") String paymentId){
        Payment payment = this.readPaymentService.execute(paymentId);
        PaymentDTO paymentDTO = modelMapper.map(payment, PaymentDTO.class);
        BeanUtils.copyProperties(paymentDTO, payment);
        return paymentDTO;
    }

    /**
     * Create a payment
     *
     * @param createPayment
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createPayment(@PathVariable(value = "paymentId") String paymentId, @RequestBody @Validated CreatePayment createPayment){
        createPaymentService.execute(createPayment, paymentId);
    }

    /**
     * Create a payment
     *
     * @param paymentId
     * @param updatePayment
     */
    @RequestMapping(method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePayment(@PathVariable(value = "paymentId") String paymentId, @RequestBody @Validated UpdatePayment updatePayment){
        updatePaymentService.execute(updatePayment, paymentId);
    }

    /**
     * Delete a payment made by customer
     *
     * @param paymentId
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "paymentId") String paymentId) {
        deletePaymentService.execute(paymentId);
    }
}
