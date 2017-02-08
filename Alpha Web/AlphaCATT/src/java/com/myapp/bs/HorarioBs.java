/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.bs;

import com.myapp.dao.HorarioDao;
import com.myapp.model.Horario;
import java.util.List;

/**
 *
 * @author root
 */
public class HorarioBs {
        
    public static Horario findById(int id)
    {
        HorarioDao horarioDao = new HorarioDao();
        Horario s;
        s = horarioDao.finfById(id);
        return s;
    }
    
    public static List<Horario> findAll()
    {
        HorarioDao horarioDao = new HorarioDao();
        List<Horario> s = horarioDao.findAll();
        return s;
    }
    
    public static void save(Horario s)
    {
        HorarioDao horarioDao = new HorarioDao();
        horarioDao.create(s);
    }
    
    public static void update(Horario s)
    {
        HorarioDao horarioDao = new HorarioDao();
        horarioDao.modify(s);
    }
    
    public static void delete(Horario s)
    {
        HorarioDao horarioDao = new HorarioDao();
        horarioDao.erase(s);
    }
}
