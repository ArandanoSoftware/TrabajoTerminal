/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerexcel;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author hazzy76
 */
public class Profesor  implements java.io.Serializable {
    private int idProfesor;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String email;
    private Set<Horario> horario;

    public Profesor() {
        this.nombre = "";
        this.aPaterno = "";
        this.aMaterno = "";
        this.horario = new HashSet(0);
    }
    
    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Set<Horario> getHorario() {
        return this.horario;
    }
    
    public void setHorario(Set<Horario> horario) {
        this.horario = horario;
    }
}
