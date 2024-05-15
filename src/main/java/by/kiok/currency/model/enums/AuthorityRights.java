package by.kiok.currency.model.enums;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Getter
public enum AuthorityRights {

    CURRENCY_READ(new SimpleGrantedAuthority("currency:read")),
    CURRENCY_MODIFY(new SimpleGrantedAuthority("currency:modify")),
    EXCHANGE_RATES_READ(new SimpleGrantedAuthority("exchangeRates:read")),
    EXCHANGE_RATES_MODIFY(new SimpleGrantedAuthority("exchangeRates:modify"));

    private final GrantedAuthority grantedAuthority;

    AuthorityRights(GrantedAuthority grantedAuthority) {
        this.grantedAuthority = grantedAuthority;
    }
}
