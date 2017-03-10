/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.hibernate.HibernateUtil;
import com.myapp.model.Horario;
import com.myapp.model.Profesor;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author root
 */
public class HorarioDao {
    Session session;

    
    public HorarioDao()
    {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public void create(Horario s)
    {
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(s);
        tx.commit();
    }
    
    public void modify(Horario s)
    {
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        //s = (Horario)session.load(Horario.class, s.getIdHorario());
        session.update(s);
        tx.commit();
    }
    
    public void erase(Horario p)
    {
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(p);
        tx.commit();
    }
    
    public Horario finfById(int id)
    {
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Horario p = (Horario)session.get(Horario.class, id);
        tx.commit();
        return p;
    }
    
    public List<Horario> findAll()
    {   
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Horario> horarios = (List<Horario>)session.createCriteria(Horario.class).list();
        tx.commit();
        return horarios;
    }
    
    public List<Horario> findByProf(Profesor p)
    {
        Transaction tx = session.beginTransaction();
        List<Horario> horarios = (List<Horario>) session.createCriteria(Horario.class).add(Restrictions.eq("profesor", p)).list();
        tx.commit();
        return horarios;
    }
    
    public void close()
    {
        session.close();
    }
}