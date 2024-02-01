package company.pruebapractica_02.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Utiles {

    public boolean isPassCorrect(String pass) {
        return pass.length() < 16;
    }

    public boolean isEmailCorrect(String email) {
        return email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }

    public String formatBytes(long bytes) {
        double kilobytes = bytes / 1024.0;
        double megabytes = kilobytes / 1024.0;
        double gigabytes = megabytes / 1024.0;

        return String.format("%.2f GB", gigabytes);
    }

    public String formatPercentage(double percentageUsed) {
        return String.format("%.0f%%", percentageUsed);
    }

    public static void generarReporteDeCorreos() {

        String rutaCarpeta = "src/main/java/company/pruebapractica_02/emails";

        File carpeta = new File(rutaCarpeta);
        File[] archivos = carpeta.listFiles();

        System.out.println(archivos.length);

        if (archivos != null && archivos.length > 1) {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar reporte de correos en PDF");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF (*.pdf)", "pdf"));

            int seleccionUsuario = fileChooser.showSaveDialog(null);

            if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
                File archivoPDFSalida = fileChooser.getSelectedFile();

                Document document = new Document();

                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(archivoPDFSalida + ".pdf");
                    PdfWriter pdfWriter = PdfWriter.getInstance(document, fileOutputStream);

                    document.open();

                    for (File archivo : archivos) {
                        if (archivo.isFile() && archivo.getName().endsWith(".txt")) {

                            agregarContenidoTxtADocumento(document, archivo);

                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                document.close();
                JOptionPane.showMessageDialog(null, "El PDF se créo de forma correcta.", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "En la carpeta no se encuentras archivos a los que hacer reporte",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    private static void agregarContenidoTxtADocumento(Document document, File archivoTxt) throws IOException {

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivoTxt));
            String linea;

            while ((linea = br.readLine()) != null) {
                document.add(new Paragraph(linea));
            }
            document.add(new Paragraph("================================"));

        } catch (DocumentException ex) {
            Logger.getLogger(Utiles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
