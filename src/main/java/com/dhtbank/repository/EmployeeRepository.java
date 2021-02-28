package com.dhtbank.repository;

import com.dhtbank.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("select e from Employee e where e.ten like %?1")
    List<Employee> findByName(String name);
    @Query("select e from Employee e where e.ma = ?1 ")
    Employee findByMa(String ma);
    @Query("select e from Employee e where e.ma = ?1 and e.passWord = ?2 ")
    Employee findByUserAndPass(String user, String Pass);
}
