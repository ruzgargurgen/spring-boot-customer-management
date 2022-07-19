package com.rgurgen.customermanagement.model.payment;


import com.rgurgen.customermanagement.enums.PaymentStatus;
import com.rgurgen.customermanagement.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class PaymentItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    private PaymentType type=PaymentType.CREDIT_CARD;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status= PaymentStatus.PENDING;

    private String orderId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id",referencedColumnName = "id")
    private Payment payment;



}
