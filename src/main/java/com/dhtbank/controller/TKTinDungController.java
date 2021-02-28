package com.dhtbank.controller;

import com.dhtbank.model.Customer;
import com.dhtbank.model.Employee;
import com.dhtbank.model.TKGui;
import com.dhtbank.model.TKTinDung;
import com.dhtbank.service.CustomerService;
import com.dhtbank.service.EmployeeService;
import com.dhtbank.service.TKGuiService;
import com.dhtbank.service.TKTinDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class TKTinDungController {
    private final CustomerService customerService;
    private final EmployeeService employeeService;
    private final TKTinDungService tkTinDungService;
    @Autowired
    public TKTinDungController(CustomerService customerService, EmployeeService employeeService, TKGuiService tkGuiService, TKTinDungService tkTinDungService) {
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.tkTinDungService = tkTinDungService;

    }
    @GetMapping(value = "/create-TKTinDung")
    public String deleteStaff(@RequestParam("id") Long id, HttpSession session) {
        System.out.println("luu khach hang");
        session.setAttribute("customerId",id);
        return "redirect:/admin/TKTinDung";
    }
    @GetMapping(value = "/TKTinDung")
    public String createTKGui(Model model) {

        TKTinDung tkTinDung = new TKTinDung();
        model.addAttribute("tkTinDung", tkTinDung);
        return "admin/createTKTinDung";
    }
    @PostMapping(value = "/TKTinDung")
    public String saveTKGui(Model model, @ModelAttribute("tkTinDung") TKTinDung tkTinDung, HttpSession session) {

        Long customerId = (Long) session.getAttribute("customerId");
        Long employeeId = (Long) session.getAttribute("employeeId");
        Customer customer = customerService.findById(customerId);
        Employee employee = employeeService.findById(employeeId);
        System.out.println(customer.getTen()+" "+employee.getTen());
        tkTinDung.setHanMuc(-50);
        tkTinDung.setCustomer(customer);
        tkTinDung.setEmployee(employee);
        tkTinDungService.saveTKTinDung(tkTinDung);
        session.removeAttribute("customerId");
        System.out.println("luu tai khoan gui");
        return "redirect:/admin/manage-customer";
    }
}
