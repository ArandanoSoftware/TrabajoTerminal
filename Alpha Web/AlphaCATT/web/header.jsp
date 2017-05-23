<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

      <%--DefaultCSS --%>
      <link rel="stylesheet" href="css/normalize.css">

      <%--PersonalCSS--%>
      <link rel="stylesheet" href="css/master.css">
      <link rel="stylesheet" href="css/css-loader.css">
      <%--Javascript--%>
      <script type="text/javascript" src="js/master.js"></script>
      <script type="text/javascript" src="js/jspdf.min.js"></script>
      <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
      <script type="text/javascript" src="js/html2canvas.js"></script>
      <script type="text/javascript" src="js/calendarioGeneral.js"></script>




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
            <s:a action="restprof" forceAddSchemeHostAndPort="true">Restricciones de Profesores</s:a>
          </div>
      </div>
      <div class="dropdown">
        <button class="dropbtn">Trabajos Terminales</button>
          <div class="dropdown-content">
            <s:a action="rtt" forceAddSchemeHostAndPort="true">Registro de Trabajos Terminales</s:a>
            <s:a action="qtt" forceAddSchemeHostAndPort="true">Gestión de Trabajos Terminales</s:a>
          </div>
      </div>
      <div class="dropdown">
        <button class="dropbtn">Salas</button>
          <div class="dropdown-content">
            <s:a action="rsalas" forceAddSchemeHostAndPort="true">Registro de Salas</s:a>
            <s:a action="qsalas" forceAddSchemeHostAndPort="true">Gestión de Salas</s:a>
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
        <button class="dropbtn red">Directorio</button>
          <div class="dropdown-content">
            <s:a action="qusers" forceAddSchemeHostAndPort="true">Gesión del Directorio</s:a>
          </div>
      </div>
      <div class="dropdown">
        <button class="dropbtn red">Configuración</button>
          <div class="dropdown-content">
            <s:a action="qusers" forceAddSchemeHostAndPort="true">Gestión de Usuarios</s:a>
            <s:a action="" forceAddSchemeHostAndPort="true">Notificaciones</s:a>
            <s:a action="" forceAddSchemeHostAndPort="true"></s:a>
          </div>
      </div>
    </div>
