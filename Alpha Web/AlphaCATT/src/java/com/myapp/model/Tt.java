package com.myapp.model;
// Generated 4/02/2017 08:19:46 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tt generated by hbm2java
 */
public class Tt  implements java.io.Serializable {


     private String idTt;
     private String nombre;
     private int nivel;
     private Calendario calendario;
     private Set<Alumno> alumnos = new HashSet<Alumno>(0);

    public Tt() {
    }

	
    public Tt(String idTt, String nombre, int nivel) {
        this.idTt = idTt;
        this.nombre = nombre;
        this.nivel = nivel;
    }
    public Tt(String idTt, String nombre, int nivel, Calendario calendario, Set<Alumno> alumnos) {
       this.idTt = idTt;
       this.nombre = nombre;
       this.nivel = nivel;
       this.calendario = calendario;
       this.alumnos = alumnos;
    }
   
    public String getIdTt() {
        return this.idTt;
    }
    
    public void setIdTt(String idTt) {
        this.idTt = idTt;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getNivel() {
        return this.nivel;
    }
    
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public Calendario getCalendario() {
        return this.calendario;
    }
    
    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }
    public Set<Alumno> getAlumnos() {
        return this.alumnos;
    }
    
    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }




}


