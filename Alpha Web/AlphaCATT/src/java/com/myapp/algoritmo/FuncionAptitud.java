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
import com.myapp.modulo.Genetico;
import java.util.Date;
import java.util.List;
//////////////recuerda hazziely que tienes que remplazar!!!!
/**
 *
 * @author Hazzy76
 */
public class FuncionAptitud {
    
    private static List<Dirige> directores;
    private static List<Sinodalia> sinodales;
    
    private List<Cromosoma> poblacion;
    private Dirige dirige;
    private Sinodalia sinodalia;
    private Cromosoma cc;
    private final List<Restriccion> restricciones;
    
    public FuncionAptitud(List<Restriccion> restricciones)
    {
        FuncionAptitud.directores = DirigeBs.findAll();
        FuncionAptitud.sinodales = SinodaliaBs.findAll();
        this.restricciones = restricciones;
    }
    
    public int evaluar(Cromosoma cc, List<Cromosoma> poblacion)
    {
        this.dirige = DirigeBs.findById(cc.getGen2().getTt());
        this.sinodalia = SinodaliaBs.findById(cc.getGen2().getTt());
        this.cc = cc;
        this.poblacion = poblacion;
        if(!salaLibre())return 0;
        int aptitud = 0, directors = 0, sinodals = 0;
        directors += funcionDirector();
        if(directors < 35) return 0;
        sinodals += funcionSinodal();
        if(sinodals < 46) return 0;
        aptitud += directors + sinodals;
        return aptitud;
    }
    
    protected int funcionDirector()
    {
        if(dirige.getProfesorByD2() == null)
            return funcionDirector1();
        int personal1 = 70, personal2 = 70, hora1 = 0, hora2 = 0;
        for(int i = 0; i < restricciones.size(); i++)
        {
            if(!(igualBin(cc.getGen1().getMes(),restricciones.get(i).getMes()) && igualBin(cc.getGen1().getDia(),restricciones.get(i).getDia()) && disponible(restricciones.get(i).getHora(),cc.getGen1().getHora())))
            {
                if(restricciones.get(i).getProfesor() == dirige.getProfesorByD1().getIdProfesor())personal1 = 0;
                if(restricciones.get(i).getProfesor() == dirige.getProfesorByD2().getIdProfesor())personal2 = 0;
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
        horario[0] = director1[11];
        horario[1] = director1[12];
        horario[2] = director1[13];
        horario[3] = director1[14];
        horario[4] = director1[15];
        horario[5] = director1[16];
        horario[6] = director1[17];
        horario[7] = director1[18];
        horario[8] = director1[19];
        if(disponible(horario, cc.getGen1().getHora()))hora1 += 30;
        horario[0] = director2[11];
        horario[1] = director2[12];
        horario[2] = director2[13];
        horario[3] = director2[14];
        horario[4] = director2[15];
        horario[5] = director2[16];
        horario[6] = director2[17];
        horario[7] = director2[18];
        horario[8] = director2[19];
        if(disponible(horario, cc.getGen1().getHora()))hora2 += 30;
        
        int dir1 = dirige.getProfesorByD1().getIdProfesor();
        int dir2 = dirige.getProfesorByD2().getIdProfesor();
        for(int i = 0; i < directores.size(); i++)
        {
            int d1 = directores.get(i).getProfesorByD1().getIdProfesor();
            int d2;
            try{d2= directores.get(i).getProfesorByD2().getIdProfesor();}catch(Exception e){d2 = d1;}
            int s1 = sinodales.get(i).getProfesorByS1().getIdProfesor();
            int s2 = sinodales.get(i).getProfesorByS2().getIdProfesor();
            int s3;
            try{s3 = sinodales.get(i).getProfesorByS3().getIdProfesor();}catch(Exception e){s3 = s1;}
            for(int j = 0; j < poblacion.size(); j++)
            {
                if(poblacion.get(j).getGen2().getTt().equals(directores.get(i).getIdTt()) && igualBin(cc.getGen1().getSala(),poblacion.get(j).getGen1().getSala()) && igualBin(cc.getGen1().getMes(),poblacion.get(j).getGen1().getMes()) && igualBin(cc.getGen1().getDia(),poblacion.get(j).getGen1().getDia()) && igualBin(cc.getGen1().getHora(),poblacion.get(j).getGen1().getHora()))
                {
                    if(dir1 == d1 || dir1 == d2 || dir1 == s1 || dir1 == s2 || dir1 == s3)
                        personal1 = 0;
                    if(dir2 == d1 || dir2 == d2 || dir2 == s1 || dir2 == s2 || dir2 == s3)
                        personal2 = 0;
                }
            }
        }
        
        return (personal1 + personal2 + hora1 + hora2)/2;
    }

        protected int funcionDirector1()
    {
        int personal1 = 70, hora1 = 0;
        for(int i = 0; i < restricciones.size(); i++)
        {
            if(!(igualBin(cc.getGen1().getMes(),restricciones.get(i).getMes()) && igualBin(cc.getGen1().getDia(),restricciones.get(i).getDia()) && disponible(restricciones.get(i).getHora(),cc.getGen1().getHora())))
            {
                if(restricciones.get(i).getProfesor() == dirige.getProfesorByD1().getIdProfesor())personal1 = 0;
            }
        }
        if(personal1 == 0)return 0;
        //Hasta aqui ya se comprobó si pueden o no xD
        
        Date date = new Date();
        date.setMonth(Genetico.binToInt(cc.getGen1().getMes()));
        date.setDate(Genetico.binToInt(cc.getGen1().getDia()));
        int diaSem = date.getDay();//0 = sunday
        boolean[] director1 = new boolean[20];
        Genetico.profebin(dirige.getProfesorByD1(), director1);
        if(diaSem == 1){director1 = Genetico.lunbin(dirige.getProfesorByD1(), director1);}
        if(diaSem == 2){director1 = Genetico.marbin(dirige.getProfesorByD1(), director1);}
        if(diaSem == 3){director1 = Genetico.miebin(dirige.getProfesorByD1(), director1);}
        if(diaSem == 4){director1 = Genetico.juebin(dirige.getProfesorByD1(), director1);}
        if(diaSem == 5){director1 = Genetico.viebin(dirige.getProfesorByD1(), director1);}
        boolean[] horario  = new boolean[9];
        horario[0] = director1[11];
        horario[1] = director1[12];
        horario[2] = director1[13];
        horario[3] = director1[14];
        horario[4] = director1[15];
        horario[5] = director1[16];
        horario[6] = director1[17];
        horario[7] = director1[18];
        horario[8] = director1[19];
        if(disponible(horario, cc.getGen1().getHora()))hora1 += 30;
        
        int dir1 = dirige.getProfesorByD1().getIdProfesor();
        for(int i = 0; i < directores.size(); i++)
        {
            int d1 = directores.get(i).getProfesorByD1().getIdProfesor();
            int d2;
            try{d2= directores.get(i).getProfesorByD2().getIdProfesor();}catch(Exception e){d2 = d1;}
            int s1 = sinodales.get(i).getProfesorByS1().getIdProfesor();
            int s2 = sinodales.get(i).getProfesorByS2().getIdProfesor();
            int s3;
            try{s3 = sinodales.get(i).getProfesorByS3().getIdProfesor();}catch(Exception e){s3 = s1;}
            for(int j = 0; j < poblacion.size(); j++)
            {
                if(poblacion.get(j).getGen2().getTt().equals(directores.get(i).getIdTt()) && igualBin(cc.getGen1().getSala(),poblacion.get(j).getGen1().getSala()) && igualBin(cc.getGen1().getMes(),poblacion.get(j).getGen1().getMes()) && igualBin(cc.getGen1().getDia(),poblacion.get(j).getGen1().getDia()) && igualBin(cc.getGen1().getHora(),poblacion.get(j).getGen1().getHora()))
                {
                    if(dir1 == d1 || dir1 == d2 || dir1 == s1 || dir1 == s2 || dir1 == s3)
                        personal1 = 0;
                }
            }
        }
        
        return personal1 + hora1;
    }
    
    protected int funcionSinodal()
    {
        if(sinodalia.getProfesorByS3() == null)
            return funcionSinodal2();
        int personal1 = 70, personal2 = 70, personal3 = 70, hora1 = 0, hora2 = 0, hora3 = 0;
        for(int i = 0; i < restricciones.size(); i++)
        {
            if(!(igualBin(cc.getGen1().getMes(),restricciones.get(i).getMes()) && igualBin(cc.getGen1().getDia(),restricciones.get(i).getDia()) && disponible(restricciones.get(i).getHora(),cc.getGen1().getHora())))
            {
                if(restricciones.get(i).getProfesor() == sinodalia.getProfesorByS1().getIdProfesor())personal1 = 0;
                if(restricciones.get(i).getProfesor() == sinodalia.getProfesorByS2().getIdProfesor())personal2 = 0;
                if(restricciones.get(i).getProfesor() == sinodalia.getProfesorByS3().getIdProfesor())personal3 = 0;
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
        Genetico.profebin(sinodalia.getProfesorByS3(), sinodal3);
        if(diaSem == 1){sinodal1 = Genetico.lunbin(sinodalia.getProfesorByS1(), sinodal1); sinodal2 = Genetico.lunbin(sinodalia.getProfesorByS2(), sinodal2); sinodal3 = Genetico.lunbin(sinodalia.getProfesorByS3(), sinodal3);}
        if(diaSem == 1){sinodal1 = Genetico.marbin(sinodalia.getProfesorByS1(), sinodal1); sinodal2 = Genetico.marbin(sinodalia.getProfesorByS2(), sinodal2); sinodal3 = Genetico.marbin(sinodalia.getProfesorByS3(), sinodal3);}
        if(diaSem == 1){sinodal1 = Genetico.miebin(sinodalia.getProfesorByS1(), sinodal1); sinodal2 = Genetico.miebin(sinodalia.getProfesorByS2(), sinodal2); sinodal3 = Genetico.miebin(sinodalia.getProfesorByS3(), sinodal3);}
        if(diaSem == 1){sinodal1 = Genetico.juebin(sinodalia.getProfesorByS1(), sinodal1); sinodal2 = Genetico.juebin(sinodalia.getProfesorByS2(), sinodal2); sinodal3 = Genetico.juebin(sinodalia.getProfesorByS3(), sinodal3);}
        if(diaSem == 1){sinodal1 = Genetico.viebin(sinodalia.getProfesorByS1(), sinodal1); sinodal2 = Genetico.viebin(sinodalia.getProfesorByS2(), sinodal2); sinodal3 = Genetico.viebin(sinodalia.getProfesorByS3(), sinodal3);}
        boolean[] horario  = new boolean[9];
        horario[0] = sinodal1[11];
        horario[1] = sinodal1[12];
        horario[2] = sinodal1[13];
        horario[3] = sinodal1[14];
        horario[4] = sinodal1[15];
        horario[5] = sinodal1[16];
        horario[6] = sinodal1[17];
        horario[7] = sinodal1[18];
        horario[8] = sinodal1[19];
        if(disponible(horario, cc.getGen1().getHora()))hora1 += 30;
        horario[0] = sinodal2[11];
        horario[1] = sinodal2[12];
        horario[2] = sinodal2[13];
        horario[3] = sinodal2[14];
        horario[4] = sinodal2[15];
        horario[5] = sinodal2[16];
        horario[6] = sinodal2[17];
        horario[7] = sinodal2[18];
        horario[8] = sinodal2[19];
        if(disponible(horario, cc.getGen1().getHora()))hora2 += 30;
        horario[0] = sinodal3[11];
        horario[1] = sinodal3[12];
        horario[2] = sinodal3[13];
        horario[3] = sinodal3[14];
        horario[4] = sinodal3[15];
        horario[5] = sinodal3[16];
        horario[6] = sinodal3[17];
        horario[7] = sinodal3[18];
        horario[8] = sinodal3[19];
        if(disponible(horario, cc.getGen1().getHora()))hora3 += 30;
        
        int sin1 = sinodalia.getProfesorByS1().getIdProfesor();
        int sin2 = sinodalia.getProfesorByS2().getIdProfesor();
        int sin3 = sinodalia.getProfesorByS3().getIdProfesor();
        for(int i = 0; i < sinodales.size(); i++)
        {
            int d1 = directores.get(i).getProfesorByD1().getIdProfesor();
            int d2;
            try{d2= directores.get(i).getProfesorByD2().getIdProfesor();}catch(Exception e){d2 = d1;}
            int s1 = sinodales.get(i).getProfesorByS1().getIdProfesor();
            int s2 = sinodales.get(i).getProfesorByS2().getIdProfesor();
            int s3;
            try{s3 = sinodales.get(i).getProfesorByS3().getIdProfesor();}catch(Exception e){s3 = s1;}
            for(int j = 0; j < poblacion.size(); j++)
            {
                if(poblacion.get(j).getGen2().getTt().equals(directores.get(i).getIdTt()) && igualBin(cc.getGen1().getSala(),poblacion.get(j).getGen1().getSala()) && igualBin(cc.getGen1().getMes(),poblacion.get(j).getGen1().getMes()) && igualBin(cc.getGen1().getDia(),poblacion.get(j).getGen1().getDia()) && igualBin(cc.getGen1().getHora(),poblacion.get(j).getGen1().getHora()))
                {
                    if(sin1 == d1 || sin1 == d2 || sin1 == s1 || sin1 == s2 || sin1 == s3)
                        personal1 = 0;
                    if(sin2 == d1 || sin2 == d2 || sin2 == s1 || sin2 == s2 || sin2 == s3)
                        personal2 = 0;
                    if(sin3 == d1 || sin3 == d2 || sin3 == s1 || sin3 == s2 || sin3 == s3)
                        personal3 = 0;
                }
            }
        }
        if(personal1 == 0 || personal2 == 0)return 0;
        return (personal1 + personal2 + personal3 + hora1 + hora2 + hora3)/3;
    }
    
        protected int funcionSinodal2()
    {
        int personal1 = 70, personal2 = 70, hora1 = 0, hora2 = 0;
        for(int i = 0; i < restricciones.size(); i++)
        {
            if(!(igualBin(cc.getGen1().getMes(),restricciones.get(i).getMes()) && igualBin(cc.getGen1().getDia(),restricciones.get(i).getDia()) && disponible(restricciones.get(i).getHora(),cc.getGen1().getHora())))
            {
                if(restricciones.get(i).getProfesor() == sinodalia.getProfesorByS1().getIdProfesor())personal1 = 0;
                if(restricciones.get(i).getProfesor() == sinodalia.getProfesorByS2().getIdProfesor())personal2 = 0;
            }
        }
        
        if(personal1 == 0 || personal2 == 0)return 0;
        //Hasta aqui ya se comprobó si pueden o no xD
        
        Date date = new Date();
        date.setMonth(Genetico.binToInt(cc.getGen1().getMes()));
        date.setDate(Genetico.binToInt(cc.getGen1().getDia()));
        int diaSem = date.getDay();//0 = sunday
        boolean[] sinodal1 = new boolean[20];
        boolean[] sinodal2 = new boolean[20];
        Genetico.profebin(sinodalia.getProfesorByS1(), sinodal1);
        Genetico.profebin(sinodalia.getProfesorByS2(), sinodal2);
        if(diaSem == 1){sinodal1 = Genetico.lunbin(sinodalia.getProfesorByS1(), sinodal1); sinodal2 = Genetico.lunbin(sinodalia.getProfesorByS2(), sinodal2);}
        if(diaSem == 1){sinodal1 = Genetico.marbin(sinodalia.getProfesorByS1(), sinodal1); sinodal2 = Genetico.marbin(sinodalia.getProfesorByS2(), sinodal2);}
        if(diaSem == 1){sinodal1 = Genetico.miebin(sinodalia.getProfesorByS1(), sinodal1); sinodal2 = Genetico.miebin(sinodalia.getProfesorByS2(), sinodal2);}
        if(diaSem == 1){sinodal1 = Genetico.juebin(sinodalia.getProfesorByS1(), sinodal1); sinodal2 = Genetico.juebin(sinodalia.getProfesorByS2(), sinodal2);}
        if(diaSem == 1){sinodal1 = Genetico.viebin(sinodalia.getProfesorByS1(), sinodal1); sinodal2 = Genetico.viebin(sinodalia.getProfesorByS2(), sinodal2);}
        boolean[] horario  = new boolean[9];
        horario[0] = sinodal1[11];
        horario[1] = sinodal1[12];
        horario[2] = sinodal1[13];
        horario[3] = sinodal1[14];
        horario[4] = sinodal1[15];
        horario[5] = sinodal1[16];
        horario[6] = sinodal1[17];
        horario[7] = sinodal1[18];
        horario[8] = sinodal1[19];
        if(disponible(horario, cc.getGen1().getHora()))hora1 += 30;
        horario[0] = sinodal2[11];
        horario[1] = sinodal2[12];
        horario[2] = sinodal2[13];
        horario[3] = sinodal2[14];
        horario[4] = sinodal2[15];
        horario[5] = sinodal2[16];
        horario[6] = sinodal2[17];
        horario[7] = sinodal2[18];
        horario[8] = sinodal2[19];
        if(disponible(horario, cc.getGen1().getHora()))hora2 += 30;
        
        int sin1 = sinodalia.getProfesorByS1().getIdProfesor();
        int sin2 = sinodalia.getProfesorByS2().getIdProfesor();
        for(int i = 0; i < sinodales.size(); i++)
        {
            int d1 = directores.get(i).getProfesorByD1().getIdProfesor();
            int d2;
            try{d2= directores.get(i).getProfesorByD2().getIdProfesor();}catch(Exception e){d2 = d1;}
            int s1 = sinodales.get(i).getProfesorByS1().getIdProfesor();
            int s2 = sinodales.get(i).getProfesorByS2().getIdProfesor();
            int s3 = 0;
            try{s3 = sinodales.get(i).getProfesorByS3().getIdProfesor();}catch(Exception e){if(sinodales.get(i).getProfesorByS3() == null)s3 = s1;}
           for(int j = 0; j < poblacion.size(); j++)
            {
                if(poblacion.get(j).getGen2().getTt().equals(directores.get(i).getIdTt()) && igualBin(cc.getGen1().getSala(),poblacion.get(j).getGen1().getSala()) && igualBin(cc.getGen1().getMes(),poblacion.get(j).getGen1().getMes()) && igualBin(cc.getGen1().getDia(),poblacion.get(j).getGen1().getDia()) && igualBin(cc.getGen1().getHora(),poblacion.get(j).getGen1().getHora()))
                {
                    if(sin1 == d1 || sin1 == d2 || sin1 == s1 || sin1 == s2 || sin1 == s3)
                        personal1 = 0;
                    if(sin2 == d1 || sin2 == d2 || sin2 == s1 || sin2 == s2 || sin2 == s3)
                        personal2 = 0;
                }
            }
        }
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
    
    protected boolean salaLibre()
    {
        for(int i = 0; i < poblacion.size();i++)
        {
            if(igualBin(cc.getGen1().getSala(),poblacion.get(i).getGen1().getSala()) && igualBin(cc.getGen1().getMes(),poblacion.get(i).getGen1().getMes()) && igualBin(cc.getGen1().getDia(),poblacion.get(i).getGen1().getDia()) && igualBin(cc.getGen1().getHora(),poblacion.get(i).getGen1().getHora()))
            {                
                return false;
            }
        }
        return true;
    }
    
    public static double aptitudPoblacional(int suma, int poblacion)
    {
        return suma/poblacion;
    }
}