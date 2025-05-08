package org.cooksystem.service;

import org.cooksystem.models.Customer;

public class ChefService {


        private CustomerService customerService;

        public ChefService(CustomerService customerService) {
            this.customerService = customerService;
        }

        public Customer getCustomerPreferences(String customerName) {
            return customerService.getCustomer(customerName);
        }
    }

