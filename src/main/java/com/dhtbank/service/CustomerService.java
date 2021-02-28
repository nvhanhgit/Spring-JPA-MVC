package com.dhtbank.service;


import com.dhtbank.model.Customer;

import java.util.List;

public interface CustomerService {
    Iterable<Customer> findAll ();
    Customer  findById (Long id);
    boolean editCustomer ( Customer customer );
    boolean saveCustomer ( Customer customer );
    boolean deleteCustomer ( Customer customer );
    List<Customer> findByName(String name);
    Customer findByCmt(String cmt);
}
