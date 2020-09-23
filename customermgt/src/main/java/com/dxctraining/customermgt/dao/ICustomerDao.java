package com.dxctraining.customermgt.dao;


import com.dxctraining.customermgt.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerDao extends JpaRepository<Customer,Integer> {


}
