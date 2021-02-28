package com.dhtbank.repository.impl;

import com.dhtbank.model.TKGui;
import com.dhtbank.repository.ChuyenKhoanRepository;
import com.dhtbank.repository.TKGuiRepository;
import com.dhtbank.service.TKGuiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class ChuyenKhoanRepositoryImpl implements ChuyenKhoanRepository {
    private final TKGuiService tkGuiService ;
    private final TKGuiRepository tkGuiRepository;
    @Autowired
    public ChuyenKhoanRepositoryImpl(TKGuiService tkGuiService, TKGuiRepository tkGuiRepository) {
        this.tkGuiService = tkGuiService;
        this.tkGuiRepository = tkGuiRepository;
    }

    @Transactional(propagation = Propagation.MANDATORY )
    public void addAmount(String Ma, int amount) throws Exception {
        TKGui tkGui = tkGuiService.findByMa(Ma);
        if (tkGui == null) {
            throw new Exception("ko tim thay TKGui");
        }

        if (tkGui.getSoDu() + amount < 0) {
            throw new Exception("khong du tien '" + Ma );
        }
        tkGui.setSoDu( tkGui.getSoDu() + amount );
        tkGuiRepository.save(tkGui);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void sendMoney(String fromAccountMa, String toAccountMa, int amount) throws Exception {
        addAmount(toAccountMa, amount);
        addAmount(fromAccountMa, -amount);
    }

}
