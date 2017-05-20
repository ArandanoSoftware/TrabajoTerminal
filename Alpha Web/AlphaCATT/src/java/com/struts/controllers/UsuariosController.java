package com.struts.controllers;

import com.myapp.model.Usuario;
import com.myapp.bs.UsuarioBs;
import com.struts.operaciones.UsuariosOperaciones;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

public class UsuariosController extends ActionSupport {

  
  /**
   * 
   */
    private int id;
    private String username;
    private String password;
    private String tipo;

    private List<Usuario> ListUser;
    private UsuarioBs Userbs;
    private UsuariosOperaciones UserOp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public UsuarioBs getUserbs() {
        return Userbs;
    }

    public void setUserbs(UsuarioBs Userbs) {
        this.Userbs = Userbs;
    }
    
    public List<Usuario> getListUser() {
        return ListUser;
    }

    public void setListUser(List<Usuario> ListUser) {
        this.ListUser = ListUser;
    }
   
    
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
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public UsuariosOperaciones getUserOp() {
        return UserOp;
    }

    public void setUserOp(UsuariosOperaciones UserOp) {
        this.UserOp = UserOp;
    }
    
    @Override
    public String execute() throws Exception
        {
          this.Userbs = new UsuarioBs();
          this.ListUser= Userbs.findAll();
          return SUCCESS;
        }
    public String regUser()
        {
          this.UserOp = new UsuariosOperaciones();
          UserOp.regUser(username, password, tipo);
          return SUCCESS;
        }
    public String delUser()
        {
          this.UserOp = new UsuariosOperaciones();
          UserOp.delUser(id);
          return SUCCESS;  
        }
    
 
}
