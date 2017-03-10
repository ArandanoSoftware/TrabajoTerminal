package com.myapp.model;
// Generated 4/02/2017 08:19:46 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Profesor generated by hbm2java
 */
public class Profesor  implements java.io.Serializable {


     private Integer idProfesor;
     private String nombre;
     private String apaterno;
     private String amaterno;
     private String email;
     private Set<Dirige> dirigesForD2 = new HashSet(0);
     private Set<Sinodalia> sinodaliasForS1 = new HashSet(0);
     private Set<Dirige> dirigesForD1 = new HashSet(0);
     private Set<Horario> horarios = new HashSet(0);
     private Set<Sinodalia> sinodaliasForS3 = new HashSet(0);
     private Set<Sinodalia> sinodaliasForS2 = new HashSet(0);

    public Profesor() {
        this.nombre = "";
        this.apaterno = "";
        this.amaterno = "";
    }

	
    public Profesor(String nombre, String apaterno, String amaterno) {
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
    }
    public Profesor(String nombre, String apaterno, String amaterno, String email, Set<Dirige> dirigesForD2, Set<Sinodalia> sinodaliasForS1, Set<Dirige> dirigesForD1, Set<Horario> horarios, Set<Sinodalia> sinodaliasForS3, Set<Sinodalia> sinodaliasForS2) {
       this.nombre = nombre;
       this.apaterno = apaterno;
       this.amaterno = amaterno;
       this.email = email;
       this.dirigesForD2 = dirigesForD2;
       this.sinodaliasForS1 = sinodaliasForS1;
       this.dirigesForD1 = dirigesForD1;
       this.horarios = horarios;
       this.sinodaliasForS3 = sinodaliasForS3;
       this.sinodaliasForS2 = sinodaliasForS2;
    }
   
    public Integer getIdProfesor() {
        return this.idProfesor;
    }
    
    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApaterno() {
        return this.apaterno;
    }
    
    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }
    public String getAmaterno() {
        return this.amaterno;
    }
    
    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Set<Dirige> getDirigesForD2() {
        return this.dirigesForD2;
    }
    
    public void setDirigesForD2(Set<Dirige> dirigesForD2) {
        this.dirigesForD2 = dirigesForD2;
    }
    public Set<Sinodalia> getSinodaliasForS1() {
        return this.sinodaliasForS1;
    }
    
    public void setSinodaliasForS1(Set<Sinodalia> sinodaliasForS1) {
        this.sinodaliasForS1 = sinodaliasForS1;
    }
    public Set<Dirige> getDirigesForD1() {
        return this.dirigesForD1;
    }
    
    public void setDirigesForD1(Set<Dirige> dirigesForD1) {
        this.dirigesForD1 = dirigesForD1;
    }
    public Set<Horario> getHorarios() {
        return this.horarios;
    }
    
    public void setHorarios(Set<Horario> horarios) {
        this.horarios = horarios;
    }
    public Set<Sinodalia> getSinodaliasForS3() {
        return this.sinodaliasForS3;
    }
    
    public void setSinodaliasForS3(Set<Sinodalia> sinodaliasForS3) {
        this.sinodaliasForS3 = sinodaliasForS3;
    }
    public Set<Sinodalia> getSinodaliasForS2() {
        return this.sinodaliasForS2;
    }
    
    public void setSinodaliasForS2(Set<Sinodalia> sinodaliasForS2) {
        this.sinodaliasForS2 = sinodaliasForS2;
    }




}


