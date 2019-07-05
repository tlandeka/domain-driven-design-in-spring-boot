package com.example.excercise.testdatafactory.application.payment.dto;

import com.example.excercise.application.payment.dto.request.CreatePayment;
import com.example.excercise.application.payment.dto.request.UpdatePayment;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class TestData {
    public static List<CreatePayment> getCreatePaymentDto() throws IOException {
       return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).
                readValue(CreatePayment.class.getResourceAsStream("/CreatePaymentDTOs.json"),
                        new TypeReference<List<CreatePayment>>(){});
    }

    public static UpdatePayment getUpdatePaymentDto(){
        UpdatePayment updatePayment = new UpdatePayment();
        updatePayment.setPaymentScheme("SWIFT");
        updatePayment.setCurrency("USD");
        updatePayment.setPaymentType("TestPayment");
        return updatePayment;
    }
}
