/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.algoritmo;

import com.myapp.bs.DirigeBs;
import com.myapp.bs.SinodaliaBs;
import com.myapp.model.Dirige;
import com.myapp.model.Sinodalia;
import java.util.ArrayList;
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
        int num = 1;
        List<Restriccion> res = buscarRestriccion(dir1);
        if(dir2 != null)
        {
            num = 2;
            res.addAll(buscarRestriccion(dir2));
        }
        for(int i = 0; i < res.size(); i++)
        {
            if(igualBin(cc.getGen1().getMes(),res.get(i).getMes()) && igualBin(cc.getGen1().getDia(),res.get(i).getDia())){}
                //estan en el mismo dia del mismo mes y se hace algo xD
        }
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
