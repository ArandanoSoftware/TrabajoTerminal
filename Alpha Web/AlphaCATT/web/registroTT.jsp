<%--
Trabajo Terminal - pagina para registrar los trabajos terminales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <%--CSS --%>
    <link rel="stylesheet" href="css/master.css">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/breadstyle.css">
    <%--Javascript--%>

    <%--Date picker--%>
    <!-- Include Required Prerequisites -->
    <script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
    <script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap/3/css/bootstrap.css"/>

    <!-- Include Date Range Picker -->
    <script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css"/>

    <title>Restricciones de Fechas para las restricciones de Trabajos
    terminales</title>
  </head>
  <body>
    <div class="MainMenu">
        <div class="Title">
         <ul>
             <li class="Title-item-name"><b>CATT</b> </li>
         </ul>
        </div>
    </div>
  <section class="General">
    <p>
      <b>Instrucciones:</b><br>
      En esta página ingresa el trabaj que quieras registrar para tu trabajo, revisa que todos los datos sean correctos.
    </p>

    <form class="" action="index.html" method="post">


    <table>
      <tr>
        <th># De Trabajo  Terminal:   </th>
        <th><input type="text" name="" value=""></th>
      </tr>
      <tr>
        <th>Nombre del Trabajo  Terminal:   </th>
        <th><input type="text" name="" value=""></th>
      </tr>
      <tr>
        <th># De Trabajo  Terminal:   </th>
        <th>   <input type="text" name="" value=""></th>
      </tr>



    </table>

    </form>

  </section>
  </body>
</html>
