/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.model.Restriccion;
import com.myapp.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Hazzy76
 */
public class RestriccionDao {
        Session session;

    
    public RestriccionDao()
    {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void create(Restriccion restriccion)
    {
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(restriccion);
        tx.commit();
        close();
    }
    
    public void modify(Restriccion restriccion)
    {
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        //s = (Restriccion)session.load(Restriccion.class, s.getIdRestriccion());
        session.update(restriccion);
        tx.commit();
        close();
    }
    
    public void erase(Restriccion restriccion)
    {
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(restriccion);
        tx.commit();
        close();
    }
    
    public Restriccion finfById(int id)
    {
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Restriccion restriccion = (Restriccion)session.get(Restriccion.class, id);
        tx.commit();
        close();
        return restriccion;
    }
    
    public List<Restriccion> findAll()
    {   
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Restriccion> restricciones = (List<Restriccion>)session.createCriteria(Restriccion.class).list();
        tx.commit();
        close();
        return restricciones;
    }
    
    public void close()
    {
        session.close();
    }
}
