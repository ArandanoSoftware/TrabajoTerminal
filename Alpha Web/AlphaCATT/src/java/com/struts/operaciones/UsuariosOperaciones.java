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
        Transaction tx = session.beginTransaction();


        //Petición
        String hql= "FROM Usuario U WHERE U.username = :u_username and U.password = :u_password";
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
        return true;
    }
    
      public void regUser(String username, String password, String tipo)
    {
      SessionFactory factory = HibernateUtil.getSessionFactory();
      Session session=factory.openSession();
      Transaction tx =session.beginTransaction();
      //Query con Entity
       Usuario user = new Usuario();
       user.setUsername(username);
       user.setPassword(password);
       user.setTipo(Integer.parseInt(tipo));
      //
      session.save(user);
      tx.commit();
      session.close();
    }
      
       public void delUser(int id)
     {
        SessionFactory factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();

        // Magic here
        Usuario user=(Usuario)session.get(Usuario.class, id);
        session.delete(user);

        tx.commit();
        session.close();
     }

}
