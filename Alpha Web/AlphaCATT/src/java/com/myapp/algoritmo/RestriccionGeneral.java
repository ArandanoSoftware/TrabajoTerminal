/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.algoritmo;

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
        restricciones = new ArrayList<>();
    }

    public List<Restriccion> getRestricciones() {
        for(int i = 0; i < restricciones.size(); i++)
        {
            restricciones.get(i).setProfesor(profesor);
        }
        return restricciones;
    }

    public void setRestricciones(List<Restriccion> restricciones) {
        this.restricciones = restricciones;
    }
    
    public void setRango(Date date1, Date date2)
    {
        boolean[] allday = {true, true, true, true, true, true, true, true, true};
        date2.setDate(date2.getDate()+1);
        while(!fechaIgual(date1, date2))
        {
            Restriccion restriccion = new Restriccion();
            restriccion.setMes(Genetico.getBinMonth(date1));
            restriccion.setDia(Genetico.getBinDay(date1));
            restriccion.setHora(allday);
            restricciones.add(restriccion);
            date1.setDate(date1.getDate()+1);
        }
    }
    
    public void setDiaSem(int dia, Date date1, Date date2)
    {
        boolean[] allday = {true, true, true, true, true, true, true, true, true};
        date2.setDate(date2.getDate()+1);
        while(fechaIgual(date1, date2))
        {
            if(dia != date1.getDay() && date1.getDay() != 0 && date1.getDay() != 6)
            {            
                Restriccion restriccion = new Restriccion();
                restriccion.setMes(Genetico.getBinMonth(date1));
                restriccion.setDia(Genetico.getBinDay(date1));
                restriccion.setHora(allday);
                restricciones.add(restriccion);
                date1.setDate(date1.getDate()+1);
            }
        }
    }
    
    public void setHora(int hora, Date date1, Date date2)
    {
        boolean[] allday = {false, false, false, false, false, false, false, false, false};
        //1 = 10:00     2 = 12:00   3 = 14:00   4 = 16:00
        if(hora == 1)allday[2] = true;
        if(hora == 2)allday[3] = true;
        if(hora == 3)allday[4] = true;
        if(hora == 4)allday[6] = true;
        date2.setDate(date2.getDate()+1);
        while(fechaIgual(date1, date2))
        {
                Restriccion restriccion = new Restriccion();
                restriccion.setMes(Genetico.getBinMonth(date1));
                restriccion.setDia(Genetico.getBinDay(date1));
                restriccion.setHora(allday);
                restricciones.add(restriccion);
                date1.setDate(date1.getDate()+1);
        }
    }
    
    public void setDia(Date date)
    {
        Restriccion restriccion = new Restriccion();
        boolean[] allday = {false, false, false, false, false, false, false, false, false};
        restriccion.setMes(Genetico.getBinMonth(date));
        restriccion.setDia(Genetico.getBinDay(date));
        restriccion.setHora(allday);
        restricciones.add(restriccion);
    }
    
    protected boolean fechaIgual(Date date1, Date date2)
    {
        if(date1.getYear() != date2.getYear())return false;
        if(date1.getMonth()!= date2.getMonth())return false;
        if(date1.getDate()!= date2.getDate())return false;
        return true;
    }
}
