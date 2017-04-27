package com.struts.controllers;
import com.opensymphony.xwork2.ActionSupport;
import com.struts.operaciones.UsuariosOperaciones;


public class LoginController extends ActionSupport {

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
    
    private UsuariosOperaciones UserOp;
    private String userName;
    private String passWord;

  
    @Override
  public String execute() throws Exception
  {
      //call Service class to store personBean's state in database
      return SUCCESS;
  }
  
  public String login()
  {
      this.UserOp = new UsuariosOperaciones();
      if(UserOp.Authenticate(userName, passWord)){
          return "success";
      }else{
          return "error";
      }
      
  }
}
