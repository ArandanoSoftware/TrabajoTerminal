<%--
Trabajo terminal - Registro de Salas
Pagina para registrar las salas disponibles
 --%>


<%--Basic Java Stuff --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


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
    </div>

  <div class="General">
    <h1>Registro de Salas:</h2>
    <hr />
    <h3>Instrucciones:</h3>
    <p>
      Formato para agregar salas disponibles para presentaciones de trabajos terminales.
    </p>
    <s:form action="regSala">
    <table>
      <tr>
        <th> Nombre de la sala:</th>
        <th> <input type="text" name="nombre" required></th>
      </tr>
    </table>
      <s:submit onsubmit="Aviso();" value ="Eviar" ></s:submit>
    </s:form>
    <script>
      function Aviso(){
          alert("Tus Datos se guardaron correctamente");
      }
    </script>
  </div>





  </body>
</html>
