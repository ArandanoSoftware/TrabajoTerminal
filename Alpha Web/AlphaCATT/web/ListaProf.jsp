<%--
Trabajo Terminal - Pagina para registrar los Profesores Externos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="css/registroTT.css.css">
    <%--Javascript--%>
    <script type="text/javascript" src="js/master.js"></script>
    <title>Registro de Profesor Externo:</title>
  </head>
  <body>
    <div class="MainMenu">
        <div class="Title">
         <ul>
           <li class="Title-item"><img src="img/logoEscom.png" id="logoEscom"></li>
           <li class="Title-item">
            <b><aconym title="Comision Academica de Trabajos Terminales"/>CATT</b>
          </li>
          <li class="Title-item-name"><a href=""class="Title-item-name"></a></li>
         </ul>
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

        <!-- struts Form -->
     <table class="TableCode">
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
                  <td><s:property value="id"/> </td>
                  <td><s:property value="name"/> </td>
                  <td><s:property value="language"/> </td>
                  <td><s:property value="code"/> </td>
              </tr>
          </s:iterator>
      </tbody>
      </table>
  </div>
  </body>
</html>
