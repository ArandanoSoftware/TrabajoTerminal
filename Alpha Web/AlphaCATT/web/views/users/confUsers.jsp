<%--
Trabajo Terminal - Sistema de generacion de fechas para presentaciones de trabajos terminales
Función: usuarios
Tareas:
  -Gestionar Usuarios CRUD
  -
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
      <link rel="stylesheet" href="css/icomoon/style.css">
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
            <s:a action="calendar" forceAddSchemeHostAndPort="true">Calendario Generado</s:a>
            <s:a action="" forceAddSchemeHostAndPort="true">Editor de Calendario</s:a>
            <s:a action="" forceAddSchemeHostAndPort="true">Opcion "C"</s:a>
          </div>
      </div>
      <div class="dropdown">
        <button class="dropbtn red">Configuración</button>
          <div class="dropdown-content">
            <s:a action="qusers" forceAddSchemeHostAndPort="true">Usuarios</s:a>
            <s:a action="" forceAddSchemeHostAndPort="true">Notificaciones</s:a>
            <s:a action="" forceAddSchemeHostAndPort="true"></s:a>
          </div>
      </div>
    </div>
    <div class="General">
      <h1> Gestión de Usuarios </h1>
      <hr />
      <p>
        <b>Instrucciones:</b>
        La siguiente sección es para gestionar los usuarios que estan registrados
        en el sistema, desde esta pagina puede registra, consultar y elimanar los
        usuarios actuales.
      </p>
      <h3>Registrar Nuevo Usuario</h3>
      <s:form action="regUser">
      <table>
        <tr>
          <th>Nombre de Usuario:</th>
          <th> <input type="text" name="username"  required></th>
        </tr>
        <tr>
          <th>Contraseña:</th>
          <th> <input type="text" name="password"  required></th>
        </tr>
        <tr>
          <th>Tipo:</th>
          <th> <input type="text" name="tipo"  required></th>
        </tr>
      </table>
          <s:submit onsubmit="" value ="Enviar" ></s:submit>
      </s:form>

      <h3>Usuarios Registrados Actualmente</h3>

      <table class="Table" id="tabla">
               <thead>
               <th>ID</th>
               <th>Nombre de usuario</th>
               <th>Contraseña</th>
               <th>Tipo</th>
               </thead>
       <tbody>
           <s:iterator value="ListUser" status="estado">
               <tr>
                   <td><s:property value="idUser"/> </td>
                   <td><s:property value="username"/> </td>
                   <td><s:property value="password"/> </td>
                   <td><s:property value="tipo"/> </td>
                   <td>
                     <s:a action="dUser">
                     <s:param name="id" value="idUser" />
                     <span class="icon-bin"></span>
                     </s:a>
                   </td>
               </tr>
           </s:iterator>
       </tbody>
       </table>


     </div>
   </body>
</html>
