package com.myapp.model;
// Generated 27/04/2017 10:27:18 AM by Hibernate Tools 4.3.1



/**
 * Sinodalia generated by hbm2java
 */
public class Sinodalia  implements java.io.Serializable {


     private String idTt;
     private Profesor profesorByS1;
     private Profesor profesorByS3;
     private Profesor profesorByS2;

    public Sinodalia() {
    }

	
    public Sinodalia(String idTt, Profesor profesorByS1, Profesor profesorByS2) {
        this.idTt = idTt;
        this.profesorByS1 = profesorByS1;
        this.profesorByS2 = profesorByS2;
    }
    public Sinodalia(String idTt, Profesor profesorByS1, Profesor profesorByS3, Profesor profesorByS2) {
       this.idTt = idTt;
       this.profesorByS1 = profesorByS1;
       this.profesorByS3 = profesorByS3;
       this.profesorByS2 = profesorByS2;
    }
   
    public String getIdTt() {
        return this.idTt;
    }
    
    public void setIdTt(String idTt) {
        this.idTt = idTt;
    }
    public Profesor getProfesorByS1() {
        return this.profesorByS1;
    }
    
    public void setProfesorByS1(Profesor profesorByS1) {
        this.profesorByS1 = profesorByS1;
    }
    public Profesor getProfesorByS3() {
        return this.profesorByS3;
    }
    
    public void setProfesorByS3(Profesor profesorByS3) {
        this.profesorByS3 = profesorByS3;
    }
    public Profesor getProfesorByS2() {
        return this.profesorByS2;
    }
    
    public void setProfesorByS2(Profesor profesorByS2) {
        this.profesorByS2 = profesorByS2;
    }




}


