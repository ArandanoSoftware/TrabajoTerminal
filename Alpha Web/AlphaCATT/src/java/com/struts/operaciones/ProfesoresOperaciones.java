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

import com.myapp.model.Profesor;

public class ProfesoresOperaciones {

    public ArrayList<Profesor> getUsuarios()
    {
        SessionFactory sesion=HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx=session.beginTransaction();
            //acá hacemos la magia
                ArrayList<Profesor> arreglo = new ArrayList<Profesor>();
                Query q;
                q = session.createQuery("from Profesor");
                List<Profesor> lista=q.list();
                Iterator<Profesor> iter= lista.iterator();
            //acá termina la magia
        tx.commit();
        session.close();
        //acá ya terminados todo y solo tomamos la lista y la pasamos a una arraylist
        while(iter.hasNext())
        {
            Profesor noti = (Profesor) iter.next();
            arreglo.add(noti);
        }

        return arreglo;

    }

    public void regProf(String nombre, String apaterno, String amaterno, String email)
    {
      SessionFactory factory = HibernateUtil.getSessionFactory();
      Session session=factory.openSession();
      Transaction tx =session.beginTransaction();
      //Query con Entity
      Profesor prof = new Profesor();
       prof.setNombre(nombre);
       prof.setApaterno(apaterno);
       prof.setAmaterno(amaterno);
       prof.setEmail(email);
      
      //
      session.save(prof);
      tx.commit();
      session.close();
    }

    public void deleteProf(int id)
     {
        SessionFactory factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();

        // Magic here
        Profesor prof=(Profesor)session.get(Profesor.class, id);
        session.delete(prof);

        tx.commit();
        session.close();
     }
}
