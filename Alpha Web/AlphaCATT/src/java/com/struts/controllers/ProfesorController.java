
package com.struts.controllers;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;

import com.myapp.model.Profesor;
import com.struts.operaciones.ProfesoresOperaciones;

public class ProfesorController  extends ActionSupport {
    
    private static final long serialVersionUID = 1L;

    private ArrayList<Profesor> datos;
    
    private ProfesoresOperaciones ProfOP;
    private Profesor prof;

    public ProfesoresOperaciones getProfOP() {
        return ProfOP;
    }

    public void setProfOP(ProfesoresOperaciones ProfOP) {
        this.ProfOP = ProfOP;
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
          return SUCCESS;
  }

  public String profs() throws Exception
    {
        this.ProfOP = new ProfesoresOperaciones();
        this.datos = ProfOP.getUsuarios();
        return SUCCESS;
    }

}
