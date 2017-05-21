/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.bs;

import com.myapp.dao.ProfesorDao;
import com.myapp.model.Horario;
import com.myapp.model.Profesor;
import java.util.Arrays;
import java.util.HashSet;
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
        //p.setHorarios(new HashSet<>(HorarioBs.findByProf(p)));
        return p;
    }
    
    public static List<Profesor> findAll()
    {
        ProfesorDao profesorDao = new ProfesorDao();
        List<Profesor> p = profesorDao.findAll();
//        for(int i = 0; i < p.size();i++)
//        {
//            p.get(i).setHorarios(new HashSet<>(HorarioBs.findByProf(p.get(i))));
//        }
        return p;
    }
    
    public static void save(Profesor p)
    {
        ProfesorDao profesorDao = new ProfesorDao();
        profesorDao.create(p);
        List<Horario> h = Arrays.asList(p.getHorarios().toArray(new Horario[0]));
        for(int i = 0; i < h.size(); i++)
        {
            HorarioBs.save(h.get(i));
        }
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
