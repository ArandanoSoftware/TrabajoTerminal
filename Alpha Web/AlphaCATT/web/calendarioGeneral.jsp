<%--
Pagina para mostrar la vista general de todos las presentaciones de
de trabajo terminal
 --%>
<%--Basic Java Stuff --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <%--CSS --%>
    <link rel="stylesheet" href="css/master.css">
    <link rel="stylesheet" href="css/calendarioGeneral.css">

    <title>Calendario general de Trabajos Terminales</title>
  </head>
  <body>


<%--Calendar Div --%>
<div id="calendar-wrap">
    		<header>
    			<h1>Presentaciones TT1 - Mayo 2017</h1>
    		</header>
    		<div id="calendar">
    			<ul class="weekdays">
    				<li>Domingo</li>
    				<li>Lunes</li>
    				<li>Martes</li>
    				<li>Miercoles</li>
    				<li>Jueves</li>
    				<li>Viernes</li>
    				<li>Sabado</li>
    			</ul>

    			<!-- Days from previous month -->

    			<ul class="days">
    				<li class="day other-month">
    					<div class="date">27</div>
    				</li>
    				<li class="day other-month">
    					<div class="date">28</div>
    				</li>
    				<li class="day other-month">
    					<div class="date">29</div>
    				</li>
    				<li class="day other-month">
    					<div class="date">30</div>
    				</li>
    				<li class="day other-month">
    					<div class="date">31</div>
    				</li>

    				<!-- Days in current month -->

    				<li class="day">
    					<div class="date">1</div>
    				</li>
    				<li class="day">
    					<div class="date">2</div>
    					<div class="event">
    						<div class="event-desc">
    							TT 2016-A088 - Sala 14
    						</div>
    						<div class="event-time">
    							2:00pm
    						</div>
    					</div>

              <div class="event">
                <div class="event-desc">
                  TT 2016-A088 - Sala 14
                </div>
                <div class="event-time">
                  2:00pm
                </div>
              </div>	<div class="event">
      						<div class="event-desc">
      							TT 2016-A088 - Sala 14
      						</div>
      						<div class="event-time">
      							2:00pm
      						</div>
      					</div>	<div class="event">
        						<div class="event-desc">
        							TT 2016-A088 - Sala 14
        						</div>
        						<div class="event-time">
        							2:00pm
        						</div>
        					</div>	<div class="event">
          						<div class="event-desc">
          							TT 2016-A088 - Sala 14
          						</div>
          						<div class="event-time">
          							2:00pm
          						</div>
          					</div>	<div class="event">
            						<div class="event-desc">
            							TT 2016-A088 - Sala 14
            						</div>
            						<div class="event-time">
            							2:00pm
            						</div>
            					</div>




    				</li>
    			</ul>

    				<!-- Row #2 -->

    			<ul class="days">
    				<li class="day">
    					<div class="date">3</div>
    				</li>
    				<li class="day">
    					<div class="date">4</div>
    				</li>
    				<li class="day">
    					<div class="date">5</div>
    				</li>
    				<li class="day">
    					<div class="date">6</div>
    				</li>
    				<li class="day">
    					<div class="date">7</div>
    				</li>
    				<li class="day">
    					<div class="date">8</div>
    				</li>
    				<li class="day">
    					<div class="date">9</div>
    				</li>
    			</ul>

    				<!-- Row #3 -->

    			<ul class="days">
    				<li class="day">
    					<div class="date">10</div>
    				</li>
    				<li class="day">
    					<div class="date">11</div>
    				</li>
    				<li class="day">
    					<div class="date">12</div>
    				</li>
    				<li class="day">
    					<div class="date">13</div>
    				</li>
    				<li class="day">
    					<div class="date">14</div>
    				</li>
    				<li class="day">
    					<div class="date">15</div>
    				</li>
    				<li class="day">
    					<div class="date">16</div>
    				</li>
    			</ul>

    				<!-- Row #4 -->

    			<ul class="days">
    				<li class="day">
    					<div class="date">17</div>
    				</li>
    				<li class="day">
    					<div class="date">18</div>
    				</li>
    				<li class="day">
    					<div class="date">19</div>
    				</li>
    				<li class="day">
    					<div class="date">20</div>
    				</li>
    				<li class="day">
    					<div class="date">21</div>
    				</li>
    				<li class="day">
    					<div class="date">22</div>
    				</li>
    				<li class="day">
    					<div class="date">23</div>
    				</li>
    			</ul>

    					<!-- Row #5 -->

    			<ul class="days">
    				<li class="day">
    					<div class="date">24</div>
    				</li>
    				<li class="day">
    					<div class="date">25</div>
    				</li>
    				<li class="day">
    					<div class="date">26</div>
    				</li>
    				<li class="day">
    					<div class="date">27</div>
    				</li>
    				<li class="day">
    					<div class="date">28</div>
    				</li>
    				<li class="day">
    					<div class="date">29</div>
    				</li>
    				<li class="day">
    					<div class="date">30</div>
    				</li>
    			</ul>

    			<!-- Row #6 -->

    			<ul class="days">
    				<li class="day">
    					<div class="date">31</div>
    				</li>
    				<li class="day other-month">
    					<div class="date">1</div> <!-- Next Month -->
    				</li>
    				<li class="day other-month">
    					<div class="date">2</div>
    				</li>
    				<li class="day other-month">
    					<div class="date">3</div>
    				</li>
    				<li class="day other-month">
    					<div class="date">4</div>
    				</li>
    				<li class="day other-month">
    					<div class="date">5</div>
    				</li>
    				<li class="day other-month">
    					<div class="date">6</div>
    				</li>
    			</ul>

    		</div><!-- /. calendar -->
    	</div><!-- /. wrap -->


    </body>
  </html>
