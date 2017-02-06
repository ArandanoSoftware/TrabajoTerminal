/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import com.myapp.bs.SalaBs;
import java.util.List;
import com.myapp.model.Sala;

/**
 *
 * @author root
 */
public class mianPrueba {
    
    public static void main(String[] args) throws Exception 
    {
//        List<Sala> salas;
//        salas = SalaBs.findAll();
//        System.out.println(salas.get(0).getNombre());
//        for(int i = 0; i < salas.size(); i++)
//        {
//            System.out.println("id: " + salas.get(i).getIdSala() + " Nombre: " + salas.get(i).getNombre());
//        }
        
        List<Sala> salas;
        
        Sala s = new Sala("nueva sala");
        for(int i = 18; i < 53; i++)
        {
            if(i == 24)continue;
            s.setIdSala(i);
            SalaBs.delete(s);
        }
        s.setIdSala(56);
        SalaBs.delete(s);
        s.setIdSala(57);
        SalaBs.delete(s);
        s.setIdSala(58);
        SalaBs.delete(s);
        salas = SalaBs.findAll();
        for(int i = 0; i < salas.size(); i++)
        {
            System.out.println("id: " + salas.get(i).getIdSala() + " Nombre: " + salas.get(i).getNombre());
        }
    }
    
}
