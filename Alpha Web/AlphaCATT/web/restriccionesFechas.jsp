<%--
Trabajo terminal - Restricciones de Fechas
Pagina para ingresar las restricciones de fechas para las presentaciones de
Trabajos terminales
 --%>
<%--Basic Java Stuff --%>
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
      <script type="text/javascript" src="js/restriccionesFechas.js"></script>
      <%--Date picker--%>

    <title>Configuración de Fechas</title>
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
    <h1>Configuración del rango de fechas y las restricciones de calendario.</h1>
    <hr />
    <p>
      <b>Instrucciones:</b> <br>En esta página ingresa la información de las fechas
       para la calendarización así  como los restricciones que tengas para el
       sistema en sí, recuerda llenar correctamente bien las fechas ya que el
       sistema tomará estas como base para generar el calendario.
    </p>
    <table>
      <tr>
        <th><h3>Rango de fecha para calendarizar:</h3></th>
      </tr>
      <tr>
        <th>Fecha de Inicio:</th>
        <th><input type="date" name="" value=""><i>   mm/dd/yyyy</i></th>
      </tr>
      <tr>
        <th>Fecha de Final:</th>
        <th><input type="date" name="" value=""><i>   mm/dd/yyyy</i></th>
      </tr>
      <tr>
        <th><h3>Restricciones por día:</h3></th>
      </tr>
      <tr>

      </tr>
    </table>


  </div>
  </body>
</html>
