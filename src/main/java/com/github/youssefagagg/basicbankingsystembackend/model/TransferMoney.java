package com.github.youssefagagg.basicbankingsystembackend.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "transfermoney")
public class TransferMoney implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "transferfrom")
    private int transferFrom;
    @Column(name = "transferto")
    private int transferTo;
    private double amount;
    @Column(name = "transferdate")
    private Date transferDate;

}
