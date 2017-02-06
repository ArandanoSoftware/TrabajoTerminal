/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.model.HibernateUtil;
import com.myapp.model.Profesor;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author root
 */
public class ProfesorDao {
    
    Session session;
    
    public ProfesorDao()
    {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public void create(Profesor p)
    {
        session.save(p);
    }
    
    public void modify(Profesor p)
    {
        session.update(p);
    }
    
    public void erase(Profesor p)
    {
        session.delete(p);
    }
    
    public Profesor finfById(int id)
    {
        session.clear();
        Profesor p = (Profesor)session.get(Profesor.class, id);
        return p;
    }
    
    public List<Profesor> findAll()
    {
        session.clear();
        return (List<Profesor>)session.createCriteria(Profesor.class).list();
    }
    
}
