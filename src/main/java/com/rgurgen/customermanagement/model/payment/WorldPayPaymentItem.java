package com.rgurgen.customermanagement.model.payment;


import com.rgurgen.customermanagement.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorColumn(name = "type")
//@DiscriminatorValue("WORLD_PAY")
@Getter
@Setter
public class WorldPayPaymentItem extends CreditCardPaymentItem {

    private String qrCode;

   public WorldPayPaymentItem(){
        setType(PaymentType.WORLD_PAY);
    }


}
