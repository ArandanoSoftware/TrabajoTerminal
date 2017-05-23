<%--
Trabajo Terminal- Sistema de cal
Funci�n home:
Mostrar las opciones.
informar sobre la situaci�n actual para la generaci�n de� calendario
--%>
    <%@ include file = "header.jsp" %>
    <style>
      .container {
      max-width: 800px;
      width: 100%;
      margin: 0 auto;
      font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
      }
    </style>
    <div id="loading" class=""></div>
    <div class="General">
        <h2>Bienvenido: <s:property value="#session.loginId"></s:property></h2>
      <h1>Sistema de calendarizacion  de presentaciones de trabajos terminales </h1>
      <hr />
      <p>
        El siguiente sistema tiene como proposito agendar las fechas de para
        las presentaciones de trabajos terminales, para realizar esta tarea el
        sistema hace uso de la siguiente información:
      </p>
      <ul>
        <li>Horario de clases de los profesores</li>
        <li>Salas Disponibles para presentacion de trabajos terminales</li>
        <li>El registro de los trabajos terminales que presentaran</li>
        <li>Las restricciones personales para los profesores, es decir que d�as no est�n disponibles para presentar</li>
        <li>Las restricciones para el uso de las salas</li>
      </ul>
      <p>
        Este sistema esta dividido en secciones para facilitar el uso del mismo.
        <br>
        <br>
        Este sistema solo ofrece opciones de presentacion de trabajos terminales,
        la decisión final dependera del personal de la CATT así como de las
        autoridades pertinentes.
      </p>

        <h2 align="center"> Estado de la Calendarización: </h2>
          <table class="StatusTable">
            <tr>
              <th colspan="2"> Profesores: </th>
            </tr>
            <tr>
              <td> Registro de Profesores: </td>
              <td> Actualmente: <b><s:property value="totalProfesores"/> </b> Registrados</td>
            </tr>
            <tr>
              <td> Restricciones de Profesores: </td>
              <td> <b>Actualmente: </b> <s:property value="total_restricciones"/> <b> <b> Registrados</b></td>
            </tr>
            <tr>
              <th colspan="2" > Trabajos Terminales: </th>
            </tr>
            <tr>
              <td> Trabajos Terminales registrados para calendarizar</td>
              <td>  <b> <s:property value="totalTrabajosTerminales"/></b> Registrados</td>
            </tr>
            <tr>
              <th colspan="2" > Salas: </th>
            </tr>
            <tr>
              <td> Salas disponibles para calendarizar:  </td>
              <td> Actualmente: <b><s:property value="totalSalas"/> </b> Salas registradas </td>
            </tr>
            <tr>
              <th colspan="2" > Calendario: </th>
            </tr>
            <tr>
              <td> Iniciar proceso de calendarización: </td>
              <td><s:a action="calendarizacion" onclick="iniciado();"> <input type="button" class="botonCalendar" value="Iniciar Calendarizaci�n" ></s:a> </td>
            </tr>
            <tr>
              <td> Editar Fecha de Trabajo Terminal:  </td>
              <td><input type="button" class="botonCalendar" value="Editor de Calendario"> </td>
            </tr>
          </table>
        <script>
          function iniciado(){
              document.getElementById("loading").className = "loader loader-default is-active";
              alert("La calendarizacion ha comenzado");
          }
        </script>


   </div>
   </body>
</html>
