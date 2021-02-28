package com.dhtbank.service;

import com.dhtbank.model.Salary;
import com.dhtbank.model.TKGui;
import com.dhtbank.model.TKTinDung;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface TKTinDungService {
    boolean editTKTinDung(TKTinDung tkTinDung);

    boolean saveTKTinDung(TKTinDung tkTinDung);

    boolean deleteTKTinDung(TKTinDung tkTinDung);


}