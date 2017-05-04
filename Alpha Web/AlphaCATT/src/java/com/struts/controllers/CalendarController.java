
package com.struts.controllers;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.operaciones.CalendarOperaciones;

import java.util.ArrayList;
import java.util.List;
import com.myapp.model.Calendario;
import com.myapp.dao.CalendarioDao;
import com.myapp.bs.CalendarioBs;


public class CalendarController extends ActionSupport{

    // Classes 
    private CalendarioDao CalDao;
    private CalendarOperaciones CalOp;
    private CalendarioBs CalBs;
    //Outputs
    private ArrayList<Calendario> CalList;
    private List<Calendario> CalArrayList;
    
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

    public ArrayList<Calendario> getCalList() {
        return CalList;
    }

    public void setCalList(ArrayList<Calendario> CalList) {
        this.CalList = CalList;
    }

    public List<Calendario> getCalArrayList() {
        return CalArrayList;
    }

    public void setCalArrayList(List<Calendario> CalArrayList) {
        this.CalArrayList = CalArrayList;
    }
   
    @Override
    public String execute() throws Exception{

        return "success";
    }
    public String calendar()
    {
      this.CalBs = new CalendarioBs();
      CalArrayList= this.CalBs.findAll();
      return SUCCESS;
    }
    public String calendar2()
    {


      return SUCCESS;
    }

}
