/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.modulo;

import com.myapp.algoritmo.Cromosoma;
import com.myapp.model.Calendario;
import com.myapp.model.Sala;
import com.myapp.model.Tt;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Random;

/**
 *
 * @author root
 */
public class Genetico {
    public static List<Cromosoma> crearPoblacionTT1(Date inicio, Date fin, Set<Tt> tt, int salas)
    {
        List<Cromosoma> poblacion = new ArrayList();
        Random random = new Random();
        Set<Integer> dias = new HashSet();
        Date fecha = new Date();
        fecha.setMonth(inicio.getMonth());
        int rango = difFecha(fin, inicio)/2;
        
        int jj = 0;
        
        while(dias.size() != (tt.size()/3)+1)
        {
            int diaR = random.nextInt(rango + 1) + inicio.getDate();
            fecha.setDate(diaR);
            if(fecha.getDay() != 0 && fecha.getDay() != 6)
                dias.add(diaR);
            jj++;
            if(jj >= (tt.size()/3)+1)System.out.println("va en " + jj + " con dias guardados " + dias.size());
        }
        
        List<Integer> diaR = new ArrayList(dias);
        List<Tt> tts = new ArrayList(tt);
        for(int i = 0; i < tt.size(); i++)
        {
            Cromosoma cromosoma = new Cromosoma();
            fecha.setDate(diaR.get(i%diaR.size()));
            cromosoma.getGen1().setDia(getBinDay(fecha));
            cromosoma.getGen1().setMes(getBinMonth(fecha));
            cromosoma.getGen1().setHora(getBinHorario(random.nextInt(3)+1));
            cromosoma.getGen1().setSala(getBinSala(random.nextInt(salas + 1)));
            cromosoma.getGen2().setTt(tts.get(i).getIdTt());
            poblacion.add(cromosoma);
        }
        
        return poblacion;
    }
    protected static boolean[] getBinDay(Date fecha)
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
    
    protected static boolean[] getBinMonth(Date fecha)
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
    
    protected static boolean[] getBinSala(int s)
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
    
    protected static boolean[] getBinHorario(int h)
    {
        boolean[] hora = new boolean[9];
        hora[0]=hora[1]=hora[2]=hora[3]=hora[4]=hora[5]=hora[6]=hora[7]=hora[8]=false;
        if(h == 1)hora[2]=true;
        if(h == 2)hora[3]=true;
        if(h == 3)hora[5]=true;
        if(h == 4)hora[6]=true;
        return hora;
    }
    
    public static List<Calendario> crearCalendario(List<Cromosoma>  poblacion)
    {
        List<Calendario> calendario = new ArrayList();
        
        for(int i = 0; i < poblacion.size(); i++)
        {
            Calendario vale = new Calendario();
            Tt titi = new Tt();
            Sala sala = new Sala();
            Date fecha = getDateC(poblacion.get(i));
            titi.setIdTt(poblacion.get(i).getGen2().getTt());
            sala.setIdSala(binToInt(poblacion.get(i).getGen1().getSala()));
            vale.setFecha(fecha);
            vale.setTt(titi);
            vale.setSala(sala);
            calendario.add(vale);
        }
        
        return calendario;
    }
    
    protected static Date getDateC(Cromosoma c)
    {
        Date fecha = new Date();
        fecha.setDate(binToInt(c.getGen1().getDia()));
        fecha.setMonth(binToInt(c.getGen1().getMes())-1);
        int hora = binToInt(c.getGen1().getHora());
        if(hora == 4)fecha.setHours(10);fecha.setMinutes(0);
        if(hora == 8)fecha.setHours(12);fecha.setMinutes(0);
        if(hora == 32)fecha.setHours(14);fecha.setMinutes(0);
        if(hora == 64)fecha.setHours(16);fecha.setMinutes(0);
        return fecha;
    }
    
    protected static int binToInt(boolean[] bool)
    {
        int entero = 0;
        
        for(int i = 0; i < bool.length; i++)
        {
            if(bool[bool.length - i - 1])entero+=(Math.pow(2, i));
        }
        return entero;
    }
    
    protected static int difFecha(Date fecha1, Date fecha2)
    {
        int resultado = (int)((fecha1.getTime()-fecha2.getTime())/86400000) + 1;
        
        return resultado;
    }
    
}
