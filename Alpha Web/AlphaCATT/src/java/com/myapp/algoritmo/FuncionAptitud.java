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
        int num = 1, personal1 = 0, personal2 = 0;
        List<Restriccion> res = buscarRestriccion(dir1);
        if(dir2 != null)
        {
            num = 2;
            res.addAll(buscarRestriccion(dir2));
        }
        for(int i = 0; i < res.size(); i++)
        {
            if(!(igualBin(cc.getGen1().getMes(),res.get(i).getMes()) && igualBin(cc.getGen1().getDia(),res.get(i).getDia()) && igualBin(restricciones.get(i).getHora(),cc.getGen1().getHora())))
            {
                if(restricciones.get(i).getProfesor() == dir1)personal1 += 70;
                if(restricciones.get(i).getProfesor() == dir2)personal2 += 70;
            }
            else
                break;
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
        
        
        return new Integer(2);
    }
        
    protected int funcionSinodal()
    {
        return new Integer(8);
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
}
