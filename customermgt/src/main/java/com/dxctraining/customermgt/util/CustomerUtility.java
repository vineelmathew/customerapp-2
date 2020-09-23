package com.dxctraining.customermgt.util;

import com.dxctraining.customermgt.dto.CustomerDetails;
import com.dxctraining.customermgt.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerUtility {


    public CustomerDetails userDto(Customer customer){
        CustomerDetails details=new CustomerDetails(customer.getId(), customer.getName(), customer.getBalance());
        return details;
    }

}
