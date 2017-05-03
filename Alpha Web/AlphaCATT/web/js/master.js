/*
Trabajo terminal 2017-A088
Funciones generales de Java Script
@robb_1999
*/

//Aviso General

function Filter()
{
  // Declare variables
  var input, filter, table, tr, td, i;
  input = document.getElementById("buscador");
  filter = input.value.toUpperCase();
  table = document.getElementById("tabla");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++)
  {
    td = tr[i].getElementsByTagName("td")[1];
    td2 = tr[i].getElementsByTagName("td")[2];
    td3 = tr[i].getElementsByTagName("td")[3];
    if(td){
        if(td.innerHTML.toUpperCase().indexOf(filter)> -1||
           td2.innerHTML.toUpperCase().indexOf(filter)> -1||
           td3.innerHTML.toUpperCase().indexOf(filter) > -1){
          tr[i].style.display = "";
        }else{
          tr[i].style.display = "none";
        }
    }
  }
}
