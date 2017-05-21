/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.bs;

import com.myapp.dao.DirigeDao;
import com.myapp.model.Dirige;
import java.util.List;

/**
 *
 * @author root
 */
public class DirigeBs {
        public static Dirige findById(String id)
    {
        DirigeDao dirigeDao = new DirigeDao();
        Dirige dirige = dirigeDao.findById(id);
//        dirige.setProfesorByD1(ProfesorBs.findById(dirige.getProfesorByD1().getIdProfesor()));
//        try{dirige.setProfesorByD2(ProfesorBs.findById(dirige.getProfesorByD2().getIdProfesor()));}catch(Exception e){}
        return dirige;
    }
    
    public static List<Dirige> findAll()
    {
        DirigeDao dirigeDao = new DirigeDao();
        List<Dirige> dirige = dirigeDao.findAll();
//        for(int i = 0; i < dirige.size(); i++)
//        {
//            dirige.get(i).setProfesorByD1(ProfesorBs.findById(dirige.get(i).getProfesorByD1().getIdProfesor()));
//            try{dirige.get(i).setProfesorByD2(ProfesorBs.findById(dirige.get(i).getProfesorByD2().getIdProfesor()));}catch(Exception e){}
//        }
        return dirige;
    }
    
    public static void save(Dirige dirige)
    {
        DirigeDao dirigeDao = new DirigeDao();
        dirigeDao.create(dirige);
    }
    
    public static void update(Dirige dirige)
    {
        DirigeDao dirigeDao = new DirigeDao();
        dirigeDao.modify(dirige);
    }
    
    public static void delete(Dirige dirige)
    {
        DirigeDao dirigeDao = new DirigeDao();
        dirigeDao.erase(dirige);
    }
}
