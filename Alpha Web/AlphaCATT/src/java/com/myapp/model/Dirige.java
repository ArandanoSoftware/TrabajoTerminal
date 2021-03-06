package com.myapp.model;
// Generated 14/05/2017 03:16:46 PM by Hibernate Tools 4.3.1



/**
 * Dirige generated by hbm2java
 */
public class Dirige  implements java.io.Serializable {


     private String idTt;
     private Profesor profesorByD2;
     private Profesor profesorByD1;

    public Dirige() {
    }

	
    public Dirige(String idTt, Profesor profesorByD1) {
        this.idTt = idTt;
        this.profesorByD1 = profesorByD1;
    }
    public Dirige(String idTt, Profesor profesorByD2, Profesor profesorByD1) {
       this.idTt = idTt;
       this.profesorByD2 = profesorByD2;
       this.profesorByD1 = profesorByD1;
    }
   
    public String getIdTt() {
        return this.idTt;
    }
    
    public void setIdTt(String idTt) {
        this.idTt = idTt;
    }
    public Profesor getProfesorByD2() {
        return this.profesorByD2;
    }
    
    public void setProfesorByD2(Profesor profesorByD2) {
        this.profesorByD2 = profesorByD2;
    }
    public Profesor getProfesorByD1() {
        return this.profesorByD1;
    }
    
    public void setProfesorByD1(Profesor profesorByD1) {
        this.profesorByD1 = profesorByD1;
    }




}


