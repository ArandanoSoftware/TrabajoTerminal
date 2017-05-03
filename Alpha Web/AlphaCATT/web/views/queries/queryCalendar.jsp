<%--
Calendario General de Presentaciones:
Pagina para mostrar la vista general de todos las presentaciones de
de trabajo terminal
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
    <%--PersonalCSS--%>
    <link rel="stylesheet" href="css/master.css">
    <%--Javascript--%>
    <script type="text/javascript" src="js/master.js"></script>
    <script type="text/javascript" src="js/jspdf.min.js"></script>
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="js/html2canvas.js"></script>
    <script type="text/javascript" src="js/calendarioGeneral.js"></script>
    <title>Calendario general de Trabajos Terminales</title>
  </head>
  <body>

    <div class="TitleBar">
        <div class="Title">
          <ul>
            <li class="Title-item"><img src="../../img/logoEscom.png" id="logoEscom"></li>
            <li class="Title-item"><b>Sistema de Calendarización de presentaciones de Trabajos Terminales </b></li>
            <li class="Title-item-name">
         </ul>
        </div>
    </div>
    <div class="MainMenu">
      <div class="dropdown">
        <button class="dropbtn">Profesores</button>
          <div class="dropdown-content">
            <s:a action="" forceAddSchemeHostAndPort="true">Registro Profesores</s:a>
            <s:a action="" forceAddSchemeHostAndPort="true">Gestión de Prfesores</s:a>
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
      <h1>Calendario de Presentación de Trabajos Terminales</h1>
      <hr />
      <h3>Instrucciones:</h3>
      <p>
        Este calendario muestra todas  las presentaciones de trabajo terminal
        calendarizadas.
      </p>
      <br>
        <button onclick="Save()"> Guardar Calendario </button>
    </div>

    <table class="TableCode">
        <h2>Celandario General :</h2>
             <thead>
             <%-- <th># Trabajo Terminal: </th> --%>
             <%-- <th>Nombre: </th> --%>
             <%-- <th>Apellido Materno: </th> --%>
             <%-- <th>Apellido Paterno: </th> --%>
             </thead>
     <tbody>
         <s:iterator value="CalDaoList" var="dato" status="estado">
             <tr>
                 <td><s:property value="fecha"/> </td>
                 <td><s:property value="idTt"/> </td>
                 <!-- <td><s:property value="sala"/> </td> -->
                 <!-- <td><s:property value="tt"/> </td> -->
                <%-- <td><s:property value="opcion"/> </td> --%>
             </tr>
         </s:iterator>
     </tbody>
     </table>


</body>
</html>
