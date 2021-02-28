package com.dhtbank.service.impl;


import com.dhtbank.model.Customer;
import com.dhtbank.model.Employee;
import com.dhtbank.repository.EmployeeRepository;
import com.dhtbank.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    @Override
    public Iterable<Employee> findAll() {
        Iterable<Employee> listEmployee = null;
        try {
            listEmployee = employeeRepository.findAll();
        }catch (Exception e){
        return null;}
        return listEmployee;
    }

    @Override
    public Employee findById(Long id) {
        try {
            Optional<Employee> employee = employeeRepository.findById(id);
            if (employee.isPresent()) {
                return employee.get();
            }
        }catch (Exception e){
            return null; }
      return null;
    }

    @Override
    public boolean editEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
        }catch (Exception e){
            return false;}
        return true;
    }

    @Override
    public boolean saveEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
        }catch (Exception e){
            return false;}
        return true;
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        try {
            employeeRepository.delete(employee);
        }catch (Exception e){
            return false;}
        return true;
    }

    @Override
    public List<Employee> findByName(String name) {
            List<Employee> listEmployees = null;
            try {
                listEmployees = employeeRepository.findByName(name);
            }catch (Exception e){
                return null;}
            return listEmployees;
        }

    @Override
    public Employee findByMa(String ma) {
        Employee employee = null;
        try {
            employee = employeeRepository.findByMa(ma);
        }catch (Exception e){
            return null;}
        return employee;
    }

    @Override
    public Employee findByUserAndPass(String user, String Pass) {
        Employee employee =null;
        try {
            employee = employeeRepository.findByUserAndPass(user,Pass);
        }catch (Exception e){
            return null;}
        return employee;
    }

}
