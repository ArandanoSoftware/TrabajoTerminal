<%--
Trabajo Terminal - pagina para registrar los trabajos terminales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*,java.util.*,java.sql.*"%>
<%@page import="javax.servlet.http.*,javax.servlet.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
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
    <title>Restricciones de Fechas para las restricciones de Trabajos Terminales</title>
  </head>
  <body>
    <div class="MainMenu">
        <div class="Title">
         <ul>
             <li class="Title-item-name"><b>CATT</b> </li>
         </ul>
        </div>
    </div>
  <section class="General">
    <p>
      <b>Instrucciones:</b>
      En esta página ingresa el trabajo que quieras registrar para tu trabajo, revisa que todos los datos sean correctos.
    </p>

    <form class="" action="index.html" method="post">
    <table>
      <tr>
        <th># De Trabajo  Terminal:</th>
        <th><input type="text" name="" value=""></th>
      </tr>
      <tr>
        <th>Nombre del Trabajo  Terminal:</th>
        <th><input type="text" name="" value=""></th>
      </tr>
      <tr>
        <th># De Trabajo  Terminal:</th>
        <th><input type="text" name="" value=""></th>
      </tr>
      <tr>
        <th> Director 1:</th>
        <th> <input type="text" name="" value=""></th>
      </tr>
      <tr>
        <th> Director 2:</th>
        <th> <input type="text" name="" value=""></th>
      </tr>
      <tr>
        <th> Sinodal 1:</th>
        <th> <input type="text" name="" value=""></th>
      </tr>
      <tr>
        <th> Sinodal 2:</th>
        <th> <input type="text" name="" value=""></th>
      </tr>
      <tr>
        <th> Sinodal 3:</th>
        <th> <input type="text" name="" value=""></th>
      </tr>
    </table>

    </form>
  </section>




  </body>
</html>
