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
    <link rel="stylesheet" href="css/calendarioGeneral.css">
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
          </div>
      </div>
    </div>
            <s:a action="" forceAddSchemeHostAndPort="true">Opcion "C"</s:a>


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
  <%--Java script Code--%>
  <script>
        function Save(){
          var pdf = new jsPDF('p', 'pt', 'letter');
          pdf.addHTML($('#calendar-zone')[0], function () {
          pdf.save('Test.pdf');
          });
        }

        function SaveFromHTML() {
        var pdf = new jsPDF('p', 'pt', 'letter');
        // source can be HTML-formatted string, or a reference
        // to an actual DOM element from which the text will be scraped.
        //source = myImage;
        source = $('#calendar-zone')[0];

        // we support special element handlers. Register them with jQuery-style
        // ID selector for either ID or node name. ("#iAmID", "div", "span" etc.)
        // There is no support for any other type of selectors
        // (class, of compound) at this time.
        specialElementHandlers = {
            // element with id of "bypass" - jQuery style selector
            '#bypassme': function (element, renderer) {
                // true = "handled elsewhere, bypass text extraction"
                return true
            }
        };
        margins = {
            top: 80,
            bottom: 60,
            left: 40,
            width: 522
        };
        // all coords and widths are in jsPDF instance's declared units
        // 'inches' in this case
        pdf.fromHTML(
            source, // HTML string or DOM elem ref.
            margins.left, // x coord
            margins.top, { // y coord
                'width': margins.width, // max width of content on PDF
                'elementHandlers': specialElementHandlers
            },

            function (dispose) {
                // dispose: object with X, Y of the last line add to the PDF
                //          this allow the insertion of new lines after html
                pdf.save('Calendario.pdf');
            }, margins
        );
    }
  </script>

<%--Calendar Div --%>
  <table class="TableCode">
      <h2>Calendario de Presentaciones de Trabajos Terminales:</h2>
           <thead>
           <th>Número de Trabajo Terminal: </th>
           <th>Sala de Presentación </th>
           <th>Apellido Materno: </th>
           <th>Apellido Paterno: </th>
           </thead>
   <tbody>
       <s:iterator value="datos" var="dato" status="estado">
           <tr>
               <td><s:property value="idTt"/> </td>
               <td><s:property value="sala"/> </td>
               <td><s:property value="tt"/> </td>
               <td><s:property value="fecha"/> </td>
           </tr>
       </s:iterator>
   </tbody>
   </table>




</body>
</html>
