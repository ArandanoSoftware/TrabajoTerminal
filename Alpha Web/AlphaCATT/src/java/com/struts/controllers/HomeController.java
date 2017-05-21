package com.struts.controllers;
import com.opensymphony.xwork2.ActionSupport;

import com.myapp.bs.ProfesorBs;
import com.myapp.bs.SalaBs;
import com.myapp.bs.TTBs;
import com.myapp.model.Profesor;
import java.util.List;

public class HomeController extends ActionSupport {
   
    
    private ProfesorBs profBs;
    private SalaBs salasBs;
    private TTBs ttBs;
 
    private Integer totalProfesores;
    private Integer totalRestriccionesProf;
    private Integer totalTrabajosTerminales;
    private Integer totalSalas;

    
  @Override
  public String execute() throws Exception
  {
     
      return SUCCESS;
  }
  
  public String home()
  {   
      
      this.totalProfesores =  profBs.findAll().size();
      this.totalSalas = salasBs.findAll().size();
      this.totalTrabajosTerminales = ttBs.findAll().size();
      return "success";
  }
    
  /**
   *  
   * Getter  & Setters
   * 
   */
  
      public ProfesorBs getProfBs() {
        return profBs;
    }

    public void setProfBs(ProfesorBs profBs) {
        this.profBs = profBs;
    }

    public Integer getTotalProfesores() {
        return totalProfesores;
    }

    public void setTotalProfesores(Integer totalProfesores) {
        this.totalProfesores = totalProfesores;
    }

    public Integer getTotalRestriccionesProf() {
        return totalRestriccionesProf;
    }

    public void setTotalRestriccionesProf(Integer totalRestriccionesProf) {
        this.totalRestriccionesProf = totalRestriccionesProf;
    }

    public Integer getTotalTrabajosTerminales() {
        return totalTrabajosTerminales;
    }

    public void setTotalTrabajosTerminales(Integer totalTrabajosTerminales) {
        this.totalTrabajosTerminales = totalTrabajosTerminales;
    }

    public Integer getTotalSalas() {
        return totalSalas;
    }

    public void setTotalSalas(Integer totalSalas) {
        this.totalSalas = totalSalas;
    }
   
  
}
