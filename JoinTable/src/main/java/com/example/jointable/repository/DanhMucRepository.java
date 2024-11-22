package com.example.jointable.repository;

import com.example.jointable.entity.DanhMuc;
import com.example.jointable.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class DanhMucRepository {
    Session s;
    public DanhMucRepository(){
        s = HibernateUtil.getFACTORY().openSession();
    }

    public List<DanhMuc> getAll(){
        return s.createQuery("from DanhMuc ").list();
    }

    public DanhMuc getOne(Integer id){
        return s.find(DanhMuc.class, id);
    }

    public void add(DanhMuc dm){
        try {
            s.getTransaction().begin();
            s.save(dm);
            s.getTransaction().commit();
        }catch (Exception e){
            s.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void update(DanhMuc dm){
        try {
            s.getTransaction().begin();
            s.merge(dm);
            s.getTransaction().commit();
        }catch (Exception e){
            s.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void delete(DanhMuc dm){
        try {
            s.getTransaction().begin();
            s.delete(dm);
            s.getTransaction().commit();
        }catch (Exception e){
            s.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(new DanhMucRepository().getAll());
    }
}
