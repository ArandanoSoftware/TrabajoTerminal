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
    <link rel="stylesheet" href="../../css/normalize.css">
    <%--PersonalCSS--%>
    <link rel="stylesheet" href="../../css/master.css">
    <link rel="stylesheet" href="../../css/calendarioGeneral.css">
    <%--Javascript--%>
    <script type="text/javascript" src="../../js/master.js"></script>
    <script type="text/javascript" src="../../js/jspdf.min.js"></script>
    <script type="text/javascript" src="../../js/calendarioGeneral.js"></script>
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
  </div>
  <button onclick="demoFromHTML()">Click me</button>
  <a href="javascript:demoFromHTML()" class="button"> Run Code </a>
  <div id="content">
      <h1>
          Prueba de PDF
      </h1>
  </div>
  <script>
    function demoFromHTML() {
        var pdf = new jsPDF('p', 'pt', 'letter');
        // source can be HTML-formatted string, or a reference
        // to an actual DOM element from which the text will be scraped.
        source = $('#content')[0];

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
                pdf.save('Test.pdf');
            }, margins
        );
    }
</script>

<%--Calendar Div --%>
  <div id="calendar-zone">
      		<div id="calendar">
      			<ul class="weekdays">
      				<li>Lunes</li>
      				<li>Martes</li>
      				<li>Miercoles</li>
      				<li>Jueves</li>
      				<li>Viernes</li>
      			</ul>

      			<!-- Days from previous month -->
      			<ul class="days">
      				<li class="day other-month"><div class="date">29</div></li>
      				<li class="day other-month"><div class="date">30</div></li>
      				<li class="day other-month"> <div class="date">31</div></li>
      				<!-- Days in current month -->
      				<li class="day"><div class="date">1</div></li>
      				<li class="day"><div class="date">2</div>
              <%--
                <div class="event">
      			         <div class="event-desc">TT 2016-A088 - Sala 14</div>
      						   <div class="event-time">2:00pm</div>
      					</div>
                <div class="event">
                    <div class="event-desc">TT 2016-A088 - Sala 14</div>
                    <div class="event-time">2:00pm</div>
                </div>
                <div class="event">
                    <div class="event-desc">TT 2016-A088 - Sala 14</div>
                    <div class="event-time">2:00pm</div>
                </div>
                --%>
      				</li>
      			</ul>
      			<!-- Row #2 -->
      			<ul class="days">
              <li class="day"><div class="date">3</div></li>
              <li class="day"><div class="date">4</div></li>
              <li class="day"><div class="date">5</div></li>
              <li class="day"><div class="date">6</div></li>
      				<li class="day"><div class="date">7</div></li>

      			</ul>
      				<!-- Row #3 -->
      			<ul class="days">
      				<li class="day"><div class="date">10</div></li>
      				<li class="day"><div class="date">11</div></li>
      				<li class="day"><div class="date">12</div></li>
      				<li class="day"><div class="date">13</div></li>
      				<li class="day"><div class="date">14</div></li>

      			</ul>
      				<!-- Row #4 -->
      			<ul class="days">
      				<li class="day"><div class="date">17</div></li>
      				<li class="day"><div class="date">18</div></li>
      				<li class="day"><div class="date">19</div></li>
      				<li class="day"><div class="date">20</div></li>
      				<li class="day"><div class="date">21</div></li>
      			</ul>
      		  <!-- Row #5 -->
      			<ul class="days">
      				<li class="day"><div class="date">24</div></li>
      				<li class="day"><div class="date">25</div></li>
      				<li class="day"><div class="date">26</div></li>
      				<li class="day"><div class="date">27</div></li>
      				<li class="day"><div class="date">28</div></li>
      			</ul>
      			<!-- Row #6 -->
      			<ul class="days">
              <li class="day"><div class="date">31</div>
              <!-- Next Month -->
      				</li><li class="day other-month"><div class="date">1</div>
      				</li><li class="day other-month"><div class="date">2</div>
      				</li><li class="day other-month"><div class="date">3</div>
      				</li><li class="day other-month"><div class="date">4</div>
      				</li>
      			</ul>
      		</div>
    </div>
  <!-- /. wrap -->



</body>
</html>
