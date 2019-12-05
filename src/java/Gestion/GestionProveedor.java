package Gestion;

import Conexiones.AbstractDB;
import Negocio.Producto;
import Negocio.Proveedor;
import Negocio.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestionProveedor extends AbstractDB
{

    public GestionProveedor() 
    {
        super();
    }
    
    public boolean guardaProveedor(Proveedor proveedor)
    {
        boolean todoBien=false;
        try 
        {
            ResultSet res;
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO proveedor(idProveedor,Nombre)\n" +
                                                        "        VALUES (?,?)");
            
            stmt.setString(1,proveedor.getIdP());
            stmt.setString(2,proveedor.getNombreP());
                       
            stmt.executeUpdate();
            todoBien=true;
            
        }
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
        
        return todoBien;
    }
    
    public ArrayList<Proveedor> getTodos()
    {
        ArrayList<Proveedor> proveedores=new ArrayList();
        
        try 
        {
             ResultSet res;
             PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM proveedor");
             res = stmt.executeQuery();
             while(res.next())
             {
                 Proveedor proveedor = new Proveedor();
                 
                 proveedor.setIdP(res.getString("idProveedor"));
                 proveedor.setNombreP(res.getString("Nombre"));
                 proveedores.add(proveedor);
             }
             res.close();   
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return proveedores;
    }
    
     public Proveedor buscarProveedor(String id) 
    {
       Proveedor proveedor=null;
        try 
        {
             ResultSet res;
             PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM proveedor\n" +
                                                        "        WHERE idProveedor ="+id);
             res = stmt.executeQuery();
             
             while(res.next())
             {
                 proveedor = new Proveedor();
                 
                 proveedor.setIdP(res.getString("idProveedor"));
                 proveedor.setNombreP(res.getString("Nombre"));
             }
             res.close();   
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return proveedor;
    }
    
}
