
package com.struts.controllers;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.operaciones.CalendarOperaciones;

import java.util.ArrayList;
import com.myapp.model.Calendario;


public class CalendarController extends ActionSupport{

    private CalendarOperaciones CalOp;
    private ArrayList<Calendario> CalList;

    public ArrayList<Calendario> getCalList() {
        return CalList;
    }

    public void setCalList(ArrayList<Calendario> CalList) {
        this.CalList = CalList;
    }
   

     
  

    public CalendarOperaciones getCalOp() {
        return CalOp;
    }

    public void setCalOp(CalendarOperaciones CalOp) {
        this.CalOp = CalOp;
    }
    
    @Override
    public String execute() throws Exception{

        return "success";
    }
    public String calendar()
    {
      this.CalOp =  new CalendarOperaciones();
      this.CalList = CalOp.getCalendar();
      System.out.print(CalList);
      return SUCCESS;
    }


}
