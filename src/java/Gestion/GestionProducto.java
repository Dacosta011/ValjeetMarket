package Gestion;

import Conexiones.AbstractDB;
import Negocio.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestionProducto extends AbstractDB
{

    public GestionProducto() 
    {
        super();
    }
  
    public boolean guardaProducto(Producto producto)
    {
        boolean todoBien=false;
        try 
        {
            ResultSet res;
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO producto(idProducto,Nombre,Cantidad,PrecioCompra,PrecioVenta,Foto)\n" +
                                                       "        VALUES (?,?,?,?,?,?)");
            
            stmt.setString(1,producto.getIdPo());
            stmt.setString(2,producto.getNombrePo());
            stmt.setString(3,producto.getCantidadPo());
            stmt.setString(4,producto.getPrecioCompraPo());
            stmt.setString(5,producto.getPrecioVentaPo());
            stmt.setString(6,producto.getNombreFotoPo());
            
            stmt.executeUpdate();
            todoBien=true;
            
        }
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
        
        return todoBien;
    }
    public String getPrecio(String Nombre)
    {
        String res="2";
        ArrayList<Producto> producto = this.getTodos();
        
        for (Producto producto1 : producto) 
        {
            if(producto1.getNombrePo().equals(Nombre))
            {
                res=producto1.getPrecioCompraPo();
            }
        }
        return res;
    }
    public Producto buscarProducto(String id) 
    {
        Producto producto=null;
        try 
        {
             ResultSet res;
             PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM producto\n" +
                                                        "        WHERE idProducto ="+id);
             res = stmt.executeQuery();
             
             while(res.next())
             {
                 producto = new Producto();
                 //Demandante demandante = new Demandante();
                 producto.setIdPo(res.getString("idProducto"));
                 producto.setNombrePo(res.getString("Nombre"));
                 producto.setCantidadPo(res.getString("Cantidad"));
                 producto.setPrecioCompraPo(res.getString("PrecioCompra"));
                 producto.setPrecioVentaPo(res.getString("PrecioVenta"));
                 producto.setNombreFotoPo(res.getString("Foto"));
             }
             res.close();   
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return producto;
    }
    
    public boolean eliminarProducto(String id)
    {
        boolean todoBien=false;
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement("DELETE FROM producto\n" +
                                                        "        WHERE idProducto = ?;");
            stmt.setString(1, id);
            stmt.executeUpdate();
            todoBien=true;
        }
        catch (SQLException ex) 
        {
            System.err.println(ex);
        }
        
        return todoBien;
    }
    
    public boolean modificarDemandante(Producto producto,String oldId)
    {
        boolean todoBien=false;
        try 
        {
            ResultSet res;
            PreparedStatement stmt = this.conn.prepareStatement("UPDATE producto SET \n" +
"        idProducto = ?,\n" +
"        Nombre = ?,\n" +
"        Cantidad = ?,\n" +
"        PrecioCompra = ?,\n" +
"        PrecioVenta = ?,\n" +
"        Foto =?\n" +
"        WHERE idProducto= ?;");
            
            stmt.setString(1,producto.getIdPo());
            stmt.setString(2,producto.getNombrePo());
            stmt.setString(3,producto.getCantidadPo());
            stmt.setString(4,producto.getPrecioCompraPo());
            stmt.setString(5,producto.getPrecioVentaPo());
            stmt.setString(6,producto.getNombreFotoPo());
            stmt.setString(7, oldId);
            
            stmt.executeUpdate();
            todoBien=true;
            
        }
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
        return todoBien;
    }
    
    public ArrayList<Producto> getTodos()
    {
        ArrayList<Producto> productos=new ArrayList();
        
        try 
        {
            ResultSet res;
             PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM producto");
             res = stmt.executeQuery();
             while(res.next())
             {
                 Producto producto = new Producto();
                 
                 producto.setIdPo(res.getString("idProducto"));
                 producto.setNombrePo(res.getString("Nombre"));
                 producto.setCantidadPo(res.getString("Cantidad"));
                 producto.setPrecioCompraPo(res.getString("PrecioCompra"));
                 producto.setPrecioVentaPo(res.getString("PrecioVenta"));
                 producto.setNombreFotoPo(res.getString("Foto"));
                 
                 productos.add(producto);
             }
             res.close();   
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return productos;
    }
    public boolean ActualizaDatos(String idproducto, int cantidad)
    {
        boolean actualizado = false;
        
        try 
        {
            ResultSet res;
            PreparedStatement stmt = this.conn.prepareStatement("call actualizaProducto(?,?)");
            
            stmt.setString(1,idproducto);
            stmt.setInt(2,cantidad);
            
            
            res = stmt.executeQuery();
            res.close();
            actualizado=true;
            
        }
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
        return actualizado;
    }
    public boolean ActualizaDatos2(String idproducto, int cantidad)
    {
        boolean actualizado = false;
        
        try 
        {
            ResultSet res;
            PreparedStatement stmt = this.conn.prepareStatement("call actualizaProducto2(?,?)");
            
            stmt.setString(1,idproducto);
            stmt.setInt(2,cantidad);
            
            
            res = stmt.executeQuery();
            res.close();
            actualizado=true;
            
        }
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
        return actualizado;
    }
    public ArrayList<Producto> FiltroHistorialCompra(String f1, String f2)
    {
        ArrayList<Producto> productos=new ArrayList();
        
        try 
        {
             Statement stmt = this.conn.createStatement();
             ResultSet res = stmt.executeQuery("call filtroHistorialCompra(?,?)");
             while(res.next())
             {
                 Producto producto = new Producto();
                 
                 producto.setIdPo(res.getString("idProducto"));
                 producto.setNombrePo(res.getString("Nombre"));
                 producto.setCantidadPo(res.getString("Cantidad"));
                 producto.setPrecioCompraPo(res.getString("PrecioCompra"));
                 producto.setPrecioVentaPo(res.getString("PrecioVenta"));
                 producto.setNombreFotoPo(res.getString("Foto"));
                 
                 productos.add(producto);
             }
             res.close();   
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return productos;
    }
}
