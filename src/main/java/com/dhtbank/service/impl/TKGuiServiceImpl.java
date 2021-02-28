package com.dhtbank.service.impl;

import com.dhtbank.model.Salary;
import com.dhtbank.model.TKGui;
import com.dhtbank.repository.TKGuiRepository;
import com.dhtbank.service.EmployeeService;
import com.dhtbank.service.TKGuiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TKGuiServiceImpl implements TKGuiService {
    private final  TKGuiRepository tkGuiRepository;
    private final EmployeeService employeeService;
     @Autowired
    public TKGuiServiceImpl(TKGuiRepository tkGuiRepository, EmployeeService employeeService) {

         this.tkGuiRepository = tkGuiRepository;
         this.employeeService = employeeService;
     }

    @Override
    public boolean editTKGui(TKGui tkGui) {
        try {
            tkGuiRepository.save(tkGui);
        }catch (Exception e){
            System.out.println("lỗi");
            System.out.println(e.toString());
            return false;}
        return true;
    }

    @Override
    public boolean saveTKGui(TKGui tkGui) {
        try {
            tkGuiRepository.save(tkGui);
        }catch (Exception e){
            System.out.println("lỗi");
            System.out.println(e.toString());
            return false;}
        return true;
    }

    @Override
    public boolean deleteTKGui(TKGui tkGui) {
        try {
            tkGuiRepository.delete(tkGui);
        }catch (Exception e){
            return false;}
        return true;
    }
    @Override
    public TKGui findById(Long id) {
        try {
            Optional<TKGui> tkGui = tkGuiRepository.findById(id);
            if (tkGui.isPresent()) {
                return tkGui.get();
            }
        }catch (Exception e){
            return null; }
        return null;
    }

    @Override
    public TKGui findByMa(String ma) {
        try {
            TKGui tkGui = tkGuiRepository.findByMa(ma);

            return tkGui;
        }catch (Exception e){
            return null; }
    }

    @Override
    public Salary findSalaryByMa(Date startDate, Date endDate, Long employeeId) {
        try {
            Salary salary =new Salary();
            int soTKTao = tkGuiRepository.findAllByTKGuiAndDateBetween(startDate, endDate, employeeId);
             salary.setTongTKTao(soTKTao);
             salary.setSalary(soTKTao*100);
             salary.setEmployee(employeeService.findById(employeeId));
            return salary;
        }catch (Exception e){
            return null; }
    }
}
