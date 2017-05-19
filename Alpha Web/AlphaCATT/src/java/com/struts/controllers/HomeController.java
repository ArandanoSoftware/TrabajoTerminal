package com.struts.controllers;
import com.opensymphony.xwork2.ActionSupport;

import com.myapp.bs.ProfesorBs;

public class HomeController extends ActionSupport {
   
    
    private ProfesorBs profBs;
    
    private Integer Total_profesores;

    public Integer getTotal_profesores() {
        return Total_profesores;
    }

    public void setTotal_profesores(Integer Total_profesores) {
        this.Total_profesores = Total_profesores;
    }
    
  
    
  @Override
  public String execute() throws Exception
  {
      //call Service class to store personBean's state in database
      return SUCCESS;
  }
  public String test()
  {
      return "success";
  }
  
}
