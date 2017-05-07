package com.struts.controllers;
import com.opensymphony.xwork2.ActionSupport;

public class UsuariosController extends ActionSupport {

    private String username;
    private String password;

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
