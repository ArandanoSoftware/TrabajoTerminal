/*
Trabajo terminal 2017-A088
Funciones generales de Java Script
@robb_1999
*/

//Función de Saludo para Home(Prueba)
function greeting(){
  var today= new Date();
  var hournow= today.getHours();
  var greeting;

  if (hournow > 18){
    greeting= 'Buenas Noches';
  }else if (hournow > 12) {
    greeting= 'Buenas Tardes';
  }else if (hournow > 0) {
    greeting= 'Buenos Días';
  }else {
    greeting= 'Bienvenido';
  }

  document.write('<h1>'+ greeting +'</h1>');
}
// Disable Input Text
function enableDisable(bEnable, textBoxID)
   {
        document.getElementById(textBoxID).disabled = !bEnable
   }
