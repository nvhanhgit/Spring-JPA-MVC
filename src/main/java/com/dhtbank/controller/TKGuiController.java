package com.dhtbank.controller;

import com.dhtbank.model.Customer;
import com.dhtbank.model.Employee;
import com.dhtbank.model.TKGui;
import com.dhtbank.repository.ChuyenKhoanRepository;
import com.dhtbank.service.CustomerService;
import com.dhtbank.service.EmployeeService;
import com.dhtbank.service.TKGuiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class TKGuiController {
    private final CustomerService customerService;
    private final EmployeeService employeeService;
    private final TKGuiService tkGuiService;
    private final ChuyenKhoanRepository chuyenKhoanRepository;
   @Autowired
    public TKGuiController(CustomerService customerService, EmployeeService employeeService, TKGuiService tkGuiService, ChuyenKhoanRepository chuyenKhoanRepository) {
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.tkGuiService = tkGuiService;
       this.chuyenKhoanRepository = chuyenKhoanRepository;
   }
    @GetMapping(value = "/create-TKGui")
    public String deleteStaff(@RequestParam("id") Long id, HttpSession session) {
        System.out.println("luu khach hang");
        session.setAttribute("customerId",id);
        return "redirect:/admin/TKGui";
    }
    @GetMapping(value = "/TKGui")
    public String createTKGui(Model model) {

        TKGui tkGui = new TKGui();
        model.addAttribute("tkGui", tkGui);
        return "admin/createTKGui";
    }
    @PostMapping(value = "/TKGui")
    public String saveTKGui(Model model, @ModelAttribute("tkGui") TKGui tkGui, HttpSession session) {
        Long customerId = (Long) session.getAttribute("customerId");
        Long employeeId = (Long) session.getAttribute("employeeId");
        Customer customer = customerService.findById(customerId);
        Employee employee = employeeService.findById(employeeId);
        System.out.println(customer.getTen()+" "+employee.getTen());
        tkGui.setSoDuToiThieu(50);
        tkGui.setCustomer(customer);
        tkGui.setEmployee(employee);
        tkGuiService.saveTKGui(tkGui);
        session.removeAttribute("customerId");
        System.out.println("luu tai khoan gui");
        return "redirect:/admin/manage-customer";
    }
    @PostMapping(value = "/edit-TKGui")
    public String editCustomer(@ModelAttribute("TKGui") TKGui tkGui) {
        TKGui tkGuiOld = tkGuiService.findById(tkGui.getId());
        tkGui.setNgayTao(tkGuiOld.getNgayTao());
        tkGui.setCustomer(tkGuiOld.getCustomer());
        tkGui.setEmployee(tkGuiOld.getEmployee());
        tkGuiService.saveTKGui(tkGui);
        return "redirect:/admin/manage-customer";
    }
    @GetMapping(value = "/edit-TKGui")
    public String editTKGui(Model model, @RequestParam(value = "id") Long id) {
        System.out.println("TKGui"+id);
        TKGui tkGui = tkGuiService.findById(id);
        System.out.println("TKGui"+tkGui.getMa()+id);
        model.addAttribute("tkGui", tkGui);
        return "admin/edit-TKGui";
    }
    @GetMapping(value = "/chuyen-khoan-TKGui")
    public String chuyenKhoan(Model model, @RequestParam(value = "id") String ma) {
        model.addAttribute("fromMa", ma);
        return "tkGui/chuyen-khoan";
    }
    @GetMapping(value = "/xac-nhan-chuyen-khoan")
    public String ckTKGui(Model model, @RequestParam("fromMa") String fromMa, @RequestParam("toMa") String toMa, @RequestParam("amount") int amount) {
        TKGui fromTkGui = tkGuiService.findByMa(fromMa);
        if( fromTkGui.getSoDu() - fromTkGui.getSoDuToiThieu() - amount < 0 )
            return "redirect:/admin/chuyen-khoan-TKGui";
        TKGui toTkGui = tkGuiService.findByMa(toMa);
        if(toTkGui==null)
            return "redirect:/admin/chuyen-khoan-TKGui";
        model.addAttribute("fromMa",fromMa);
        model.addAttribute("toMa",toMa);
        model.addAttribute("toTen",toTkGui.getCustomer().getTen());
        model.addAttribute("amount",amount);
        return "tkGui/xac-nhan-chuyen-khoan";
    }
    @PostMapping(value = "/thuc-hien-ck")
    public String thucHienCK( @RequestParam("fromMa") String fromMa, @RequestParam("toMa") String toMa, @RequestParam("amount") int amount) throws Exception {
        chuyenKhoanRepository.sendMoney(fromMa, toMa ,amount);

        return "redirect:/admin/manage-customer";
    }

}
