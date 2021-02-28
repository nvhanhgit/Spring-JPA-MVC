package com.dhtbank.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
@Entity
@Table(name = "tblCustomer")
@Data
public class Customer implements Serializable {
    private static final long serialVersionUID =  1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ten", length = 50, nullable = false)
    private String ten;
    @Column(name = "ma", length = 50, nullable = false , unique = true)
    private String ma;
    @Column(name = "cmt", length = 50, nullable = false , unique = true)
    private String cmt;
    @Column(name = "ngay_sinh", length = 50, nullable = false)
    private String ngaySinh;
    @Column(name = "dia_chi", length = 50, nullable = false)
    private String diaChi;
    @Column(name = "ngay_tao", nullable = false)
    private Date   ngayTao;

    @ManyToOne
    @JoinColumn(name = "employee_id") // thông qua khóa ngoại employee_id
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Employee employee;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL) // quan he 1-n Customer-TKGui
    // MapopedBy tro toi ten bien customer o trong TKGui.
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khoonhg sử dụng trong toString()
    private Collection<TKGui> tkGuis;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL) // quan he 1-n Customer-TKGui
    // MapopedBy tro toi ten bien customer o trong TKGui.
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khoonhg sử dụng trong toString()
    private Collection<TKTinDung> tkTinDungs;
    @PrePersist
    void ngayTao() {
        this.ngayTao = new Date();
    }

}
