package com.alex.che.atm.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "There is no such card")
public class ThereIsNoSuchCardException extends RuntimeException {
    private String message;
}
