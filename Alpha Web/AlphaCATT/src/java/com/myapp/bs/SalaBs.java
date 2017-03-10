/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.bs;

import com.myapp.dao.SalaDao;
import com.myapp.model.Sala;
import java.util.List;

/**
 *
 * @author root
 */
public class SalaBs {
    
    public static Sala findById(int id)
    {
        SalaDao salaDao = new SalaDao();
        Sala s;
        s = salaDao.finfById(id);
        return s;
    }
    
    public static List<Sala> findAll()
    {
        SalaDao salaDao = new SalaDao();
        List<Sala> s = salaDao.findAll();
        return s;
    }
    
    public static void save(Sala s)
    {
        SalaDao salaDao = new SalaDao();
        salaDao.create(s);
    }
    
    public static void update(Sala s)
    {
        SalaDao salaDao = new SalaDao();
        salaDao.modify(s);
    }
    
    public static void delete(Sala s)
    {
        SalaDao salaDao = new SalaDao();
        salaDao.erase(s);
    }
}
