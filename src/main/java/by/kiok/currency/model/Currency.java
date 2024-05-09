package by.kiok.currency.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Currency extends BaseEntity{

    private String title;
    private String moneySign;
}
