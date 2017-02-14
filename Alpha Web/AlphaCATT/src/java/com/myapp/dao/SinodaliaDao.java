/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.hibernate.HibernateUtil;
import com.myapp.model.Sinodalia;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author root
 */
public class SinodaliaDao {
        
    Session session;
    
    public SinodaliaDao()
    {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
        
    public void create(Sinodalia sinodalia)
    {
        Transaction tx = session.beginTransaction();
        session.save(sinodalia);
        tx.commit();
    }
    
    public void modify(Sinodalia sinodalia)
    {
        Transaction tx = session.beginTransaction();
        session.update(sinodalia);
        tx.commit();
    }
    
    public void erase(Sinodalia sinodalia)
    {
        Transaction tx = session.beginTransaction();
        session.delete(sinodalia);
        tx.commit();
    }
    
    public Sinodalia findById(String id)
    {
        Transaction tx = session.beginTransaction();
        Sinodalia sinodalia = (Sinodalia)session.get(Sinodalia.class, id);
        tx.commit();
        return sinodalia;
    }
    
    public List<Sinodalia> findAll()
    {   
        Transaction tx = session.beginTransaction();
        List<Sinodalia> sinodalia = (List<Sinodalia>)session.createCriteria(Sinodalia.class).list();
        tx.commit();
        return sinodalia;
    }
    
    public void close()
    {
        session.close();
    }
}
