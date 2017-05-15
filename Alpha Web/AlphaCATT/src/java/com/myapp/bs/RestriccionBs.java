/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.bs;

import com.myapp.algoritmo.Restriccion;
import com.myapp.dao.RestriccionDao;
import java.util.List;

/**
 *
 * @author Hazzy76
 */
public class RestriccionBs {
    
    public static Restriccion findById(int id)
    {
        RestriccionDao restriccionDao = new RestriccionDao();
        Restriccion s;
        s = restriccionDao.finfById(id);
        return s;
    }
    
    public static List<Restriccion> findAll()
    {
        RestriccionDao restriccionDao = new RestriccionDao();
        List<Restriccion> restricciones = restriccionDao.findAll();
        return restricciones;
    }
    
    public static void save(Restriccion restriccion)
    {
        RestriccionDao restriccionDao = new RestriccionDao();
        restriccionDao.create(restriccion);
    }
    
    public static void update(Restriccion restriccion)
    {
        RestriccionDao restriccionDao = new RestriccionDao();
        restriccionDao.modify(restriccion);
    }
    
    public static void delete(Restriccion restriccion)
    {
        RestriccionDao restriccionDao = new RestriccionDao();
        restriccionDao.erase(restriccion);
    }
}
