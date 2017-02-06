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
    
    protected static SalaDao profesorDao = new SalaDao();
    
    public static Sala findById(int id)
    {
        Sala p;
        p = profesorDao.finfById(id);
        return p;
    }
    
    public static List<Sala> findAll()
    {
        List<Sala> p = profesorDao.findAll();
                return p;
    }
    
    public static void save(Sala p)
    {
        profesorDao.create(p);
    }
    
    public static void update(Sala p)
    {
        profesorDao.modify(p);
    }
    
    public static void delete(Sala p)
    {
        profesorDao.erase(p);
    }
}
