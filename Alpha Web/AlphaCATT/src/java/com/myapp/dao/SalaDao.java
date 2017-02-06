/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.model.HibernateUtil;
import com.myapp.model.Sala;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author root
 */
public class SalaDao {
    Session session;
    
    public SalaDao()
    {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public void create(Sala p)
    {
        session.save(p);
    }
    
    public void modify(Sala p)
    {
        session.update(p);
    }
    
    public void erase(Sala p)
    {
        session.delete(p);
    }
    
    public Sala finfById(int id)
    {
        session.clear();
        Sala p = (Sala)session.get(Sala.class, id);
        return p;
    }
    
    public List<Sala> findAll()
    {
        session.clear();
        return (List<Sala>)session.createCriteria(Sala.class).list();
    }
}
