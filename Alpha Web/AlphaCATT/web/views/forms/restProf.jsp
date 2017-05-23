    <%@ include file = "../../header.jsp" %>
    <div class="General">
      <h1>Pagina para Restricciones de Fechas en el horario de los profesores:</h1>
      <hr  />
      <p><b>Instrucciones:</b>
      En la siguiente pagina puedes ingresa  las restricciones de fechas en os horarios
      de los profesores, esto para no calendarizar presentaciones de trabajo terminal
      en esas fechas.
      </p>
      <s:form action="regTt">
        <table>
          <tr>
            <td> Director 1:</td>
            <td><s:select name = "" list="" headerKey="-1" headerValue="--- Secciona ---" /></td>
          </tr>
        </table>
      </s:form>


    </div>
 </body>
</html>
