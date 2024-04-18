package com.JC.service;

import com.JC.model.Business;
import com.JC.model.Customer;
import com.JC.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterService {

    @Autowired
    private CustomerRepo customerRepo;

    @Transactional
    public ResponseEntity<String> registerCustomer(Customer customer) {
        try {
            // Validate phone number
            if (!isValidPhoneNumber(customer.getMobileNumber())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid phone number");
            }

            // Compare pin and confirmPin
            if (customer.getPin() != null && customer.getConfirmPin() != null && customer.getPin().equals(customer.getConfirmPin())) {
                // If they match, proceed with saving the pin to the database
                customer.setConfirmPin(null); // Clear the confirmPin field
                Customer savedCustomer = customerRepo.save(customer);
                return ResponseEntity.status(HttpStatus.CREATED).body("Successfully registered customer with ID: " + savedCustomer.getCustomerId());
            } else {
                // Handle PIN and Confirm PIN mismatch error
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PIN and Confirm PIN do not match");
            }
        } catch (Exception e) {
            // Handle other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while registering customer: " + e.getMessage());
        }
    }

    // Utility method to validate phone number
    private boolean isValidPhoneNumber(String phoneNumber) {
        // Implement your phone number validation logic here
        // For example, you can check if it has 12 digits
//        return phoneNumber != null && phoneNumber.matches("\\d{10}");
        return phoneNumber != null && phoneNumber.matches("\\d{12}");
        }

//        public ResponseEntity<String> registerBusiness(Business business) {
//        try {
//            // Additional validation logic if needed
//            Business savedBusiness =customerRepo.save(business);
//            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully registered business with ID: " + savedBusiness.getId());
//        } catch (Exception e) {
//            // Handle other exceptions
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while registering business: " + e.getMessage());
//        }
//    }
}
