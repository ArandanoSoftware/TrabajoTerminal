/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.modulo;

import com.myapp.model.Calendario;
import com.myapp.model.Horario;
import com.myapp.model.Profesor;
import com.myapp.model.Sala;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
        public static List<Profesor> extraerExcelSamara(FileInputStream file)throws IOException
    {
        	HSSFWorkbook workbook = new HSSFWorkbook(file);
        HSSFSheet sheet = workbook.getSheetAt(2);
        Iterator<Row> filas = sheet.iterator();
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
            try{h.setLun(row.getCell(4).getStringCellValue());}catch(Exception e){h.setLun("-");ultimo++;}
            try{h.setMar(row.getCell(5).getStringCellValue());}catch(Exception e){h.setMar("-");ultimo++;}
            try{h.setMie(row.getCell(6).getStringCellValue());}catch(Exception e){h.setMie("-");ultimo++;}
            try{h.setJue(row.getCell(7).getStringCellValue());}catch(Exception e){h.setJue("-");ultimo++;}
            try{h.setVie(row.getCell(8).getStringCellValue());}catch(Exception e){h.setVie("-");ultimo++;}
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
    
    public static List<Profesor> extraeExcelJuanita(FileInputStream file) throws IOException
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
    
        public static List<Sala> extraeExcelSala(FileInputStream file) throws IOException
    {
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        HSSFSheet sheet = workbook.getSheetAt(3);
        Iterator<Row> filas = sheet.iterator();
        filas.next();
        List<Sala> salas = new ArrayList<>();
        
        while (filas.hasNext())
        {
            Sala s = new Sala();
            s.setNombre(filas.next().getCell(0).toString());
            salas.add(s);
        }
        workbook.close();
        return salas;
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
    
    
    public static void inportaExcel(List<Calendario> calendario, int num) throws FileNotFoundException, IOException
    {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, "Calendario" + num);
        
        String[] headers = {"IdTT", "Nombre tt", "hora", "dia", "mes", "Sala"};
        
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
            HSSFCell celda0 = fila.createCell(0);
            celda0.setCellValue(calendario.get(i).getTt().getIdTt());
            HSSFCell celda1 = fila.createCell(1);
            celda1.setCellValue(calendario.get(i).getTt().getNombre());
            HSSFCell celda2 = fila.createCell(2);
            celda2.setCellValue(calendario.get(i).getFecha().getHours());
            HSSFCell celda3 = fila.createCell(3);
            celda3.setCellValue(calendario.get(i).getFecha().getDate());
            HSSFCell celda4 = fila.createCell(4);
            celda4.setCellValue(calendario.get(i).getFecha().getMonth());
            HSSFCell celda5 = fila.createCell(5);
            celda5.setCellValue(calendario.get(i).getSala().getIdSala());
        }
        

        try
        {
            System.out.println("vamos si lo haces?");
            FileOutputStream file = new FileOutputStream("../calendar2.xls");
            workbook.write(file);
            file.close();
        }catch(IOException e){}
    }
}
