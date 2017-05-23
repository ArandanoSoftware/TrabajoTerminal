<%--
Trabajo Terminal - Sistema de generacion de fechas para presentaciones de trabajos terminales
Función: usuarios
Tareas:
  -Gestionar Usuarios CRUD
  -
--%>
    <%@ include file = "../../header.jsp" %>
    <div class="General">
      <h1> Gestión de Usuarios </h1>
      <hr />
      <p>
        <b>Instrucciones:</b>
        La siguiente sección es para gestionar los usuarios que estan registrados
        en el sistema, desde esta pagina puede registra, consultar y elimanar los
        usuarios actuales.
      </p>
      <h3>Registrar Nuevo Usuario</h3>
      <s:form action="regUser">
      <table>
        <tr>
          <th>Nombre de Usuario:</th>
          <th> <input type="text" name="username"  required></th>
        </tr>
        <tr>
          <th>Contraseña:</th>
          <th> <input type="text" name="password"  required></th>
        </tr>
        <tr>
          <th>Tipo:</th>
          <th> <input type="text" name="tipo"  required></th>
        </tr>
      </table>
          <s:submit onsubmit="" value ="Enviar" ></s:submit>
      </s:form>

      <h3>Usuarios Registrados Actualmente</h3>

      <table class="Table" id="tabla">
               <thead>
               <th>ID</th>
               <th>Nombre de usuario</th>
               <th>Contraseña</th>
               <th>Tipo</th>
               </thead>
       <tbody>
           <s:iterator value="ListUser" status="estado">
               <tr>
                   <td><s:property value="idUser"/> </td>
                   <td><s:property value="username"/> </td>
                   <td><s:property value="password"/> </td>
                   <td><s:property value="tipo"/> </td>
                   <td>
                     <s:a action="dUser">
                     <s:param name="id" value="idUser" />
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
