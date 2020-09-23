package com.dxctraining.customermgt.service;


import com.dxctraining.customermgt.entities.Customer;

import java.util.List;

public interface ICustomerService {

    Customer findById(int id);

    Customer save(Customer employee);

    void remove(int id);

    List<Customer> allUsers();

}
