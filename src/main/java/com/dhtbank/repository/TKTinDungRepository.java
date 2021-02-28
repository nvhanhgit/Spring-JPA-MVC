package com.dhtbank.repository;

import com.dhtbank.model.Employee;
import com.dhtbank.model.TKTinDung;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface TKTinDungRepository extends CrudRepository<TKTinDung, Long> {
}
