
package com.struts.controllers;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.operaciones.CalendarOperaciones;

import java.util.ArrayList;
import java.util.List;

import com.myapp.model.Calendario;
import com.myapp.dao.CalendarioDao;
import com.myapp.bs.CalendarioBs;

import com.myapp.bs.DirigeBs;
import com.myapp.model.Dirige;

import com.myapp.model.Sinodalia;


public class CalendarController extends ActionSupport{

    // Classes
    private CalendarioDao CalDao;
    private CalendarOperaciones CalOp;
    private CalendarioBs CalBs;
    
    private  DirigeBs DirBs;

   

    //Datos entrada
    private int id;
    
    
    //Listas de Salida
    private List<Calendario> CalList;
    private List<Dirige> DirList;
    private List<Sinodalia> SinList;

    public CalendarioDao getCalDao() {
        return CalDao;
    }

    public void setCalDao(CalendarioDao CalDao) {
        this.CalDao = CalDao;
    }

    public CalendarOperaciones getCalOp() {
        return CalOp;
    }

    public void setCalOp(CalendarOperaciones CalOp) {
        this.CalOp = CalOp;
    }

    public CalendarioBs getCalBs() {
        return CalBs;
    }

    public void setCalBs(CalendarioBs CalBs) {
        this.CalBs = CalBs;
    }
    public List<Calendario> getCalList() {
        return CalList;
    }

    //Outputs
    public void setCalList(List<Calendario> CalList) {
        this.CalList = CalList;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
    

    @Override
    public String execute() throws Exception{

        return "success";
    }
    public String calendar()
    {
      this.CalOp = new CalendarOperaciones();
      CalList= this.CalOp.getCalendar();
      return SUCCESS;
    }
    public String Directors()
    {
      this.DirBs = new DirigeBs();
      DirList= this.DirBs.findById(id);
      return SUCCESS;
    }


}
