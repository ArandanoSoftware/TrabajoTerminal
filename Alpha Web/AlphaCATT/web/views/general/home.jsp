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
      <link rel="stylesheet" href="../../css/breadstyle.css">
      <%--PersonalCSS--%>
      <link rel="stylesheet" href="../../css/master.css">
      <link rel="stylesheet" href="../../css/registroTT.css.css">
      <%--Javascript--%>
      <script type="text/javascript" src="../../js/master.js"></script>

      <title> Sistema CATT </title>
    </head>
    <body>
      <div class="MainMenu">
          <div class="Title">
           <ul>
             <li class="Title-item"><img src="../../img/logoEscom.png" id="logoEscom"></li>
             <li class="Title-item">
              <b><aconym title="Comision Academica de Trabajos Terminales"/>CATT</b>
            </li>
            <li class="Title-item-name"><a href=""class="Title-item-name"></a></li>
            <li class="Title-item-name">
                <div class="dropdown">
                  <button class="dropbtn">Profesores</button>
                    <div class="dropdown-content">
                        <s:a action="home" forceAddSchemeHostAndPort="true">Registro Prfesores</s:a>   
                       
                          <a href="#">Restricciones de Profesores</a>
                          <a href="#">Consulta de profesores</a>
                    </div>
               </div>
            </li>
            <li class="Title-item">
                <div class="dropdown">
                  <button class="dropbtn">Alumnos</button>
                    <div class="dropdown-content">
                          <a href="#">Link 1</a>
                          <a href="#">Link 2</a>
                          <a href="#">Link 3</a>
                    </div>
               </div>
            </li>
            <li class="Title-item">
                <div class="dropdown">
                  <button class="dropbtn">Trabajos Terminales</button>
                    <div class="dropdown-content">
                          <a href="#">Link 1</a>
                          <a href="#">Link 2</a>
                          <a href="#">Link 3</a>
                    </div>
               </div>
            </li>

           </ul>
          </div>
      </div>




   <div class="General">
     <p><script type="text/javascript">
     </script></p>

   <div class="PanelGeneral PanelHome">
     <div class="Panel-Title">
       <b>Estado de la Calendarización:</b>
     </div>
     <div class="PanelContent">
       <table>
         <tr>
           <th>Registro de los Profesores:</th>
           <th> Completo! <progress value="0" max="100">100%</progress></th>
         </tr>
         <tr>
           <th>Registro de los Trabajos terminales:</th>
           <th> Completo! <progress value="0" max="100">100%</progress></th>
         </tr>
       </table>
     </div>
   </div>
   </div>
   </body>
</html>
