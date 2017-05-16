package com.myapp.bs;

import com.myapp.dao.UsuarioDao;
import com.myapp.model.Usuario;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author root
 */
public class UsuarioBs {
    
    public static Usuario findById(int id)
    {
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario u;
        u = usuarioDao.findById(id);
        return u;
    }
    
    public static List<Usuario> findAll()
    {
        UsuarioDao usuarioDao = new UsuarioDao();
        List<Usuario> u = usuarioDao.findAll();
        return u;
    }
    
    
 
    
    public static void update(Usuario u)
    {
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.modify(u);
    }
    
    public static void delete(Usuario u)
    {
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.erase(u);
    }
}
