package com.github.youssefagagg.basicbankingsystembackend.service;

import com.github.youssefagagg.basicbankingsystembackend.exception.CustomerAccountNotFoundException;
import com.github.youssefagagg.basicbankingsystembackend.model.CustomerAccount;
import com.github.youssefagagg.basicbankingsystembackend.repository.CustomerAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerAccountService {
    private CustomerAccountRepository customerAccountRepository;
    @Autowired
    public void setCustomerAccountRepository(CustomerAccountRepository customerAccountRepository) {
        this.customerAccountRepository = customerAccountRepository;
    }
    public List<CustomerAccount> getAllCustomers(){
        return  customerAccountRepository.findAllByOrderByIdAsc();
    }
    public CustomerAccount getCustomerAccount(int id) throws CustomerAccountNotFoundException {
        return customerAccountRepository.findCustomerAccountById(id)
                .orElseThrow(() -> new CustomerAccountNotFoundException("Customer by id " + id + " was not found"));
    }
    public CustomerAccount updateCustomerAccount(CustomerAccount customerAccount){
       return customerAccountRepository.save(customerAccount);
    }
}
