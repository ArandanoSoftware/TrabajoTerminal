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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Hazzy76
 */
public class FuncionAptitud {
    
    Integer dir1;
    Integer dir2;
    Integer sin1;
    Integer sin2;
    Integer sin3;
    Cromosoma cc;
    List<Restriccion> restricciones;
    
    public FuncionAptitud(Cromosoma cc, List<Restriccion> restricciones)
    {
        Dirige dirige = DirigeBs.findById(cc.getGen2().getTt());
        Sinodalia sinodalia = SinodaliaBs.findById(cc.getGen2().getTt());
        this.cc = cc;
        this.dir1 = dirige.getProfesorByD1().getIdProfesor();
        this.dir2 = dirige.getProfesorByD2().getIdProfesor();
        this.sin1 = sinodalia.getProfesorByS1().getIdProfesor();
        this.sin2 = sinodalia.getProfesorByS2().getIdProfesor();
        this.sin3 = sinodalia.getProfesorByS3().getIdProfesor();
        this.restricciones = restricciones;
    }
    
    public int evaluar(Cromosoma individuo)
    {
        int aptitud = 0;
        
        return aptitud;
    }
    
    protected int funcionDirector()
    {
        int personal1 = 0, personal2 = 0, hora1 = 0, hora2 = 0;
        for(int i = 0; i < restricciones.size(); i++)
        {
            if(!(igualBin(cc.getGen1().getMes(),restricciones.get(i).getMes()) && igualBin(cc.getGen1().getDia(),restricciones.get(i).getDia()) && igualBin(restricciones.get(i).getHora(),cc.getGen1().getHora())))
            {
                if(restricciones.get(i).getProfesor() == dir1)personal1 += 70;
                if(restricciones.get(i).getProfesor() == dir2)personal2 += 70;
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
        Profesor d1 = ProfesorBs.findById(dir1);
        Profesor d2 = ProfesorBs.findById(dir2);
        Genetico.profebin(d1, director1);
        Genetico.profebin(d2, director2);
        if(diaSem == 1){director1 = Genetico.lunbin(d1, director1); director2 = Genetico.lunbin(d2, director2);}
        if(diaSem == 2){director1 = Genetico.marbin(d1, director1); director2 = Genetico.marbin(d2, director2);}
        if(diaSem == 3){director1 = Genetico.miebin(d1, director1); director2 = Genetico.miebin(d2, director2);}
        if(diaSem == 4){director1 = Genetico.juebin(d1, director1); director2 = Genetico.juebin(d2, director2);}
        if(diaSem == 5){director1 = Genetico.viebin(d1, director1); director2 = Genetico.viebin(d2, director2);}
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
        return (personal1 + personal2 + hora1 + hora2)/2;
    }
        
    protected int funcionSinodal()
    {
        int personal1 = 0, personal2 = 0, personal3 = 0, hora1 = 0, hora2 = 0, hora3 = 0;
        for(int i = 0; i < restricciones.size(); i++)
        {
            if(!(igualBin(cc.getGen1().getMes(),restricciones.get(i).getMes()) && igualBin(cc.getGen1().getDia(),restricciones.get(i).getDia()) && igualBin(restricciones.get(i).getHora(),cc.getGen1().getHora())))
            {
                if(restricciones.get(i).getProfesor() == sin1)personal1 += 70;
                if(restricciones.get(i).getProfesor() == sin2)personal2 += 70;
                if(restricciones.get(i).getProfesor() == sin3)personal3 += 70;
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
        Profesor s1 = ProfesorBs.findById(sin1);
        Profesor s2 = ProfesorBs.findById(sin2);
        Profesor s3 = ProfesorBs.findById(sin3);
        Genetico.profebin(s1, sinodal1);
        Genetico.profebin(s2, sinodal2);
        Genetico.profebin(s3, sinodal2);
        if(diaSem == 1){sinodal1 = Genetico.lunbin(s1, sinodal1); sinodal2 = Genetico.lunbin(s2, sinodal2); sinodal3 = Genetico.lunbin(s3, sinodal3);}
        if(diaSem == 1){sinodal1 = Genetico.marbin(s1, sinodal1); sinodal2 = Genetico.marbin(s2, sinodal2); sinodal3 = Genetico.marbin(s3, sinodal3);}
        if(diaSem == 1){sinodal1 = Genetico.miebin(s1, sinodal1); sinodal2 = Genetico.miebin(s2, sinodal2); sinodal3 = Genetico.miebin(s3, sinodal3);}
        if(diaSem == 1){sinodal1 = Genetico.juebin(s1, sinodal1); sinodal2 = Genetico.juebin(s2, sinodal2); sinodal3 = Genetico.juebin(s3, sinodal3);}
        if(diaSem == 1){sinodal1 = Genetico.viebin(s1, sinodal1); sinodal2 = Genetico.viebin(s2, sinodal2); sinodal3 = Genetico.viebin(s3, sinodal3);}
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
    
    protected List<Restriccion> buscarRestriccion(int director)
    {
        List<Restriccion> res = new ArrayList<>();
        for(int i = 0; i < restricciones.size(); i++)
            if(restricciones.get(i).getProfesor() == director) res.add(restricciones.get(i));
        return res;
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
    
}