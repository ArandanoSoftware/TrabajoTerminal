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
        SalaBs.save(s);
        System.out.println(SalaBs.findById(4).getNombre());
        salas = SalaBs.findAll();
        for(int i = 0; i < salas.size(); i++)
        {
            System.out.println("id: " + salas.get(i).getIdSala() + " Nombre: " + salas.get(i).getNombre());
        }
        s.setNombre("la sala nueva nueva");
        s.setIdSala(54);
        SalaBs.update(s);
        salas = SalaBs.findAll();
        for(int i = 0; i < salas.size(); i++)
        {
            System.out.println("id: " + salas.get(i).getIdSala() + " Nombre: " + salas.get(i).getNombre());
        }
        SalaBs.delete(s);
        salas = SalaBs.findAll();
        for(int i = 0; i < salas.size(); i++)
        {
            System.out.println("id: " + salas.get(i).getIdSala() + " Nombre: " + salas.get(i).getNombre());
        }
        //s.setCalendarios((Set<Calendario>) new Calendario());
    }
    
}
