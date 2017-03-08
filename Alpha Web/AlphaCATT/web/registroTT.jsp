<%--
Trabajo Terminal - pagina para registrar los trabajos terminales
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
  <div class="General">
    <h1>Instrucciones:</h1>
    <p>
      En este cuestionario ingresa los datos del trabajo terminal que quieres
      registra, revisa cuidadosamente que los datos sean correctos.
    </p>
    <hr />
    <table>
      <tr>
        <th>"#" De Trabajo  Terminal:</th>
        <th><input type="text" name="" value=""></th>
      </tr>
      <tr>
        <th>Nombre del Trabajo  Terminal:</th>
        <th><input type="text" name="" value=""></th>
      </tr>
   </table>
   <h3>Ingresa el Nombre de tus Directores: </h3>
   <table>
      <tr>
        <th> Director 1:</th>
        <th> <input type="text" name="" value=""></th>
      </tr>
      <tr>
        <th> Director 2:</th>
        <th> <input type="text" id="texBoxDirector" ></th>
        <th><input type="checkbox" id="checkbox"
          onclick="enableDisable(this.checked, 'texBoxDirector')">Nulo</th>
      </tr>
   </table>
   <h3>Ingresa el nombre de tus sinodales: </h3>
   <table>
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
        <th><input type="text" id="texBoxSinodal" ></th>
        <th><input type="checkbox" id="checkbox"
          onclick="enableDisable(this.checked, 'texBoxSinodal')">Nulo</th>
      </tr>
   </table>
 </div>
  </body>
</html>
