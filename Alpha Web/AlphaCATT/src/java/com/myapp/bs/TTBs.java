/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.bs;

import com.myapp.dao.TTDao;
import com.myapp.model.Tt;
import java.util.List;

/**
 *
 * @author root
 */
public class TTBs {
            
    public static Tt findById(String id)
    {
        TTDao ttDao = new TTDao();
        Tt tt = ttDao.findById(id);
        return tt;
    }
    
    public static List<Tt> findAll()
    {
        TTDao ttDao = new TTDao();
        List<Tt> tt = ttDao.findAll();
        return tt;
    }
    
    public static void save(Tt tt)
    {
        TTDao ttDao = new TTDao();
        ttDao.create(tt);
    }
    
    public static void update(Tt tt)
    {
        TTDao ttDao = new TTDao();
        ttDao.modify(tt);
    }
    
    public static void delete(Tt tt)
    {
        TTDao ttDao = new TTDao();
        ttDao.erase(tt);
    }
}
