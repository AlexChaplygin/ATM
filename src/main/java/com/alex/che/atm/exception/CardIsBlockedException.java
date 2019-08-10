package com.alex.che.atm.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@EqualsAndHashCode(callSuper = true)
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Card is blocked")
public class CardIsBlockedException extends AuthenticationException {
    public CardIsBlockedException(String msg) {
        super(msg);
    }
}
