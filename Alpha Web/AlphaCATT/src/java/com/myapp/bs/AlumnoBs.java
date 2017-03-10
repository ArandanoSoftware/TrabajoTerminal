/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.bs;

import com.myapp.dao.AlumnoDao;
import com.myapp.model.Alumno;
import java.util.List;

/**
 *
 * @author root
 */
public class AlumnoBs {
        public static Alumno findById(String id)
    {
        AlumnoDao alumnoDao = new AlumnoDao();
        Alumno alumno = alumnoDao.findById(id);
        return alumno;
    }
    
    public static List<Alumno> findAll()
    {
        AlumnoDao alumnoDao = new AlumnoDao();
        List<Alumno> alumno = alumnoDao.findAll();
        return alumno;
    }
    
    public static void save(Alumno alumno)
    {
        AlumnoDao alumnoDao = new AlumnoDao();
        alumnoDao.create(alumno);
    }
    
    public static void update(Alumno alumno)
    {
        AlumnoDao alumnoDao = new AlumnoDao();
        alumnoDao.modify(alumno);
    }
    
    public static void delete(Alumno alumno)
    {
        AlumnoDao alumnoDao = new AlumnoDao();
        alumnoDao.erase(alumno);
    }
}
