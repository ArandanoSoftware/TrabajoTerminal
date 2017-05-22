<%@ include file = "../../header.jsp" %>

  <div class="General">
    <h1>Registro de Profesores directores/asesores Externos:</h2>
    <hr />
    <h2>Instrucciones:</h2>
    <p>
      Para facilitar el registro de usuarios puedes cargar el horario en formato excel que se encuentra en el
      sistema c20, para los profesores que sean externos a la institución o que no se encuentren dando clases
      puedes registrarlos de manera manual en el siguiente formulario.
    </p>
    <h3>Cargador de Excel:</h3>
    <s:form action="doUpload" method="post" enctype="multipart/form-data">
        <s:file name="upload" label="File"/>
      <s:submit value="Subir"/>
    </s:form>
    <h3>Formulario de registro:</h3>
    <s:form action="regProf">
    <table>
      <tr>
        <th> Nombre:</th>
        <th> <input type="text" name="nombre" value="" required></th>
      </tr>
      <tr>
        <th> Apellido paterno:</th>
        <th> <input type="text" name="APaterno" value="" required></th>
      </tr>
      <tr>
        <th> Apellido materno:</th>
        <th> <input type="text" name="AMaterno" value=""required></th>
      </tr>
      <tr>
        <th> E-mail:</th>
        <th> <input type="email" name="Email" value=""></th>
      </tr>
    </table>
        <s:submit onsubmit="Aviso();" value ="Eviar" ></s:submit>
    </s:form>
    <script>
      function Aviso(){
          alert("Tus Datos se guardaron correctamente");
      }
    </script>

  </div>
  </body>
</html>
