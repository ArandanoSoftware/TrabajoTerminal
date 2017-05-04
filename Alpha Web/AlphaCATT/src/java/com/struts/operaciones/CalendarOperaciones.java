package com.struts.operaciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myapp.model.Calendario;

import com.myapp.hibernate.HibernateUtil;


public class CalendarOperaciones {

  public ArrayList<Calendario> getCalendar()
    {
        SessionFactory sesion= HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx=session.beginTransaction();
        //acá hacemos la magia
                ArrayList<Calendario> arreglo = new ArrayList<Calendario>();
                Query q=session.createQuery("from Calendario");
                List<Calendario> lista = q.list();
                Iterator<Calendario> iter = lista.iterator();
            //acá termina la magia

        tx.commit();
        session.close();
        //acá ya terminados todo y solo tomamos la lista y la pasamos a una arraylist
        while(iter.hasNext())
        {
            Calendario noti = (Calendario) iter.next();
            arreglo.add(noti);
        }

        return arreglo;
    }

}
