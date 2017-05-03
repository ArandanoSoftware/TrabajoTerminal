/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.bs;

import com.myapp.dao.CalendarioDao;
import com.myapp.model.Calendario;
import java.util.List;

/**
 *
 * @author root
 */
public class CalendarioBs {
    public static Calendario findById(String id)
    {
        CalendarioDao calendarioDao = new CalendarioDao();
        Calendario calendario = calendarioDao.findById(id);
        return calendario;
    }
    
    public static List<Calendario> findAll()
    {
        CalendarioDao calendarioDao = new CalendarioDao();
        List<Calendario> calendario = calendarioDao.findAll();
        for(int i = 0; i < calendario.size(); i++)
        {
            calendario.get(i).setSala(SalaBs.findById(calendario.get(i).getSala().getIdSala()));
            calendario.get(i).setTt(TTBs.findById(calendario.get(i).getIdTt()));
        }
        return calendario;
    }
    
    public static void save(Calendario calendario)
    {
        CalendarioDao calendarioDao = new CalendarioDao();
        calendarioDao.create(calendario);
    }
    
    public static void update(Calendario calendario)
    {
        CalendarioDao calendarioDao = new CalendarioDao();
        calendarioDao.modify(calendario);
    }
    
    public static void delete(Calendario calendario)
    {
        CalendarioDao calendarioDao = new CalendarioDao();
        calendarioDao.erase(calendario);
    }
    
    public static void close()
    {
        CalendarioDao calendarioDao = new CalendarioDao();
        calendarioDao.close();
    }
}
