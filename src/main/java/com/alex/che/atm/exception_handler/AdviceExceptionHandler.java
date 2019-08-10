package com.alex.che.atm.exception_handler;

import com.alex.che.atm.exception.ThereIsNoSuchCardException;
import com.alex.che.atm.exception.WrongPinException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AdviceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ThereIsNoSuchCardException.class)
    protected ResponseEntity<ThereIsNoSuchCardException> handleThereIsNoSuchUserException() {
        return new ResponseEntity<>(new ThereIsNoSuchCardException("There is no such card"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WrongPinException.class)
    protected ResponseEntity<WrongPinException> handleWrongPinException(WrongPinException e) {
        return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }
}
