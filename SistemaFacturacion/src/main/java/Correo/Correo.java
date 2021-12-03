/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Correo;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author kevin
 */
public class Correo {

    public static void enviarEMail(String destinatario, String asunto, String contenido) {
        String emisor = "facturasystemprueba@gmail.com";
        String clave = "FACTURASYSTEM";

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.user", emisor);
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(emisor));
            message.addRecipients(Message.RecipientType.TO, destinatario);
            message.setSubject(asunto);
            message.setText(contenido);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", emisor, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Correo enviado exitosamente");
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }

}
