package com.dhtbank.controller;

import com.dhtbank.model.Employee;
import com.dhtbank.model.Salary;
import com.dhtbank.service.EmployeeService;
import com.dhtbank.service.TKGuiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class StaffController {
   public final EmployeeService employeeService;
   public final TKGuiService tkGuiService;
   @Autowired
    public StaffController(EmployeeService employeeService, TKGuiService tkGuiService) {
        this.employeeService = employeeService;
       this.tkGuiService = tkGuiService;
   }


    @GetMapping(value = "/luong")
    public String getLuongStaff(Model model,@RequestParam("ma") String maNV) {
        Employee employee = employeeService.findByMa(maNV);
        model.addAttribute("maNV",maNV);
        model.addAttribute("tenNV",employee.getTen());
        Salary salary = new Salary();
        model.addAttribute( "salary", salary);
        return "admin/thong-tin-luong";
    }
    @PostMapping (value = "/search-luong")
    public String getSearchLuongStaff(Model model, @RequestParam("ma") String maNV, @RequestParam("startDate")String startDate, @RequestParam("endDate") String endDate) throws ParseException {

        Date sDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
        Date eDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
        Employee employee = employeeService.findByMa(maNV);
        if(employee==null) return "admin/thong-tin-luong";
        Salary salary = tkGuiService.findSalaryByMa(sDate,eDate,employee.getId());
        model.addAttribute(salary);
        return "admin/thong-tin-luong";
    }
    @GetMapping(value = "/manage-employee")
    public String getManageEmployeePage(Model model) {

        List<Employee> employees = new ArrayList<>();
        model.addAttribute("employees",employees);
        return "admin/admin-manage-info-staff";
    }
    @PostMapping (value = "/manage-employee-search")
    public String getManageEmployeeSearch(@RequestParam ("maNV") String maNV, Model model) {
        List<Employee> employees = new ArrayList<>();
        Employee employee = employeeService.findByMa(maNV);
        if(employee != null) employees.add(employee);
        model.addAttribute("employees",employees);
        return "admin/admin-manage-info-staff";
    }
}
