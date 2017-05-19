/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.bs;

import com.myapp.dao.RangoDao;
import com.myapp.model.Rango;
import java.util.List;

/**
 *
 * @author hazzy76
 */
public class RangoBs {
        
    public static Rango findById(int id)
    {
        RangoDao rangoDao = new RangoDao();
        Rango rango;
        rango = rangoDao.finfById(id);
        return rango;
    }
    
    public static List<Rango> findAll()
    {
        RangoDao rangoDao = new RangoDao();
        List<Rango> rangoes = rangoDao.findAll();
        return rangoes;
    }
    
    public static void save(Rango rango)
    {
        RangoDao rangoDao = new RangoDao();
        rangoDao.create(rango);
    }
    
    public static void update(Rango rango)
    {
        RangoDao rangoDao = new RangoDao();
        rangoDao.modify(rango);
    }
    
    public static void delete(Rango rango)
    {
        RangoDao rangoDao = new RangoDao();
        rangoDao.erase(rango);
    }
    
}
