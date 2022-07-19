package com.rgurgen.customermanagement.model.payment;


import com.rgurgen.customermanagement.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "payment")
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal totalAmount;


    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "payment",
            cascade = CascadeType.ALL)
    private List<PaymentItem> items;

}
