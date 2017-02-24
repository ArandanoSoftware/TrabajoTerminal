/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.modulo;

import com.myapp.algoritmo.Cromosoma;
import com.myapp.model.Tt;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author root
 */
public class Genetico {
    public static List<Cromosoma> crearPoblacion(Date inicio, Date fin, Set<Tt> tt)
    {
        List<Cromosoma> poblacion = new ArrayList();
        
        
        
        return poblacion;
    }
    public static boolean[] getBinDay(Date fecha)
    {
        boolean[] dia = {false,false,false,false,false};
        int day = fecha.getDate();
        System.out.println(day);
        if(day/16 > 0)dia[0]=true;
        day%=16;
        if(day/8 > 0)dia[1]=true;
        day%=8;
        if(day/4 > 0)dia[2]=true;
        day%=4;
        if(day/2 > 0)dia[3]=true;
        day%=2;
        if(day == 1)dia[4]=true;
        return dia;
    }    
}
