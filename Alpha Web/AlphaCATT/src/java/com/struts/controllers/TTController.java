package com.struts.controllers;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
//Model imports 
import com.myapp.model.Profesor;
import com.myapp.model.Tt;
//Operations and Bs Imports 
import com.struts.operaciones.TTOperaciones;
import com.myapp.bs.ProfesorBs;


public class TTController  extends ActionSupport {
    
    private List<Profesor> ProfList;
    private ArrayList<Tt> datos;
    
    private TTOperaciones ttOP;
    private ProfesorBs  profBs;
    private Tt tt;
    
   

    
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
        return ProfList;
    }
    public void setProfList(List<Profesor> ProfList) {
        this.ProfList = ProfList;
    } 
    
    @Override
    public String execute() throws Exception
        {
          return SUCCESS;
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
    
    


}
