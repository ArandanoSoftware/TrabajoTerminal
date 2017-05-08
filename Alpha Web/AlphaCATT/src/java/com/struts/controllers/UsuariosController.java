package com.struts.controllers;
import com.opensymphony.xwork2.ActionSupport;

public class UsuariosController extends ActionSupport {

  

    private String username;
    private String password;
    
   
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String execute() throws Exception
        {
          return SUCCESS;
        }
    public String insertUser(){

        return SUCCESS;
    }
    public String deleteUser(){

        return SUCCESS;
    }
}
