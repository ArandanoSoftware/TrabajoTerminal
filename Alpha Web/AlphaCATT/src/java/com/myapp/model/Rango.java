/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.model;

import java.util.Date;

/**
 *
 * @author hazzy76
 */
public class Rango {
    
    private Integer idRango;
    private Date fecha1;
    private Date fecha2;

    public Rango() {
    }

    public Rango(Date fecha1, Date fecha2) {
        this.fecha1 = fecha1;
        this.fecha2 = fecha2;
    }

    public Integer getIdRango() {
        return idRango;
    }

    public void setIdRango(Integer idRango) {
        this.idRango = idRango;
    }

    public Date getFecha1() {
        return fecha1;
    }

    public void setFecha1(Date fecha1) {
        this.fecha1 = fecha1;
    }

    public Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }
    
}
