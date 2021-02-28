package com.dhtbank.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface ChuyenKhoanRepository {
    @Transactional(propagation = Propagation.MANDATORY )
    public void addAmount(String Ma, int amount) throws Exception;
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void sendMoney(String fromAccountMa, String toAccountMa, int amount) throws Exception;
}
