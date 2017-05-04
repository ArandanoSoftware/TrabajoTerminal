/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import com.myapp.modulo.PDF;
import com.myapp.algoritmo.Cromosoma;
import com.myapp.algoritmo.FuncionAptitud;
import com.myapp.algoritmo.Restriccion;
import com.myapp.algoritmo.RestriccionGeneral;
import com.myapp.bs.CalendarioBs;
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
import com.myapp.modulo.Email;
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
        long tinicio, tfin, tiempo; //Variables para determinar el tiempo de ejecución
        tinicio = System.currentTimeMillis(); 
        List<Integer> lista1 = new ArrayList<>();
        List<Integer> lista2 = new ArrayList<>();
        List<Integer> lista3 = new ArrayList<>();
        lista1.add(4);
        lista1.add(44);
        lista1.add(444);
        lista1.add(4444);
        lista2.add(1111);
        lista2.add(111);
        lista2.add(11);
        lista2.add(1);
        lista3.addAll(lista1);
        lista3.addAll(lista2);
                
        Date fes = new Date();
        fes.setMonth(4);
        fes.setDate(1);
        Genetico.noHabil.add(fes);
        fes = new Date();
        fes.setMonth(4);
        fes.setDate(5);
        Genetico.noHabil.add(fes);
        fes = new Date();
        fes.setMonth(4);
        fes.setDate(10);
        Genetico.noHabil.add(fes);
        fes = new Date();
        fes.setMonth(4);
        fes.setDate(15);
        Genetico.noHabil.add(fes);
        for(int i = 0; i < lista3.size(); i++)
            System.out.println(lista3.get(i));
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
        
        
        int mayor = 0;
        
        Set<Tt> tt1s = new HashSet(TTBs.findAllTT1());
        List<Cromosoma> poblacion;
        List<Restriccion> restricciones = new ArrayList<>();
        Date inicio = new Date();
        inicio.setDate(2);
        inicio.setMonth(4);
        Date fin = new Date();
        fin.setDate(6);
        fin.setMonth(5);
        poblacion = Genetico.crearPoblacionTT1(inicio, fin, tt1s, SalaBs.findAll().size());
        
        List<Calendario> cal = Genetico.crearCalendario(poblacion,1);
        
        for(int i = 0; i < cal.size(); i++)
        {
            System.out.println("TT: " + cal.get(i).getTt().getIdTt()+ " Fecha: " + cal.get(i).getFecha() + " en la sala: " + cal.get(i).getSala().getIdSala());
        }
        
        System.out.println("fecha fin: " + fin);
        //LeerExcel.inportaExcel(cal, 1);
        
        
        //List<Restriccion> restricciones = new ArrayList<>();
        //primera restriccion
        
        
        RestriccionGeneral restriccionGen1 = new RestriccionGeneral(137);
        Date rango1 = new Date();
        Date rango2 = new Date();
        rango1.setMonth(4);
        rango1.setDate(23);
        rango2.setMonth(4);
        rango2.setDate(26);
        restriccionGen1.setRango(rango1, rango2);
        //segunda restriccion
        RestriccionGeneral restriccionGen2 = new RestriccionGeneral(46);
        restriccionGen2.setRango(rango1, rango2);
        //tercera restriccion
        RestriccionGeneral restriccionGen3 = new RestriccionGeneral(25);
        rango1.setDate(24);
        restriccionGen3.setRango(rango1, rango2);
        //cuarta restriccion
        RestriccionGeneral restriccionGen4 = new RestriccionGeneral(123);
        restriccionGen4.setHora(3, inicio, fin);
        //quinta restriccion
        RestriccionGeneral restriccionGen5 = new RestriccionGeneral(183);
        restriccionGen5.setHora(3, inicio, fin);
        //sexta restriccion
        RestriccionGeneral restriccionGen6 = new RestriccionGeneral(216);
        restriccionGen6.setDiaSem(2, inicio, fin);
        restriccionGen6.setDiaSem(3, inicio, fin);
        //septima restricicon
        RestriccionGeneral restriccionGen7 = new RestriccionGeneral(197);
        rango1.setDate(31);
        rango2.setMonth(5);
        rango2.setDate(2);
        restriccionGen7.setRango(rango1, rango2);
        //octava restriccion
        RestriccionGeneral restriccionGen8 = new RestriccionGeneral(236);
        restriccionGen8.setDiaSem(2, inicio, fin);
        restriccionGen8.setDiaSem(3, inicio, fin);
        restriccionGen8.setDiaSem(5, inicio, fin);
        //novena restriccion
        RestriccionGeneral restriccionGen9 = new RestriccionGeneral(9);
        rango1.setMonth(4);
        rango1.setDate(8);
        restriccionGen9.setDia(rango1);
        rango1.setDate(22);
        restriccionGen9.setDia(rango1);
        rango1.setDate(29);
        restriccionGen9.setDia(rango1);
        rango1.setMonth(5);
        rango1.setDate(5);
        restriccionGen9.setDia(rango1);
        //decima restriccion 
        RestriccionGeneral restriccionGen10 = new RestriccionGeneral(200);
        rango1.setMonth(4);
        rango1.setDate(9);
        restriccionGen10.setDia(rango1);
        rango1.setDate(12);
        restriccionGen10.setDia(rango1);
        //Decima Primera Restriccion
        RestriccionGeneral restriccionGen11 = new RestriccionGeneral(115);
        rango1.setMonth(4);
        rango1.setDate(8);
        restriccionGen11.setDia(rango1);
        rango1.setDate(22);
        restriccionGen11.setDia(rango1);
        rango1.setDate(29);
        restriccionGen11.setDia(rango1);
        rango1.setMonth(5);
        rango1.setDate(5);
        restriccionGen11.setDia(rango1);
        //decima segunda restricicon
        RestriccionGeneral restriccionGen12 = new RestriccionGeneral(224);
        restriccionGen12.setDiaSem(2, inicio, fin);
        //decima tercera restricicon
        RestriccionGeneral restriccionGen13 = new RestriccionGeneral(234);
        restriccionGen13.setDiaSem(2, inicio, fin);
        //decima cuarta restricicon
        RestriccionGeneral restriccionGen14 = new RestriccionGeneral(220);
        restriccionGen14.setDiaSem(2, inicio, fin);
        //decima quimta restriccion
        RestriccionGeneral restriccionGen15 = new RestriccionGeneral(72);
        rango1.setMonth(5);
        rango1.setDate(7);
        rango2.setMonth(5);
        rango2.setDate(9);
        restriccionGen15.setRango(rango1, rango2);
        //decima sexta restriccion
        RestriccionGeneral restriccionGen16 = new RestriccionGeneral(161);
        rango1.setDate(7);
        rango2.setMonth(5);
        rango2.setDate(9);
        restriccionGen16.setRango(rango1, rango2);
        //decima septima restriccion
        RestriccionGeneral restriccionGen17 = new RestriccionGeneral(64);
        rango1.setMonth(4);
        rango1.setDate(18);
        rango2.setMonth(4);
        rango2.setDate(26);
        restriccionGen17.setRango(rango1, rango2);
        //decima octava restriccion
        RestriccionGeneral restriccionGen18 = new RestriccionGeneral(21);
        restriccionGen18.setHora(3, inicio, fin);
        //Decima Novena Restricicon
        RestriccionGeneral restriccionGen19 = new RestriccionGeneral(24);
        rango1.setMonth(4);
        rango1.setDate(29);
        rango2.setMonth(5);
        rango2.setDate(9);
        restriccionGen19.setRango(rango1, rango2);
        //asignacion de las restricciones
        restricciones.addAll(restriccionGen1.getRestricciones());
        restricciones.addAll(restriccionGen2.getRestricciones());
        restricciones.addAll(restriccionGen3.getRestricciones());
        restricciones.addAll(restriccionGen4.getRestricciones());
        restricciones.addAll(restriccionGen5.getRestricciones());
        restricciones.addAll(restriccionGen6.getRestricciones());
        restricciones.addAll(restriccionGen7.getRestricciones());
        restricciones.addAll(restriccionGen8.getRestricciones());
        restricciones.addAll(restriccionGen9.getRestricciones());
        restricciones.addAll(restriccionGen10.getRestricciones());
        restricciones.addAll(restriccionGen11.getRestricciones());
        restricciones.addAll(restriccionGen12.getRestricciones());
        restricciones.addAll(restriccionGen13.getRestricciones());
        restricciones.addAll(restriccionGen14.getRestricciones());
        restricciones.addAll(restriccionGen15.getRestricciones());
        restricciones.addAll(restriccionGen16.getRestricciones());
        restricciones.addAll(restriccionGen17.getRestricciones());
        restricciones.addAll(restriccionGen18.getRestricciones());
        restricciones.addAll(restriccionGen19.getRestricciones());
        
        System.out.println("fecha fin: " + fin);
        System.out.println(tt1s.size());
        
        Genetico.nel = Genetico.aptitudGneral(poblacion, restricciones);
        System.out.println("Poblacion Inicial con aptitud de " + Genetico.aptitudPoblacion + " y no se puede? D= " + Genetico.nel + " y son: " + poblacion.size());
        
        //FuncionAptitud funcion = new FuncionAptitud(restricciones);
        //List<Integer> aptitudes = new ArrayList<>();

//        for(int i = 0; i < 100; i++)
//        {
//            poblacion = Genetico.generaNuevaGen(poblacion,restricciones);
//            if(Genetico.aptitudPoblacion > mayor)mayor = Genetico.aptitudPoblacion;
//            System.out.println(Genetico.aptitudPoblacion + " y esta ha sido la mayor aptitud: " + mayor + " y no se puede? D= " + Genetico.nel);
//            Genetico.aptitudPoblacion = 0;
//        }
        int j = 0;
        while(Genetico.nel)
        {
            System.out.print("\niteracion " + j + "\t");
            //el uno es de que son tt1
            poblacion = Genetico.generaNuevaGen(poblacion,restricciones,1);
            if(Genetico.aptitudPoblacion > mayor)mayor = Genetico.aptitudPoblacion;
            System.out.println(Genetico.aptitudPoblacion + " y esta ha sido la mayor aptitud: " + mayor + " y no se puede? D= " + Genetico.nel + " y son: " + poblacion.size());
            j++;
            //System.out.println("");
        }
        System.out.println("esta resulto siendo la ultima aptitud " + Genetico.aptitudPoblacion);
        
        cal = Genetico.crearCalendario(poblacion,1);
        
        for(int i = 0; i < cal.size(); i++)
        {
            System.out.println("TT: " + cal.get(i).getTt().getIdTt()+ " Fecha: " + cal.get(i).getFecha() + " en la sala: " + cal.get(i).getSala().getIdSala());
        }
        
        //a partir de aqui empiezan los tt2
        Genetico.busqueda = false;
        mayor = 0;
        System.out.println("\nahora vienen los tt2\n");
        
        Set<Tt> tt2s = new HashSet(TTBs.findAllTT2());
        List<Cromosoma> poblaciontt2;
        System.out.println("fecha fin: " + fin);
        poblaciontt2 = Genetico.crearPoblacionTT2(inicio, fin, tt2s, SalaBs.findAll().size());
        
        List<Calendario> caltt2 = Genetico.crearCalendario(poblaciontt2,1);
        
        for(int i = 0; i < caltt2.size(); i++)
        {
            System.out.println("TT: " + caltt2.get(i).getTt().getIdTt()+ " Fecha: " + caltt2.get(i).getFecha() + " en la sala: " + caltt2.get(i).getSala().getIdSala());
        }
        
        
        
        
        
        j = 0;
        Genetico.nel = true;
        while(Genetico.nel)
        {
            System.out.print("\niteracion " + j + "\t");
            //el uno es de que son tt1
            poblaciontt2 = Genetico.generaNuevaGen(poblaciontt2,restricciones,2);
            if(Genetico.aptitudPoblacion > mayor)mayor = Genetico.aptitudPoblacion;
            System.out.println(Genetico.aptitudPoblacion + " y esta ha sido la mayor aptitud: " + mayor + " y no se puede? D= " + Genetico.nel + " y son: " + poblaciontt2.size());
            j++;
            //System.out.println("");
        }
        System.out.println("esta resulto siendo la ultima aptitud " + Genetico.aptitudPoblacion);
        
        caltt2 = Genetico.crearCalendario(poblaciontt2,1);
        
        for(int i = 0; i < caltt2.size(); i++)
        {
            System.out.println("TT: " + caltt2.get(i).getTt().getIdTt()+ " Fecha: " + caltt2.get(i).getFecha() + " en la sala: " + caltt2.get(i).getSala().getIdSala());
        }
        
        
        
        
        
        
        
        poblacion.addAll(poblaciontt2);
////        
        List<Calendario> calDefinitivo = CalendarioBs.findAll();
        for(int i = 0; i < calDefinitivo.size(); i++) CalendarioBs.delete(calDefinitivo.get(i));
        calDefinitivo = Genetico.crearCalendario(poblacion, 1);
        for(int i = 0; i < calDefinitivo.size(); i++)CalendarioBs.save(calDefinitivo.get(i));
        LeerExcel.inportaExcel(calDefinitivo, 2);//u7u7uioki0,
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        PDF pdfCalendario = new PDF();
        pdfCalendario.createPDF(new File("../Calendario.pdf"),Genetico.noHabil);
        
//        Email mail = new Email();
//        //mail.enviar("hazzy76@hotmail.com");
//        List<String> destinos = new ArrayList<>();
//        destinos.add("hazzy76@hotmail.com");
//        destinos.add("robonline7@gmail.com");
//        mail.enviar(destinos);
        CalendarioBs.close();
        tfin = System.currentTimeMillis();
        tiempo = tfin - tinicio;
        System.out.println("Ya terminó !!!!! en " + tiempo/1000);
    }    
}