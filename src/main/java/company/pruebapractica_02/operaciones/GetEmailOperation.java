package company.pruebapractica_02.operaciones;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;

public class GetEmailOperation {

    private Properties propiedades;
    private Session sesion;
    private String user;
    private String pass;
    private String asunto;

    public GetEmailOperation(String user, String pass, String asunto) {
        this.user = user;
        this.pass = pass;
        this.asunto = asunto;
        this.propiedades = new Properties();
    }

public void getEmailsAndSave(String username, String password, String subjectToSearch) {

    
        propiedades.setProperty("imap.gmail.com", "imaps");

        try {
            Session session = Session.getDefaultInstance(propiedades, null);
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", username, password);

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();
            
            for (Message message : messages) {
                if (message.getSubject() != null && message.getSubject().contains(subjectToSearch)) {
                    saveEmailsToAFile(message);
                }
            }
            inbox.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveEmailsToAFile(Message message) {
        
        try {
            String content = message.getContent().toString();
            FileWriter fileWriter = new FileWriter(new File("src/main/java/company/pruebapractica_02/emails/Correo_" + message.getMessageNumber() + ".txt"));
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException | MessagingException e) {
            e.printStackTrace();
        }
    }
}
