/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.model.HibernateUtil;
import com.myapp.model.Sala;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author root
 */
public class SalaDao {
    Session session;

    
    public SalaDao()
    {
    }
    
    public void create(Sala s)
    {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(s);
        tx.commit();
    }
    
    public void modify(Sala s)
    {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        //s = (Sala)session.load(Sala.class, s.getIdSala());
        session.update(s);
        tx.commit();
    }
    
    public void erase(Sala p)
    {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(p);
        tx.commit();
    }
    
    public Sala finfById(int id)
    {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Sala p = (Sala)session.get(Sala.class, id);
        tx.commit();
        return p;
    }
    
    public List<Sala> findAll()
    {   
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Sala> salas = (List<Sala>)session.createCriteria(Sala.class).list();
        tx.commit();
        return salas;
    }
    
    public void close()
    {
        session.close();
    }
}
