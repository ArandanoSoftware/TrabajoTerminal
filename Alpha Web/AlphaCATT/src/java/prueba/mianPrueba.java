/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import com.myapp.bs.ProfesorBs;
import com.myapp.model.Profesor;
import com.myapp.model.Tt;
import com.myapp.modulo.Genetico;
import java.util.List;
import com.myapp.modulo.LeerExcel;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author root
 */
public class mianPrueba {
    
    public static void main(String[] args) throws Exception 
    {
//        List<Sala> salas;
//        salas = SalaBs.findAll();
//        System.out.println(salas.get(0).getNombre());
//        for(int i = 0; i < salas.size(); i++)
//        {
//            System.out.println("id: " + salas.get(i).getIdSala() + " Nombre: " + salas.get(i).getNombre());
//        }
//        
//        List<Sala> salas;
//        
//        Sala s = new Sala("nueva sala");
//        for(int i = 18; i < 53; i++)
//        {
//            if(i == 24)continue;
//            s.setIdSala(i);
//            SalaBs.delete(s);
//        }
//        s.setIdSala(56);
//        SalaBs.delete(s);
//        s.setIdSala(57);
//        SalaBs.delete(s);
//        s.setIdSala(58);
//        SalaBs.delete(s);
//        salas = SalaBs.findAll();
//        for(int i = 0; i < salas.size(); i++)
//        {
//            System.out.println("id: " + salas.get(i).getIdSala() + " Nombre: " + salas.get(i).getNombre());
//        }
        
//        FileInputStream file = new FileInputStream(new File("../Estructura 2017 1.xls"));
//        List<Profesor> profesores = LeerExcel.ExtraeExcel(file);
        
//        for(int i = 0; i < profesores.size(); i++)
//        {
//            ProfesorBs.save(profesores.get(i));
 //       }
//        for(int j = 0;j<profesores.size();j++)
//        {
//            //profesores.get(j).setIdProfesor(j+1);
//            System.out.println("id: " + profesores.get(j).getIdProfesor() + ": " + profesores.get(j).getApaterno() + ", "+ profesores.get(j).getAmaterno() + ", " + profesores.get(j).getNombre());
//            List<Horario> horarios = Arrays.asList(profesores.get(j).getHorarios().toArray(new Horario[0]));
//            for(int i = 0; i < horarios.size(); i++)
//            {
//                Horario hor = horarios.get(i);
//                System.out.println("\tHorario: " + hor.getLun() + " " + hor.getMar() + " " + hor.getMie() + " " + hor.getJue() + " " + hor.getVie() );
//            }
//        }

////        List<Profesor> profesores = ProfesorBs.findAll();
////        for(int i = 0; i < profesores.size(); i++)
////        {
////            ProfesorBs.delete(profesores.get(i));
////        }

        Date date = new Date();
        date.setMonth(2);
        date.setDate(14);
        boolean[] bo = Genetico.getBinDay(date);
        System.out.println("Dia: " + bo[0] + " " + bo[1] + " "  + bo[2] + " "  + bo[3] + " "  + bo[4]);
        bo = Genetico.getBinMonth(date);
        System.out.println("Mes: " + bo[0] + " " + bo[1] + " "  + bo[2] + " "  + bo[3]);
        bo = Genetico.getBinSala(1);
        System.out.println("Sala: " + bo[0] + " " + bo[1] + " "  + bo[2] + " "  + bo[3]);
        
        Date nueva = new Date();
        nueva.setDate(14);
        nueva.setMonth(3);
        
        Set<Tt> tts = new HashSet();
        
        for(int i = 0; i < 100; i++)
        {
            Genetico.crearPoblacion(nueva, date, tts, 1);
        }
        
        
        System.out.println(nueva.getDate() + " " + nueva.getMonth());
        
        System.out.println("Ya terminó !!!!!");
    }    
}
