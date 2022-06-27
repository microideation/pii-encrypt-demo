package com.microideation.samples.piiencryptdemo.repository;

import com.microideation.samples.piiencryptdemo.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    // Standard find by Query. Here the mobile number will be automatically encrypted and passed to match with encrypted value
    // in the db
    Customer findByMobile(String mobile);

    // Using JQL.
    // JQL automatically applies the attribute converters.
    // NOTE: Native query will not support this functionality and we are required to pass the encrypted value
    // from our side.
    @Query("select C from Customer C where C.mobile=?1")
    Customer findByMobileUsingJQL(String mobile);
}
