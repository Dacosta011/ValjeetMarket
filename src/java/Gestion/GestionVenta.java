package Gestion;

import Conexiones.AbstractDB;
import Negocio.Compra1;
import Negocio.Proveedor;
import Negocio.Usuario;
import Negocio.Venta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestionVenta extends AbstractDB
{

    public GestionVenta()
    {
        super();
    }
    
    public boolean crearVenta(Venta ventis)
    {
        boolean todoBien=false;
        try 
        {
            ResultSet res;
            PreparedStatement stmt = this.conn.prepareStatement("call newVenta(?,?,?,?,?,?)");
            
            stmt.setString(1,ventis.getIdVe());
            stmt.setString(2,ventis.getFecha());
            stmt.setInt(3,ventis.getTotal());
            stmt.setBoolean(4,ventis.isCredito());
            stmt.setInt(5,ventis.getAbono());
            stmt.setString(6,ventis.getIdU());
            
            res = stmt.executeQuery();
            res.close();
            todoBien=true;
            
        }
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
        
        return todoBien;
    }
    
    public boolean ClienteProducto(String idusuario, String idproducto)
    {
        boolean todoBien=false;
        try 
        {
            ResultSet res;
            PreparedStatement stmt = this.conn.prepareStatement("call newClienteProducto(?,?)");
            
            stmt.setString(1,idusuario);
            stmt.setString(2,idproducto);
            
            
            res = stmt.executeQuery();
            res.close();
            todoBien=true;
            
        }
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
        
        return todoBien;
    }
    
    public boolean crearDetallesVenta(String idventa, String idproducto, String precio, String cantidad) 
    {
        boolean todoBien=false;
        try 
        {
            ResultSet res;
            PreparedStatement stmt = this.conn.prepareStatement("call newDetalleVenta(?,?,?,?)");
            
            stmt.setString(1,idventa);
            stmt.setString(2,idproducto);
            stmt.setString(3,precio);
            stmt.setString(4,cantidad);
            
            res = stmt.executeQuery();
            res.close();
            todoBien=true;
            
        }
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
        
        return todoBien;
    }
     public ArrayList<Venta> getTodos()
    {
        ArrayList<Venta> ventas =new ArrayList();
        
        try 
        {
             Statement stmt = this.conn.createStatement();
             ResultSet res = stmt.executeQuery("call getAllVentas()");
             while(res.next())
             {
                 Venta venta = new Venta();
                 
                 venta.setIdVe(res.getString("IdVenta"));
                 venta.setIdU(res.getString("Cliente"));
                 venta.setFecha(res.getString("Fecha"));
                 venta.setTotal(res.getInt("Total"));
                 venta.setAbono(res.getInt("Abono"));
                 int credito = Integer.parseInt(res.getString("Credito"));
                 boolean oky;
                 if (credito == 1)
                 {
                    oky = true;
                 } else
                 {
                    oky = false;
                 }
                 venta.setCredito(oky);
                 
                 ventas.add(venta);
             }
             res.close();   
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return ventas;
    }
     
     public String cambiaa(boolean credito)
     {
         String res="";
         if(credito == true)
         {
             res="Credito";
         }else{
             res="Contado";
         }
         
         return res;
     }
     public ArrayList<Venta> getVentaFecha(String inicio, String fin) {
        ArrayList<Venta> ventas = new ArrayList();

        try {

            ResultSet res;
            PreparedStatement stmt = this.conn.prepareStatement("call filtroHistorialVenta(?,?)");
            stmt.setString(1, inicio);
            stmt.setString(2, fin);
            res = stmt.executeQuery();
            while (res.next()) {
                
                Venta venta = new Venta();
                 
                 venta.setIdVe(res.getString("IdVenta"));
                 venta.setIdU(res.getString("Cliente"));
                 venta.setFecha(res.getString("Fecha"));
                 venta.setTotal(res.getInt("Total"));
                 venta.setAbono(res.getInt("Abono"));
                 int credito = Integer.parseInt(res.getString("Credito"));
                 boolean oky;
                 if (credito == 1)
                 {
                    oky = true;
                 } else
                 {
                    oky = false;
                 }
                 venta.setCredito(oky);
                 
                 ventas.add(venta);

            }
            res.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return ventas;

    }
     
     public String getNombreC(String id)
     {
         String res=""; 
         GestionUsuario gu = new GestionUsuario();
          ArrayList<Venta> ven = this.getTodos();
          ArrayList<Usuario> usa = gu.getTodos();
          
          for (Venta venti : ven) 
         {
             for(Usuario usi : usa)
             {
                 if(venti.getIdU().equals(usi.getIdU()))
                 {
                     res = usi.getNombreU();
                 }
             }
         }
         return res;
     }
      public boolean ActualizaAbono(String idcompra, int abono)
    {
        boolean actualizado = false;
        
        try 
        {
            ResultSet res;
            PreparedStatement stmt = this.conn.prepareStatement("call modifyAbonoCliente(?,?)");
            
            stmt.setString(1,idcompra);
            stmt.setInt(2,abono);
            
            
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
}
