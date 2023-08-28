/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JTable;

/**
 *
 * @author erick
 */
public class generatePDF {
    public generatePDF(){
    
    };
    
    
    public void pdfTable(JTable table){
        Document document = new Document(PageSize.A4);
        
        // Convertir la fecha en una cadena con formato
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString = currentDate.format(formatter);
        
        //Nombre
        String programName = "ManageMoney"; // Cambia esto al nombre de tu programa
        String pdfFileName = programName + "_" + dateString + "_report.pdf";

        String documentsPath = System.getProperty("user.home") + File.separator + "Documents";
        String outputPath = documentsPath + File.separator + pdfFileName;
        
        
        try {
            PdfWriter.getInstance(document, new FileOutputStream(outputPath));
            document.open();

            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());

            // Agregar encabezados de columna
            for (int i = 0; i < table.getColumnCount(); i++) {
                pdfTable.addCell(table.getColumnName(i));
            }

            // Agregar filas de datos
            for (int i = 0; i < table.getRowCount(); i++) {
                for (int j = 0; j < table.getColumnCount(); j++) {
                    pdfTable.addCell(table.getValueAt(i, j).toString());
                }
            }

            document.add(pdfTable);
            document.close();

            System.out.println("PDF generate - " + outputPath);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
