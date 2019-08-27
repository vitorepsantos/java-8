package br.code;

import java.util.Date;

public interface PaymentFactory {

    Payment create(Date startDate, Double amount);

}
