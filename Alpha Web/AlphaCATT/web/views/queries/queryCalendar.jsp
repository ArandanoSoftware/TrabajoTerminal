<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

      <%--DefaultCSS --%>
      <link rel="stylesheet" href="css/normalize.css">

      <%--PersonalCSS--%>
      <link rel="stylesheet" href="css/master.css">
      <link rel="stylesheet" href="css/calendarTable.css">
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
    <div class="General">
      <h1>Calendario de Presentación de Trabajos Terminales</h1>
      <hr />
      <h3>Instrucciones:</h3>
      <p>
        Este calendario muestra todas  las presentaciones de trabajo terminal
        calendarizadas hasta el momento.
      </p>
    <h2>Calendario General :</h2>
    <h3>Opcion <s:property value="opcion"/></h3>
    <form action="selectCal">
        <select name="opcion">
            <option name = "1" value="1">Calendario 1</option>
            <option name = "2" value="2">Calendario 2</option>
            <option name = "3" value="3">Calendario 3</option>
            <option name = "4" value="4">Calendario 4</option>
            <option name = "5" value="5">Calendario 5</option>
        </select>

        <s:submit value ="Seleccinar"></s:submit>
        <s:a action="generaPDF" onclick="iniciado();"> <input type="button" class="botonCalendar" value="Generar archivo PDF" ></s:a>
    </form>
    </div>
    <div class="calendarZone">
    <table class="calendarTable">
             <thead>
              <th class="TableHead">HORA</th>
              <th class="TableHead">LUGAR</th>
              <th class="TableHead">TT</th>
              <th class="TableHead">TITULO</th>
              <th class="TableHead">DIRECTOR 1</th>
              <th class="TableHead">DIRECTOR 2</th>
              <th class="TableHead" colspan="3">SINODALIA</th>
             </thead>
      <s:iterator value="CalList" status="estado">
       <tr>
         <td><s:property value="fecha"/></td>
         <td><s:property value="sala"/></td>
         <td><s:property value="tt.idTt"/></td>
         <td><s:property value="tt.nombre"/></td>
         <s:set var="id2" value="#estado.index" />
         <s:iterator value="DirList" begin="#id2" end="#id2">
             <td><s:property value="profesorByD1"/></td>
             <td><s:property value="profesorByD2"/></td>
         </s:iterator>
         <s:iterator value="SinList" begin="#id2" end="#id2">
             <td><s:property value="profesorByS1"/></td>
             <td><s:property value="profesorByS2"/></td>
             <td><s:property value="profesorByS3"/></td>
         </s:iterator>
         </tr>
      </s:iterator>
     </tbody>
    </table>
  </div>
</body>
</html>
