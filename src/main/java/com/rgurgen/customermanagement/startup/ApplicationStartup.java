package com.rgurgen.customermanagement.startup;

import com.rgurgen.customermanagement.enums.PaymentStatus;
import com.rgurgen.customermanagement.model.payment.CreditCardPaymentItem;
import com.rgurgen.customermanagement.model.payment.Payment;
import com.rgurgen.customermanagement.model.payment.PaymentItem;
import com.rgurgen.customermanagement.model.payment.WorldPayPaymentItem;
import com.rgurgen.customermanagement.repos.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationStartup implements CommandLineRunner {

    private final PaymentRepository paymentRepository;

    public ApplicationStartup(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Payment payment=new Payment();
        payment.setTotalAmount(new BigDecimal(200.00));

        List<PaymentItem> items=new ArrayList<>();

        CreditCardPaymentItem creditCardPaymentItem=new CreditCardPaymentItem();
        creditCardPaymentItem.setMaskedCardNumber("45265****262525");
        creditCardPaymentItem.setCvv("526");
        creditCardPaymentItem.setExpirationDate("02/26");
        creditCardPaymentItem.setAmount(new BigDecimal(100).setScale(2));
        creditCardPaymentItem.setPayment(payment);
        items.add(creditCardPaymentItem);


        WorldPayPaymentItem worldPayPaymentItem=new WorldPayPaymentItem();
        worldPayPaymentItem.setMaskedCardNumber("45265****262525");
        worldPayPaymentItem.setCvv("526");
        worldPayPaymentItem.setExpirationDate("02/26");
        worldPayPaymentItem.setAmount(new BigDecimal(100).setScale(2));
        worldPayPaymentItem.setQrCode("YKB-65546");
        worldPayPaymentItem.setStatus(PaymentStatus.SUCCESS);
        worldPayPaymentItem.setPayment(payment);
        items.add(worldPayPaymentItem);

        payment.setItems(items);

        this.paymentRepository.save(payment);
    }
}
