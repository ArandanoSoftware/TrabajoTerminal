<%--
Trabajo Terminal- Sistema de cal
Funci�n home:
Mostrar las opciones.
informar sobre la situaci�n actual para la generaci�n de� calendario
--%>
    <%@ include file = "header.jsp" %>
    <div class="General">
        <h2>Bienvenido: <s:property value="#session.loginId"></s:property></h2>
      <h1>Sistema de calendarizaci�n  de presentaciones de trabajos terminales </h1>
      <hr />
      <p>
        El siguiente sistema tiene como prop�sito agendar las fechas de para
        las presentaciones de trabajos terminales, para realizar esta tarea el
        sistema hace uso de la siguiente informaci�n:
      </p>
      <ul>
        <li>Horario de clases de los profesores</li>
        <li>Salas Disponibles para presentaci�n de trabajos terminales</li>
        <li>El registro de los trabajos terminales que presentaran</li>
        <li>Las restricciones personales para los profesores, es decir que d�as no est�n disponibles para presentar</li>
        <li>Las restricciones para el uso de las salas</li>
      </ul>
      <p>
        Este sistema esta dividido en secciones para facilitar el uso del mismo.
        <br>
        <br>
        Este sistema solo ofrece opciones de presentaci�n de trabajos terminales,
        la decisi�n final depender� del personal de la CATT as� como de las
        autoridades pertinentes.
      </p>

        <h2 align="center"> Estado de la Calendarizaci�n: </h2>
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
              <td> Iniciar proceso de calendarizaci�n: </td>
              <td><s:a action="calendarizacion" onclick="iniciado();"> <input type="button" class="botonCalendar" value="Iniciar Calendarizaci�n" ></s:a> </td>
            </tr>
            <tr>
              <td> Editar Fecha de Trabajo Terminal:  </td>
              <td><input type="button" class="botonCalendar" value="Editor de Calendario"> </td>
            </tr>
          </table>
        <script>
          function iniciado(){
              alert("La calendarizacion ha comenzado");
          }
        </script>


   </div>
   </body>
</html>
