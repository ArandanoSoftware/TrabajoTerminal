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
    <title> CATT- LOGIN</title>
  </head>
  <body>
    <div class="TitleBar">
        <div class="Title">
          <ul>
            <li class="Title-item"><img src="img/logoEscom.png" id="logoEscom"></li>
            <li class="Title-item"><b><aconym title="Comision Academica de Trabajos Terminales"/>Sistema de Calendarización de presentaciones de Trabajos Terminales - "JUANITA 2.0" </b></li>
            <li class="Title-item-name">
         </ul>
        </div>
    </div>
    <div class="LoginForm, General" align="center" >
      <h1> CATT Login : </h1>
      <s:actionerror/>
      <s:form action="home" method="post">
          <s:textfield  name="userName" label="Username" size="20"/>
          <s:password   name="passWord" label="Password" size="20"/>
          <s:submit align="center" value="Login"/>
      </s:form>

    </div>
  </body>
</html>
