/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.algoritmo;

import com.myapp.bs.RestriccionBs;
import com.myapp.modulo.Genetico;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Hazzy76
 */
public class RestriccionGeneral {
    private List<Restriccion> restricciones;
    private final int profesor;

    public RestriccionGeneral(int prof)
    {
        this.profesor = prof;
        //restricciones = new ArrayList<>();
    }

    public List<Restriccion> getRestricciones() {
        for(int i = 0; i < restricciones.size(); i++)
        {
            restricciones.get(i).setIdProfesor(profesor);
        }
        return restricciones;
    }

    public void setRestricciones(List<Restriccion> restricciones) {
        this.restricciones = restricciones;
    }
    
    public void setRango(Date rango1, Date rango2)
    {
        Date date1 = new Date();
        Date date2 = new Date();
        date1.setMonth(rango1.getMonth());
        date1.setDate(rango1.getDate());
        date2.setMonth(rango2.getMonth());
        date2.setDate(rango2.getDate());
        //boolean[] allday = {true, true, true, true, true, true, true, true, true};
        date2.setDate(date2.getDate()+1);
        while(!fechaIgual(date1, date2))
        {
            Restriccion restriccion = new Restriccion();
            //restriccion.setMes(Genetico.getBinMonth(date1));
            //restriccion.setDia(Genetico.getBinDay(date1));
            //restriccion.setHora(allday);
            date2.setHours(0);
            restriccion.setFecha(date1);
            restriccion.setIdProfesor(profesor);
            RestriccionBs.save(restriccion);
            //restricciones.add(restriccion);
            date1.setDate(date1.getDate()+1);
        }
    }
    
    public void setDiaSem(int dia, Date rango1, Date rango2)
    {
        Date date1 = new Date();
        Date date2 = new Date();
        date1.setMonth(rango1.getMonth());
        date1.setDate(rango1.getDate());
        date2.setMonth(rango2.getMonth());
        date2.setDate(rango2.getDate());
        //boolean[] allday = {true, true, true, true, true, true, true, true, true};
        date2.setDate(date2.getDate()+1);
        Restriccion restriccion;
        while(!fechaIgual(date1, date2))
        {
            if(dia == date1.getDay())
            {            
                restriccion = new Restriccion();
                //restriccion.setMes(Genetico.getBinMonth(date1));
                //restriccion.setDia(Genetico.getBinDay(date1));
                //restriccion.setHora(allday);
                date1.setHours(0);
                restriccion.setFecha(date1);
                restriccion.setIdProfesor(profesor);
                RestriccionBs.save(restriccion);
                //restricciones.add(restriccion);
            }
            date1.setDate(date1.getDate()+1);
        }
    }
    
    public void setHora(int hora, Date rango1, Date rango2)
    {
        Date date1 = new Date();
        Date date2 = new Date();
        date1.setMonth(rango1.getMonth());
        date1.setDate(rango1.getDate());
        date2.setMonth(rango2.getMonth());
        date2.setDate(rango2.getDate());
        //boolean[] allday = {false, false, false, false, false, false, false, false, false};
        //1 = 10:00     2 = 12:00   3 = 14:00   4 = 16:00
        if(hora == 1)date1.setHours(10);//allday[2] = true;
        if(hora == 2)date1.setHours(12);//allday[3] = true;
        if(hora == 3)date1.setHours(14);//allday[4] = true;
        if(hora == 4)date1.setHours(16);//allday[6] = true;
        date2.setDate(date2.getDate()+1);
        Restriccion restriccion;
        while(!fechaIgual(date1, date2))
        {
            restriccion = new Restriccion();
            //restriccion.setMes(Genetico.getBinMonth(date1));
            //restriccion.setDia(Genetico.getBinDay(date1));
            //restriccion.setHora(allday);
            restriccion.setFecha(date1);
            restriccion.setIdProfesor(profesor);
            RestriccionBs.save(restriccion);
            //restricciones.add(restriccion);
            date1.setDate(date1.getDate()+1);
        }
    }
    
    public void setDia(Date rango)
    {
        Date date = new Date();
        date.setMonth(rango.getMonth());
        date.setDate(rango.getDate());
        Restriccion restriccion = new Restriccion();
        //boolean[] allday = {false, false, false, false, false, false, false, false, false};
        //restriccion.setMes(Genetico.getBinMonth(date));
        //restriccion.setDia(Genetico.getBinDay(date));
        //restriccion.setHora(allday);
        date.setHours(0);
        restriccion.setFecha(date);
        restriccion.setIdProfesor(profesor);
        RestriccionBs.save(restriccion);
        //restricciones.add(restriccion);
    }
    
    protected boolean fechaIgual(Date date1, Date date2)
    {
        if(date1.getYear() != date2.getYear())return false;
        if(date1.getMonth()!= date2.getMonth())return false;
        if(date1.getDate()!= date2.getDate())return false;
        return true;
    }
}
