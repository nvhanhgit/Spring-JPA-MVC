package com.dhtbank.service.impl;


import com.dhtbank.model.Customer;
import com.dhtbank.repository.CustomerRepository;
import com.dhtbank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Iterable<Customer> findAll() {
        Iterable<Customer> listCustomer = null;
        try {
            listCustomer = customerRepository.findAll();
        }catch (Exception e){
            return null;}
        return listCustomer;
    }

    @Override
    public Customer findById(Long id) {
        try {
            Optional<Customer> customer = customerRepository.findById(id);
            if (customer.isPresent()) {
                return customer.get();
            }
        }catch (Exception e){
            return null; }
        return null;
    }

    @Override
    public boolean editCustomer(Customer customer) {
        try {
            customerRepository.save(customer);
        }catch (Exception e){
            return false;}
        return true;
    }

    @Override
    public boolean saveCustomer(Customer customer) {
        try {
            customerRepository.save(customer);
        }catch (Exception e){
            return false;}
        return true;
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        try {
            customerRepository.delete(customer);
        }catch (Exception e){
            return false;}
        return true;
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> listCustomers = null;
        try {
            listCustomers=customerRepository.findByName(name);
        }catch (Exception e){
            return null;}
        return listCustomers;
    }

    @Override
    public Customer findByCmt(String cmt) {
        Customer customer = null;
        try {
            customer =customerRepository.findByCmt(cmt);
        }catch (Exception e){
            return null;}
        return customer;
    }
}
