
package com.struts.operaciones;

import com.myapp.hibernate.HibernateUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.myapp.model.Sala;

public class SalasOperaciones {
    
    public ArrayList<Sala> getUsuarios()
    {
        SessionFactory sesion=HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx=session.beginTransaction();
            //acá hacemos la magia
                ArrayList<Sala> arreglo = new ArrayList<Sala>();
                Query q;
                q = session.createQuery("from Sala");
                List<Sala> lista=q.list();
                Iterator<Sala> iter= lista.iterator();
            //acá termina la magia
        tx.commit();
        session.close();
        //acá ya terminados todo y solo tomamos la lista y la pasamos a una arraylist
        while(iter.hasNext())
        {
            Sala noti = (Sala) iter.next();
            arreglo.add(noti);
        }

        return arreglo;

    }
    
}
