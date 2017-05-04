/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.hibernate.HibernateUtil;
import com.myapp.model.Dirige;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author root
 */
public class DirigeDao {
            
    Session session;
    
    public DirigeDao()
    {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
        
    public void create(Dirige dirige)
    {
        Transaction tx = session.beginTransaction();
        session.save(dirige);
        tx.commit();
        close();
    }
    
    public void modify(Dirige dirige)
    {
        Transaction tx = session.beginTransaction();
        session.update(dirige);
        tx.commit();
        close();
    }
    
    public void erase(Dirige dirige)
    {
        Transaction tx = session.beginTransaction();
        session.delete(dirige);
        tx.commit();
        close();
    }
    
    public Dirige findById(String id)
    {
        Transaction tx = session.beginTransaction();
        Dirige dirige = (Dirige)session.get(Dirige.class, id);
        tx.commit();
        close();
        return dirige;
    }
    
    public List<Dirige> findAll()
    {   
        Transaction tx = session.beginTransaction();
        List<Dirige> dirige = (List<Dirige>)session.createCriteria(Dirige.class).list();
        tx.commit();
        close();
        return dirige;
    }
    
    public void close()
    {
        session.close();
    }
}
