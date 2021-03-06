package com.myapp.modulo;
 
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.myapp.bs.CalendarioBs;
import com.myapp.bs.DirigeBs;
import com.myapp.bs.NohabilBs;
import com.myapp.bs.SinodaliaBs;
import com.myapp.model.Calendario;
import com.myapp.model.Dirige;
import com.myapp.model.Nohabil;
import com.myapp.model.Profesor;
import com.myapp.model.Sinodalia;
import java.awt.Color;
import java.io.*; 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
 
/**

 *
 * @hazzy76
 */
public class PDF {
    // Fonts definitions (Definición de fuentes).
    private static final Font NORMALFONT = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL, new BaseColor(15,36,62));
    private static final Font NORMALBOLDFONT = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD, new BaseColor(15,36,62));
    private static final Font NORMALUNDERLINEDBOLDFONT = new Font(Font.FontFamily.HELVETICA, 8, Font.UNDERLINE|Font.BOLD, new BaseColor(15,36,62));
    private static final Font FECHATITLE = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.WHITE);
    private static final Font REDFONT = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD,  new BaseColor(192, 0, 0));
    private static final Font LITTLE = new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL);
    private static final Font TABLETITLES = new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.WHITE);
    private static final Font TITLE1 = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, new BaseColor(0, 32, 96));
    private static final Font TITLE2 = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, new BaseColor(0, 32, 96));
    private static final Font TITLE3 = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD, new BaseColor(0, 32, 96));
    private static final Font TITLE4 = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD, new BaseColor(0, 32, 96));
    private static final Font TITLE5 = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);
    private static final Font TITLE6 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, new BaseColor(0, 32, 96));
     
    private static final String iTextExampleImage = "/home/hazzy76/Imágenes/ipn.png";
    private static final String IPNIMAGE = "../ipn.png";
    private static final String ESCOMIMAGE = "../escom.png";
    
    public PDF()
    {
    }
    
    /**

     * Creamos un documento PDF
     * @param pdfNewFile
     * @param opcion
     */
    public void createPDF(File pdfNewFile, int opcion) {
         List<Nohabil> festivos = NohabilBs.findAll();
        // We create the document and set the file name.        
        try {
            Document document = new Document(PageSize.A4.rotate());
            try {
 
                PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));
 
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No se encontró el fichero para generar el pdf " + fileNotFoundException);
            }
            document.open();
            // Añadimos los metadatos del PDF
            document.addTitle("Calendario de Presentaciones de Trabajos Terminales");
            document.addSubject("Calendarización");
            document.addKeywords("Trabajo Terminal, Fecha, Presentación");
            document.addAuthor("CATT");
            document.addCreator("CATT");
            
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            List<Calendario> cal = CalendarioBs.findByOption(opcion);
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            cal = orderCal(cal);
            
            List<Sinodalia> sinodales = SinodaliaBs.findAll();
            List<Dirige> directores = DirigeBs.findAll();
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Date inicio = new Date();
            inicio.setDate(2);
            inicio.setMonth(4);
            Date fin = new Date();
            fin.setDate(6);
            fin.setMonth(6);
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Date acuse;
            boolean banderaInstrucciones = true;
            

            // Ahora llenamos la tabla del PDF
            PdfPCell columnHeader;
            PdfPTable titulos = new PdfPTable(3);
            titulos.setWidthPercentage(100);
            float[] medidas2 = {2,10,2};
            titulos.setWidths(medidas2);

                        // Añadimos una imagen
            Image image;
            try {
                image = Image.getInstance(IPNIMAGE);
                image.scaleAbsolute(36, 49);
                columnHeader = new PdfPCell(image);
                columnHeader.setBorder(0);
                columnHeader.setRowspan(2);
                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                columnHeader.setVerticalAlignment(Element.ALIGN_CENTER);
                titulos.addCell(columnHeader);

                columnHeader = new PdfPCell(new Paragraph("INSTITUTO POLITÉCNICO NACIONAL", TITLE1));
                columnHeader.setBorder(0);
                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                titulos.addCell(columnHeader);


                image = Image.getInstance(ESCOMIMAGE);
                image.scaleAbsolute(64, 49);
                columnHeader = new PdfPCell(image);
                columnHeader.setBorder(0);
                columnHeader.setRowspan(2);
                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                columnHeader.setVerticalAlignment(Element.ALIGN_CENTER);
                titulos.addCell(columnHeader);
            }catch (BadElementException ex) {System.out.println("Image BadElementException" +  ex);}
            catch (IOException ex) {System.out.println("Image IOException " +  ex);}

            columnHeader = new PdfPCell(new Paragraph("ESCUELA SUPERIOR DE CÓMPUTO", TITLE2));
            columnHeader.setBorder(0);
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            titulos.addCell(columnHeader);

            columnHeader = new PdfPCell(new Paragraph("SUBDIRECCIÓN ACADÉMICA", TITLE3));
            columnHeader.setBorder(0);
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            columnHeader.setColspan(3);
            columnHeader.setBackgroundColor(new BaseColor(193, 193, 255));
            titulos.addCell(columnHeader);

            columnHeader = new PdfPCell(new Paragraph("DEPARTAMENTO DE FORMACIÓN INTEGRAL E INSTITUCIONAL", TITLE4));
            columnHeader.setBorder(0);
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            columnHeader.setColspan(3);
            titulos.addCell(columnHeader);

            columnHeader = new PdfPCell(new Paragraph("COMISIÓN ACADÉMICA DE TRABAJOS TERMINALES", TITLE5));
            columnHeader.setBorder(0);
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            columnHeader.setColspan(3);
            columnHeader.setBackgroundColor(new BaseColor(0, 0, 99));
            titulos.addCell(columnHeader);

            columnHeader = new PdfPCell(new Paragraph("CALENDARIO DE PRESENTACION TTI,TTII y TTR CICLO 2016-2017/2", TITLE6));
            columnHeader.setBorder(0);
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            columnHeader.setColspan(3);
            titulos.addCell(columnHeader);


            PdfPTable tablaInstrucciones = new PdfPTable(1);
            tablaInstrucciones.setWidthPercentage(100);

            PdfPCell zelda = new PdfPCell(new Phrase(" ",LITTLE));
            zelda.setBackgroundColor(new BaseColor(220,230,241));
            zelda.setBorder(0);
            tablaInstrucciones.addCell(zelda);

            Paragraph instrucciones = new Paragraph();
            instrucciones.add(new Phrase("PARA PRESENTAR EVALUACIÓN DE TRABAJO TERMINAL DEBES:\n\n", NORMALBOLDFONT));
            instrucciones.add(new Phrase("1. ", NORMALFONT));
            instrucciones.add(new Phrase("REVISAR Y CUMPLIR LOS REQUISITOS PARA PRESENTAR EVALUACIÓN DE TT-I, TT-II O TT-R", NORMALUNDERLINEDBOLDFONT));
            instrucciones.add(new Phrase(", según corresponda (www.escom.ipn.mx/titulacion/catt.php)\n", NORMALFONT));
            instrucciones.add(new Phrase("2. ", NORMALFONT));
            instrucciones.add(new Phrase("UN DÍA ANTES DE LA PRESENTACIÓN, CONFIRMAR CON SU JURADO EVALUADOR ", NORMALBOLDFONT));
            instrucciones.add(new Phrase("(Directores y Sinodales), ", NORMALFONT));
            instrucciones.add(new Phrase("LA HORA Y EL LUGAR DE EVALUACIÓN.\n", NORMALBOLDFONT));
            instrucciones.add(new Phrase("      Si se requiere alguna modificación en el horario, se tendrá que contar con la autorización de TODO EL JURADO EVALUADOR Y DEBERÁN NOTIFICAR POR ESCRITO A LA CATT, como MÁXIMO tres días antes de la presentación.\n", NORMALFONT));
            instrucciones.add(new Phrase("      EL DÍA DE LA PRESENTACIÓN.\n", NORMALBOLDFONT));
            instrucciones.add(new Phrase("      Acudir a la CATT 30 min. antes de su evaluación para:\n            1. Revisar el acta de evaluación y verificar los datos del TT (Nombres de integrantes, Título, etc.)\n            2. Solicitar Mantel, Proyector electrónico, multicontacto, extensión y controles remotos (según se requiera) con identificación OFICIAL VIGENTE.\n\n", NORMALFONT));
            instrucciones.add(new Phrase("      Acudir a la CATT 30 min. antes de su evaluación para:\n", NORMALFONT));
            instrucciones.add(new Phrase("      AL CONCLUIR LA PRESENTACIÓN.\n", NORMALBOLDFONT));
            instrucciones.add(new Phrase("            1. Entregar el Material en las mismas condiciones en las que les fue prestado; el mantel debe estar limpio y doblado (evitar colocar alimentos y/o ingerirlos sobre él)", NORMALFONT));
            zelda = new PdfPCell(instrucciones);
            zelda.setBorder(0);
            tablaInstrucciones.addCell(zelda);

            zelda = new PdfPCell(new Phrase(" ",LITTLE));
            zelda.setBorder(0);
            zelda.setBackgroundColor(new BaseColor(220,230,241));
            tablaInstrucciones.addCell(zelda);
            
            
            while(inicio.getTime() <= fin.getTime())
            {
                
                if(inicio.getDay() == 0 || inicio.getDay()== 6){inicio.setDate(inicio.getDate() + 1);continue;}
                
                boolean esta = false;
                
                Integer numColumns = 9;
                Integer numRows = cal.size();
                // Creamos la tabla.
                PdfPTable table = new PdfPTable(numColumns);
                table.setWidthPercentage(100);
                float[] medidas = {1.25f ,2f ,1.5f ,8 ,2.25f ,2.25f ,2.25f ,2.25f ,2.25f};
                table.setWidths(medidas);
                // rellenamos las filas de la tabla. 
                acuse = diaAcuse(inicio, festivos);
                Paragraph parrafito = new Paragraph();
                parrafito.add(new Phrase(getDiaSem(inicio) + " " + inicio.getDate() + " de " + getMes(inicio) + " " + (inicio.getYear() + 1900), FECHATITLE));
                parrafito.add(new Phrase("\nRECEPCIÓN DEN LA C.A.T.T. " + getDiaSem(acuse) + " " + acuse.getDate() + " de " + getMes(acuse) + " " + (acuse.getYear() + 1900), REDFONT));
                columnHeader = new PdfPCell(parrafito);
                columnHeader.setColspan(9);
                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                columnHeader.setBackgroundColor(new BaseColor(79, 129, 189));
                table.addCell(columnHeader);
                
                
                columnHeader = new PdfPCell(new Phrase("HORA", TABLETITLES));
                columnHeader.setBackgroundColor(new BaseColor(0, 32, 96));
                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(columnHeader);  

                columnHeader = new PdfPCell(new Phrase("LUGAR", TABLETITLES));
                columnHeader.setBackgroundColor(new BaseColor(0, 32, 96));
                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(columnHeader);  

                columnHeader = new PdfPCell(new Phrase("TT", TABLETITLES));
                columnHeader.setBackgroundColor(new BaseColor(0, 32, 96));
                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(columnHeader);  

                columnHeader = new PdfPCell(new Phrase("TÍTULO", TABLETITLES));
                columnHeader.setBackgroundColor(new BaseColor(0, 32, 96));
                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(columnHeader);  

                columnHeader = new PdfPCell(new Phrase("DIRECTOR 1", TABLETITLES));
                columnHeader.setBackgroundColor(new BaseColor(0, 32, 96));
                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(columnHeader);  

                columnHeader = new PdfPCell(new Phrase("DIRECTOR 2", TABLETITLES));
                columnHeader.setBackgroundColor(new BaseColor(0, 32, 96));
                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(columnHeader);  

                columnHeader = new PdfPCell(new Phrase("SINODALÍA", TABLETITLES));
                columnHeader.setBackgroundColor(new BaseColor(0, 32, 96));
                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                columnHeader.setColspan(3);
                table.addCell(columnHeader);
                for (int i = 0; i < numRows; i++)
                {
                    if(cal.get(i).getFecha().getDate() == inicio.getDate() && cal.get(i).getFecha().getMonth() == inicio.getMonth())
                    {
                        columnHeader = new PdfPCell(new Paragraph(cal.get(i).getFecha().getHours() + ":00", LITTLE));
                        columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(columnHeader);
                        
                        columnHeader = new PdfPCell(new Paragraph(cal.get(i).getSala().getNombre(), LITTLE));
                        columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(columnHeader);
                        
                        columnHeader = new PdfPCell(new Paragraph(cal.get(i).getTt().getIdTt(), LITTLE));
                        columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(columnHeader);
                        
                        columnHeader = new PdfPCell(new Paragraph(cal.get(i).getTt().getNombre(), LITTLE));
                        columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(columnHeader);
                        
                        List<Profesor> profTT = getDirectores(cal.get(i).getTt().getIdTt(), directores);
                        columnHeader = new PdfPCell(new Paragraph(profTT.get(0).getApaterno()+ " " + profTT.get(0).getAmaterno()+ " " + profTT.get(0).getNombre(), LITTLE));
                        columnHeader.setBackgroundColor(new BaseColor(197, 217, 241));
                        columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(columnHeader);
                        
                        try
                        {
                            columnHeader = new PdfPCell(new Paragraph(profTT.get(1).getApaterno()+ " " + profTT.get(1).getAmaterno()+ " " + profTT.get(1).getNombre(), LITTLE));
                            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                            columnHeader.setBackgroundColor(new BaseColor(197, 217, 241));
                            table.addCell(columnHeader);
                        }catch(Exception e)
                        {
                            columnHeader = new PdfPCell(new Paragraph(" "));
                            columnHeader.setBackgroundColor(new BaseColor(197, 217, 241));
                            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table.addCell(columnHeader);
                        }
                        
                        profTT = getSinodales(cal.get(i).getTt().getIdTt(), sinodales);
                        columnHeader = new PdfPCell(new Paragraph(profTT.get(0).getApaterno()+ "  " + profTT.get(0).getAmaterno()+ " " + profTT.get(0).getNombre(), LITTLE));
                        columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(columnHeader);
                        
                        columnHeader = new PdfPCell(new Paragraph(profTT.get(1).getApaterno()+ "  " + profTT.get(1).getAmaterno()+ " " + profTT.get(1).getNombre(), LITTLE));
                        columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(columnHeader);
                        
                        try
                        {
                            columnHeader = new PdfPCell(new Paragraph(profTT.get(2).getApaterno()+ "  " + profTT.get(2).getAmaterno()+ " " + profTT.get(2).getNombre(), LITTLE));
                            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table.addCell(columnHeader);
                        }catch(Exception e)
                        {
                            columnHeader = new PdfPCell(new Paragraph(" "));
                            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table.addCell(columnHeader);
                        }
                        esta = true;
                    }

                }
                if(!esta)
                {
                    inicio.setDate(inicio.getDate() + 1);
                    continue;
                }
                
            
                
                inicio.setDate(inicio.getDate() + 1);
                // We add the table (Añadimos la tabla)
                
                document.add(titulos);
                if(banderaInstrucciones){ document.add(tablaInstrucciones); banderaInstrucciones = false;}
                else document.add(new Paragraph("\n"));
                document.add(table);
                document.newPage();
            }
            // We add the paragraph with the table (Añadimos el elemento con la tabla).
            
            document.close();
            System.out.println("Your PDF file has been generated!(¡Se ha generado tu hoja PDF!");
        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
        }
    }
    /**
     * @param tt
     * @param sinodales
     * @return 
     */
//    public static void main(String args[]) {
//        PDF generatePDFFileIText = new PDF();
//        generatePDFFileIText.createPDF(new File("../Calendario.pdf"));
//    }
    
    protected List<Profesor> getSinodales(String tt, List<Sinodalia> sinodales)
    {
        List<Profesor> sinodals = new ArrayList<>();
        for(int i = 0; i < sinodales.size(); i++)
        {
            if(sinodales.get(i).getIdTt().equals(tt))
            {
                sinodals.add(sinodales.get(i).getProfesorByS1());
                sinodals.add(sinodales.get(i).getProfesorByS2());
                sinodals.add(sinodales.get(i).getProfesorByS3());
                break;
            }
        }
        return sinodals;
    }    
    
    protected List<Profesor> getDirectores(String tt, List<Dirige> directores)
    {
        List<Profesor> diriges = new ArrayList<>();
        for(int i = 0; i < directores.size(); i++)
        {
            if(directores.get(i).getIdTt().equals(tt))
            {
                diriges.add(directores.get(i).getProfesorByD1());
                diriges.add(directores.get(i).getProfesorByD2());
                break;
            }
        }
        return diriges;
    }
    
    protected String getDiaSem(Date fecha)
    {
        if(fecha.getDay() == 1) return "LUNES";
        if(fecha.getDay() == 2) return "MARTES";
        if(fecha.getDay() == 3) return "MIÉRCOLES";
        if(fecha.getDay() == 4) return "JUEVES";
        if(fecha.getDay() == 5) return "VIERNES";
        return "fin de semana que no debería de estar aquí";
    }
    
    protected String getMes(Date fecha)
    {
        if(fecha.getMonth()== 0) return "ENERO";
        if(fecha.getMonth()== 1) return "FEBRERO";
        if(fecha.getMonth()== 2) return "MARZO";
        if(fecha.getMonth()== 3) return "ABRIL";
        if(fecha.getMonth()== 4) return "MAYO";
        if(fecha.getMonth()== 5) return "JUNIO";
        if(fecha.getMonth()== 6) return "JULIO";
        if(fecha.getMonth()== 7) return "AGOSTO";
        if(fecha.getMonth()== 8) return "SEPTIEMBRE";
        if(fecha.getMonth()== 9) return "OCTUBRE";
        if(fecha.getMonth()== 10) return "NOVIEMBRE";
        if(fecha.getMonth()== 11) return "DICIEMBRE";
        return "fin de semana que no debería de estar aquí";
    }
    
    protected List<Calendario> orderCal(List<Calendario> cal)
    {
        List<Calendario> diez = new ArrayList<>();
        List<Calendario> doce = new ArrayList<>();
        List<Calendario> dos = new ArrayList<>();
        List<Calendario> cuatro = new ArrayList<>();
        
        for(int i = 0; i < cal.size(); i++)
        {
            if(cal.get(i).getFecha().getHours() == 10) diez.add(cal.get(i));
            if(cal.get(i).getFecha().getHours() == 12) doce.add(cal.get(i));
            if(cal.get(i).getFecha().getHours() == 14) dos.add(cal.get(i));
            if(cal.get(i).getFecha().getHours() == 16) cuatro.add(cal.get(i));
        }
        diez.addAll(doce);
        diez.addAll(dos);
        diez.addAll(cuatro);
        return diez;
    }
    
    protected Date diaAcuse(Date fecha, List<Nohabil> res)
    {
        Date acuse = new Date();
        acuse.setDate(fecha.getDate());
        acuse.setMonth(fecha.getMonth());
        for(int i = 0; i < 5;)
        {
            acuse.setDate(acuse.getDate() - 1);
            if(acuse.getDay() != 0 && acuse.getDay() != 6 && !contieneFecha(acuse, res))
                i++;
        }
        return acuse;
    }
    
    protected boolean contieneFecha(Date fecha1, List<Nohabil> fecha2)
    {
        for(int i = 0; i < fecha2.size(); i++)
        {
            if(fecha1.getDate() == fecha2.get(i).getFecha().getDate() && fecha1.getMonth() == fecha2.get(i).getFecha().getMonth())
                return true;
        }
        return false;
    }
}