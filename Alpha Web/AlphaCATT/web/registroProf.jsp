<%--
Trabajo Terminal - Pagina para registrar los Profesores Externos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%-- <%@page import="java.io.*,java.util.*,java.sql.*"%>
<%@page import="javax.servlet.http.*,javax.servlet.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%> --%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <%--DefaultCSS --%>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/breadstyle.css">
    <%--PersonalCSS--%>
    <link rel="stylesheet" href="css/master.css">
    <link rel="stylesheet" href="css/registroTT.css.css">
    <%--Javascript--%>
    <script type="text/javascript" src="js/master.js"></script>
    <title>Registro de Profesor Externo:</title>
  </head>
  <body>
    <div class="MainMenu">
        <div class="Title">
         <ul>
           <li class="Title-item"><img src="img/logoEscom.png" id="logoEscom"></li>
           <li class="Title-item">
            <b><aconym title="Comision Academica de Trabajos Terminales"/>CATT</b>
          </li>
          <li class="Title-item-name"><a href=""class="Title-item-name"></a></li>
         </ul>
        </div>
    </div>
  <div class="General">
    <h1>Registro de directores/asesores Externos:</h2>
    <hr />
    <h3>Instrucciones:</h3>
    <p>
      Si tu director o asesor es una persona externa a la institución registra sus datos
      así como su información de contacto.
    </p>
    <table>
      <tr>
        <th> Nombre:</th>
        <th> <input type="text" name="" value=""></th>
      </tr>
      <tr>
        <th> Apellido paterno:</th>
        <th> <input type="text" name="" value=""></th>
      </tr>
      <tr>
        <th> Apellido materno:</th>
        <th> <input type="text" name="" value=""></th>
      </tr>
      <tr>
        <th> E-mail:</th>
        <th> <input type="email" name="" value=""></th>
      </tr>

    </table>

  </div>
  </body>
</html>
