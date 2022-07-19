package com.rgurgen.customermanagement.model.payment;

import com.rgurgen.customermanagement.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorColumn(name = "type")
//@DiscriminatorValue("BKM_EXPRESS")
@Getter
@Setter
public class BkmExpressPaymentItem extends CreditCardPaymentItem {

    private String bkmCode;

    public BkmExpressPaymentItem() {
        setType(PaymentType.BKM_EXPRESS);
    }
}
