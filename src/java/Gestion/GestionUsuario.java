package Gestion;

import Conexiones.AbstractDB;
import Negocio.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestionUsuario extends AbstractDB
{
    public GestionUsuario() 
    {
        super();
    }
  
    public boolean guardaUsuario(Usuario usuario)
    {
        boolean todoBien=false;
        try 
        {
            ResultSet res = null;
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO cliente(idCliente,Nombre,Tipo,Clave)\n" +
"        VALUES (?,?,?,?)");
            
            stmt.setString(1,usuario.getIdU());
            stmt.setString(2,usuario.getNombreU());
            stmt.setString(3,usuario.getTipo());
            stmt.setString(4,usuario.getClave());
            
            stmt.executeUpdate();
            todoBien=true;
            
        }
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
        
        return todoBien;
    }
    public boolean validaIngresoCliente(String id, String pass) 
    {
        ArrayList<Usuario> us = this.getTodos();
        boolean oki=false;
        for (Usuario u : us) 
        {
         if(u.getIdU().equals(id) && u.getClave().equals(pass))
         {
             oki=true;
         } 
        }
        return oki;
    }
    
        public boolean validaIngresoAdmin(String id, String pass) 
    {
        ArrayList<Usuario> us = this.getTodos();
        boolean oki=false;
        
        for (Usuario u : us) 
        {
         if(u.getIdU().equals(id) && u.getClave().equals(pass))
         {
             oki=true;
         } 
        }
        return oki;
    }
        public String getTipo(String id) 
    {
        ArrayList<Usuario> us = this.getTodos();
        String oki="";
        for (Usuario u : us) 
        {
         if(u.getIdU().equals(id))
         {
             oki=u.getTipo();
         } 
        }
        return oki;
    }
   
  
    public ArrayList<Usuario> getTodos()
    {
        ArrayList<Usuario> usuarios=new ArrayList();
        
        try 
        {
             Statement stmt = this.conn.createStatement();
             ResultSet res = stmt.executeQuery("SELECT * FROM cliente");
             while(res.next())
             {
                 Usuario usuario = new Usuario();
                 
                 usuario.setIdU(res.getString("idCliente"));
                 usuario.setNombreU(res.getString("Nombre"));
                 usuario.setTipo(res.getString("Tipo"));
                 usuario.setClave(res.getString("Clave"));
                 
                 usuarios.add(usuario);
             }
             res.close();   
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return usuarios;
    }
    
    public Usuario validar(String user, String dni) {
        Usuario em = new Usuario();
        String sql = "SELECT * FROM cliente where idCliente="+user+" and Clave="+dni;
        try {
            ResultSet res;
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            res = stmt.executeQuery();
            while (res.next()) {
                em.setIdU(res.getString("idCliente"));
                em.setNombreU(res.getString("Nombre"));
                em.setTipo(res.getString("Tipo"));
                em.setClave(res.getString("Clave"));
            }
        } catch (Exception e) {
        }
        return em;
    }
    
}
