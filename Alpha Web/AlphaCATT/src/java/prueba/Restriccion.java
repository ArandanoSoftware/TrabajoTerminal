package prueba;
// Generated 14/05/2017 03:16:46 PM by Hibernate Tools 4.3.1



/**
 * Restriccion generated by hbm2java
 */
public class Restriccion  implements java.io.Serializable {


     private Integer id;
     private boolean mes;
     private boolean dia;
     private boolean hora;
     private int idProfesor;

    public Restriccion() {
    }

    public Restriccion(boolean mes, boolean dia, boolean hora, int idProfesor) {
       this.mes = mes;
       this.dia = dia;
       this.hora = hora;
       this.idProfesor = idProfesor;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public boolean isMes() {
        return this.mes;
    }
    
    public void setMes(boolean mes) {
        this.mes = mes;
    }
    public boolean isDia() {
        return this.dia;
    }
    
    public void setDia(boolean dia) {
        this.dia = dia;
    }
    public boolean isHora() {
        return this.hora;
    }
    
    public void setHora(boolean hora) {
        this.hora = hora;
    }
    public int getIdProfesor() {
        return this.idProfesor;
    }
    
    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }




}

