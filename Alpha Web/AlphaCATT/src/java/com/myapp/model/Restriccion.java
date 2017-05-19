/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.model;

import com.myapp.modulo.Genetico;
import java.util.Date;

/**
 *
 * @author Hazzy76
 */
public class Restriccion {
    private Integer id;
    private Date fecha;
    private boolean[] mes;
    private boolean[] dia;
    private boolean[] hora;
    private int idProfesor;

    public Restriccion() {
        this.mes = new boolean[4];
        this.dia = new boolean[5];
        this.hora = new boolean[9];
    }

    public Restriccion(Date fecha, int idProfesor) {
       this.fecha = fecha;
       this.idProfesor = idProfesor;
    }

   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date Fecha) {
        this.fecha = Fecha;
    }
    
    public boolean[] getDia() {
        dia = Genetico.getBinDay(fecha);
        return dia;
    }

    public void setDia(boolean[] dia) {
        this.dia = dia;
    }

    public boolean[] getHora() {
        boolean[] allday = {false,false,false,false,false,false,false,false,false};
        hora = allday;
        int horas = fecha.getHours();
        //1 = 10:00     2 = 12:00   3 = 14:00   4 = 16:00
        if(horas == 10) hora[2] = true;
        if(horas == 12) hora[3] = true;
        if(horas == 14) hora[4] = true;
        if(horas == 16) hora[6] = true;
        if(horas == 0)
        {
            allday[0] = true; allday[1] = true; allday[2] = true; allday[3] = true; allday[4] = true; allday[5] = true; allday[6] = true; allday[7] = true; allday[8] = true;
            hora = allday;
        }
        return hora;
    }

    public void setHora(boolean[] hora) {
        this.hora = hora;
    }

    public boolean[] getMes() {
        mes = Genetico.getBinMonth(fecha);
        return mes;
    }

    public void setMes(boolean[] mes) {
        this.mes = mes;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }
    
}
