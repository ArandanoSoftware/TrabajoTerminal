/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author root
 */
public class CreoDAO {
    
    Session session = null;
    
    public CreoDAO()
    {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Sala> getSalas()
    {
        List<Sala> salas = null;
        try
        {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Sala");
            salas = (List<Sala>)q.list();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return salas;
    }
}
