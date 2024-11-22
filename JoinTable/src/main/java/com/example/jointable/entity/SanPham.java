package com.example.jointable.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "san_pham")
public class SanPham {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "ma_san_pham", nullable = false, length = 50)
    private String maSanPham;

    @Nationalized
    @Column(name = "ten_san_pham", nullable = false, length = 50)
    private String tenSanPham;

    @Nationalized
    @Column(name = "trang_thai", nullable = false, length = 50)
    private String trangThai;

    @Column(name = "ngay_tao")
    private LocalDate ngayTao;

    @Column(name = "ngay_sua")
    private LocalDate ngaySua;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_danh_muc", nullable = false)
    private DanhMuc idDanhMuc;

}