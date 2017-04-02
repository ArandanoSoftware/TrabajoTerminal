/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.algoritmo;

/**
 *
 * @author Hazzy76
 */
public class Restriccion {
    private boolean[] mes;
    private boolean[] dia;
    private boolean[] hora;
    private boolean[] profesor;

    public Restriccion() {
        this.mes = new boolean[4];
        this.dia = new boolean[5];
        this.hora = new boolean[9];
        this.profesor = new boolean[8];
    }

    public boolean[] getDia() {
        return dia;
    }

    public void setDia(boolean[] dia) {
        this.dia = dia;
    }

    public boolean[] getHora() {
        return hora;
    }

    public void setHora(boolean[] hora) {
        this.hora = hora;
    }

    public boolean[] getMes() {
        return mes;
    }

    public void setMes(boolean[] mes) {
        this.mes = mes;
    }

    public boolean[] getProfesor() {
        return profesor;
    }

    public void setProfesor(boolean[] profesor) {
        this.profesor = profesor;
    }
    
}
