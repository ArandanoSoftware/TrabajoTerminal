
package com.struts.controllers;

import com.myapp.bs.AlumnoBs;
import com.opensymphony.xwork2.ActionSupport;
import com.struts.operaciones.CalendarOperaciones;

import java.util.ArrayList;
import java.util.List;

import com.myapp.model.Calendario;
import com.myapp.dao.CalendarioDao;
import com.myapp.bs.CalendarioBs;

import com.myapp.bs.DirigeBs;
import com.myapp.bs.SalaBs;
import com.myapp.bs.TTBs;
import com.myapp.model.Alumno;
import com.myapp.model.Dirige;
import com.myapp.model.Sala;

import com.myapp.model.Sinodalia;
import com.myapp.model.Tt;
import java.util.Date;
import prueba.mianPrueba;


public class CalendarController extends ActionSupport{

    // Classes
    //private CalendarioDao CalDao;
    //private CalendarOperaciones CalOp;
    //private CalendarioBs CalBs;
    
    //private  DirigeBs DirBs;

   

    //Datos entrada
    private String id;
    
    
    //Listas de Salida
    private List<Calendario> CalList;
    //private List<Dirige> DirList;
    //private List<Sinodalia> SinList;
    
    private Dirige Dirige;

    public Dirige getDirige() {
        return Dirige;
    }

    public void setDirige(Dirige Dirige) {
        this.Dirige = Dirige;
    }

//    public CalendarioDao getCalDao() {
//        return CalDao;
//    }
//
//    public void setCalDao(CalendarioDao CalDao) {
//        this.CalDao = CalDao;
//    }
//
//    public CalendarOperaciones getCalOp() {
//        return CalOp;
//    }
//
//    public void setCalOp(CalendarOperaciones CalOp) {
//        this.CalOp = CalOp;
//    }
//
//    public CalendarioBs getCalBs() {
//        return CalBs;
//    }
//
//    public void setCalBs(CalendarioBs CalBs) {
//        this.CalBs = CalBs;
//    }
    public List<Calendario> getCalList() {
        return CalList;
    }

    //Outputs
    public void setCalList(List<Calendario> CalList) {
        this.CalList = CalList;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

  
    

    @Override
    public String execute() throws Exception{

        return "success";
    }
    public String calendar() throws Exception
    {
        //Calendario tt = CalendarioBs.findById(7144);
        //Alumno tt = AlumnoBs.findById(2012630055);
      //List<Calendario> calendario = CalendarioBs.findByOption(1);
      //Calendario cc = CalendarioBs.findById(7144);
      //System.out.println("\n\n\n\n\n " + tt.getTt().getIdTt() + "\n\n\n\n");
      //this.CalOp = new CalendarOperaciones();
      CalList= CalendarioBs.findByOption(1);// this.CalOp.getCalendar();
      //this.DirBs = new DirigeBs();
      //Dirige= this.DirBs.findById(Integer.toString(1));
      //Calendario cc = new Calendario(TTBs.findById("2016-B088"), new Date(1993,7,6), new Sala("la sala xD"), 1);
      //CalList.add(cc);
        //mianPrueba prueba = new mianPrueba();
        //prueba.regresa();
        String [] prub = new String[0];
        //mianPrueba.main(prub);
      return SUCCESS;
    }
    public String Directors()
    {
      //this.DirBs = new DirigeBs();
      Dirige = DirigeBs.findById(id);
      return SUCCESS;
    }


}
