package by.kiok.currency.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=true)
public class Currency extends BaseEntity{

    private String title;
    private String moneySign;
}
