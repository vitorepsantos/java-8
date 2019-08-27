package br.code;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Client {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BasicModule());
        PaymentAction paymentAction = injector.getInstance(PaymentAction.class);
        paymentAction.doPayment(200.0);
    }

}
