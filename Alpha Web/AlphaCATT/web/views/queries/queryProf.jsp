  <%@ include file = "../../header.jsp" %>

  <div class="General">
    <h1>Directorio de Profesores Registrados en la BD:</h2>
    <hr />
    <h3>Instrucciones:</h3>
    <p>
      En este listado se muestran todos los profesores que estan registrados
      en la base de datos.
    </p>
    <h5>Buscador:</h5><input type="text" id="buscador" onkeyup="Filter()" placeholder="Buscar nombres..">

    <!-- struts Form -->
     <table class="Table" id="tabla">
         <h2>Profesores:</h2>
              <thead>
              <th>ID: </th>
              <th>Nombre: </th>
              <th>Apellido Materno: </th>
              <th>Apellido Paterno: </th>
              </thead>
      <tbody>
          <s:iterator value="datos" var="dato" status="estado">
              <tr>
                  <td><s:property value="idProfesor"/> </td>
                  <td><s:property value="nombre"/> </td>
                  <td><s:property value="apaterno"/> </td>
                  <td><s:property value="amaterno"/> </td>
                  <td><s:property value="email"/> </td>
                  <td>
                    <s:a action="dprof">
                    <s:param name="id" value="idProfesor" />
                    <span class="icon-bin"></span>
                    </s:a>
                  </td>
              </tr>
          </s:iterator>
      </tbody>
      </table>
  </div>
  </body>
</html>
