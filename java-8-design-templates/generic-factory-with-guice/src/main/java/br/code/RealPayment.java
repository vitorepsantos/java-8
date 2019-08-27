package br.code;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

import java.util.Date;

public class RealPayment implements Payment {

    private Date startDate;

    private Double amount;

    @AssistedInject
    public RealPayment(@Assisted Date startDate, @Assisted Double amount) {
        this.startDate = startDate;
        this.amount = amount;
    }

    @Override
    public void apply() {
        System.out.println(this.startDate);
        System.out.println(this.amount);
    }
}
