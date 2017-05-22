<%@ include file = "../../header.jsp" %>
<div class="General">
  <h1> Directorio de Involucrados a Notificar</h2>
  <hr />
  <h2>Instrucciones:</h2>
  <p>


  </p>
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
