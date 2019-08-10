package com.alex.che.atm.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Out of balance")
public class OutOfBalanceException extends RuntimeException {
    private String message;
}
