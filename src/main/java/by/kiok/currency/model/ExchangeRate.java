package by.kiok.currency.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=true, exclude = {"concluding", "initial"})
public class ExchangeRate extends BaseEntity {

    private Currency initial;
    private int initialAmount;
    private Currency concluding;
    private int concludingAmount;
    private double rate;
}
