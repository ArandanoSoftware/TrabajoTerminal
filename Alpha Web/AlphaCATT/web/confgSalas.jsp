<%--
Trabajo terminal - Registro de Salas
Pagina para registrar las salas disponibles
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
      <%--Javascript--%>
      <%--Date picker--%>

    <title>Configuración de Salas para presentación de Trabajo Terminal</title>
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
    <h1>Configuración de Salas para presentación de Trabajo Terminal</h1>
    <hr />
    <p>
      <b>Instrucciones:</b> <br>
    </p>
  </div>

    <div class="PanelGeneral PanelBlue">
      <div class="Panel-Title">
        <b>Agregar una sala:</b>
      </div>
    <div class="PanelContent">
      <table>
        <tr>
          <th>Nombre de la sala: </th>
          <th> <input type="text" name="" value=""></th>
        </tr>
      </table>
    </div>
    </div>

    <div class="PanelGeneral PanelRed">
      <div class="Panel-Title">
        <b>Salas Disponibles :</b>
      </div>
      <div class="PanelContent">
      <table>
        <tr>

        </tr>
      </table>
      </div>
    </div>

    <div class="PanelGeneral PanelBlue">
      <div class="Panel-Title">
        <b>Restriccion de Salas :</b>
      </div>
      <div class="PanelContent">
      <table>
        <tr>

        </tr>
      </table>
      </div>
    </div>





  </body>
</html>
