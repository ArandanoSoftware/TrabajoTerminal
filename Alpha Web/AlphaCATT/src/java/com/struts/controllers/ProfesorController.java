
package com.struts.controllers;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;


import com.myapp.model.Profesor;
import com.struts.operaciones.ProfesoresOperaciones;

public class ProfesorController  extends ActionSupport {

    private static final long serialVersionUID = 1L;

    // Datos de
    private ArrayList<Profesor> datos;
    private ProfesoresOperaciones ProfOP;
    private Profesor prof;
    private int id;


    private String Nombre;
    private String APaterno;
    private String AMaterno;
    private String Email;

     public ArrayList<Profesor> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<Profesor> datos) {
        this.datos = datos;
    }

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

 public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getAPaterno() {
        return APaterno;
    }

    public void setAPaterno(String APaterno) {
        this.APaterno = APaterno;
    }

    public String getAMaterno() {
        return AMaterno;
    }

    public void setAMaterno(String AMaterno) {
        this.AMaterno = AMaterno;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
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

  public String deleteProf()
  {
      this.ProfOP = new ProfesoresOperaciones();
      this.ProfOP.deleteProf(id);
      return SUCCESS;
  }
  public String regProf()
  {
    this.ProfOP= new ProfesoresOperaciones();
    this. ProfOP.regProf(Nombre, APaterno, AMaterno,Email);
    return SUCCESS;
  }
  
  public String populateSelect() {
        this.ProfOP = new ProfesoresOperaciones();
        this.datos = new ArrayList<>();
        this.datos = ProfOP.getUsuarios();
        return "none";
    }


}
