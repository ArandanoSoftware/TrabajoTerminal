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
    
    public static Profesor findById(int id)
    {
        ProfesorDao profesorDao = new ProfesorDao();
        Profesor p;
        p = profesorDao.finfById(id);
        return p;
    }
    
    public static List<Profesor> findAll()
    {
        ProfesorDao profesorDao = new ProfesorDao();
        List<Profesor> p = profesorDao.findAll();
        return p;
    }
    
    public static void save(Profesor p)
    {
        ProfesorDao profesorDao = new ProfesorDao();
        profesorDao.create(p);
    }
    
    public static void update(Profesor p)
    {
        ProfesorDao profesorDao = new ProfesorDao();
        profesorDao.modify(p);
    }
    
    public static void delete(Profesor p)
    {
        ProfesorDao profesorDao = new ProfesorDao();
        profesorDao.erase(p);
    }
}
