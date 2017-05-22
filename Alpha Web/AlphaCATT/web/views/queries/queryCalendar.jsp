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
      <s:iterator value="CalList" status="estado">
       <tr>
         <td><s:property value="fecha"/></td>
         <td><s:property value="sala"/></td>
         <td><s:property value="tt.idTt"/></td>
         <td><s:property value="tt.nombre"/></td>
         <s:set var="id2" value="#estado.index" />
         <s:iterator value="DirList" begin="#id2" end="#id2">
             <td><s:property value="profesorByD1.nombre"/></td>
             <td><s:property value="profesorByD2.nombre"/></td>
         </s:iterator>
         <s:iterator value="SinList" begin="#id2" end="#id2">
             <td><s:property value="profesorByS1.nombre"/></td>
             <td><s:property value="profesorByS2.nombre"/></td>
             <td><s:property value="profesorByS3.nombre"/></td>
         </s:iterator>
         </tr>
      </s:iterator>
     </tbody>
    </table>
  </div>
</body>
</html>
