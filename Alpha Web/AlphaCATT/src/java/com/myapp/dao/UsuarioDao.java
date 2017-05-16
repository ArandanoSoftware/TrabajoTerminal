/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.hibernate.HibernateUtil;
import com.myapp.model.Usuario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author robb
 */
public class UsuarioDao {
     
    Session session;
    
    public UsuarioDao()
    {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
     public void create(Usuario usuario)
    {
        Transaction tx = session.beginTransaction();
        session.save(usuario);
        tx.commit();
        close();
    }
    
    public void modify(Usuario usuario)
    {
        Transaction tx = session.beginTransaction();
        session.update(usuario);
        tx.commit();
        close();
    }
    
    public void erase(Usuario usuario)
    {
        Transaction tx = session.beginTransaction();
        session.delete(usuario);
        tx.commit();
        close();
    }
    
    public Usuario findById(int id)
    {
        Transaction tx = session.beginTransaction();
        Usuario alumno = (Usuario)session.get(Usuario.class, id);
        tx.commit();
        close();
        return alumno;
    }
    
    public List<Usuario> findAll()
    {   
        Transaction tx = session.beginTransaction();
        List<Usuario> usuario = (List<Usuario>)session.createCriteria(Usuario.class).list();
        tx.commit();
        close();
        return usuario;
    }
    
    public void close()
    {
        session.close();
    }
}
