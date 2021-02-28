package com.dhtbank.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class GiaoDich {
    private Long id;
    private int soTien;
    @ManyToOne
    @JoinColumn(name = "TKGui" , nullable = false) // thông qua khóa ngoại TKGui
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private TKGui TKGui;

    @ManyToOne
    @JoinColumn(name = "TKNhan" , nullable = false) // thông qua khóa ngoại TKGui
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private TKGui tkGui;
}
