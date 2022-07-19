package com.rgurgen.customermanagement.model.payment;


import com.rgurgen.customermanagement.enums.PaymentType;
import com.rgurgen.customermanagement.model.payment.Payment;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
//@DiscriminatorColumn(name = "type",discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue("CREDIT_CARD")
@Getter
@Setter
public class CreditCardPaymentItem extends PaymentItem {

    private String maskedCardNumber;

    private String cvv;

    private String expirationDate;//06/26

    public CreditCardPaymentItem(){
        this.setType(PaymentType.CREDIT_CARD);
    }



}
