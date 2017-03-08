<%--
Trabajo Terminal - Pagina para registrar los Profesores Externos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
           <li class="Title-item-name"><b>CATT</b> </li>
       </ul>
      </div>
  </div>
  <div class="General">
    <h1>Registro de directores/asesores Externos:</h2>
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
    </table>

  </div>
  </body>
</html>
