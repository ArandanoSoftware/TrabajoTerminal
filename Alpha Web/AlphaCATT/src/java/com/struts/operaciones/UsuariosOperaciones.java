package com.struts.operaciones;

import java.util.Iterator;

import com.myapp.hibernate.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;

import  com.myapp.model.Usuario;

public class UsuariosOperaciones {


    public boolean Authenticate(String user, String pass){

        SessionFactory sesion= HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx=session.beginTransaction();
        

//Petición
        String hql= "FROM Usuario U WHERE U.username = :u_username and U.password= :u_password";
        Query  query = session.createQuery(hql);
        query.setParameter("u_username", user);
        query.setParameter("u_password", pass);
        //Fin de la petición
        java.util.List<Usuario> lista = query.list();
        
        tx.commit();
        session.close();
        if(lista.isEmpty())
        {
            return false;
        }
        return false;
    }

}
