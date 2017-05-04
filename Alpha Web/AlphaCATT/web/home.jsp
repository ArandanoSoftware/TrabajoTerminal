<%--
Trabajo Terminal- Sistema de cal
Función home:
Mostrar las opciones.
informar sobre la situación actual para la generación deñ calendario
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <meta charset="utf-8">
      <%--DefaultCSS --%>
      <link rel="stylesheet" href="css/normalize.css">

      <%--PersonalCSS--%>
      <link rel="stylesheet" href="css/master.css">
      <%--Javascript--%>
      <script type="text/javascript" src="js/master.js"></script>

      <title> Sistema CATT </title>
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
            <s:a action="rprof" forceAddSchemeHostAndPort="true">Registro Profesores</s:a>
            <s:a action="qprof" forceAddSchemeHostAndPort="true">Gestión de Profesores</s:a>
            <s:a action="" forceAddSchemeHostAndPort="true">Restricciones de Profesores</s:a>
          </div>
      </div>
      <div class="dropdown">
        <button class="dropbtn">Trabajos Terminales</button>
          <div class="dropdown-content">
            <s:a action="rtt" forceAddSchemeHostAndPort="true">Registro de Trabajos Terminales</s:a>
            <s:a action="qtt" forceAddSchemeHostAndPort="true">Gestión de Trabajos Terminales</s:a>
            <s:a action="" forceAddSchemeHostAndPort="true">Restricciones de Trabajos Terminales</s:a>
          </div>
      </div>
      <div class="dropdown">
        <button class="dropbtn">Salas</button>
          <div class="dropdown-content">
            <s:a action="rsalas" forceAddSchemeHostAndPort="true">Registro de Salas</s:a>
            <s:a action="qsalas" forceAddSchemeHostAndPort="true">Gestión de Salas</s:a>
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
      <div class="dropdown">
        <button class="dropbtn red">Configuración</button>
          <div class="dropdown-content">
            <s:a action="" forceAddSchemeHostAndPort="true">Usuarios</s:a>
            <s:a action="" forceAddSchemeHostAndPort="true"></s:a>
            <s:a action="" forceAddSchemeHostAndPort="true"></s:a>
          </div>
      </div>
    </div>
    <div class="General">
      <h1>Sistema de calendarización  de presentaciones de trabajos terminales </h1>
      <p>
        El siguiente sistema tiene como propósito agendar las fechas de para
        las presentaciones de trabajos terminales, para realizar esta tarea el
        sistema hace uso de la siguiente información:
      </p>
      <ul>
        <li>Horario de clases de los profesores</li>
        <li>Salas Disponibles para presentación de trabajos terminales</li>
        <li>El registro de los trabajos terminales que presentaran</li>
        <li>Las restricciones personales para los profesores, es decir que días no están disponibles para presentar</li>
        <li>Las restricciones para el uso de las salas</li>
      </ul>
      <p>
        Este sistema esta dividido en secciones para facilitar el uso del mismo.
        <br>
        <br>
        Este sistema solo ofrece opciones de presentación de trabajos terminales,
        la decisión final dependerá del personal de la CATT así como de las
        autoridades pertinentes.
      </p>

   </div>
   </body>
</html>
