/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.modulo;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
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
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.user", usuario);
        props.put("mail.password", password);
        
        session = Session.getDefaultInstance(props);
    }    
    public Email(String user, String password)
    {
        this.usuario = user;
        this.password = password;
        props = new Properties();
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.user", usuario);
        props.put("mail.password", password);
        
        session = Session.getDefaultInstance(props);
    }
    
    public void enviar(String destinatario)
    {
        try
        {
            MimeMessage mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(usuario));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mensaje.setSubject("EL CALENDARIO =D");
            BodyPart cuerpoMensaje = new MimeBodyPart();
            cuerpoMensaje.setText("este es un mensaje que te envia el calendario, puto");
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
        }
    }
}
