/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.modulo;

import com.myapp.algoritmo.Cromosoma;
import com.myapp.algoritmo.FuncionAptitud;
import com.myapp.algoritmo.Restriccion;
import com.myapp.model.Calendario;
import com.myapp.model.Horario;
import com.myapp.model.Profesor;
import com.myapp.model.Sala;
import com.myapp.model.Tt;
import java.util.ArrayList;
import java.util.Arrays;
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
    
    public static int aptitudPoblacion;
    
    public static List<Cromosoma> crearPoblacionTT1(Date inicio, Date fin, Set<Tt> tt, int salas)
    {
        List<Cromosoma> poblacion = new ArrayList();
        Random random = new Random();
        Set<Integer> dias = new HashSet();
        Date fecha = new Date();
        fecha.setDate(inicio.getDate());
        fecha.setMonth(inicio.getMonth());
        int rango = difFecha(fin, inicio)/2;
        int ttxdia = tt.size()/diaHabil(fecha, rango, 0);
        System.out.println("ttxdia = " + ttxdia);
        while(dias.size() != (tt.size()/ttxdia))
        {
            int diaR = random.nextInt(rango + 1) + inicio.getDate();
            fecha.setMonth(inicio.getMonth());
            fecha.setDate(diaR);
            if(fecha.getDay() != 0 && fecha.getDay() != 6)
                dias.add(diaR);
        }
        
        List<Integer> diaR = new ArrayList(dias);
        List<Tt> tts = new ArrayList(tt);
        for(int i = 0; i < tt.size(); i++)
        {
            Cromosoma cromosoma = new Cromosoma();
            fecha.setMonth(inicio.getMonth());
            fecha.setDate(diaR.get(i%diaR.size()));
            cromosoma.getGen1().setDia(getBinDay(fecha));
            cromosoma.getGen1().setMes(getBinMonth(fecha));
            cromosoma.getGen1().setHora(getBinHorario(random.nextInt(3)+1));
            cromosoma.getGen1().setSala(getBinSala(random.nextInt(salas)+1));
            cromosoma.getGen2().setTt(tts.get(i).getIdTt());
            poblacion.add(cromosoma);
        }
        
        return poblacion;
    }
    
    public static List<Cromosoma> crearPoblacionTT2(Date inicio, Date fin, Set<Tt> tt, int salas)
    {
        List<Cromosoma> poblacion = new ArrayList();
        Random random = new Random();
        Set<Integer> dias = new HashSet();
        Date fecha = new Date();
        int rango = difFecha(fin, inicio)/2;
        inicio.setDate(inicio.getDate() + rango + 1);
        fecha.setDate(inicio.getDate());
        fecha.setMonth(inicio.getMonth());
        int ttxdia = tt.size()/diaHabil(fecha, rango, 0);
        System.out.println("ttxdia = " + ttxdia);
        while(dias.size() != (tt.size()/ttxdia))
        {
            int diaR = random.nextInt(rango + 1) + inicio.getDate();
            fecha.setMonth(inicio.getMonth());
            fecha.setDate(diaR);
            if(fecha.getDay() != 0 && fecha.getDay() != 6)
                dias.add(diaR);
        }
        
        List<Integer> diaR = new ArrayList(dias);
        List<Tt> tts = new ArrayList(tt);
        for(int i = 0; i < tt.size(); i++)
        {
            Cromosoma cromosoma = new Cromosoma();
            fecha.setMonth(inicio.getMonth());
            fecha.setDate(diaR.get(i%diaR.size()));
            cromosoma.getGen1().setDia(getBinDay(fecha));
            cromosoma.getGen1().setMes(getBinMonth(fecha));
            cromosoma.getGen1().setHora(getBinHorario(random.nextInt(3)+1));
            cromosoma.getGen1().setSala(getBinSala(random.nextInt(salas)+1));
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
        if(h == 3)hora[4]=true;
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
    
    public static Date getDateC(Cromosoma c)//Protected
    {
        Date fecha = new Date();
        fecha.setDate(binToInt(c.getGen1().getDia()));
        fecha.setMonth(binToInt(c.getGen1().getMes())-1);
        int hora = binToInt(c.getGen1().getHora());
        if(hora == 4)fecha.setHours(16);fecha.setMinutes(0);
        if(hora == 16)fecha.setHours(14);fecha.setMinutes(0);
        if(hora == 32)fecha.setHours(12);fecha.setMinutes(0);
        if(hora == 64)fecha.setHours(10);fecha.setMinutes(0);
        return fecha;
    }
    
    public static int binToInt(boolean[] bool)
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
        int resultado = (int)((fecha1.getTime()-fecha2.getTime())/86400000);
        
        return resultado;
    }
    
    protected static int diaHabil(Date fecha, int rango, int dias)
    {
        if(fecha.getDay() != 0 && fecha.getDay() != 6)
            dias++;
        fecha.setDate(fecha.getDate()+1);
        rango--;
        if(rango == -1)
            return dias;
        return diaHabil(fecha, rango, dias);
    }
    
    
    
    protected static List<Cromosoma> NuevaGeneracion()
    {
        return new ArrayList();
    }

    public static boolean[] marbin(Profesor p, boolean[] bin) {
        bin[8] = false;
        bin[9] = true;
        bin[10] = false;
        bin[11] = bin[12] = bin[13] = bin[14] = bin[15] = bin[16] = bin[17] = bin[18] = bin[19] = false;
        List<Horario> h = Arrays.asList(p.getHorarios().toArray(new Horario[0]));
        for (int i = 0; i < h.size(); i++) {
            if (h.get(i).getMar().contains("7:00-")) {
                bin[11] = true;
            }
            if (h.get(i).getMar().contains("8:30-")) {
                bin[12] = true;
            }
            if (h.get(i).getMar().contains("10:30-")) {
                bin[13] = true;
            }
            if (h.get(i).getMar().contains("12:00-")) {
                bin[14] = true;
            }
            if (h.get(i).getMar().contains("13:30-")) {
                bin[15] = true;
            }
            if (h.get(i).getMar().contains("15:00-")) {
                bin[16] = true;
            }
            if (h.get(i).getMar().contains("16:30-")) {
                bin[17] = true;
            }
            if (h.get(i).getMar().contains("18:30-")) {
                bin[18] = true;
            }
            if (h.get(i).getMar().contains("20:00-")) {
                bin[19] = true;
            }
        }
        return bin;
    }

    public static boolean[] profebin(Profesor p, boolean[] profb) {
        int id = p.getIdProfesor();
        if (id >= 128) {
            id -= 128;
            profb[0] = true;
        } else {
            profb[0] = false;
        }
        if (id >= 64) {
            id -= 64;
            profb[1] = true;
        } else {
            profb[1] = false;
        }
        if (id >= 32) {
            id -= 32;
            profb[2] = true;
        } else {
            profb[2] = false;
        }
        if (id >= 16) {
            id -= 16;
            profb[3] = true;
        } else {
            profb[3] = false;
        }
        if (id >= 8) {
            id -= 8;
            profb[4] = true;
        } else {
            profb[4] = false;
        }
        if (id >= 4) {
            id -= 4;
            profb[5] = true;
        } else {
            profb[5] = false;
        }
        if (id >= 2) {
            id -= 2;
            profb[6] = true;
        } else {
            profb[6] = false;
        }
        if (id >= 1) {
            id -= 1;
            profb[7] = true;
        } else {
            profb[7] = false;
        }
        return profb;
    }

    public static boolean[] viebin(Profesor p, boolean[] bin) {
        bin[8] = true;
        bin[9] = false;
        bin[10] = true;
        bin[11] = bin[12] = bin[13] = bin[14] = bin[15] = bin[16] = bin[17] = bin[18] = bin[19] = false;
        List<Horario> h = new ArrayList<>(p.getHorarios());
        for (int i = 0; i < h.size(); i++) {
            if (h.get(i).getVie().contains("7:00-")) {
                bin[11] = true;
            }
            if (h.get(i).getVie().contains("8:30-1")) {
                bin[12] = true;
            }
            if (h.get(i).getVie().contains("10:30-")) {
                bin[13] = true;
            }
            if (h.get(i).getVie().contains("12:00-")) {
                bin[14] = true;
            }
            if (h.get(i).getVie().contains("13:30-")) {
                bin[15] = true;
            }
            if (h.get(i).getVie().contains("15:00-")) {
                bin[16] = true;
            }
            if (h.get(i).getVie().contains("16:30-")) {
                bin[17] = true;
            }
            if (h.get(i).getVie().contains("18:30-")) {
                bin[18] = true;
            }
            if (h.get(i).getVie().contains("20:00-")) {
                bin[19] = true;
            }
        }
        return bin;
    }

    public static boolean[] juebin(Profesor p, boolean[] bin) {
        bin[8] = true;
        bin[9] = false;
        bin[10] = false;
        bin[11] = bin[12] = bin[13] = bin[14] = bin[15] = bin[16] = bin[17] = bin[18] = bin[19] = false;
        List<Horario> h = Arrays.asList(p.getHorarios().toArray(new Horario[0]));
        for (int i = 0; i < h.size(); i++) {
            if (h.get(i).getJue().contains("7:00-")) {
                bin[11] = true;
            }
            if (h.get(i).getJue().contains("8:30-")) {
                bin[12] = true;
            }
            if (h.get(i).getJue().contains("10:30-")) {
                bin[13] = true;
            }
            if (h.get(i).getJue().contains("12:00-")) {
                bin[14] = true;
            }
            if (h.get(i).getJue().contains("13:30-")) {
                bin[15] = true;
            }
            if (h.get(i).getJue().contains("15:00-")) {
                bin[16] = true;
            }
            if (h.get(i).getJue().contains("16:30-")) {
                bin[17] = true;
            }
            if (h.get(i).getJue().contains("18:30-")) {
                bin[18] = true;
            }
            if (h.get(i).getJue().contains("20:00-")) {
                bin[19] = true;
            }
        }
        return bin;
    }

    public static boolean[] lunbin(Profesor p, boolean[] bin) {
        bin[8] = false;
        bin[9] = false;
        bin[10] = true;
        bin[11] = bin[12] = bin[13] = bin[14] = bin[15] = bin[16] = bin[17] = bin[18] = bin[19] = false;
        List<Horario> h = Arrays.asList(p.getHorarios().toArray(new Horario[0]));
        for (int i = 0; i < h.size(); i++) {
            if (h.get(i).getLun().contains("7:00-")) {
                bin[11] = true;
            }
            if (h.get(i).getLun().contains("8:30-")) {
                bin[12] = true;
            }
            if (h.get(i).getLun().contains("10:30-")) {
                bin[13] = true;
            }
            if (h.get(i).getLun().contains("12:00-")) {
                bin[14] = true;
            }
            if (h.get(i).getLun().contains("13:30-")) {
                bin[15] = true;
            }
            if (h.get(i).getLun().contains("15:00-")) {
                bin[16] = true;
            }
            if (h.get(i).getLun().contains("16:30-")) {
                bin[17] = true;
            }
            if (h.get(i).getLun().contains("18:30-")) {
                bin[18] = true;
            }
            if (h.get(i).getLun().contains("20:00-")) {
                bin[19] = true;
            }
        }
        return bin;
    }

    public static boolean[] miebin(Profesor p, boolean[] bin) {
        bin[8] = false;
        bin[9] = true;
        bin[10] = true;
        bin[11] = bin[12] = bin[13] = bin[14] = bin[15] = bin[16] = bin[17] = bin[18] = bin[19] = false;
        List<Horario> h = Arrays.asList(p.getHorarios().toArray(new Horario[0]));
        for (int i = 0; i < h.size(); i++) {
            if (h.get(i).getMie().contains("7:00-")) {
                bin[11] = true;
            }
            if (h.get(i).getMie().contains("8:30-")) {
                bin[12] = true;
            }
            if (h.get(i).getMie().contains("10:30-")) {
                bin[13] = true;
            }
            if (h.get(i).getMie().contains("12:00-")) {
                bin[14] = true;
            }
            if (h.get(i).getMie().contains("13:30-")) {
                bin[15] = true;
            }
            if (h.get(i).getMie().contains("15:00-")) {
                bin[16] = true;
            }
            if (h.get(i).getMie().contains("16:30-")) {
                bin[17] = true;
            }
            if (h.get(i).getMie().contains("18:30-")) {
                bin[18] = true;
            }
            if (h.get(i).getMie().contains("20:00-")) {
                bin[19] = true;
            }
        }
        return bin;
    }

    public static boolean[] disponibilidad(boolean[] a, boolean[] b) {
        boolean[] c = new boolean[9];
        for (int i = 0; i < 9; i++) {
            c[i] = !(a[11 + i] || b[i + 11]);
        }
        return c;
    }
    
    protected static Cromosoma[] cruza(Cromosoma padre1, Cromosoma padre2)
    {
        Cromosoma[] hijos = {new Cromosoma(), new Cromosoma()};
        Random random = new Random();
        boolean[] mascara = {random.nextBoolean(),random.nextBoolean(),random.nextBoolean(),random.nextBoolean(),random.nextBoolean()};
        
        if(mascara[0])
        {
            hijos[0].getGen1().setDia(padre1.getGen1().getDia());
            hijos[1].getGen1().setDia(padre2.getGen1().getDia());
        }else
        {
            hijos[0].getGen1().setDia(padre2.getGen1().getDia());
            hijos[1].getGen1().setDia(padre1.getGen1().getDia());
        }
        if(mascara[1])
        {
            hijos[0].getGen1().setHora(padre1.getGen1().getHora());
            hijos[1].getGen1().setHora(padre2.getGen1().getHora());
        }else
        {
            hijos[0].getGen1().setHora(padre2.getGen1().getHora());
            hijos[1].getGen1().setHora(padre1.getGen1().getHora());
        }
        if(mascara[2])
        {
            hijos[0].getGen1().setMes(padre1.getGen1().getMes());
            hijos[1].getGen1().setMes(padre2.getGen1().getMes());
        }else
        {
            hijos[0].getGen1().setMes(padre2.getGen1().getMes());
            hijos[1].getGen1().setMes(padre1.getGen1().getMes());
        }
        if(mascara[3])
        {
            hijos[0].getGen1().setSala(padre1.getGen1().getSala());
            hijos[1].getGen1().setDia(padre2.getGen1().getSala());
        }else
        {
            hijos[0].getGen1().setSala(padre2.getGen1().getSala());
            hijos[1].getGen1().setSala(padre1.getGen1().getSala());
        }
        if(mascara[4])
        {
            hijos[0].getGen2().setTt(padre1.getGen2().getTt());
            hijos[1].getGen2().setTt(padre2.getGen2().getTt());
        }else
        {
            hijos[0].getGen2().setTt(padre2.getGen2().getTt());
            hijos[1].getGen2().setTt(padre1.getGen2().getTt());
        }
        
        return hijos;
    }
    
    public static List<Cromosoma> generaNuevaGen(List<Cromosoma> poblacion)
    {
        List<Cromosoma> nuevaPoblacion = new ArrayList<>();
        List<Restriccion> restricciones = new ArrayList<>();
        List<Cromosoma> feos = new ArrayList<>();
        FuncionAptitud funcion = new FuncionAptitud(restricciones);
        for( int i = 0; i < poblacion.size(); i++)
        {
            int aptitud = funcion.evaluar(poblacion.get(i), nuevaPoblacion);
            aptitudPoblacion += aptitud;
            if(aptitud > 140)
                nuevaPoblacion.add(poblacion.get(i));
            else
                feos.add(poblacion.get(i));
        }
        for(int i = 0; i < feos.size(); i++)
        {
            if(i < feos.size() - 1)
            {
                Cromosoma[] hijo = cruza(feos.get(i),feos.get(i+1));
                nuevaPoblacion.add(hijo[0]);
                nuevaPoblacion.add(hijo[1]);
            }
        }
        
        return nuevaPoblacion;
    }
}