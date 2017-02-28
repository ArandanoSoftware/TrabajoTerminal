<%--
Trabajo terminal - Restricciones de Fechas
Pagina para ingresar las restricciones de fechas para las presentaciones de
Trabajos terminales
 --%>
<%--Basic Java Stuff --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <%--CSS --%>
    <link rel="stylesheet" href="css/master.css">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="">
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
      <b>Instrucciones:</b> <br>En esta página ingresa la información de las fechas
       para la calendarización así  como los restricciones que tengas para el
       sistema en sí, recuerda llenar correctamente bien las fechas ya que el
        sistema tomará estas como base para generar el calendario.

    </p>

    <b>Rango de fechas:  </b>
    <input type="text" name="datefilter" value="" />
    <script type="text/javascript" src="js/restriccionesFechas.js"></script>

    <script type="text/javascript">
      $(function() {
      $('input[name="datefilter"]').daterangepicker({
          autoUpdateInput: false,
          locale: {
              cancelLabel: 'Clear'
          }
      });
      $('input[name="datefilter"]').on('apply.daterangepicker', function(ev, picker) {
          $(this).val(picker.startDate.format('MM/DD/YYYY') + ' - ' + picker.endDate.format('MM/DD/YYYY'));
      });
      $('input[name="datefilter"]').on('cancel.daterangepicker', function(ev, picker) {
          $(this).val('');
      });
      });
    </script>



  </section>
  </body>
</html>
