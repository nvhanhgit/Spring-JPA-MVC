package com.dhtbank.controller;

import com.dhtbank.model.Customer;
import com.dhtbank.service.CustomerService;
import com.dhtbank.service.TKGuiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class CustomerController {
    private final CustomerService customerService;
    private final TKGuiService tkGuiService;

    public CustomerController(CustomerService customerService, TKGuiService tkGuiService) {
        this.customerService = customerService;
        this.tkGuiService = tkGuiService;
    }
    @GetMapping(value = "/TTKH")
    public String getCustomerInformation(Model model, @RequestParam ("id") Long id) {
        Customer customer = customerService.findById(id);
        model.addAttribute("tkGuis",customer.getTkGuis());
        model.addAttribute("tkTinDungs",customer.getTkTinDungs());
        return "customer/Customer-Information";
    }
}
