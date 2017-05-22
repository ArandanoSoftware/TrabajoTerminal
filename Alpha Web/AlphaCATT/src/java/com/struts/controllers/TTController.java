package com.struts.controllers;

import com.myapp.bs.DirigeBs;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
//Model imports 
import com.myapp.model.Profesor;
import com.myapp.model.Tt;
//Operations and Bs Imports 
import com.struts.operaciones.TTOperaciones;
import com.myapp.bs.ProfesorBs;
import com.myapp.bs.SinodaliaBs;
import com.myapp.bs.TTBs;
import com.myapp.model.Alumno;
import com.myapp.model.Dirige;
import com.myapp.model.Sinodalia;


public class TTController  extends ActionSupport {
    
    private ArrayList<Tt> datos;
    
    private TTOperaciones ttOP;
    private ProfesorBs  profBs;
    private Tt tt;
    
    
    
    private List<Profesor> profList = ProfesorBs.findAll();
    private Dirige directores;
    private Sinodalia sinodales;
    private Alumno alumno;

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    

    public ProfesorBs getProfBs() {
        return profBs;
    }

    public void setProfBs(ProfesorBs profBs) {
        this.profBs = profBs;
    }

    public Dirige getDirectores() {
        return directores;
    }

    public void setDirectores(Dirige directores) {
        this.directores = directores;
    }

    public Sinodalia getSinodales() {
        return sinodales;
    }

    public void setSinodales(Sinodalia sinodales) {
        this.sinodales = sinodales;
    }
    
   

    
    private String  id;

    public String  getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public ArrayList<Tt> getDatos() {
        return datos;
    }
    public void setDatos(ArrayList<Tt> datos) {
        this.datos = datos;
    }
    public TTOperaciones getTtOP() {
        return ttOP;
    }
    public void setTtOP(TTOperaciones ttOP) {
        this.ttOP = ttOP;
    }
    public Tt getTt() {
        return tt;
    }
    public void setTt(Tt tt) {
        this.tt = tt;
    }

    public List<Profesor> getProfList() {
        return profList;
    }
    public void setProfList(List<Profesor> profList) {
        this.profList = profList;
    } 

    public String tts() throws Exception
    {
        this.ttOP = new TTOperaciones();
        this.datos = ttOP.getTts();
        return SUCCESS;
    }


    public String deleteTt()
    {
         this.ttOP = new TTOperaciones();
         this.ttOP.deleteTt(id);
         return SUCCESS;
    }
    
    
    
    @Override
    public String execute() throws Exception
        {
            profList = ProfesorBs.findAll();
          return SUCCESS;
        }

    public String regTt()
    {
        TTBs.save(tt);
        directores.setIdTt(tt.getIdTt());
        sinodales.setIdTt(tt.getIdTt());
        DirigeBs.save(directores);
        SinodaliaBs.save(sinodales);
        return SUCCESS;
    }
}
