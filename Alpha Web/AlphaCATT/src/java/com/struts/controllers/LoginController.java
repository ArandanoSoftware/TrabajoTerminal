/**
 * Sistema de Calendarización de Trabajos terminales
 * Controlador  de Login 
 * Funciones:  Autentificación 
 */


package com.struts.controllers;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;


import com.struts.operaciones.UsuariosOperaciones;
import java.util.Map;

import com.myapp.bs.UsuarioBs;

public class LoginController extends ActionSupport implements SessionAware{
    
    /**
     * Variables de Entrada 
     */
    private UsuariosOperaciones UserOp;
    private String userName;
    private String passWord;

    /**
     * Getters & Setters:  Login 
     *  
     */

    public UsuariosOperaciones getUserOp() {
        return UserOp;
    }

    public void setUserOp(UsuariosOperaciones UserOp) {
        this.UserOp = UserOp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
    /*
    Java Map para la Sesion 
    */
    private Map<String,Object> session;

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
   
    
  @Override
  public String execute() throws Exception
  {
      //call Service class to store personBean's state in database
      return SUCCESS;
  }

  /**
   * Metodo de Login 
   * @return 
   */
  public String login()
  {
      this.UserOp = new UsuariosOperaciones();
      if(UserOp.Authenticate(userName, passWord)){
          return "success";
        }else{
          return "error";
        }

  }
  
  //private boolean isValidUser()
  
  
}
