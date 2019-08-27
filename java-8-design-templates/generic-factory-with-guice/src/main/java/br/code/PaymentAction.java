package br.code;

import com.google.inject.Inject;

import java.util.Date;

public class PaymentAction {

    @Inject
    private PaymentFactory paymentFactory;

    public void doPayment(Double amount) {
        Payment payment = this.paymentFactory.create(new Date(), amount);
        payment.apply();
    }



}
