
package com.struts.autocomplete;

import java.util.ArrayList;
import com.opensymphony.xwork2.Action;

import com.myapp.model.Profesor;

public class AutoCompleteProfesor implements Action {
    
    //public ArrayList<Profesor> ProfArrayList = new ArrayList<Profesor>();
    public ArrayList<String> ProfArrayList = new ArrayList<String>();
    public String profesor;
    
    public String execute() 
        {
                ProfesorsList();
                return SUCCESS;
        }
    public void ProfesorsList()
    {
        ProfArrayList.add("adasds");
        ProfArrayList.add("daasd");
        ProfArrayList.add("dsada");
        ProfArrayList.add("asda");
    }
    
    public String displayProfesor() 
      {
              return SUCCESS;
      }
    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
}
