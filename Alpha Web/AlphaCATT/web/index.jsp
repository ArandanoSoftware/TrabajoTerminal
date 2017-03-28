<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>



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
    <div class="MainMenu">
        <div class="Title">
         <ul>
           <li class="Title-item"><img src="img/logoEscom.png" id="logoEscom"></li>
           <li class="Title-item">
            <b><aconym title="Comision Academica de Trabajos Terminales"/>CATT</b>
          </li>
          <li class="Title-item-name"><a href=""class="Title-item-name"></a></li>
         </ul>
        </div>
    </div>

    <div class="LoginForm, General" align="center" >
      <h1> CATT Login : </h1>
      <s:form action="login">
          <s:textfield  name="userName" label="Username" size="20"/>
          <s:password   name="passWord" label="Password" size="20"/>
          <s:submit align="center" value="Login"/>
      </s:form>
    </div>
  </body>
</html>
