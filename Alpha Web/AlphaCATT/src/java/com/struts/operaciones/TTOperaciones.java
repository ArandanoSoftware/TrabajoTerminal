/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.struts.operaciones;

import com.myapp.hibernate.HibernateUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.myapp.model.Tt;

public class TTOperaciones {

    public ArrayList<Tt> getTts()
    {
        SessionFactory sesion=HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx=session.beginTransaction();
            //acá hacemos la magia
                ArrayList<Tt> arreglo = new ArrayList<Tt>();
                Query q;
                q = session.createQuery("from Tt");
                List<Tt> lista=q.list();
                Iterator<Tt> iter= lista.iterator();
            //acá termina la magia
        tx.commit();
        session.close();
        //acá ya terminados todo y solo tomamos la lista y la pasamos a una arraylist
        while(iter.hasNext())
        {
            Tt noti = (Tt) iter.next();
            arreglo.add(noti);
        }

        return arreglo;

    }
    
    public void deleteTt(String id)
     {
        SessionFactory factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        
        // Magic here
        Tt tt=(Tt)session.get(Tt.class, id);
        session.delete(tt);

        tx.commit();
        session.close();
     }
}
