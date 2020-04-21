package Gestion;

import Conexiones.AbstractDB;
import Negocio.Compra1;
import Negocio.DetalleVen;
import Negocio.Proveedor;
import Negocio.Usuario;
import Negocio.Venta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestionVenta extends AbstractDB {

    public GestionVenta() {
        super();
    }

    public boolean crearVenta(Venta ventis) {
        boolean todoBien = false;
        try {
            ResultSet res;
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO venta(idVenta, Fecha, Total, Credito, Abono, Cliente)\n" +
                                                        "        VALUES (?,?,?,?,?,?);");

            stmt.setString(1, ventis.getIdVe());
            stmt.setString(2, ventis.getFecha());
            stmt.setInt(3, ventis.getTotal());
            stmt.setBoolean(4, ventis.isCredito());
            stmt.setInt(5, ventis.getAbono());
            stmt.setString(6, ventis.getIdU());

            stmt.executeUpdate();
            todoBien = true;

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return todoBien;
    }

    public boolean ClienteProducto(String idusuario, String idproducto) {
        boolean todoBien = false;
        try {
            ResultSet res;
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO cliente-producto(Cliente, Producto)\n" +
                                                        "        VALUES (?,?)");

            stmt.setString(1, idusuario);
            stmt.setString(2, idproducto);

            stmt.executeUpdate();
            todoBien = true;

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return todoBien;
    }

    public boolean crearDetallesVenta(DetalleVen detv) {
        boolean todoBien = false;
        try {
            ResultSet res;
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO detalleventa(idVenta, Producto, Precio, Cantidad)\n" +
                                                        "        VALUES (?, ? , ? , ?)");

            stmt.setString(1, detv.getIdven());
            stmt.setString(2, detv.getProducto());
            stmt.setInt(3, detv.getPrecio());
            stmt.setInt(4, detv.getCantidad());

            stmt.executeUpdate();
            todoBien = true;

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return todoBien;
    }

    public ArrayList<Venta> getTodos() {
        ArrayList<Venta> ventas = new ArrayList();

        try {
            Statement stmt = this.conn.createStatement();
            ResultSet res = stmt.executeQuery("call getAllVentas()");
            while (res.next()) {
                Venta venta = new Venta();

                venta.setIdVe(res.getString("IdVenta"));
                venta.setIdU(res.getString("Cliente"));
                venta.setFecha(res.getString("Fecha"));
                venta.setTotal(res.getInt("Total"));
                venta.setAbono(res.getInt("Abono"));
                int credito = Integer.parseInt(res.getString("Credito"));
                boolean oky;
                if (credito == 1) {
                    oky = true;
                } else {
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

    public String cambiaa(boolean credito) {
        String res = "";
        if (credito == true) {
            res = "Credito";
        } else {
            res = "Contado";
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
                if (credito == 1) {
                    oky = true;
                } else {
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

    public String getNombreC(String id) {
        String res = "";
        GestionUsuario gu = new GestionUsuario();
        ArrayList<Venta> ven = this.getTodos();
        ArrayList<Usuario> usa = gu.getTodos();

        for (Venta venti : ven) {
            for (Usuario usi : usa) {
                if (venti.getIdU().equals(usi.getIdU())) {
                    res = usi.getNombreU();
                }
            }
        }
        return res;
    }

    public boolean ActualizaAbono(String idcompra, int abono) {
        boolean actualizado = false;

        try {
            ResultSet res;
            PreparedStatement stmt = this.conn.prepareStatement("UPDATE venta SET \n" +
                                                        "        Abono = ?\n" +
                                                        "        WHERE idVenta=?");

            stmt.setInt(1, abono);
            stmt.setString(2, idcompra);

            stmt.executeUpdate();
            actualizado = true;

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return actualizado;
    }

    public ArrayList<Venta> Buscarenta(String clie) {
        ArrayList<Venta> ventas = new ArrayList();

        try {
            ResultSet res;
            PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM venta where Cliente =" + clie);
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
                if (credito == 1) {
                    oky = true;
                } else {
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

    public ArrayList<DetalleVen> detalle(String fact) 
    {
        
        ArrayList<DetalleVen> detalles = new ArrayList<DetalleVen>();

        try {
            ResultSet res;
            PreparedStatement stmt = this.conn.prepareStatement("SELECT detalleventa.idVenta,producto.Nombre,detalleventa.Precio,detalleventa.Cantidad FROM detalleventa\n"
                                                                + "inner join producto\n"
                                                                + "on detalleventa.Producto = \n"
                                                                + "producto.idProducto\n"
                                                                + "where idVenta="+fact);
            res = stmt.executeQuery();
            while (res.next()) {
                DetalleVen detv = new DetalleVen();
                
                detv.setIdven(res.getString("idVenta"));
                detv.setProducto(res.getString("Nombre"));
                detv.setPrecio(res.getInt("Precio"));
                detv.setCantidad(res.getInt("Cantidad"));

                detalles.add(detv);
            }
            res.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return detalles;
    }
    
    public String GenerarSerie()
     {
        String numeroserie="";
        String sql="SELECT max(idVenta) FROM venta";
         
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
