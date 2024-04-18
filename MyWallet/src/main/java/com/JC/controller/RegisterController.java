package com.JC.controller;

import com.JC.model.Business;
import com.JC.model.Customer;
import com.JC.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register/jc-customer")
    public ResponseEntity<ResponseEntity<String>> registerCustomer(@Valid @RequestBody Customer customer) {
        ResponseEntity<ResponseEntity<String>> responseEntity;
        try {
            ResponseEntity<String> registeredCustomer = registerService.registerCustomer(customer);
            responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(registeredCustomer);
        } catch (Exception e) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return responseEntity;
    }

    //Register Business Api
//
//        @PostMapping("/register/business")
//        public ResponseEntity<Business> registerBusiness(@Valid @RequestBody Business business) {
//            Business registeredBusiness = registerService.registerBusiness(business);
//            return new ResponseEntity<>(registeredBusiness, HttpStatus.CREATED);
//        }
}
