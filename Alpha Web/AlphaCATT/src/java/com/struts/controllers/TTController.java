package com.struts.controllers;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;

import com.myapp.model.Tt;
import com.struts.operaciones.TTOperaciones;

public class TTController  extends ActionSupport {

    private ArrayList<Tt> datos;

    private TTOperaciones ttOP;
    private Tt tt;

     public ArrayList<Tt> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<Tt> datos) {
        this.datos = datos;
    }

    public TTOperaciones getTtOP() {
        return ttOP;
    }

    public void setTtOP(TTOperaciones ttOP) {
        this.ttOP = ttOP;
    }

    public Tt getTt() {
        return tt;
    }

    public void setTt(Tt tt) {
        this.tt = tt;
    }

     public String tts() throws Exception
    {
        this.ttOP = new TTOperaciones();
        this.datos = ttOP.getTts();
        return SUCCESS;
    }


}
