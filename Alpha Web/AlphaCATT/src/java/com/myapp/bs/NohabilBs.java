/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.bs;

import com.myapp.dao.NohabilDao;
import com.myapp.dao.SalaDao;
import com.myapp.model.Nohabil;
import com.myapp.model.Sala;
import java.util.List;

/**
 *
 * @author Hazzy76
 */
public class NohabilBs {
    
    public static Nohabil findById(int id)
    {
        NohabilDao nohabilDao = new NohabilDao();
        Nohabil nohabil;
        nohabil = nohabilDao.finfById(id);
        return nohabil;
    }
    
    public static List<Nohabil> findAll()
    {
        NohabilDao nohabilDao = new NohabilDao();
        List<Nohabil> nohabiles = nohabilDao.findAll();
        return nohabiles;
    }
    
    public static void save(Nohabil nohabil)
    {
        NohabilDao nohabilDao = new NohabilDao();
        nohabilDao.create(nohabil);
    }
    
    public static void update(Nohabil nohabil)
    {
        NohabilDao nohabilDao = new NohabilDao();
        nohabilDao.modify(nohabil);
    }
    
    public static void delete(Nohabil nohabil)
    {
        NohabilDao nohabilDao = new NohabilDao();
        nohabilDao.erase(nohabil);
    }
}
