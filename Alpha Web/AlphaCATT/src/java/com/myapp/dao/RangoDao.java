/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.hibernate.HibernateUtil;
import com.myapp.model.Rango;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hazzy76
 */
public class RangoDao {
        
        Session session;

    
    public RangoDao()
    {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void create(Rango rango)
    {
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(rango);
        tx.commit();
        close();
    }
    
    public void modify(Rango rango)
    {
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        //s = (Sala)session.load(Sala.class, s.getIdSala());
        session.update(rango);
        tx.commit();
        close();
    }
    
    public void erase(Rango rango)
    {
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(rango);
        tx.commit();
        close();
    }
    
    public Rango finfById(int id)
    {
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Rango rango = (Rango)session.get(Rango.class, id);
        tx.commit();
        close();
        return rango;
    }
    
    public List<Rango> findAll()
    {   
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Rango> rangoes = (List<Rango>)session.createCriteria(Rango.class).list();
        tx.commit();
        close();
        return rangoes;
    }
    
    public void close()
    {
        session.close();
    }
    
}
