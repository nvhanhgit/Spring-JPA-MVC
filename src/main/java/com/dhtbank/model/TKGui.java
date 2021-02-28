package com.dhtbank.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "tblTKGui")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TKGui implements Serializable {
    private static final long serialVersionUID =  1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ma", length = 50, nullable = false)
    private String ma;
    @Column(name = "loai", length = 50, nullable = false)
    private String loai;
    @Column(name = "so_du", length = 50, nullable = false)
    private  int soDu;
    @Column(name = "so_du_tt", length = 50, nullable = false)
    private int soDuToiThieu;
    @Column(name = "lai_suat_thang", length = 50, nullable = false)
    private float laiSuatThang;
    @Column(name = "ngay_Tao", nullable = false)
    private Date ngayTao;

    @ManyToOne
    @JoinColumn(name = "employee_id" , nullable = false) // thông qua khóa ngoại employee_id
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id" , nullable = false) // thông qua khóa ngoại employee_id
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Customer customer;
    @PrePersist
    void ngayTao() {
        this.ngayTao = new Date();
    }
}
