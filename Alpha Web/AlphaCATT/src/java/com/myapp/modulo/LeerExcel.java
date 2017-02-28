/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.modulo;

import com.myapp.model.Calendario;
import com.myapp.model.Horario;
import com.myapp.model.Profesor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author hazzy76
 */
public class LeerExcel {
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
            h.setProfesor(p);
            p.getHorarios().add(h);
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
            p.setApaterno("De la O");
            p.setAmaterno("Torres");
            return p;
        }
        nom = nom.replaceAll(" +"," ");
        String[] separado = nom.split(" ");
        if(separado.length ==  2)
        {
            p.setApaterno(separado[0]);
            p.setNombre(separado[1]);
            return p;
        }
        int j = 0;
        for(int i = 0; i<separado.length; i++)
        {
            if(separado[i].length() < 4 && j == 0)
            {
                p.setApaterno(p.getApaterno() + separado[i] + " ");
                continue;
            }else if(j == 0)
            {
                p.setApaterno(p.getApaterno() + separado[i]);
                j++;
                continue;
            }
            if(separado[i].length() < 4 && j == 1)
            {
                p.setAmaterno(p.getAmaterno() + separado[i] + " ");
                continue;
            }else if( j == 1 )
            {
                p.setAmaterno(p.getAmaterno() + separado[i]);
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
        List<Horario> h = Arrays.asList(p.getHorarios().toArray(new Horario[0]));
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
        List<Horario> h = Arrays.asList(p.getHorarios().toArray(new Horario[0]));
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
        List<Horario> h = Arrays.asList(p.getHorarios().toArray(new Horario[0]));
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
        List<Horario> h = Arrays.asList(p.getHorarios().toArray(new Horario[0]));
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
        List<Horario> h = Arrays.asList(p.getHorarios().toArray(new Horario[0]));
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
    
    public static void inportaExcel(List<Calendario> calendario, int num) throws FileNotFoundException, IOException
    {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, "Calendario" + num);
        
        String[] headers = {"IdTT", "Nombre tt", "Presentacion", "Sala"};
        
        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        headerStyle.setFont(font);

        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);

        HSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; ++i) {
            String header = headers[i];
            HSSFCell cell = headerRow.createCell(i);
            cell.setCellStyle(headerStyle);
            cell.setCellValue(header);
        }
        
        for(int i = 0; i < calendario.size(); i++)
        {
            HSSFRow fila = sheet.createRow(i+1);
            HSSFCell celda = fila.createCell(0);
            celda.setCellValue(calendario.get(i).getIdTt());
            celda = fila.createCell(1);
            celda.setCellValue(calendario.get(i).getTt().getNombre());
            celda = fila.createCell(2);
            celda.setCellValue(calendario.get(i).getFecha());
            celda = fila.createCell(0);
            celda.setCellValue(calendario.get(i).getSala().getIdSala());
        }
        

        try
        {
            FileOutputStream file = new FileOutputStream("../calendar.xls");
            workbook.write(file);
            file.close();
        }catch(Exception e){}
    }
}
