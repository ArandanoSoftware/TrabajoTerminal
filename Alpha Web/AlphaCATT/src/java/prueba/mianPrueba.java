/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import com.myapp.algoritmo.Cromosoma;
import com.myapp.algoritmo.FuncionAptitud;
import com.myapp.algoritmo.Restriccion;
import com.myapp.bs.DirigeBs;
import com.myapp.bs.ProfesorBs;
import com.myapp.bs.SalaBs;
import com.myapp.bs.TTBs;
import com.myapp.model.Calendario;
import com.myapp.model.Dirige;
import com.myapp.model.Horario;
import com.myapp.model.Profesor;
import com.myapp.model.Sala;
import com.myapp.model.Tt;
import com.myapp.modulo.Genetico;
import static com.myapp.modulo.Genetico.crearPoblacionTT1;
import java.util.List;
import com.myapp.modulo.LeerExcel;
import com.sun.javafx.scene.control.skin.VirtualFlow;
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
////        
//////        FileInputStream file = new FileInputStream(new File("..\\ASIGNACIÓN2.xls"));
//////        List<Profesor> profesores = LeerExcel.extraerExcelSamara(file);
////        List<Profesor> profesores = ProfesorBs.findAll();
        
//////        for(int i = 0; i < profesores.size(); i++)
//////        {
//////            ProfesorBs.save(profesores.get(i));
//////        }
//////        
//////        profesores = ProfesorBs.findAll();
//////        
//////        for(int j = 0;j<profesores.size();j++)
//////        {
//////            System.out.println("id: " + profesores.get(j).getIdProfesor() + ": " + profesores.get(j).getApaterno() + ", "+ profesores.get(j).getAmaterno() + ", " + profesores.get(j).getNombre());
//////            List<Horario> horarios = new ArrayList(profesores.get(j).getHorarios());
//////            for(int i = 0; i < horarios.size(); i++)
//////            {
//////                Horario hor = horarios.get(i);
//////                System.out.println("\tHorario: L:" + hor.getLun() + " M:" + hor.getMar() + " M:" + hor.getMie() + " J:" + hor.getJue() + " V:" + hor.getVie() );
//////            }
//////        }
//////        FileInputStream file2 = new FileInputStream(new File("..\\ASIGNACIÓN2.xls"));
//////        List<Sala> salas = LeerExcel.extraeExcelSala(file2);
//////        
//////        for(int i = 0; i < salas.size(); i++)
//////        {
//////            SalaBs.save(salas.get(i));
//////        }
//////        
//////        salas = SalaBs.findAll();
//////        
//////        for(int i = 0; i < salas.size(); i++)
//////        {
//////            System.out.println("id: " + salas.get(i).getIdSala() + " sala: " + salas.get(i).getNombre());
//////        }
        
        
        

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
        
//        Date fechaI = new Date();
//        fechaI.setDate(2);
//        fechaI.setMonth(4);
//        Date fechaF = new Date();
//        fechaF.setDate(2);
//        fechaF.setMonth(5);
//        
//        Set<Tt> tts = new HashSet();
//        for(int i = 0; i < 89; i++)
//        {
//            Tt tt = new Tt();
//            tt.setIdTt("Trabajo Terminal " + i);
//            tt.setNombre("Nombre de  " + i);
//            tts.add(tt);
//        }
//        
//        List<Calendario> cal = Genetico.crearCalendario(Genetico.crearPoblacionTT2(fechaI, fechaF, tts, 9));
//        
//        for(int i = 0; i < cal.size(); i++)
//        {
//            System.out.println("TT: " + cal.get(i).getTt().getIdTt()+ " Fecha: " + cal.get(i).getFecha() + " en la sala: " + cal.get(i).getSala().getIdSala());
//        }
//        
//        LeerExcel.inportaExcel(cal, 1);
        
////        file.close();
        
////        List<Tt> tts = TTBs.findAll();
////        
////        for (int i = 0; i < tts.size(); i++)
////        {
////            System.out.println("id: " + tts.get(i).getIdTt() + " " + tts.get(i).getNombre());
////        }
        
        
        List<Integer> prueba = new ArrayList<>();
        prueba.add(4);
        prueba.add(7);
        prueba.add(5);
        prueba.add(3);
        prueba.add(1);
        prueba.add(8);
        prueba.add(6);
        prueba.add(9);
        prueba.add(2);
        
        System.out.println("Este se quita xD " + prueba.remove(4) + " Ahora este es el de la pos uno" + prueba.get(1) + " y este donde esta la pos " + prueba.get(4));
        
        Set<Tt> tt1s = new HashSet(TTBs.findAllTT1());
        List<Cromosoma> poblacion;
        Date inicio = new Date();
        inicio.setDate(2);
        inicio.setMonth(4);
        Date fin = new Date();
        fin.setDate(6);
        fin.setMonth(5);
        poblacion = Genetico.crearPoblacionTT1(inicio, fin, tt1s, SalaBs.findAll().size());
        //List<Restriccion> restricciones = new ArrayList<>();
        

        System.out.println("fueron: " + poblacion.size());
        
        poblacion = Genetico.generaNuevaGen(poblacion);
        
        System.out.println("esta es la aptitud: " + Genetico.aptitudPoblacion);

        
        System.out.println("fueron: " + poblacion.size());
        Genetico.aptitudPoblacion = 0;
        
        
        poblacion = Genetico.generaNuevaGen(poblacion);
        
        
        System.out.println("esta es la aptitud: " + Genetico.aptitudPoblacion);

        System.out.println("fueron: " + poblacion.size());
        Genetico.aptitudPoblacion = 0;
        //FuncionAptitud funcion = new FuncionAptitud(restricciones);
        //List<Integer> aptitudes = new ArrayList<>();

        for(int i = 0; i < 100; i++)
        {
            poblacion = Genetico.generaNuevaGen(poblacion);
            System.out.println(Genetico.aptitudPoblacion);
            Genetico.aptitudPoblacion = 0;
        }

        System.out.println("Ya terminó !!!!!");
    }    
}
