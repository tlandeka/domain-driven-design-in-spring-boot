package com.example.excercise.application.payment.builder;

import com.example.excercise.application.payment.dto.request.Attributes;
import com.example.excercise.application.payment.dto.request.ChargesInformation;
import com.example.excercise.application.payment.dto.request.CreatePayment;
import com.example.excercise.application.payment.dto.request.UpdatePayment;
import com.example.excercise.domain.model.payment.Account;
import com.example.excercise.domain.model.payment.Payment;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@Accessors(chain = true)
public class PaymentBuilder {
    UpdatePayment updatePayment;
    Account accountBeneficier;
    Account accountDebtor;
    Account accountSponsor;
    CreatePayment createPayment;
    String paymentId;
    Payment payment;

    public PaymentBuilder() {
    }

    public PaymentBuilder buildOnCreate(){
        Attributes attributes = createPayment.getAttributes();
        ChargesInformation chargesInformation = attributes.getChargesInformation();

        this.payment = new Payment(paymentId, createPayment.getType(), createPayment.getVersion(), createPayment.getOrganisationId(), attributes.getAmountAsDouble(),
                attributes.getCurrency(), attributes.getEndToEndReference(), attributes.getNumericReference(), attributes.getReference(), attributes.getPaymentId(),
                attributes.getPaymentPurpose(), attributes.getPaymentScheme(), attributes.getPaymentType(), attributes.getProcesingDateAsDate(),
                attributes.getSchemePaymentSubType(), attributes.getSchemePaymentType(), attributes.getFx().getContractReference(), attributes.getFx().getExchangeRateAsDouble(),
                attributes.getFx().getOriginalCurrency(), accountBeneficier, accountDebtor, accountSponsor, attributes.getChargesInformation().getBearerCode(),
                chargesInformation.getSenderCharge(attributes.getCurrency()).getAmountAsDouble(), chargesInformation.getReceiverChargesAmountAsDouble());

        return this;
    }

    public PaymentBuilder buildOnUpdate(){
        if (updatePayment.getCurrency() != null) {
            payment.updateCurrency(updatePayment.getCurrency());
        }

        if (updatePayment.getPaymentScheme() != null) {
            payment.updatePaymentScheme(updatePayment.getPaymentScheme());
        }

        if (updatePayment.getPaymentType() != null) {
            payment.updateType(updatePayment.getPaymentType());
        }

        return this;
    }

}
