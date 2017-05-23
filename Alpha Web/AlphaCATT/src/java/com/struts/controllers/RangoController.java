/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.struts.controllers;

import com.myapp.bs.RangoBs;
import com.myapp.model.Rango;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author hazzy76
 */
public class RangoController extends ActionSupport{
    
    Rango rango;
    String uno;
    String dos;

    public Rango getRango() {
        return rango;
    }

    public void setRango(Rango rango) {
        this.rango = rango;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String regFechas()
    {
        System.out.println("rangooooo " + uno + dos);
        RangoBs.save(rango);
        return SUCCESS;
    }
    
}
