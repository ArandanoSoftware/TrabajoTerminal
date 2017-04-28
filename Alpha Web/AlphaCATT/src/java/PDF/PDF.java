package PDF;
 
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
import com.myapp.bs.SinodaliaBs;
import com.myapp.model.Calendario;
import com.myapp.model.Dirige;
import com.myapp.model.Profesor;
import com.myapp.model.Sinodalia;
import java.io.*; 
import java.util.ArrayList;
import java.util.List;
 
/**

 *
 * @hazzy76
 */
public class PDF {
    // Fonts definitions (Definición de fuentes).
    private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
         
    private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);    
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
     
    private static final String iTextExampleImage = "/home/hazzy76/Imágenes/ipn.png";
    /**

     * Creamos un documento PDF
     * @param pdfNewFile
     */
    public void createPDF(File pdfNewFile) {
        // We create the document and set the file name.        
        // Creamos el documento e indicamos el nombre del fichero.
        try {
            Document document = new Document(PageSize.LETTER.rotate());
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
             
            // Primera página 
            Chunk chunk = new Chunk("CALENDARIO DE PRESENTACION TTI,TTII y TTR", chapterFont);
            chunk.setBackground(BaseColor.BLUE);
            // Creemos el primer capítulo
            Chapter chapter = new Chapter(new Paragraph(chunk), 1);
            chapter.setNumberDepth(0);
            chapter.add(new Paragraph("This is the paragraph", paragraphFont));
            // Añadimos una imagen
////            Image image;
////            try {
////                image = Image.getInstance(iTextExampleImage);  
////                image.setAbsolutePosition(2, 150);
////                chapter.add(image);
////            } catch (BadElementException ex) {
////                System.out.println("Image BadElementException" +  ex);
////            } catch (IOException ex) {
////                System.out.println("Image IOException " +  ex);
////            }
            document.add(chapter);
             
            // Second page - some elements
            // Segunda página - Algunos elementos
////////            Chapter chapSecond = new Chapter(new Paragraph(new Anchor("Some elements (Añadimos varios elementos)")), 1);
////////            Paragraph paragraphS = new Paragraph("Do it by Xules (Realizado por Xules)", subcategoryFont);
////////             
////////            // Underline a paragraph by iText (subrayando un párrafo por iText)
////////            Paragraph paragraphE = new Paragraph("This line will be underlined with a dotted line (Está línea será subrayada con una línea de puntos).");
////////            DottedLineSeparator dottedline = new DottedLineSeparator();
////////            dottedline.setOffset(-2);
////////            dottedline.setGap(2f);
////////            paragraphE.add(dottedline);
////////            chapSecond.addSection(paragraphE);
////////             
////////            Section paragraphMoreS = chapSecond.addSection(paragraphS);
////////            // List by iText (listas por iText)
////////            String text = "test 1 2 3 ";
////////            for (int i = 0; i < 5; i++) {
////////                text = text + text;
////////            }
////////            List list = new List(List.UNORDERED);
////////            ListItem item = new ListItem(text);
////////            item.setAlignment(Element.ALIGN_JUSTIFIED);
////////            list.add(item);
////////            text = "a b c align ";
////////            for (int i = 0; i < 5; i++) {
////////                text = text + text;
////////            }
////////            item = new ListItem(text);
////////            item.setAlignment(Element.ALIGN_JUSTIFIED);
////////            list.add(item);
////////            text = "supercalifragilisticexpialidocious ";
////////            for (int i = 0; i < 3; i++) {
////////                text = text + text;
////////            }
////////            item = new ListItem(text);
////////            item.setAlignment(Element.ALIGN_JUSTIFIED);
////////            list.add(item);
////////            paragraphMoreS.add(list);
////////            document.add(chapSecond);
             
            // How to use PdfPTable
            // Utilización de PdfPTable
             
            // Usamos varios elementos para añadir título y subtítulo
            
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            List<Calendario> cal = CalendarioBs.findAll();
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Anchor anchor = new Anchor("Tabla de presentaciones", categoryFont);
            anchor.setName("taba de tal fecha");            
            Chapter chapTitle = new Chapter(new Paragraph(anchor), 1);
            Paragraph paragraph = new Paragraph("creo que puedo borrar esto", subcategoryFont);
            Section paragraphMore = chapTitle.addSection(paragraph);
            paragraphMore.add(new Paragraph("Creo que tambien puedo borrar este otro xD"));
            Integer numColumns = 9;
            Integer numRows = cal.size();
            // Creamos la tabla.
            PdfPTable table = new PdfPTable(numColumns); 
            // Ahora llenamos la tabla del PDF
            PdfPCell columnHeader;
            // rellenamos las filas de la tabla.  
            
            columnHeader = new PdfPCell(new Phrase("HORA"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);  
            
            columnHeader = new PdfPCell(new Phrase("LUGAR"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);  
            
            columnHeader = new PdfPCell(new Phrase("TT"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);  
            
            columnHeader = new PdfPCell(new Phrase("TÍTULO"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);  
            
            columnHeader = new PdfPCell(new Phrase("DIRECTOR1"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);  
            
            columnHeader = new PdfPCell(new Phrase("DIRECTOR2"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);  
            
            columnHeader = new PdfPCell(new Phrase("SINODALIA1"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);  
            
            columnHeader = new PdfPCell(new Phrase("SINODALIA2"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);  
            
            columnHeader = new PdfPCell(new Phrase("SINODALIA3"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);
            
            
            table.setHeaderRows(0);
            //rellenamos las filas de la tabla.
            List<Sinodalia> sinodales = SinodaliaBs.findAll();
            List<Dirige> directores = DirigeBs.findAll();
            for (int i = 0; i < numRows; i++)
            {
                table.addCell(cal.get(i).getFecha().getHours() + ":00");
                table.addCell(cal.get(i).getSala().getNombre());
                table.addCell(cal.get(i).getTt().getNombre());
                List<Profesor> profTT = getDirectores(cal.get(i).getIdTt(), directores);
                table.addCell(profTT.get(0).getApaterno()+ " " + profTT.get(0).getAmaterno()+ " " + profTT.get(0).getNombre());
                try{table.addCell(profTT.get(1).getApaterno()+ " " + profTT.get(1).getAmaterno()+ " " + profTT.get(1).getNombre());}catch(Exception e){table.addCell(" ");}
                profTT = getSinodales(cal.get(i).getIdTt(), sinodales);
                table.addCell(profTT.get(0).getApaterno()+ " " + profTT.get(0).getAmaterno()+ " " + profTT.get(0).getNombre());
                table.addCell(profTT.get(1).getApaterno()+ " " + profTT.get(1).getAmaterno()+ " " + profTT.get(1).getNombre());
                try{table.addCell(profTT.get(2).getApaterno()+ " " + profTT.get(2).getAmaterno()+ " " + profTT.get(2).getNombre());}catch(Exception e){table.addCell(" ");}
                
            }
            // We add the table (Añadimos la tabla)
            paragraphMore.add(table);
            // We add the paragraph with the table (Añadimos el elemento con la tabla).
            document.add(chapTitle);
            document.close();
            System.out.println("Your PDF file has been generated!(¡Se ha generado tu hoja PDF!");
        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        PDF generatePDFFileIText = new PDF();
        generatePDFFileIText.createPDF(new File("../elpdfdeprueba.pdf"));
    }
    
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
}