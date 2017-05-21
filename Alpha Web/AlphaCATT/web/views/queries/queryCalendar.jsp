    <%@ include file = "../../header.jsp" %>
    <div class="General">
      <h1>Calendario de Presentación de Trabajos Terminales</h1>
      <hr />
      <h3>Instrucciones:</h3>
      <p>
        Este calendario muestra todas  las presentaciones de trabajo terminal
        calendarizadas hasta el momento.
      </p>
    <h2>Calendario General :</h2>

    </div>
    <div class="calendarZone">
    <table class="calendarTable">
             <thead>
              <th class="TableHead">HORA</th>
              <th class="TableHead">LUGAR</th>
              <th class="TableHead">TT</th>
              <th class="TableHead">TITULO</th>
              <th class="TableHead">DIRECTOR 1</th>
              <th class="TableHead">DIRECTOR 2</th>
              <th class="TableHead" colspan="3">SINODALIA</th>
             </thead>
     <tbody>
       <tr>
         <td>18:00 </td>
         <td>Eduardo Torrijos</td>
         <td>2016-A088</td>
         <td>Sistema de claendarización</td>
         <td>Pepe con Apellido</td>
         <td>Toño con Apellido</td>
         <td>El nombre debe de ser largo</td>
         <td>el nombre tiene que ser largo</td>
         <td>e                             </td>
       </tr>
      <s:iterator value="CalList" status="estado">
       <tr>
         <td><s:property value="fecha"/></td>
         <td><s:property value="sala"/></td>
         <td><s:property value="tt.idTt"/></td>
         <td><s:property value="tt"/></td>
      </s:iterator>
      <s:iterator value="Dirige">
      <s:param name="id" value="idTt" />
         <td><s:property value="profesorByD1"/></td>
         <td><s:property value=""/></td>
      </s:iterator>

       </tr>
     </tbody>
    </table>
  </div>
</body>
</html>
