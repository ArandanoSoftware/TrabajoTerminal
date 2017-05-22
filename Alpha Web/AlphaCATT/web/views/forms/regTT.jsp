<%--
Trabajo Terminal - pagina para registrar los trabajos terminales
--%>

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
    <link rel="stylesheet" href="css/registroTT.css.css">
    <%--Javascript--%>
    <script type="text/javascript" src="js/master.js"></script>
    <title>Registro de trabajos terminales</title>
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
      <h1>Registro de trabajos terminales</h1>
      <hr />
      <h3>Instrucciones:</h3>
      <p>
        En este cuestionario ingresa los datos del trabajo terminal que quieres
        registrar, revisa cuidadosamente que los datos sean correctos.
      </p>

    <s:form action="regTt">
    <table>
      <tr>
        <th><h3>Datos del trabajo terminal: </h3></th>
      </tr>
      <tr>
        <th>Número de Trabajo  Terminal:</th>
        <th><input type="text" name="tt.idTt"/></th>
      </tr>
      <tr>
        <th>Nombre del Trabajo  Terminal:</th>
        <th><input type="text" name="tt.nombre"></th>
      </tr>
      <tr>

        <th>Nivel del Trabajo  Terminal:</th>
        <th>
          <select name="tt.nivel">
            <option name = "tt.nivel" value="1">Trabajo Terminal 1</option>
            <option name = "tt.nivel" value="2">Trabajo Terminal 2</option>
            <option name = "tt.nivel" value="3">Trabajo Terminal Remedial</option>
          </select>
        </th>

      </tr>

      <tr>
        <th><h3>Ingresa el Nombre de los Directores: </h3></th>
      </tr>

      <tr>
        <th> Director 1:</th>
        <th><s:select name = "directores.profesorByD1" list="profList" headerKey="-1" headerValue="--- Select ---"/><!input type="text" name="" value=""></th>
      </tr>
      <tr>
        <th> Director 2:</th>
        <th><s:select name = "directores.profesorByD2" list="profList" headerKey="-1" headerValue="--- Select ---"/>    <!input type="text" id="texBoxDirector" ></th>
        <th><input type="checkbox" id="checkbox" onclick="enableDisable(this.checked, 'texBoxDirector')"> No Nulo</th>
      </tr>
      <tr>
        <th><h3>Ingresa el Nombre de los sinodales: </h3></th>
      </tr>
      <tr>
        <th> Sinodal 1:</th>
        <th><s:select name = "sinodales.profesorByS1" list="profList" headerKey="-1" headerValue="--- Select ---" /> <!input type="text" name="" value=""></th>
      </tr>
      <tr>
        <th> Sinodal 2:</th>
        <th><s:select name = "sinodales.profesorByS2" list="profList" headerKey="-1" headerValue="--- Select ---"/> <!input type="text" name="" value=""></th>
      </tr>
      <tr>
        <th> Sinodal 3:</th>
        <th><s:select id="prueba" name = "sinodales.profesorByS3" list="profList" headerKey="-1" headerValue="--- Select ---"/><!input type="text" id="texBoxSinodal" disabled></th>
    <th><input type="checkbox" onclick="Enable()">No Nulo</th>
      </tr>        
        <script>
          function Enable(){
                  document.getElementById("prueba").enable = true;
                }
          }
        </script>
      <tr>
        <th><h3>Datos del Alumno: </h3></th>
      </tr>
      <tr>
        <th>Nombre: </th>
        <th><input type="text" name="alumno.nombre"/></th>
      </tr>
      <tr>
        <th>Primer apellido: </th>
        <th><input type="text" name="alumno.apaterno"></th>
      </tr>
      <tr>
        <th>Segundo apellido: </th>
        <th><input type="text" name="alumno.amaterno"></th>
      </tr>
      <tr>
        <th>Email: </th>
        <th><input type="text" name="alumno.email"></th>
      </tr>
      <tr>
        <th>Telefono: </th>
        <th><input type="text" name="alumno.telefono"></th>
      </tr>
      </table>
      <s:submit onsubmit="Aviso();" value ="Eviar" ></s:submit>
      </s:form><script>
          function Aviso(){
              alert("Informacion enviada para registro de Tranajo Termninal");
          }
        </script>
    </div>
  </body>
</html>
