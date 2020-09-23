package com.dxctraining.customermgt.service;

import com.dxctraining.customermgt.dao.ICustomerDao;
import com.dxctraining.customermgt.entities.Customer;
import com.dxctraining.customermgt.exceptions.InvalidArgumentException;
import com.dxctraining.customermgt.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// transactional will inform spring that it has to open transaction at every method in this class
@Transactional
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao dao;

    @Override
    public Customer findById(int id) {
       Optional<Customer> optional= dao.findById(id);
       if(!optional.isPresent()){
           throw new UserNotFoundException("user not found for id="+id);
       }
        return optional.get();
    }

    @Override
    public Customer save(Customer customer) {
        validate(customer);
        customer =dao.save(customer);
        return customer;
    }

    @Override
    public void remove(int id) {
       dao.deleteById(id);
    }

    public void validate(Object arg){
        if(arg==null){
            throw new InvalidArgumentException("argument is null");
        }
    }

    @Override
    public List<Customer> allUsers(){
        List<Customer>employees=dao.findAll();
        return employees;
    }


}
