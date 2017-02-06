/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.bs;

import com.myapp.dao.ProfesorDao;
import com.myapp.model.Profesor;
import java.util.List;

/**
 *
 * @author root
 */
public class ProfesorBs {
    
    protected static ProfesorDao profesorDao = new ProfesorDao();
    
    public static Profesor findById(int id)
    {
        Profesor p;
        p = profesorDao.finfById(id);
        return p;
    }
    
    public static List<Profesor> findAll()
    {
        List<Profesor> p = profesorDao.findAll();
                return p;
    }
    
    public static void save(Profesor p)
    {
        profesorDao.create(p);
    }
    
    public static void update(Profesor p)
    {
        profesorDao.modify(p);
    }
    
    public static void delete(Profesor p)
    {
        profesorDao.erase(p);
    }
}
