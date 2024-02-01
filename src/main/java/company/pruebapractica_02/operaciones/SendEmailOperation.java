package company.pruebapractica_02.operaciones;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmailOperation {

    private Properties propiedades;
    private Session sesion;

    public SendEmailOperation() {
        
    }
    
    private void setPropertiesServerSMTP() {

        propiedades = System.getProperties();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.port", "587");
        propiedades.put("mail.smtp.starttls.enable", "true");
        sesion = Session.getInstance(propiedades, null);
    }

    private Transport connectServerSMTP(String direccionEmail, String password)
            throws NoSuchProviderException, MessagingException {
        
        Transport t = (Transport) sesion.getTransport("smtp");
        t.connect(propiedades.getProperty("mail.smtp.host"), direccionEmail, password);
        return t;
    }

    private Message createCoreMessage(String emisor, String destinatario, String asunto)
            throws AddressException, MessagingException {
        
        Message mensaje = new MimeMessage(sesion);
        mensaje.setFrom(new InternetAddress(emisor));
        mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
        mensaje.setSubject(asunto);
        return mensaje;
    }

    private Message createTextMessage(String emisor, String destinatario, String asunto, String textoMensaje)
            throws MessagingException, AddressException, IOException {
        
        Message mensaje = createCoreMessage(emisor, destinatario, asunto);
        mensaje.setText(textoMensaje);
        return mensaje;
    }

    private Message createAttachMessage(String emisor, String destinatario, String asunto,
            String textoMensaje, String pathFichero)
            throws MessagingException, AddressException, IOException {
        
        Message mensaje = createCoreMessage(emisor, destinatario, asunto);

        BodyPart bodyPart = new MimeBodyPart();
        bodyPart.setText(textoMensaje);

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.attachFile(new File(pathFichero));

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(bodyPart);
        multipart.addBodyPart(mimeBodyPart);

        mensaje.setContent(multipart);
        return mensaje;
    }
    
    public void sendTextMessage(String emisor, String destinatario,
                                   String asunto, String textoMensaje, String direccionEmail, String password) 
            throws AddressException, MessagingException, IOException {
        
        setPropertiesServerSMTP();
        Message mensaje = createTextMessage(emisor, destinatario, asunto, textoMensaje);
        Transport t = connectServerSMTP(direccionEmail, password);
        
        t.sendMessage(mensaje, mensaje.getAllRecipients());
        t.close();
    }

    public void sendAttachMessage(String emisor, String destinatario,
            String asunto, String textoMensaje, String direccionEmail,
            String password, String pathFichero)
            throws AddressException, MessagingException, IOException {
        
        setPropertiesServerSMTP();
        Message mensaje = createAttachMessage(emisor, destinatario, asunto, textoMensaje, pathFichero);
        Transport t = connectServerSMTP(direccionEmail, password);
        t.sendMessage(mensaje, mensaje.getAllRecipients());
        t.close();
    }
}
