/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.bs;

import com.myapp.dao.SinodaliaDao;
import com.myapp.model.Sinodalia;
import java.util.List;

/**
 *
 * @author root
 */
public class SinodaliaBs {
    public static Sinodalia findById(String id)
    {
        SinodaliaDao sinodaliaDao = new SinodaliaDao();
        Sinodalia sinodalia = sinodaliaDao.findById(id);
        sinodalia.setProfesorByS1(ProfesorBs.findById(sinodalia.getProfesorByS1().getIdProfesor()));
        sinodalia.setProfesorByS2(ProfesorBs.findById(sinodalia.getProfesorByS2().getIdProfesor()));
        sinodalia.setProfesorByS3(ProfesorBs.findById(sinodalia.getProfesorByS3().getIdProfesor()));
        return sinodalia;
    }
    
    public static List<Sinodalia> findAll()
    {
        SinodaliaDao sinodaliaDao = new SinodaliaDao();
        List<Sinodalia> sinodalia = sinodaliaDao.findAll();
        return sinodalia;
    }
    
    public static void save(Sinodalia sinodalia)
    {
        SinodaliaDao sinodaliaDao = new SinodaliaDao();
        sinodaliaDao.create(sinodalia);
    }
    
    public static void update(Sinodalia sinodalia)
    {
        SinodaliaDao sinodaliaDao = new SinodaliaDao();
        sinodaliaDao.modify(sinodalia);
    }
    
    public static void delete(Sinodalia sinodalia)
    {
        SinodaliaDao sinodaliaDao = new SinodaliaDao();
        sinodaliaDao.erase(sinodalia);
    }
}
