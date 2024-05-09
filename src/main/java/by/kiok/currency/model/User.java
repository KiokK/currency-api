package by.kiok.currency.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseEntity {

    private String username;
    private String password;
}
