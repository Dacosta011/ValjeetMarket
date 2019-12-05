package Gestion;

import Conexiones.AbstractDB;
import Negocio.Compra;
import Negocio.Compra1;
import Negocio.Producto;
import Negocio.Proveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestionCompra extends AbstractDB
{

    public GestionCompra() 
    {
        super();
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
    
    public boolean crearCompra(Compra compra)
    {
        boolean todoBien=false;
        try 
        {
            ResultSet res;
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO compra(IdCompra, Fecha, Total, Credito, Abono, Proveedor)\n" +
                                                        "        VALUES (?,?,?,?,?,?)");
            
            stmt.setString(1,compra.getIdCo());
            stmt.setString(2,compra.getFecha());
            stmt.setInt(3,compra.getTotal());
            stmt.setBoolean(4,compra.isCredito());
            stmt.setInt(5,compra.getAbono());
            stmt.setString(6,compra.getIdP());
            
            stmt.executeUpdate();
            todoBien=true;
            
        }
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
        
        return todoBien;
    }
    
    public boolean ProveedorProducto(String idproveedor, String idproducto)
    {
        boolean todoBien=false;
        try 
        {
            ResultSet res;
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO proveedorproducto(Proveedor, Producto)\n" +
                                                                              "        VALUES (?,?)");
            
            stmt.setString(1,idproveedor);
            stmt.setString(2,idproducto);
            
            
            stmt.executeUpdate();
            todoBien=true;
            
        }
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
        
        return todoBien;
    }
    
    public boolean crearDetalles(String idcompra, String idproducto, double precio, int cantidad) 
    {
        boolean todoBien=false;
        try 
        {
            ResultSet res;
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO detallecompra(idCompra, Producto, Precio, Cantidad)\n" +
                                                                          "        VALUES (?, ? , ? , ?)");
            
            stmt.setString(1,idcompra);
            stmt.setString(2,idproducto);
            stmt.setDouble(3,precio);
            stmt.setInt(4,cantidad);
            
            stmt.executeUpdate();
            todoBien=true;
            
        }
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
        
        return todoBien;
    }
     public ArrayList<Compra> getTodos()
    {
        ArrayList<Compra> compras =new ArrayList();
        
        try 
        {
             Statement stmt = this.conn.createStatement();
             ResultSet res = stmt.executeQuery("call getAllCompras()");
             while(res.next())
             {
                 Compra compra = new Compra();
                 
                 compra.setIdCo(res.getString("IdCompra"));
                 compra.setIdP(res.getString("Proveedor"));
                 compra.setFecha(res.getString("Fecha"));
                 compra.setTotal(Integer.parseInt(res.getString("Total")));
                 compra.setAbono(Integer.parseInt(res.getString("Abono")));
                 int credito = Integer.parseInt(res.getString("Credito"));
        
                 boolean oky;
                 if (credito == 1)
                 {
                    oky = true;
                 } else
                 {
                    oky = false;
                 }
                 compra.setCredito(oky);
                 
                 compras.add(compra);
             }
             res.close();   
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return compras;
    }
     
     public ArrayList<Compra1> getCompraFecha(String inicio, String fin) {
        ArrayList<Compra1> compras = new ArrayList();

        try {

            ResultSet res;
            PreparedStatement stmt = this.conn.prepareStatement("call filtroHistorialCompra(?,?)");
            stmt.setString(1, inicio);
            stmt.setString(2, fin);
            res = stmt.executeQuery();
            while (res.next()) {
                
                Compra1 compra = new Compra1();
                 
                 compra.setIdCo(res.getString("IdCompra"));
                 compra.setIdP(res.getString("Proveedor"));
                 compra.setFecha(res.getString("Fecha"));
                 compra.setTotal(Integer.parseInt(res.getString("Total")));
                 compra.setAbono(Integer.parseInt(res.getString("Abono")));
                 String credito = res.getString("Credito");
                 boolean oky;
                 if (credito == "1")
                 {
                    oky = true;
                 } else
                 {
                    oky = false;
                 }
                 compra.setCredito(oky);
                 
                 compras.add(compra);

            }
            res.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return compras;

    }
     
     public String getNombreP(String id)
     {
         String res=""; 
         GestionProveedor gpr = new GestionProveedor();
          ArrayList<Compra> com = this.getTodos();
          ArrayList<Proveedor> pro = gpr.getTodos();
          
          for (Compra compra : com) 
         {
             for(Proveedor proveedor : pro)
             {
                 if(compra.getIdP().equals(proveedor.getIdP()))
                 {
                     res = proveedor.getNombreP();
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
            PreparedStatement stmt = this.conn.prepareStatement("call modifyAbono(?,?)");
            
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
     
     public String GenerarSerie()
     {
        String numeroserie="";
        String sql="SELECT max(IdCompra) FROM compra";
         
        try {
            ResultSet res;
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            res = stmt.executeQuery();
            
            while (res.next()) {
                numeroserie=res.getString(1);
            }
        } catch (Exception e) {
        }
        return numeroserie;
    }
    
}
