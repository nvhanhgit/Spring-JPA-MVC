package com.dhtbank.service;


import com.dhtbank.model.Employee;

import java.util.List;

public interface EmployeeService {
    Iterable<Employee> findAll ();
    Employee  findById (Long id);
    boolean editEmployee ( Employee employee );
    boolean saveEmployee ( Employee employee );
    boolean deleteEmployee ( Employee employee );
    List<Employee> findByName(String name);
    Employee findByMa(String ma);
    Employee findByUserAndPass(String user, String Pass);
}
