package com.dhtbank.controller;

import com.dhtbank.model.Employee;
import com.dhtbank.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
   private final EmployeeService employeeService;

    public HomeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/")
    public String getHomePage() {

        return "admin/admin-home";
    }

    @PostMapping(value = "home/login")
    public String getLogin(@RequestParam ("username") String user , @RequestParam("password") String password, HttpSession session) {
        Employee employee = employeeService.findByUserAndPass(user, password);
        if( employee != null && employee.getViTri().equals("Staff")) {
            session.setAttribute("employeeId", employee.getId());
            return "redirect:/admin/manage-customer";
        }
        return "redirect:/";
    }
}
