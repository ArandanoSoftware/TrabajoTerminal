/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.struts.controllers;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;

import com.myapp.model.Sala;
import com.struts.operaciones.SalasOperaciones;


public class SalaController extends ActionSupport{

    private ArrayList<Sala> datos;
    private SalasOperaciones SalasOP;
    private Sala Sala;

     public ArrayList<Sala> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<Sala> datos) {
        this.datos = datos;
    }

    public SalasOperaciones getSalasOP() {
        return SalasOP;
    }

    public void setSalasOP(SalasOperaciones SalasOP) {
        this.SalasOP = SalasOP;
    }

    public Sala getSala() {
        return Sala;
    }

    public void setSala(Sala Sala) {
        this.Sala = Sala;
    }

    public String salas() throws Exception
    {
        this.SalasOP = new SalasOperaciones();
        this.datos = SalasOP.getUsuarios();
        return SUCCESS;
    }


}
