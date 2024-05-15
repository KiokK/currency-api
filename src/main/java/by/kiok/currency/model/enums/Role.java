package by.kiok.currency.model.enums;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.List;

@Getter
public enum Role {

    ADMIN(Arrays.stream(AuthorityRights.values())
            .map(AuthorityRights::getGrantedAuthority)
            .toList()
    ),
    USER(List.of(
            AuthorityRights.CURRENCY_READ.getGrantedAuthority(),
            AuthorityRights.EXCHANGE_RATES_READ.getGrantedAuthority())
    );

    private final List<GrantedAuthority> authorities;

    Role(List<GrantedAuthority> grantedAuthorities) {
        this.authorities = grantedAuthorities;
    }
}
