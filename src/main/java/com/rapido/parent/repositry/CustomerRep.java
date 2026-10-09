package com.rapido.parent.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rapido.parent.entity.Customer;

@Repository
public interface CustomerRep extends JpaRepository<Customer, Integer>{

}
