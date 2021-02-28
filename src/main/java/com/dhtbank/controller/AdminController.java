package com.dhtbank.controller;

import com.dhtbank.model.Customer;
import com.dhtbank.model.Employee;
import com.dhtbank.model.TKGui;
import com.dhtbank.service.CustomerService;
import com.dhtbank.service.EmployeeService;
import com.dhtbank.service.TKGuiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final CustomerService customerService;
    private final EmployeeService employeeService;
    private final TKGuiService tkGuiService;
    @Autowired
    public AdminController(CustomerService customerService, EmployeeService employeeService, TKGuiService tkGuiService) {
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.tkGuiService = tkGuiService;
    }

    @GetMapping(value = "/home")
    public String getAdminHomePage() {
        return "admin/admin-home";
    }

    //Manage Customer
    @GetMapping(value = "/manage-customer")
    public String getManageCustomerPage(Model model) {

        List<Customer> customers = new ArrayList<>();
        model.addAttribute("customers",customers);
        return "admin/admin-manage-info-customer";
    }
    @PostMapping(value = "/manage-customer-search")
    public String getManageCustomerSearch(@RequestParam ("cmt") String cmt, Model model) {

        List<Customer> customers = new ArrayList<>();
        Customer customer = customerService.findByCmt(cmt);
        if(customer != null) customers.add(customer);
        model.addAttribute("customers",customers);
        return "admin/admin-manage-info-customer";
    }

}
