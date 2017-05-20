<!-- Sistema de Calendarización de Trabajos Terminales-->
<!-- Login Page  -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <%--DefaultCSS --%>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/breadstyle.css">
    <%--PersonalCSS--%>
    <link rel="stylesheet" href="css/master.css">
    <link rel="stylesheet" href="css/login.css">
    <title> CATT- LOGIN</title>
    <s:head/>
  </head>
  <body>
    <!--Barra General -->
    <div class="TitleBar">
        <div class="Title">
          <ul>
            <li class="Title-item"><img src="img/logoEscom.png" id="logoEscom"></li>
            <li class="Title-item"><b>Sistema de Calendarización de presentaciones de Trabajos Terminales</b></li>
            <li class="Title-item-name">
         </ul>
        </div>
    </div>
    <div class="LoginForm, General" align="center" >
      <h1>CATT</h1>
      <h2>Comision Academica de Trabajos Terminales</h2>
       <hr />

      <div id="login_form">
      <s:form action="loginAction" method="post">
          Nombre de Usuario:   <s:textfield  name="userName" label="Username"  size="20"/>
          Contraseña:   <s:password   name="passWord" label="Password"  size="20"/>
          <s:submit align="center" value="Login"/>
      </s:form>
    </div>
    </div>
  </body>
</html>
