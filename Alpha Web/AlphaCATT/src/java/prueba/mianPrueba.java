/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.util.List;
import model.CreoDAO;
import model.Sala;

/**
 *
 * @author root
 */
public class mianPrueba {
    
    public static void main(String[] args) throws Exception 
    {
        List<Sala> salas = null;
        
        CreoDAO dao = new CreoDAO();
        salas = dao.getSalas();
        for(int i = 0; i < salas.size(); i++)
        {
            System.out.println("id: " + salas.get(i).getIdSala() + " Nombre: " + salas.get(i).getNombre());
        }
        
    }
    
}
