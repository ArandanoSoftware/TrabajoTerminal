<%-- 
    Document   : regRango
    Created on : 22/05/2017, 12:41:53 PM
    Author     : hazzy76
--%>

<%@ include file = "../../header.jsp" %>
          <div class="General">
    <h1>Configuración del rango de fechas y las restricciones de calendario.</h1>
    <hr />
    <p>
      <b>Instrucciones:</b> <br>En esta página ingresa la información de las fechas
       para la calendarización así  como los restricciones que tengas para el
       sistema en sí, recuerda llenar correctamente bien las fechas ya que el
       sistema tomará estas como base para generar el calendario.
    </p>
    <form action="rFechas">
    <table>
      <tr>
        <th><h3>Rango de fecha para calendarizar:</h3></th>
      </tr>
      <tr>
        <th>Fecha de Inicio:</th>
        <th><input type="date" name="uno" value=""><i>   mm/dd/yyyy</i></th>
      </tr>
      <tr>
        <th>Fecha de Final:</th>
        <th><input type="date" name="dos" value=""><i>   mm/dd/yyyy</i></th>
      </tr>
      <tr>
        <th><h3>Restricciones por día:</h3></th>
      </tr>
      <tr>
          <th></th>
          <th><s:submit value="Enviar" onclick="Aviso();"/> </th>
        <script>
          function Aviso(){
              alert("Dato enviados correctamente");
          }
        </script>
      </tr>
    </table>
    </form>

  </div>
    </body>
</html>
