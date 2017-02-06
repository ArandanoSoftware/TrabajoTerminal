/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author hazzy76
 */
public class LeerExcel {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int a = 132, b = 133;
        FileInputStream file = new FileInputStream(new File("../Estructura 2017 1.xls"));
        List<Profesor> profesores = ExtraeExcel(file);
        for(int j = 0;j<profesores.size();j++)
        {
            profesores.get(j).setIdProfesor(j+1);
            System.out.println("id: " + profesores.get(j).getIdProfesor() + ": " + profesores.get(j).getaPaterno() + ", "+ profesores.get(j).getaMaterno() + ", " + profesores.get(j).getNombre());
            List<Horario> horarios = Arrays.asList(profesores.get(j).getHorario().toArray(new Horario[0]));
            for(int i = 0; i < horarios.size(); i++)
            {
                Horario hor = horarios.get(i);
                System.out.println("\tHorario: " + hor.getLun() + " " + hor.getMar() + " " + hor.getMie() + " " + hor.getJue() + " " + hor.getVie() );
            }
        }
        
        boolean[] pbin = new boolean[20];
//        Profesor p = new Profesor();
        pbin = profebin(profesores.get(a), pbin);
        pbin = lunbin(profesores.get(a),pbin);
        boolean[] pai = new boolean[20];
        pai = profebin(profesores.get(b), pai);
        pai = lunbin(profesores.get(b), pai);
        
        boolean[] c = disponibilidad(pbin, pai);
        
        System.out.println("disponibilidad: " + c[0] + " " + c[1] + " " + c[2] + " " + c[3] + " " + c[4] + " " + c[5] + " " + c[6] + " " + c[7] + " " + c[8] + " ");
        
        System.out.println("son: " + profesores.size() + " Profesores");
        System.out.println("id: " + pbin[0] + " " + pbin[1] + " " + pbin[2] + " " + pbin[3] + " " + pbin[4] + " " + pbin[5] + " " + pbin[6] + " " + pbin[7]);
        System.out.println("Día: " + pbin[8] + " " + pbin[9] + " " + pbin[10]);
        System.out.println("Lunes: " + pbin[11] + " " + pbin[12] + " " + pbin[13] + " " + pbin[14] + " " + pbin[15] + " " + pbin[16] + " " + pbin[17] + " " + pbin[18] + " " + pbin[19]);
        pbin = marbin(profesores.get(a),pbin);
        System.out.println("Martes: " + pbin[11] + " " + pbin[12] + " " + pbin[13] + " " + pbin[14] + " " + pbin[15] + " " + pbin[16] + " " + pbin[17] + " " + pbin[18] + " " + pbin[19]);
        pbin = miebin(profesores.get(a),pbin);
        System.out.println("Miercoles: " + pbin[11] + " " + pbin[12] + " " + pbin[13] + " " + pbin[14] + " " + pbin[15] + " " + pbin[16] + " " + pbin[17] + " " + pbin[18] + " " + pbin[19]);
        pbin = juebin(profesores.get(a),pbin);
        System.out.println("Jueves: " + pbin[11] + " " + pbin[12] + " " + pbin[13] + " " + pbin[14] + " " + pbin[15] + " " + pbin[16] + " " + pbin[17] + " " + pbin[18] + " " + pbin[19]);
        pbin = viebin(profesores.get(a),pbin);
        System.out.println("Viernes: " + pbin[11] + " " + pbin[12] + " " + pbin[13] + " " + pbin[14] + " " + pbin[15] + " " + pbin[16] + " " + pbin[17] + " " + pbin[18] + " " + pbin[19]);
        
//System.out.println(Inrteger.parseInt(a) + b + " ");

    }
    /**
     *
     * @param file
     * @return
     * @throws java.io.IOException
     */
    public static List<Profesor> ExtraeExcel(FileInputStream file) throws IOException
    {
        // Crear el objeto que tendra el libro de Excel
	HSSFWorkbook workbook = new HSSFWorkbook(file);
        HSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> filas = sheet.iterator();
        filas.next();
        filas.next();
        filas.next();
        filas.next();
        Row row;
        List<Profesor> profes = new ArrayList<>();
        String compara = "no es igual xD";
        Profesor p = new Profesor();
        while (filas.hasNext()){
	    row = filas.next();
	    //Obtenemos el iterator que permite recorres todas las celdas de una fil
            Horario h = new Horario();
            int ultimo = 0;
            try{h.setLun(row.getCell(13).getStringCellValue());}catch(Exception e){h.setLun("-");ultimo++;}
            try{h.setMar(row.getCell(16).getStringCellValue());}catch(Exception e){h.setMar("-");ultimo++;}
            try{h.setMie(row.getCell(20).getStringCellValue());}catch(Exception e){h.setMie("-");ultimo++;}
            try{h.setJue(row.getCell(23).getStringCellValue());}catch(Exception e){h.setJue("-");ultimo++;}
            try{h.setVie(row.getCell(27).getStringCellValue());}catch(Exception e){h.setVie("-");ultimo++;}
            if(ultimo == 5)break;
            try
            {
                Cell celda = row.getCell(0);
                if(!celda.getStringCellValue().equals(compara))
                {
                    compara = celda.getStringCellValue();
                    if(!celda.getStringCellValue().contains("("))
                    {
                    p = new Profesor();
                    if(compara.equals("SIN ASIGNAR"))continue;
                    p = añadeNombre(compara);
                    profes.add(p);
                    }
                }
            }catch(Exception e){}
                p.getHorario().add(h);
	}
        // cerramos el libro excel
	workbook.close();
        return profes;
    }
    
    public static Profesor añadeNombre(String nom)
    {   
        Profesor p = new Profesor();
        if(nom.contains("De la O"))
        {
            p.setNombre("Saúl");
            p.setaPaterno("De la O");
            p.setaMaterno("Torres");
            return p;
        }
        nom = nom.replaceAll(" +"," ");
        String[] separado = nom.split(" ");
        if(separado.length ==  2)
        {
            p.setaPaterno(separado[0]);
            p.setNombre(separado[1]);
            return p;
        }
        int j = 0;
        for(int i = 0; i<separado.length; i++)
        {
            if(separado[i].length() < 4 && j == 0)
            {
                p.setaPaterno(p.getaPaterno() + separado[i] + " ");
                continue;
            }else if(j == 0)
            {
                p.setaPaterno(p.getaPaterno() + separado[i]);
                j++;
                continue;
            }
            if(separado[i].length() < 4 && j == 1)
            {
                p.setaMaterno(p.getaMaterno() + separado[i] + " ");
                continue;
            }else if( j == 1 )
            {
                p.setaMaterno(p.getaMaterno() + separado[i]);
                j++;
                continue;
            }
            if(j == 2)
            {
                p.setNombre(p.getNombre() + separado[i] + " ");
            }
        }
        p.setNombre(p.getNombre().substring(0, p.getNombre().length()-1));
        return p;
    }
    public static boolean[] profebin(Profesor p,boolean[] profb)
    {
        int id = p.getIdProfesor();
        if(id >= 128){id -= 128;profb[0] = true;}else profb[0] = false;
        if(id >= 64){id -= 64;profb[1] = true;}else profb[1] = false;
        if(id >= 32){id -= 32;profb[2] = true;}else profb[2] = false;
        if(id >= 16){id -= 16;profb[3] = true;}else profb[3] = false;
        if(id >= 8){id -= 8;profb[4] = true;}else profb[4] = false;
        if(id >= 4){id -= 4;profb[5] = true;}else profb[5] = false;
        if(id >= 2){id -= 2;profb[6] = true;}else profb[6] = false;
        if(id >= 1){id -= 1;profb[7] = true;}else profb[7] = false;
        return profb;
    }
    
    public static boolean[] lunbin(Profesor p, boolean[] bin)
    {
        bin[8] = false; bin[9] = false; bin[10] = true;
        bin[11]=bin[12]=bin[13]=bin[14]=bin[15]=bin[16]=bin[17]=bin[18]=bin[19]=false;
        List<Horario> h = Arrays.asList(p.getHorario().toArray(new Horario[0]));
        for(int i = 0; i < h.size(); i++)
        {
            if(h.get(i).getLun().contains("7:00-"))bin[11] = true;
            if(h.get(i).getLun().contains("8:30-"))bin[12] = true;
            if(h.get(i).getLun().contains("10:30-"))bin[13] = true;
            if(h.get(i).getLun().contains("12:00-"))bin[14] = true;
            if(h.get(i).getLun().contains("13:30-"))bin[15] = true;
            if(h.get(i).getLun().contains("15:00-"))bin[16] = true;
            if(h.get(i).getLun().contains("16:30-"))bin[17] = true;
            if(h.get(i).getLun().contains("18:30-"))bin[18] = true;
            if(h.get(i).getLun().contains("20:00-"))bin[19] = true;
        }
        return bin;
    }
    
    public static boolean[] marbin(Profesor p, boolean[] bin)
    {
        bin[8] = false; bin[9] = true; bin[10] = false;
        bin[11]=bin[12]=bin[13]=bin[14]=bin[15]=bin[16]=bin[17]=bin[18]=bin[19]=false;
        List<Horario> h = Arrays.asList(p.getHorario().toArray(new Horario[0]));
        for(int i = 0; i < h.size(); i++)
        {
            if(h.get(i).getMar().contains("7:00-"))bin[11] = true;
            if(h.get(i).getMar().contains("8:30-"))bin[12] = true;
            if(h.get(i).getMar().contains("10:30-"))bin[13] = true;
            if(h.get(i).getMar().contains("12:00-"))bin[14] = true;
            if(h.get(i).getMar().contains("13:30-"))bin[15] = true;
            if(h.get(i).getMar().contains("15:00-"))bin[16] = true;
            if(h.get(i).getMar().contains("16:30-"))bin[17] = true;
            if(h.get(i).getMar().contains("18:30-"))bin[18] = true;
            if(h.get(i).getMar().contains("20:00-"))bin[19] = true;
        }
        return bin;
    }
    
    public static boolean[] miebin(Profesor p, boolean[] bin)
    {
        bin[8] = false; bin[9] = true; bin[10] = true;
        bin[11]=bin[12]=bin[13]=bin[14]=bin[15]=bin[16]=bin[17]=bin[18]=bin[19]=false;
        List<Horario> h = Arrays.asList(p.getHorario().toArray(new Horario[0]));
        for(int i = 0; i < h.size(); i++)
        {
            if(h.get(i).getMie().contains("7:00-"))bin[11] = true;
            if(h.get(i).getMie().contains("8:30-"))bin[12] = true;
            if(h.get(i).getMie().contains("10:30-"))bin[13] = true;
            if(h.get(i).getMie().contains("12:00-"))bin[14] = true;
            if(h.get(i).getMie().contains("13:30-"))bin[15] = true;
            if(h.get(i).getMie().contains("15:00-"))bin[16] = true;
            if(h.get(i).getMie().contains("16:30-"))bin[17] = true;
            if(h.get(i).getMie().contains("18:30-"))bin[18] = true;
            if(h.get(i).getMie().contains("20:00-"))bin[19] = true;
        }
        return bin;
    }
    
    public static boolean[] juebin(Profesor p, boolean[] bin)
    {
        bin[8] = true; bin[9] = false; bin[10] = false;
        bin[11]=bin[12]=bin[13]=bin[14]=bin[15]=bin[16]=bin[17]=bin[18]=bin[19]=false;
        List<Horario> h = Arrays.asList(p.getHorario().toArray(new Horario[0]));
        for(int i = 0; i < h.size(); i++)
        {
            if(h.get(i).getJue().contains("7:00-"))bin[11] = true;
            if(h.get(i).getJue().contains("8:30-"))bin[12] = true;
            if(h.get(i).getJue().contains("10:30-"))bin[13] = true;
            if(h.get(i).getJue().contains("12:00-"))bin[14] = true;
            if(h.get(i).getJue().contains("13:30-"))bin[15] = true;
            if(h.get(i).getJue().contains("15:00-"))bin[16] = true;
            if(h.get(i).getJue().contains("16:30-"))bin[17] = true;
            if(h.get(i).getJue().contains("18:30-"))bin[18] = true;
            if(h.get(i).getJue().contains("20:00-"))bin[19] = true;
        }
        return bin;
    }
    
    public static boolean[] viebin(Profesor p, boolean[] bin)
    {
        bin[8] = true; bin[9] = false; bin[10] = true;
        bin[11]=bin[12]=bin[13]=bin[14]=bin[15]=bin[16]=bin[17]=bin[18]=bin[19]=false;
        List<Horario> h = Arrays.asList(p.getHorario().toArray(new Horario[0]));
        for(int i = 0; i < h.size(); i++)
        {
            if(h.get(i).getVie().contains("7:00-"))bin[11] = true;
            if(h.get(i).getVie().contains("8:30-1"))bin[12] = true;
            if(h.get(i).getVie().contains("10:30-"))bin[13] = true;
            if(h.get(i).getVie().contains("12:00-"))bin[14] = true;
            if(h.get(i).getVie().contains("13:30-"))bin[15] = true;
            if(h.get(i).getVie().contains("15:00-"))bin[16] = true;
            if(h.get(i).getVie().contains("16:30-"))bin[17] = true;
            if(h.get(i).getVie().contains("18:30-"))bin[18] = true;
            if(h.get(i).getVie().contains("20:00-"))bin[19] = true;
        }
        return bin;
    }
    
    public static boolean[] disponibilidad(boolean[] a, boolean[] b)
    {
        boolean[] c = new boolean[9];
        
        for(int i = 0; i < 9; i++)
        {
            c[i] = !(a[11+i] || b[i+11]);
        }
        
        return c;
    }
    
}
