
package com.struts.controllers;

import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

import com.myapp.model.Calendario;
import com.myapp.bs.CalendarioBs;

import com.myapp.bs.DirigeBs;
import com.myapp.bs.SinodaliaBs;
import com.myapp.model.Dirige;

import com.myapp.model.Sinodalia;
import com.myapp.modulo.PDF;
import java.io.File;


public class CalendarController extends ActionSupport{

    //Datos entrada
    
    
    //Listas de Salida
    private List<Calendario> CalList;
    private List<Dirige> DirList = new ArrayList<>();
    private List<Sinodalia> SinList = new ArrayList<>();
    
    private int opcion;
    private List<String> opciones = new ArrayList<>();

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }
    
    
    
    private Dirige Dirige;

    public Dirige getDirige() {
        return Dirige;
    }

    public void setDirige(Dirige Dirige) {
        this.Dirige = Dirige;
    }

    public List<Dirige> getDirList() {
        return DirList;
    }

    public void setDirList(List<Dirige> DirList) {
        this.DirList = DirList;
    }

    public List<Sinodalia> getSinList() {
        return SinList;
    }

    public void setSinList(List<Sinodalia> SinList) {
        this.SinList = SinList;
    }
    public List<Calendario> getCalList() {
        return CalList;
    }

    //Outputs
    public void setCalList(List<Calendario> CalList) {
        this.CalList = CalList;
    }

  
    

    @Override
    public String execute() throws Exception{
        return "success";
    }
    public String calendar() throws Exception
    {
        opciones.add("Calendario 1");
        opciones.add("Calendario 2");
        opciones.add("Calendario 3");
        opciones.add("Calendario 4");
        opciones.add("Calendario 5");
      CalList = orderCal(CalendarioBs.findByOption(1));
      return SUCCESS;
    }
    
        protected List<Calendario> orderCal(List<Calendario> cal)
    {
        List<Calendario> diez = new ArrayList<>();
        List<Calendario> doce = new ArrayList<>();
        List<Calendario> dos = new ArrayList<>();
        List<Calendario> cuatro = new ArrayList<>();
        
        for(int i = 0; i < cal.size(); i++)
        {
            if(cal.get(i).getFecha().getHours() == 10) diez.add(cal.get(i));
            if(cal.get(i).getFecha().getHours() == 12) doce.add(cal.get(i));
            if(cal.get(i).getFecha().getHours() == 14) dos.add(cal.get(i));
            if(cal.get(i).getFecha().getHours() == 16) cuatro.add(cal.get(i));
        }
        diez.addAll(doce);
        diez.addAll(dos);
        diez.addAll(cuatro);
        List<Calendario> calen = new ArrayList<>();
        Calendario temp;
        int tam = diez.size();
        for (int i=0; i < tam; i++)
        {
            temp = menor(diez);
            calen.add(temp);
            Dirige dir = DirigeBs.findById(temp.getTt().getIdTt());
            DirList.add(DirigeBs.findById(temp.getTt().getIdTt()));
            SinList.add(SinodaliaBs.findById(temp.getTt().getIdTt()));
            diez.remove(temp);
        }
        return calen;
    }
    
    protected Calendario menor(List<Calendario> calendario)
    {
        Calendario returnear = calendario.get(0);
        for(int i = 1; i < calendario.size(); i++)
        {
            if(returnear.getFecha().getMonth() > calendario.get(i).getFecha().getMonth()) returnear = calendario.get(i);
            else if(returnear.getFecha().getMonth() == calendario.get(i).getFecha().getMonth())
            {
                if(returnear.getFecha().getDate() > calendario.get(i).getFecha().getDate())returnear = calendario.get(i);
            }
        }
        return returnear;
    }
    
    public String selectCal()
    {
        if(opcion == 1)return cal1();
        if(opcion == 2)return cal2();
        if(opcion == 3)return cal3();
        if(opcion == 4)return cal4();
        if(opcion == 5)return cal5();
        return SUCCESS;
    }
    
    public String cal1()
    {
        CalList = orderCal(CalendarioBs.findByOption(1));
        return SUCCESS;
    }
    public String cal2()
    {
        CalList = orderCal(CalendarioBs.findByOption(2));
        return SUCCESS;
    }
    public String cal3()
    {
        CalList = orderCal(CalendarioBs.findByOption(3));
        return SUCCESS;
    }
    public String cal4()
    {
        CalList = orderCal(CalendarioBs.findByOption(4));
        return SUCCESS;
    }
    public String cal5()
    {
        CalList = orderCal(CalendarioBs.findByOption(5));
        return SUCCESS;
    }
    
    public String generaPDF()
    {
        PDF pdf = new PDF();
        pdf.createPDF(new File("../Calendario"+opcion+".pdf"), opcion);
        return SUCCESS;
    }
}