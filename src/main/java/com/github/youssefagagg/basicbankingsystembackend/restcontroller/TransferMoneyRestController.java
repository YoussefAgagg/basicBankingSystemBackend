package com.github.youssefagagg.basicbankingsystembackend.restcontroller;

import com.github.youssefagagg.basicbankingsystembackend.exception.AmountMoneyTransferException;
import com.github.youssefagagg.basicbankingsystembackend.exception.CustomerAccountNotFoundException;
import com.github.youssefagagg.basicbankingsystembackend.model.TransferMoney;
import com.github.youssefagagg.basicbankingsystembackend.service.TransferMoneyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferMoneyRestController {
    private final TransferMoneyService transferMoneyService;

    public TransferMoneyRestController(TransferMoneyService transferMoneyService) {
        this.transferMoneyService = transferMoneyService;
    }


    @PostMapping
    public ResponseEntity<?> addTransferMoneyOperation(@RequestBody TransferMoney transferMoney) throws CustomerAccountNotFoundException, AmountMoneyTransferException {
        System.out.println(transferMoney);
        transferMoneyService.addTransferMoneyOperation(transferMoney);
        return new ResponseEntity<>("transfer performed successfully", HttpStatus.OK);

    }
}
