
package com.struts.controllers;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

import com.myapp.model.Profesor;
import com.myapp.bs.ProfesorBs;

public class ProfesorController  extends ActionSupport {

    private List<Profesor> datos;
    private String name;
    private ProfesorBs op;
    private Profesor prof;

    public List<Profesor> getDatos() {
        return datos;
    }

    public void setDatos(List<Profesor> datos) {
        this.datos = datos;
    }

    public ProfesorBs getOp() {
        return op;
    }

    public void setOp(ProfesorBs op) {
        this.op = op;
    }

    public Profesor getProf() {
        return prof;
    }

    public void setProf(Profesor prof) {
        this.prof = prof;
    }


  @Override
  public String execute() throws Exception
  {
      this.op = new  ProfesorBs();
      this.prof= this.op.findById(123);
      this.name=prof.getNombre();
      
      //call Service class to store personBean's state in database
      return SUCCESS;
  }

}
