/**
 * Sistema de calendarizacion - ActionLogin 
 * 
 */
package com.struts.actions;


import com.myapp.bs.UsuarioBs;
import com.myapp.model.Usuario;

import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;



public class LoginAction extends ActionSupport implements SessionAware {

        private static final long serialVersionUID = 1L;
        private String userName;
        private String passWord;
        private Map<String, Object> session;
        
        private List<Usuario> listUsuario;

 

        // Log Out user
        public String logOut() {
                session.remove("loginId");
                addActionMessage("You have been Successfully Logged Out");
                return SUCCESS;
        }

        // Login user
//        public String login() {
//                if (userName.isEmpty() && passWord.isEmpty()) {                    
//                        return LOGIN;
//                } else {
//                        session.put("loginId", userName);
//                        return SUCCESS;
//                }
//        }
        
          public String login() {
                listUsuario=UsuarioBs.findAll();
                for(int i=0; i<listUsuario.size();i++){
                    if(userName.equalsIgnoreCase(listUsuario.get(i).getUsername()) && passWord.equalsIgnoreCase(listUsuario.get(i).getPassword())){
                        session.put("loginId", userName);
                        return SUCCESS;
                    }    
                }
                        addActionError("Nombre de Usuario y/o Contraseña Incorrecta");
                        return LOGIN;
                        
                   
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

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}