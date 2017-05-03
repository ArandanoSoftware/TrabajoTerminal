
package com.struts.controllers;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.operaciones.CalendarOperaciones;

import java.util.ArrayList;
import java.util.List;
import com.myapp.model.Calendario;
import com.myapp.dao.CalendarioDao;


public class CalendarController extends ActionSupport{

    
    private CalendarioDao CalDao;
    private CalendarOperaciones CalOp;
    private ArrayList<Calendario> CalList;
    private List<Calendario> CalDaoList;

    public ArrayList<Calendario> getCalList() {
        return CalList;
    }

    public void setCalList(ArrayList<Calendario> CalList) {
        this.CalList = CalList;
    }
    
    public List<Calendario> getCalDaoList() {
        return CalDaoList;
    }

    public void setCalDaoList(List<Calendario> CalDaoList) {
        this.CalDaoList = CalDaoList;
    }

    public CalendarOperaciones getCalOp() {
        return CalOp;
    }

    public void setCalOp(CalendarOperaciones CalOp) {
        this.CalOp = CalOp;
    }
    
    public CalendarioDao getCalDao() {
        return CalDao;
    }

    public void setCalDao(CalendarioDao CalDao) {
        this.CalDao = CalDao;
    }

    @Override
    public String execute() throws Exception{

        return "success";
    }
    public String calendar()
    {
      this.CalDao = new CalendarioDao();
      CalDaoList= this.CalDao.findAll();
      return SUCCESS;
    }


}
