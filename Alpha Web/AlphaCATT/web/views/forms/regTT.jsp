<%@ include file = "../../header.jsp" %>

    <div class="General">
      <h1>Registro de trabajos terminales</h1>
      <hr />
      <h3>Instrucciones:</h3>
      <p>
        En este cuestionario ingresa los datos del trabajo terminal que quieres
        registrar, revisa cuidadosamente que los datos sean correctos.
      </p>

    <s:form action="regTt">
    <table>
      <tr>
        <th><h3>Datos del trabajo terminal: </h3></th>
      </tr>
      <tr>
        <th>Número de Trabajo  Terminal:</th>
        <th><input type="text" name="tt.idTt"/></th>
      </tr>
      <tr>
        <th>Nombre del Trabajo  Terminal:</th>
        <th><input type="text" name="tt.nombre"></th>
      </tr>
      <tr>
        <th>Nivel del Trabajo  Terminal:</th>
        <th>
          <select name="tt.nivel">
            <option name = "tt.nivel" value="1">Trabajo Terminal 1</option>
            <option name = "tt.nivel" value="2">Trabajo Terminal 2</option>
            <option name = "tt.nivel" value="3">Trabajo Terminal Remedial</option>
          </select>
        </th>
      </tr>

     <tr>
        <th><h3>Ingresa el Nombre de los Directores: </h3></th>
      </tr>

      <tr>
        <th> Director 1:</th>
        <th><s:select name = "directores.profesorByD1" list="profList" headerKey="-1" headerValue="--- Secciona ---" value="1" /></th>
      </tr>
      <tr>
        <th> Director 2:</th>
        <th><s:select name = "directores.profesorByD2" list="profList" headerKey="-1" headerValue="--- Secciona ---" value="2" /></th>
      </tr>
      <tr>
      <!--    <th><h3>Ingresa el Nombre de los sinodales: </h3></th>
      </tr>
      <tr>
        <th> Sinodal 1:</th>
        <th><s:select name = "sinodales.profesorByS1" list="profList" headerKey="-1" headerValue="--- Secciona ---"  value="" /></th>
      </tr>
      <tr>
        <th> Sinodal 2:</th>
        <th><s:select name = "sinodales.profesorByS2" list="profList" headerKey="-1" headerValue="---  Secciona ---" value="" /></th>
      </tr>
      <tr>
        <th> Sinodal 3:</th>
        <th><s:select id="prueba" name = "sinodales.profesorByS3" list="profList" headerKey="-1" headerValue="---  Secciona ---"    value="" /></th>
      </tr>

      <tr>
        <th ><h3>Datos del Alumno: </h3></th>
      </tr>
      <tr>
        <th>Nombre: </th>
        <th><input type="text" name="alumno.nombre" /></th>
      </tr>
      <tr>
        <th>Primer apellido: </th>
        <th><input type="text" name="alumno.apaterno" ></th>
      </tr>
      <tr>
        <th>Segundo apellido: </th>
        <th><input type="text" name="alumno.amaterno"></th>
      </tr>
      <tr>
        <th>Email: </th>
        <th><input type="email" name="alumno.email"></th>
      </tr>
      <tr>
        <th>Telefono: </th>
        <th><input type="tel" name="alumno.telefono"></th>
      </tr> -->
      <tr>
        <td rowspan="2"><s:submit onsubmit="Aviso();" value ="Enviar" ></s:submit></td>
      </tr>
    </table>
      </s:form>
      <script>
          function Aviso(){
              alert("Informacion enviada para registro de Tranajo Termninal");
          }
        </script>
    </div>
  </body>
</html>
