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

    public Restriccion() {
        this.mes = new boolean[4];
        this.dia = new boolean[5];
        this.hora = new boolean[9];
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
    
}
