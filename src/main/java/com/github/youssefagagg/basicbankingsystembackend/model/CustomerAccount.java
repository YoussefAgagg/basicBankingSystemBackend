package com.github.youssefagagg.basicbankingsystembackend.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "customeraccount")
public class CustomerAccount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    private String email;
    private double balance;
    private Date birthdate;
    private String phone;

}
