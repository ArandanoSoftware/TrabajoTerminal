/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.hibernate.HibernateUtil;
import com.myapp.model.Calendario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author root
 */
public class CalendarioDao {
            
    Session session;
    
    public CalendarioDao()
    {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
        
    public void create(Calendario calendario)
    {
        Transaction tx = session.beginTransaction();
        session.save(calendario);
        tx.commit();
        close();
    }
    
    public void modify(Calendario calendario)
    {
        Transaction tx = session.beginTransaction();
        session.update(calendario);
        tx.commit();
        close();
    }
    
    public void erase(Calendario calendario)
    {
        Transaction tx = session.beginTransaction();
        session.delete(calendario);
        tx.commit();
        close();
    }
    
    public Calendario findById(int id)
    {
        Transaction tx = session.beginTransaction();
        Calendario calendario = (Calendario)session.get(Calendario.class, id);
        tx.commit();
        close();
        return calendario;
    }
    
    public List<Calendario> findAll()
    {   
        Transaction tx = session.beginTransaction();
        List<Calendario> calendario = (List<Calendario>)session.createCriteria(Calendario.class).list();
        tx.commit();
        close();
        return calendario;
    }
    
    public List<Calendario> findByOption(int opcion)
    {   
        Transaction tx = session.beginTransaction();
        List<Calendario> calendario = (List<Calendario>)session.createCriteria(Calendario.class).add(Restrictions.eq("opcion", opcion)).list();
        tx.commit();
        close();
        return calendario;
    }
    
    public void close()
    {
        session.close();
    }
}
