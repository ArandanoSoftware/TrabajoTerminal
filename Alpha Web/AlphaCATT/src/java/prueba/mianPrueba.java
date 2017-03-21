/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import com.myapp.bs.ProfesorBs;
import com.myapp.model.Calendario;
import com.myapp.model.Horario;
import com.myapp.model.Profesor;
import com.myapp.model.Tt;
import com.myapp.modulo.Genetico;
import java.util.List;
import com.myapp.modulo.LeerExcel;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
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
        
        FileInputStream file = new FileInputStream(new File("../Estructura 2017 1.xls"));
        List<Profesor> profesores = LeerExcel.ExtraeExcel(file);
        
        for(int i = 0; i < profesores.size();i++)
        {
            System.out.println("nombre: " + profesores.get(i).getNombre() + " " + profesores.get(i).getApaterno()+ " " + profesores.get(i).getAmaterno()+ " ");
        }
        
        
//        for(int i = 0; i < profesores.size(); i++)
//        {
//            ProfesorBs.save(profesores.get(i));
//       }
        for(int j = 0;j<profesores.size();j++)
        {
            //profesores.get(j).setIdProfesor(j+1);
            System.out.println("id: " + profesores.get(j).getIdProfesor() + ": " + profesores.get(j).getApaterno() + ", "+ profesores.get(j).getAmaterno() + ", " + profesores.get(j).getNombre());
            List<Horario> horarios = Arrays.asList(profesores.get(j).getHorarios().toArray(new Horario[0]));
            for(int i = 0; i < horarios.size(); i++)
            {
                Horario hor = horarios.get(i);
                System.out.println("\tHorario: " + hor.getLun() + " " + hor.getMar() + " " + hor.getMie() + " " + hor.getJue() + " " + hor.getVie() );
            }
        }

////        List<Profesor> profesores = ProfesorBs.findAll();
////        for(int i = 0; i < profesores.size(); i++)
////        {
////            ProfesorBs.delete(profesores.get(i));
////        }

////        Date date = new Date();
////        date.setMonth(2);
////        date.setDate(14);
////        
////        
////        Date nueva = new Date();
////        nueva.setDate(14);
////        nueva.setMonth(3);
////        
////        Set<Tt> tts = new HashSet();
////        
////        for(int i = 0; i < 100; i++)
////        {
////            Genetico.crearPoblacion(nueva, date, tts, 1);
////        }
        
////        Date fechaI = new Date();
////        fechaI.setDate(2);
////        fechaI.setMonth(4);
////        Date fechaF = new Date();
////        fechaF.setDate(2);
////        fechaF.setMonth(5);
////        
////        Set<Tt> tts = new HashSet();
////        for(int i = 0; i < 89; i++)
////        {
////            Tt tt = new Tt();
////            tt.setIdTt("Trabajo Terminal " + i);
////            tt.setNombre("Nombre de  " + i);
////            tts.add(tt);
////        }
////        
////        List<Calendario> cal = Genetico.crearCalendario(Genetico.crearPoblacionTT2(fechaI, fechaF, tts, 9));
////        
////        for(int i = 0; i < cal.size(); i++)
////        {
////            System.out.println("TT: " + cal.get(i).getTt().getIdTt()+ " Fecha: " + cal.get(i).getFecha() + " en la sala: " + cal.get(i).getSala().getIdSala());
////        }
////        
////        LeerExcel.inportaExcel(cal, 1);
        
        System.out.println("Ya terminó !!!!!");
    }    
}
