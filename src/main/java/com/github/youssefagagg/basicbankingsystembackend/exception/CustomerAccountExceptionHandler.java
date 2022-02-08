package com.github.youssefagagg.basicbankingsystembackend.exception;

import com.github.youssefagagg.basicbankingsystembackend.restcontroller.CustomerAccountRestController;
import com.github.youssefagagg.basicbankingsystembackend.restcontroller.TransferMoneyRestController;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice(assignableTypes = {CustomerAccountRestController.class, TransferMoneyRestController.class})
public class CustomerAccountExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerAccountNotFoundException.class)
    protected ResponseEntity<Object> handelCustomerAccountIdNotFound(CustomerAccountNotFoundException ex) {
          return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AmountMoneyTransferException.class)
    protected ResponseEntity<Object> handelTransferAmountMoneyException(AmountMoneyTransferException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}