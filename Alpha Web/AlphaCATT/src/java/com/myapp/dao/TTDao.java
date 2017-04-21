/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.algoritmo.Restriccion;
import com.myapp.hibernate.HibernateUtil;
import com.myapp.model.Tt;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author root
 */
public class TTDao {
    
    Session session;
    
    public TTDao()
    {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
        
    public void create(Tt tt)
    {
        Transaction tx = session.beginTransaction();
        session.save(tt);
        tx.commit();
    }
    
    public void modify(Tt tt)
    {
        Transaction tx = session.beginTransaction();
        session.update(tt);
        tx.commit();
    }
    
    public void erase(Tt tt)
    {
        Transaction tx = session.beginTransaction();
        session.delete(tt);
        tx.commit();
    }
    
    public Tt findById(String id)
    {
        Transaction tx = session.beginTransaction();
        Tt tt = (Tt)session.get(Tt.class, id);
        tx.commit();
        return tt;
    }
    
    public List<Tt> findAll()
    {   
        Transaction tx = session.beginTransaction();
        List<Tt> tt = (List<Tt>)session.createCriteria(Tt.class).list();
        tx.commit();
        return tt;
    }
    
    public List<Tt> findAllTT1()
    {   
        Transaction tx = session.beginTransaction();
        List<Tt> tt = (List<Tt>)session.createCriteria(Tt.class).add(Restrictions.eq("nivel", 1)).list();
        tx.commit();
        return tt;
    }
    
    public List<Tt> findAllTT2()
    {   
        Transaction tx = session.beginTransaction();
        List<Tt> tt = (List<Tt>)session.createCriteria(Tt.class).add(Restrictions.eq("nivel", 2)).list();
        tx.commit();
        return tt;
    }
    
    public List<Tt> findAllTTR()
    {   
        Transaction tx = session.beginTransaction();
        List<Tt> tt = (List<Tt>)session.createCriteria(Tt.class).add(Restrictions.eq("nivel", 3)).list();
        tx.commit();
        return tt;
    }
    
    
    public void close()
    {
        session.close();
    }
}
