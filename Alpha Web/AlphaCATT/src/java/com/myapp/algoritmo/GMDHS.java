/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.algoritmo;

/**
 *
 * @author root
 */
public class GMDHS {
    
    private boolean[] mes;
    private boolean[] dia;
    private boolean[] hora;
    private boolean[] sala;
    
    public GMDHS()
    {
        this.mes = new boolean[4];
        this.dia = new boolean[5];
        this.hora = new boolean[9];
        this.sala = new boolean[4];
    }

    public boolean[] getMes() {
        return mes;
    }

    public void setMes(boolean[] mes) {
        this.mes = mes;
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

    public boolean[] getSala() {
        return sala;
    }

    public void setSala(boolean[] sala) {
        this.sala = sala;
    }
    
}
