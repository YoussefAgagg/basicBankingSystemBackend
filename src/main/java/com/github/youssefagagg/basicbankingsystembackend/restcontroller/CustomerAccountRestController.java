package com.github.youssefagagg.basicbankingsystembackend.restcontroller;

import com.github.youssefagagg.basicbankingsystembackend.exception.CustomerAccountNotFoundException;
import com.github.youssefagagg.basicbankingsystembackend.model.CustomerAccount;
import com.github.youssefagagg.basicbankingsystembackend.service.CustomerAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class CustomerAccountRestController {
    private final CustomerAccountService customerAccountService;

    public CustomerAccountRestController(CustomerAccountService customerAccountService) {
        this.customerAccountService = customerAccountService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<CustomerAccount>> getAllEmployees () {
        List<CustomerAccount> customerAccounts =customerAccountService.getAllCustomers();
        return new ResponseEntity<>(customerAccounts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerAccount> getEmployeeById (@PathVariable("id") Integer id) throws CustomerAccountNotFoundException {
        CustomerAccount customerAccount=customerAccountService.getCustomerAccount(id);
        return new ResponseEntity<>(customerAccount, HttpStatus.OK);
    }

}
