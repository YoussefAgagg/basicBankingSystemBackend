package com.github.youssefagagg.basicbankingsystembackend.service;

import com.github.youssefagagg.basicbankingsystembackend.model.TransferMoney;
import com.github.youssefagagg.basicbankingsystembackend.repository.TransferMoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TransferMoneyService {
    private final TransferMoneyRepository transferMoneyRepository;
    @Autowired
    public TransferMoneyService(TransferMoneyRepository transferMoneyRepository) {
        this.transferMoneyRepository = transferMoneyRepository;
    }


    public void addTransferMoneyOperation(TransferMoney transferMoney){
        transferMoneyRepository.save(transferMoney);
    }
}
