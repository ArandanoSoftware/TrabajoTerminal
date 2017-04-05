/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.algoritmo;

import com.myapp.bs.DirigeBs;
import com.myapp.bs.ProfesorBs;
import com.myapp.bs.SinodaliaBs;
import com.myapp.model.Dirige;
import com.myapp.model.Profesor;
import com.myapp.model.Sinodalia;
import com.myapp.modulo.Genetico;
import java.util.Date;
import java.util.List;
//////////////recuerda hazziely que tienes que remplazar!!!!
/**
 *
 * @author Hazzy76
 */
public class FuncionAptitud {
    
    private final List<Cromosoma> poblacion;
    private final Dirige dirige;
    private final Sinodalia sinodalia;
    private final Cromosoma cc;
    private final List<Restriccion> restricciones;
    
    public FuncionAptitud(Cromosoma cc, List<Restriccion> restricciones, List<Cromosoma> poblacion)
    {
        this.dirige = DirigeBs.findById(cc.getGen2().getTt());
        this.sinodalia = SinodaliaBs.findById(cc.getGen2().getTt());
        this.cc = cc;
        this.restricciones = restricciones;
        this.poblacion = poblacion;
    }
    
    public int evaluar(Cromosoma individuo)
    {
        int aptitud = 0, directors = 0, sinodals = 0, saladisp;
        directors += funcionDirector();
        if(directors == 0) return 0;
        sinodals += funcionSinodal();
        if(sinodals == 0) return 0;
        saladisp = salaLibre();
        aptitud += directors + sinodals + saladisp;
        return aptitud;
    }
    
    protected int funcionDirector()
    {
        int personal1 = 0, personal2 = 0, hora1 = 0, hora2 = 0;
        for(int i = 0; i < restricciones.size(); i++)
        {
            if(!(igualBin(cc.getGen1().getMes(),restricciones.get(i).getMes()) && igualBin(cc.getGen1().getDia(),restricciones.get(i).getDia()) && igualBin(restricciones.get(i).getHora(),cc.getGen1().getHora())))
            {
                if(restricciones.get(i).getProfesor() == dirige.getProfesorByD1().getIdProfesor())personal1 += 70;
                if(restricciones.get(i).getProfesor() == dirige.getProfesorByD2().getIdProfesor())personal2 += 70;
            }
        }
        if(personal1 == 0 && personal2 == 0)return 0;
        //Hasta aqui ya se comprobó si pueden o no xD
        
        Date date = new Date();
        date.setMonth(Genetico.binToInt(cc.getGen1().getMes()));
        date.setDate(Genetico.binToInt(cc.getGen1().getDia()));
        int diaSem = date.getDay();//0 = sunday
        boolean[] director1 = new boolean[20];
        boolean[] director2 = new boolean[20];
        Genetico.profebin(dirige.getProfesorByD1(), director1);
        Genetico.profebin(dirige.getProfesorByD2(), director2);
        if(diaSem == 1){director1 = Genetico.lunbin(dirige.getProfesorByD1(), director1); director2 = Genetico.lunbin(dirige.getProfesorByD2(), director2);}
        if(diaSem == 2){director1 = Genetico.marbin(dirige.getProfesorByD1(), director1); director2 = Genetico.marbin(dirige.getProfesorByD2(), director2);}
        if(diaSem == 3){director1 = Genetico.miebin(dirige.getProfesorByD1(), director1); director2 = Genetico.miebin(dirige.getProfesorByD2(), director2);}
        if(diaSem == 4){director1 = Genetico.juebin(dirige.getProfesorByD1(), director1); director2 = Genetico.juebin(dirige.getProfesorByD2(), director2);}
        if(diaSem == 5){director1 = Genetico.viebin(dirige.getProfesorByD1(), director1); director2 = Genetico.viebin(dirige.getProfesorByD2(), director2);}
        boolean[] horario  = new boolean[9];
        director1[11] = horario[0];
        director1[12] = horario[1];
        director1[13] = horario[2];
        director1[14] = horario[3];
        director1[15] = horario[4];
        director1[16] = horario[5];
        director1[17] = horario[6];
        director1[18] = horario[7];
        director1[19] = horario[8];
        if(disponible(horario, cc.getGen1().getHora()))hora1 += 30;
        director2[11] = horario[0];
        director2[12] = horario[1];
        director2[13] = horario[2];
        director2[14] = horario[3];
        director2[15] = horario[4];
        director2[16] = horario[5];
        director2[17] = horario[6];
        director2[18] = horario[7];
        director2[19] = horario[8];
        if(disponible(horario, cc.getGen1().getHora()))hora2 += 30;
        
        
        for(int i = 0; i < poblacion.size(); i++)
        {
            if(dirige.getIdTt() == poblacion.get(i).getGen2().getTt())
                System.out.println("");
        }
        
        return (personal1 + personal2 + hora1 + hora2)/2;
    }
        
    protected int funcionSinodal()
    {
        int personal1 = 0, personal2 = 0, personal3 = 0, hora1 = 0, hora2 = 0, hora3 = 0;
        for(int i = 0; i < restricciones.size(); i++)
        {
            if(!(igualBin(cc.getGen1().getMes(),restricciones.get(i).getMes()) && igualBin(cc.getGen1().getDia(),restricciones.get(i).getDia()) && igualBin(restricciones.get(i).getHora(),cc.getGen1().getHora())))
            {
                if(restricciones.get(i).getProfesor() == sinodalia.getProfesorByS1().getIdProfesor())personal1 += 70;
                if(restricciones.get(i).getProfesor() == sinodalia.getProfesorByS2().getIdProfesor())personal2 += 70;
                if(restricciones.get(i).getProfesor() == sinodalia.getProfesorByS3().getIdProfesor())personal3 += 70;
            }
        }
        
        if((personal1 == 0 && personal2 == 0) || (personal1 == 0 && personal3 == 0) || (personal2 == 0 && personal3 == 0))return 0;
        //Hasta aqui ya se comprobó si pueden o no xD
        
        Date date = new Date();
        date.setMonth(Genetico.binToInt(cc.getGen1().getMes()));
        date.setDate(Genetico.binToInt(cc.getGen1().getDia()));
        int diaSem = date.getDay();//0 = sunday
        boolean[] sinodal1 = new boolean[20];
        boolean[] sinodal2 = new boolean[20];
        boolean[] sinodal3 = new boolean[20];
        Genetico.profebin(sinodalia.getProfesorByS1(), sinodal1);
        Genetico.profebin(sinodalia.getProfesorByS2(), sinodal2);
        Genetico.profebin(sinodalia.getProfesorByS3(), sinodal2);
        if(diaSem == 1){sinodal1 = Genetico.lunbin(sinodalia.getProfesorByS1(), sinodal1); sinodal2 = Genetico.lunbin(sinodalia.getProfesorByS2(), sinodal2); sinodal3 = Genetico.lunbin(sinodalia.getProfesorByS3(), sinodal3);}
        if(diaSem == 1){sinodal1 = Genetico.marbin(sinodalia.getProfesorByS1(), sinodal1); sinodal2 = Genetico.marbin(sinodalia.getProfesorByS2(), sinodal2); sinodal3 = Genetico.marbin(sinodalia.getProfesorByS3(), sinodal3);}
        if(diaSem == 1){sinodal1 = Genetico.miebin(sinodalia.getProfesorByS1(), sinodal1); sinodal2 = Genetico.miebin(sinodalia.getProfesorByS2(), sinodal2); sinodal3 = Genetico.miebin(sinodalia.getProfesorByS3(), sinodal3);}
        if(diaSem == 1){sinodal1 = Genetico.juebin(sinodalia.getProfesorByS1(), sinodal1); sinodal2 = Genetico.juebin(sinodalia.getProfesorByS2(), sinodal2); sinodal3 = Genetico.juebin(sinodalia.getProfesorByS3(), sinodal3);}
        if(diaSem == 1){sinodal1 = Genetico.viebin(sinodalia.getProfesorByS1(), sinodal1); sinodal2 = Genetico.viebin(sinodalia.getProfesorByS2(), sinodal2); sinodal3 = Genetico.viebin(sinodalia.getProfesorByS3(), sinodal3);}
        boolean[] horario  = new boolean[9];
        sinodal1[11] = horario[0];
        sinodal1[12] = horario[1];
        sinodal1[13] = horario[2];
        sinodal1[14] = horario[3];
        sinodal1[15] = horario[4];
        sinodal1[16] = horario[5];
        sinodal1[17] = horario[6];
        sinodal1[18] = horario[7];
        sinodal1[19] = horario[8];
        if(disponible(horario, cc.getGen1().getHora()))hora1 += 30;
        sinodal2[11] = horario[0];
        sinodal2[12] = horario[1];
        sinodal2[13] = horario[2];
        sinodal2[14] = horario[3];
        sinodal2[15] = horario[4];
        sinodal2[16] = horario[5];
        sinodal2[17] = horario[6];
        sinodal2[18] = horario[7];
        sinodal2[19] = horario[8];
        if(disponible(horario, cc.getGen1().getHora()))hora2 += 30;
        sinodal3[11] = horario[0];
        sinodal3[12] = horario[1];
        sinodal3[13] = horario[2];
        sinodal3[14] = horario[3];
        sinodal3[15] = horario[4];
        sinodal3[16] = horario[5];
        sinodal3[17] = horario[6];
        sinodal3[18] = horario[7];
        sinodal3[19] = horario[8];
        if(disponible(horario, cc.getGen1().getHora()))hora3 += 30;
        return (personal1 + personal2 + hora1 + hora2)/2;
    }
    
    protected boolean igualBin(boolean[] bin1, boolean[] bin2)
    {
        for(int i = 0; i < bin1.length; i++)
        {
            if(bin1[i] != bin2[i])
                return false;
        }
        return true;
    }
    
    protected boolean disponible(boolean[] hp, boolean[] ht)
    {
        for(int i = 0; i < hp.length; i++)
            if(hp[i] == false && ht[i] == true)return true;
        return false;
    }
    
    protected int salaLibre()
    {
        for(int i = 0; i < poblacion.size();i++)
        {
            if(igualBin(cc.getGen1().getSala(),poblacion.get(i).getGen1().getSala()) && igualBin(cc.getGen1().getMes(),poblacion.get(i).getGen1().getMes()) && igualBin(cc.getGen1().getDia(),poblacion.get(i).getGen1().getDia()) && igualBin(cc.getGen1().getHora(),poblacion.get(i).getGen1().getHora()))
            {
                return -100;
            }
        }
        return 0;
    }
}