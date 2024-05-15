package by.kiok.currency.model;

import by.kiok.currency.model.enums.Role;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=true)
public class User extends BaseEntity {

    private String username;
    private String password;
    private Role role;
}
