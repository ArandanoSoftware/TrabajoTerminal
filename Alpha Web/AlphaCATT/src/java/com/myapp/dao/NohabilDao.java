/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.hibernate.HibernateUtil;
import com.myapp.model.Nohabil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Hazzy76
 */
public class NohabilDao {
    
        Session session;

    
    public NohabilDao()
    {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void create(Nohabil nohabil)
    {
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(nohabil);
        tx.commit();
        close();
    }
    
    public void modify(Nohabil nohabil)
    {
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        //s = (Sala)session.load(Sala.class, s.getIdSala());
        session.update(nohabil);
        tx.commit();
        close();
    }
    
    public void erase(Nohabil nohabil)
    {
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(nohabil);
        tx.commit();
        close();
    }
    
    public Nohabil finfById(int id)
    {
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Nohabil nohabil = (Nohabil)session.get(Nohabil.class, id);
        tx.commit();
        close();
        return nohabil;
    }
    
    public List<Nohabil> findAll()
    {   
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Nohabil> nohabiles = (List<Nohabil>)session.createCriteria(Nohabil.class).list();
        tx.commit();
        close();
        return nohabiles;
    }
    
    public void close()
    {
        session.close();
    }
    
}
