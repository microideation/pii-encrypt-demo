package com.microideation.samples.piiencryptdemo.controller;

import com.microideation.samples.piiencryptdemo.domain.Customer;
import com.microideation.samples.piiencryptdemo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/customer/find/mobile/{mobile}")
    public Customer getByMobile(@PathVariable String mobile) {
        return customerService.findByMobile(mobile);
    }

    @GetMapping("/customer/find/mobile/jql/{mobile}")
    public Customer getByMobileJQL(@PathVariable String mobile) {
        return customerService.findByMobileJQL(mobile);
    }
}
