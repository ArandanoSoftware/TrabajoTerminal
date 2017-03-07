<%--
Trabajo Terminal- Sistema de cal
Función home:
Mostrar las opciones.
informar sobre la situación actual para la generación deñ calendario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <%--Default CSS--%>
      <link rel="stylesheet" href="css/normalize.css">
      <link rel="stylesheet" href="css/master.css">
      <%--Default js--%>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


        <title> Sistema CATT </title>
    </head>
    <body>
      <div class="MainMenu">
          <div class="Title">
           <ul>
               <li class="Title-item-name"><b>CATT</b> </li>
           </ul>
          </div>
      </div>
   <div class="General">
     <div class="panel panel-primary">
       <div class="panel-heading"> <b>Estado General:</b></div>
           <div class="panel-body">
             <p>Registro de Salas</p>
             <p>Registro de Profesores</p>
             <p>Registro de Restricciones</p>
             <p>Registro de Trabajos Terminales</p>
           </div>
     </div>
     <div class="panel panel-primary">
       <div class="panel-heading"> <b>Panel Status:</b></div>
           <div class="panel-body">
             <p>Registro de Salas</p>
             <p>Registro de Profesores</p>
             <p>Registro de Restricciones</p>
             <p>Registro de Trabajos Terminales</p>
           </div>
     </div>
   </div>
   <script src="js/home.js"></script>


   </body>
</html>
