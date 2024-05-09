package by.kiok.currency.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeRate extends BaseEntity {

    private Currency initial;
    private int initialAmount;
    private Currency concluding;
    private int concludingAmount;
    private double rate;
}
