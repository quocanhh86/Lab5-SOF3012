package com.example.jointable.repository;

import com.example.jointable.entity.SanPham;
import com.example.jointable.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class SanPhamRepository {
    Session s;
    public SanPhamRepository(){
        s = HibernateUtil.getFACTORY().openSession();
    }

    public List<SanPham> getAll(){
        Query query = s.createQuery("select sp from SanPham sp");
        return query.getResultList();
    }
}
