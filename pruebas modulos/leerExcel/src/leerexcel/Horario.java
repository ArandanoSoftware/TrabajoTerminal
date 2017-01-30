/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerexcel;

/**
 *
 * @author hazzy76
 */
class Horario {
    private int id;
    private String lun;
    private String mar;
    private String mie;
    private String jue;
    private String vie;
    private String idProf;

    public Horario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLun() {
        return lun;
    }

    public void setLun(String lun) {
        this.lun = lun;
    }

    public String getMar() {
        return mar;
    }

    public void setMar(String mar) {
        this.mar = mar;
    }

    public String getMie() {
        return mie;
    }

    public void setMie(String mie) {
        this.mie = mie;
    }

    public String getJue() {
        return jue;
    }

    public void setJue(String jue) {
        this.jue = jue;
    }

    public String getVie() {
        return vie;
    }

    public void setVie(String vie) {
        this.vie = vie;
    }

    public String getIdProf() {
        return idProf;
    }

    public void setIdProf(String idProf) {
        this.idProf = idProf;
    }
}
