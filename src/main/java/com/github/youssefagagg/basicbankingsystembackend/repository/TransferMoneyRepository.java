package com.github.youssefagagg.basicbankingsystembackend.repository;

import com.github.youssefagagg.basicbankingsystembackend.model.TransferMoney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferMoneyRepository extends JpaRepository<TransferMoney,Integer> {
}
