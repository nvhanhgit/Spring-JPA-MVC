package com.dhtbank.service;

import com.dhtbank.model.Salary;
import com.dhtbank.model.TKGui;

import java.util.Date;

public interface TKGuiService {
    boolean editTKGui ( TKGui tkGui);
    boolean saveTKGui ( TKGui tkGui);
    boolean deleteTKGui ( TKGui tkGui);
    TKGui findById(Long id);
    TKGui findByMa( String ma );
    Salary findSalaryByMa(Date startDate, Date endDate, Long employeeId);
}
