package com.dhtbank.repository;


import com.dhtbank.model.Customer;
import com.dhtbank.model.Employee;
import com.dhtbank.model.TKGui;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    @Query("select c from Customer c where c.cmt = ?1 ")
    Customer findByCmt(String cmt);
    @Query("select c from Customer c where c.ten like %?1")
    List<Customer> findByName(String name);
    @Query("select t from TKGui t where t.customer.id = ?1 ")
    List<TKGui> findByTkGuis(Long customerId);
}
