/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.modulo;

import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Hazzy76
 */
public class Email {
    //la direccion de envio (to)
    private String para;
    //la direccion de la cuenta de envio (from)
    private String usuario;
    private String password;
    //El servidor (host), En este caso usamos localhost
    private String host;
    //obtenemos las propiedades del sistema
    private Properties props;
    
    private Session session;
    
    
    
    public Email()
    {
        usuario = "hazzy76@gmail.com";
        password = "esperansa";
        props = new Properties();
        props.put("mail.smtp.auth", "true");
        //props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
 
        session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(usuario, password);
                    }
                });

    }    
    public Email(String user, String pass)
    {
        this.usuario = user;
        this.password = pass;
        props = new Properties();
        props.put("mail.smtp.auth", "true");
        //props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
 
        session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(usuario,password);
                    }
                });
    }
    
    public void enviar(String destinatario)
    {
        try
        {
            MimeMessage mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress("hazzy76@gmail.com"));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress("hazzy76@hotmail.com"));
            mensaje.setSubject("EL CALENDARIO =D si se can");
            
            BodyPart cuerpoMensaje = new MimeBodyPart();
            cuerpoMensaje.setText("te notifico que hoy tenemos que ver a nayely =S\n\n\n aquí debe haber un calendario\n\n\n y... puto\n\n\n tambien me parece que hay forma de meter html en el cuerpo del correo, algo así: mensaje.setContent(\"<h1>El mensaje de nuestro primer correo HTML</h1>\",\"text/html\" );\n\n\nno lo he intentado pero por si se ocupa mmmm... puto xD");
            Multipart multiparte = new MimeMultipart();
            multiparte.addBodyPart(cuerpoMensaje);
            
            cuerpoMensaje = new MimeBodyPart();
            String archivo = "../calendar2.xls";
            DataSource fuente = new FileDataSource(archivo);
            cuerpoMensaje.setDataHandler(new DataHandler(fuente));
            cuerpoMensaje.setFileName("calensario");
            multiparte.addBodyPart(cuerpoMensaje);
            
            mensaje.setContent(multiparte);
            
            Transport.send(mensaje);
            System.out.println("mensaje enviado =)");
        }catch(MessagingException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    public void enviar(List<String> dest)
    {
        try
        {
            MimeMessage mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(usuario));
            Address []destinos = new Address[dest.size()];//Aqui usamos el arreglo de destinatarios
            for(int i=0;i<destinos.length;i++){
                destinos[i]=new InternetAddress(dest.get(i));
            }
            mensaje.addRecipients(Message.RecipientType.TO, destinos);
            mensaje.setSubject("EL CALENDARIO =D si se can");
            
            BodyPart cuerpoMensaje = new MimeBodyPart();
            cuerpoMensaje.setText("te notifico que hoy tenemos que ver a nayely =S\n\n\n aquí debe haber un calendario\n\n\n y... puto\n\n\n tambien me parece que hay forma de meter html en el cuerpo del correo, algo así: mensaje.setContent(\"<h1>El mensaje de nuestro primer correo HTML</h1>\",\"text/html\" );\n\n\nno lo he intentado pero por si se ocupa mmmm... puto xD");
            Multipart multiparte = new MimeMultipart();
            multiparte.addBodyPart(cuerpoMensaje);
            
            cuerpoMensaje = new MimeBodyPart();
            String archivo = "../calendar2.xls";
            DataSource fuente = new FileDataSource(archivo);
            cuerpoMensaje.setDataHandler(new DataHandler(fuente));
            cuerpoMensaje.setFileName("calensario");
            multiparte.addBodyPart(cuerpoMensaje);
            
            mensaje.setContent(multiparte);
            
            Transport.send(mensaje);
            System.out.println("mensaje enviado =)");
        }catch(MessagingException e)
        {
            throw new RuntimeException(e);
        }
    }
}
