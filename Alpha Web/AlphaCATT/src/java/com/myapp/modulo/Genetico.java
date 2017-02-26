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
import java.util.Random;

/**
 *
 * @author root
 */
public class Genetico {
    public static List<Cromosoma> crearPoblacion(Date inicio, Date fin, Set<Tt> tt, int salas)
    {
        List<Cromosoma> poblacion = new ArrayList();
        Random random = new Random();
        
        Date fecha = new Date();
        fecha.setDate(2);
        
        int d;
        
        return poblacion;
    }
    public static boolean[] getBinDay(Date fecha)
    {
        boolean[] dia = {false,false,false,false,false};
        int day = fecha.getDate();
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
    
    public static boolean[] getBinMonth(Date fecha)
    {
        boolean[] mes =  {false, false, false, false};
        int month = fecha.getMonth() + 1;
        if(month/8 > 0)mes[0]=true;
        month%=8;
        if(month/4 > 0)mes[1]=true;
        month%=4;
        if(month/2 > 0)mes[2]=true;
        month%=2;
        if(month == 1)mes[3]=true;
        return mes;
    }
    
    public static boolean[] getBinSala(int s)
    {
        boolean[] sal =  {false, false, false, false};
        if(s/8 > 0)sal[0]=true;
        s%=8;
        if(s/4 > 0)sal[1]=true;
        s%=4;
        if(s/2 > 0)sal[2]=true;
        s%=2;
        if(s == 1)sal[3]=true;
        return sal;
    }
    
    public static boolean[] getBinHorario(int h)
    {
        boolean[] hora = new boolean[9];
        hora[0]=hora[1]=hora[2]=hora[3]=hora[4]=hora[5]=hora[6]=hora[7]=hora[8]=false;
        if(h == 1)hora[2]=true;
        if(h == 2)hora[3]=true;
        if(h == 3)hora[5]=true;
        if(h == 4)hora[6]=true;
        return hora;
    }
}
