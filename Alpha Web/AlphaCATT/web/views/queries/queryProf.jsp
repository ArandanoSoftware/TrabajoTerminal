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
    <link rel="stylesheet" href="css/registroTT.css">
    <%--Javascript--%>
    <script type="text/javascript" src="js/master.js"></script>
    <title>Registro de Profesor Externo:</title>
  </head>
  <body>
    <div class="TitleBar">
        <div class="Title">
          <ul>
            <li class="Title-item"><img src="img/logoEscom.png" id="logoEscom"></li>
            <li class="Title-item"><b>Sistema de Calendarización de presentaciones de Trabajos Terminales </b></li>
            <li class="Title-item-name">
         </ul>
        </div>
    </div>
    <div class="MainMenu">
      <div class="dropdown">
        <s:a action="home" forceAddSchemeHostAndPort="true" cssClass="dropbtn">Pagina Principal</s:a>
      </div>
      <div class="dropdown">
        <button class="dropbtn">Profesores</button>
          <div class="dropdown-content">
            <s:a action="" forceAddSchemeHostAndPort="true">Registro Profesores</s:a>
            <s:a action="gprof" forceAddSchemeHostAndPort="true">Gestión de Profesores</s:a>
            <s:a action="" forceAddSchemeHostAndPort="true">Restricciones de Profesores</s:a>
          </div>
      </div>
      <div class="dropdown">
        <button class="dropbtn">Trabajos Terminales</button>
          <div class="dropdown-content">
            <s:a action="" forceAddSchemeHostAndPort="true">Registro de Trabajos Terminales</s:a>
            <s:a action="" forceAddSchemeHostAndPort="true">Gestión de Trabajos Terminales</s:a>
            <s:a action="" forceAddSchemeHostAndPort="true">Restricciones de Trabajos Terminales</s:a>
          </div>
      </div>
      <div class="dropdown">
        <button class="dropbtn">Salas</button>
          <div class="dropdown-content">
            <s:a action="" forceAddSchemeHostAndPort="true">Registro de Salas</s:a>
            <s:a action="" forceAddSchemeHostAndPort="true">Gestión de Salas</s:a>
            <s:a action="" forceAddSchemeHostAndPort="true">Restricciones de Salas</s:a>
          </div>
      </div>
      <div class="dropdown">
        <button class="dropbtn">Calendario</button>
          <div class="dropdown-content">
            <s:a action="calendar" forceAddSchemeHostAndPort="true">Ver calendario Generado</s:a>
            <s:a action="" forceAddSchemeHostAndPort="true">Editor de Calendario</s:a>
            <s:a action="" forceAddSchemeHostAndPort="true">Opcion "C"</s:a>
          </div>
      </div>
    </div>


  <div class="General">
    <h1>Directorio de Profesores Registrados en la BD:</h2>
    <hr />
    <h3>Instrucciones:</h3>
    <p>
      En este listado se muestran todos los profesores que estan registrados
      en la base de datos.
    </p>
    <h5>Buscador:</h5><input type="text" id="buscador" onkeyup="Filter()" placeholder="Buscar nombres..">

        <!-- struts Form -->
     <table class="Table" id="tabla">
         <h2>Profesores:</h2>
              <thead>
              <th>ID: </th>
              <th>Nombre: </th>
              <th>Apellido Materno: </th>
              <th>Apellido Paterno: </th>
              </thead>
      <tbody>
          <s:iterator value="datos" var="dato" status="estado">
              <tr>
                  <td><s:property value="idProfesor"/> </td>
                  <td><s:property value="nombre"/> </td>
                  <td><s:property value="apaterno"/> </td>
                  <td><s:property value="amaterno"/> </td>
                  <td><s:property value="email"/> </td>
                  <td>
                    <s:a action="dprof">
                    <s:param name="id" value="idProfesor" />
                    <i class="material-icons">delete</i>
                    </s:a>
                  </td>
              </tr>
          </s:iterator>
      </tbody>
      </table>
  </div>
  </body>
</html>
