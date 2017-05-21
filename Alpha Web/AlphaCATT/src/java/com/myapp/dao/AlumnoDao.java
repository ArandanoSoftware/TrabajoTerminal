/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.hibernate.HibernateUtil;
import com.myapp.model.Alumno;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author root
 */
public class AlumnoDao {
            
    Session session;
    
    public AlumnoDao()
    {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
        
    public void create(Alumno alumno)
    {
        Transaction tx = session.beginTransaction();
        session.save(alumno);
        tx.commit();
        close();
    }
    
    public void modify(Alumno alumno)
    {
        Transaction tx = session.beginTransaction();
        session.update(alumno);
        tx.commit();
        close();
    }
    
    public void erase(Alumno alumno)
    {
        Transaction tx = session.beginTransaction();
        session.delete(alumno);
        tx.commit();
        close();
    }
    
    public Alumno findById(int id)
    {
        Transaction tx = session.beginTransaction();
        Alumno alumno = (Alumno)session.get(Alumno.class, id);
        tx.commit();
        close();
        return alumno;
    }
    
    public List<Alumno> findAll()
    {   
        Transaction tx = session.beginTransaction();
        List<Alumno> alumno = (List<Alumno>)session.createCriteria(Alumno.class).list();
        tx.commit();
        close();
        return alumno;
    }
    
    public void close()
    {
        session.close();
    }
}