<%--
Trabajo Terminal - pagina para registrar los trabajos terminales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>





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
    <s:form action="displayProfr">
      <sx:autocompleter name="profesor" list="ProfArrayList" showDownArrow="true" label="Profesor"/>
    <s:submit />
    </s:form> 
      
    <s:form action="regTt">
    <table>
      <tr>
        <th><h3>Datos del trabajo terminal: </h3></th>
      </tr>
      <tr>
        <th>Número de Trabajo  Terminal:</th>
        <th><input type="text" name="" value=""></th>
      </tr>
      <tr>
        <th>Nombre del Trabajo  Terminal:</th>
        <th><input type="text" name="" value=""></th>
      </tr>
      <tr>

        <th>Nivel del Trabajo  Terminal:</th>
        <th>
          <select name="nivel">
            <option value="1">Trabajo Terminal 1</option>
            <option value="2">Trabajo Terminal 2</option>
            <option value="3">Trabajo Terminal Remedial</option>
          </select>
        </th>

      </tr>

      <tr>
        <th><h3>Ingresa el Nombre de tus Directores: </h3></th>
      </tr>

      <tr>
        <th> Director 1:</th>
        <th> <input type="text" name="" value=""></th>
      </tr>
      <tr>
        <th> Director 2:</th>
        <th><input type="text" id="texBoxDirector" ></th>
        <th><input type="checkbox" id="checkbox"
          onclick="enableDisable(this.checked, 'texBoxDirector')"> No Nulo</th>
      </tr>
      <tr>
        <th><h3>Ingresa el Nombre de tus sinodales: </h3></th>
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
        <th><input type="text" id="texBoxSinodal" disabled></th>
        <th><input type="checkbox" id="checkbox" onclick="Enable()">No Nulo</th>
        <script>
          function Enable(){
                  document.getElementById("myText").enable = true;
                }
          }
        </script>
      </tr>
      </table>
      <s:submit onsubmit="Aviso();" value ="Eviar" ></s:submit>
      </s:form>
    </div>
  </body>
</html>
