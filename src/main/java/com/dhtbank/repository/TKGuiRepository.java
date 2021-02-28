package com.dhtbank.repository;

import com.dhtbank.model.Customer;
import com.dhtbank.model.Employee;
import com.dhtbank.model.TKGui;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TKGuiRepository extends CrudRepository<TKGui, Long> {
    @Query("select tk from TKGui tk where tk.ma = ?1 ")
    TKGui findByMa(String ma);
    @Query("SELECT COUNT(tkGui.id) FROM TKGui tkGui  WHERE (tkGui.employee.id = ?3 AND tkGui.ngayTao<?2 AND tkGui.ngayTao>?1) ")
    int findAllByTKGuiAndDateBetween(Date begin, Date end , Long employeeId);;
}
