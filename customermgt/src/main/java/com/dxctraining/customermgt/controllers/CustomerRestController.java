package com.dxctraining.customermgt.controllers;

import com.dxctraining.customermgt.dto.CustomerRequest;
import com.dxctraining.customermgt.dto.CustomerDetails;
import com.dxctraining.customermgt.entities.Customer;
import com.dxctraining.customermgt.service.ICustomerService;
import com.dxctraining.customermgt.util.CustomerUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    @Autowired
    private ICustomerService userService;

    @Autowired
    private CustomerUtility customerUtility;

    @Autowired
    private RestTemplate restTemplate;
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDetails create(@RequestBody CustomerRequest requestData) {
        String name = requestData.getName();
        int age = requestData.getAge();
        double salary = requestData.getSalary();
        Customer customer = new Customer(name,  age, salary);
        customer = userService.save(customer);
        CustomerDetails response = customerUtility.userDto(customer);
        return response;
    }


    @GetMapping("/get/{id}")
    public CustomerDetails findEmployee(@PathVariable("id") int id) {
        Customer customer = userService.findById(id);
        CustomerDetails response = customerUtility.userDto(customer);
        return response;
    }


    @GetMapping
    public List<CustomerDetails> fetchAll() {
        List<Customer> list = userService.allUsers();
        List<CustomerDetails>response=new ArrayList<>();
        for (Customer customer :list){
            CustomerDetails dto= customerUtility.userDto(customer);
            response.add(dto);
        }
        return response;
    }




}




