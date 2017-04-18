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
      <link rel="stylesheet" href="../../css/normalize.css">

      <%--PersonalCSS--%>
      <link rel="stylesheet" href="../../css/master.css">
      <%--Javascript--%>
      <script type="text/javascript" src="../../js/master.js"></script>

      <title> Sistema CATT </title>
    </head>
    <body>
    <div class="TitleBar">
        <div class="Title">
          <ul>
            <li class="Title-item"><img src="../../img/logoEscom.png" id="logoEscom"></li>
            <li class="Title-item"><b><aconym title="Comision Academica de Trabajos Terminales"/>Sistema de Calendarización de presentaciones de Trabajos Terminales - "JUANITA 2.0" </b></li>
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
            <s:a action="" forceAddSchemeHostAndPort="true">Opcion "A"</s:a>
            <s:a action="" forceAddSchemeHostAndPort="true">Opcion "B"</s:a>
            <s:a action="" forceAddSchemeHostAndPort="true">Opcion "C"</s:a>
          </div>
      </div>
    </div>
   <div class="General">

     <h1> Lista de Profesores </h1>
     <table>
       <thead>
         <th>Nombre </th>
      
       </thead>
       <tbody>
       <s:iterator value="datos" status="estado">
           <td><s:property value="nombre" /></td>
       </s:iterator>

       </tbody>
     </table>


   </div>
   </body>
</html>
