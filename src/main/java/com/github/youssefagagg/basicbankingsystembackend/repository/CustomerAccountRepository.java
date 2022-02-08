package com.github.youssefagagg.basicbankingsystembackend.repository;

import com.github.youssefagagg.basicbankingsystembackend.model.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerAccountRepository extends JpaRepository<CustomerAccount,Integer> {
    Optional<CustomerAccount> findCustomerAccountById(Integer id);
}
