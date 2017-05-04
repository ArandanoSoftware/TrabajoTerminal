/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.hibernate.HibernateUtil;
import com.myapp.model.Profesor;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author root
 */
public class ProfesorDao {
    
    Session session;
    
    public ProfesorDao()
    {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void create(Profesor p)
    {
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        close();
    }
    
    public void modify(Profesor p)
    {
        Transaction tx = session.beginTransaction();
        session.update(p);
        tx.commit();
        close();
    }
    
    public void erase(Profesor p)
    {
        Transaction tx = session.beginTransaction();
        session.delete(p);
        tx.commit();
        close();
    }
    
    public Profesor finfById(int id)
    {
        Transaction tx = session.beginTransaction();
        Profesor p = (Profesor)session.get(Profesor.class, id);
        tx.commit();
        close();
        return p;
    }
    
    public List<Profesor> findAll()
    {
        Transaction tx = session.beginTransaction();
        List<Profesor> p = (List<Profesor>)session.createCriteria(Profesor.class).list();
        tx.commit();
        close();
        return p;
    }
    
    public void close()
    {
        session.close();
    }
}
