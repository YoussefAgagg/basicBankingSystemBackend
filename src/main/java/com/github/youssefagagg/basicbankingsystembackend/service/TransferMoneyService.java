package com.github.youssefagagg.basicbankingsystembackend.service;

import com.github.youssefagagg.basicbankingsystembackend.exception.AmountMoneyTransferException;
import com.github.youssefagagg.basicbankingsystembackend.exception.CustomerAccountNotFoundException;
import com.github.youssefagagg.basicbankingsystembackend.model.CustomerAccount;
import com.github.youssefagagg.basicbankingsystembackend.model.TransferMoney;
import com.github.youssefagagg.basicbankingsystembackend.repository.CustomerAccountRepository;
import com.github.youssefagagg.basicbankingsystembackend.repository.TransferMoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TransferMoneyService {
    private final TransferMoneyRepository transferMoneyRepository;
    private final CustomerAccountService customerAccountService;
    @Autowired
    public TransferMoneyService(TransferMoneyRepository transferMoneyRepository, CustomerAccountService customerAccountService) {
        this.transferMoneyRepository = transferMoneyRepository;
        this.customerAccountService = customerAccountService;

    }


    public void addTransferMoneyOperation(TransferMoney transferMoney) throws CustomerAccountNotFoundException, AmountMoneyTransferException {
        CustomerAccount from=customerAccountService.getCustomerAccount(transferMoney.getTransferFrom());
        CustomerAccount to=customerAccountService.getCustomerAccount(transferMoney.getTransferTo());
        if(from.getBalance()>=transferMoney.getAmount()){
            from.setBalance(from.getBalance()-transferMoney.getAmount());
            to.setBalance(to.getBalance()+transferMoney.getAmount());
            customerAccountService.updateCustomerAccount(from);
            customerAccountService.updateCustomerAccount(to);
            transferMoneyRepository.save(transferMoney);
        }else{
            throw new AmountMoneyTransferException("the amount of money to transfer should be less than :"+from.getBalance());
        }
    }
}
