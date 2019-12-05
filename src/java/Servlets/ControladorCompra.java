/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestion.GenerarSerie;
import Gestion.GestionCompra;
import Gestion.GestionProducto;
import Gestion.GestionProveedor;
import Negocio.Compra;
import Negocio.Compra1;
import Negocio.Producto;
import Negocio.Proveedor;
import Negocio.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class ControladorCompra extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     Producto pro = new Producto();
        GestionProducto gpro = new GestionProducto();
        Proveedor pr = new Proveedor();
        Gestion.GestionProveedor gpr = new GestionProveedor();
        Compra1 c = new Compra1();
        Compra cm = new Compra();
        GestionCompra gcom = new GestionCompra();
        String numeroserie="";
        String fe="";
        String cre="";
        String dni="";
       
        int Stock;
        ArrayList<Compra1> lista = new ArrayList<Compra1>();
        
    int item = 0;
    String idCo;
    String fecha;
    String descripcion;
    double precio;
    int cantidad=0;
    int total=0;
    double subtotal;
    boolean credito;
    int abono;
    String idP;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
            
    {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        
        if (menu.equals("NuevaVenta")) 
        {
            dni = request.getParameter("codigocliente");
            fe = request.getParameter("fecha");
            cre = request.getParameter("credi");
            descripcion = request.getParameter("nomproducto");

            switch (accion) {
                case "BuscarCliente":
                    
                    System.out.println(cre);
                    pr = gpr.buscarProveedor(dni);
                    request.setAttribute("c", pr);
                    request.setAttribute("fecha", fe);
                    request.setAttribute("credi", cre);
                    request.setAttribute("nserie", numeroserie);
                    
                    break;
                case "BuscarProducto":
                    String id = (request.getParameter("codigoproducto"));
                    pro = gpro.buscarProducto(id);
                    pr = gpr.buscarProveedor(dni);
                    request.setAttribute("c", pr);
                    request.setAttribute("producto", pro);   
                    request.setAttribute("fecha", fe);
                    request.setAttribute("credi", cre);
                    

                    request.setAttribute("totalpagar", total);
                    request.setAttribute("lista", lista); 
                    request.setAttribute("nserie", numeroserie);
                    
                    
                    //request.setAttribute("lista", lista);                    
                    //request.setAttribute("totalpagar", totalPagar);            
                    break;
                    
                case "Agregar":
                    pr = gpr.buscarProveedor(dni);
                    request.setAttribute("c", pr);
                    request.setAttribute("fecha", fe);
                    request.setAttribute("credi", cre);
                    request.setAttribute("nserie", numeroserie);
                    
                    
                    precio = Integer.parseInt(request.getParameter("precio"));
                    cantidad = Integer.parseInt(request.getParameter("cant"));
                    Stock = Integer.parseInt(request.getParameter("stock"));
                    
                    
                    total = 0;
                    item = item + 1;
                    idP = request.getParameter("codigoproducto");
                    descripcion = request.getParameter("nomproducto");
                    precio =Double.parseDouble(request.getParameter("precio"));
                    cantidad = Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio * cantidad;
                    
                    fe = request.getParameter("fecha");
                    cre = request.getParameter("credi");
                    
                    System.out.println(cre);
                    System.err.println(dni);
                    
                    if("si".equals(cre))
                    {
                        credito = true;
                    }else if ("no".equals(cre))
                    {
                        credito = false;
                    }
                    System.out.println(credito);
                    
                    c = new Compra1();
                    
                    c.setItem(item);
                    c.setIdP(idP);
                    c.setDescripcion(descripcion);
                    c.setPrecio(precio);
                    c.setCantidad(cantidad);
                    c.setSubtotal(subtotal);
                    c.setCredito(credito);
                    c.setFecha(fe);
                    c.setIdCo(dni);
                    
                    lista.add(c);
                    
                    
                    for (int i = 0; i < lista.size(); i++) {
                        total = (int) (total + lista.get(i).getSubtotal());
                    }
                    request.setAttribute("totalpagar", total);
                    request.setAttribute("lista", lista);                    
                    break;
                    
                    case "Eliminar":
                    
                    int idp2 = Integer.parseInt(request.getParameter("id"));
                    for (int i = 0; i < lista.size(); i++)
                    {
                        if(lista.get(i).getItem() == idp2)
                        {
                            lista.remove(i);
                            request.getRequestDispatcher("ControladorCompra?menu=NuevaVenta&accion=Agregar").forward(request, response);
                        }
                    }
                    
                    break;
                    
                case "GenerarVenta":
                    //Actualizacion del Stock
                    
                    
                    
                    
                    System.out.println("holaaaaa");
                    
                    for (int i = 0; i < lista.size(); i++) 
                    {
                        
                        System.out.println(lista);
                        Producto pr=new Producto();
                        
                        int cantidad=lista.get(i).getCantidad();
                        String idproducto=lista.get(i).getIdP();
                        
                        
                        GestionProducto gpr = new GestionProducto();
                        pr=gpr.buscarProducto(idproducto);
                        
                        System.out.println(pr.getCantidadPo());
                        
                        int sac=Integer.parseInt(pr.getCantidadPo())+cantidad;
                        gpr.ActualizaDatos(idproducto, sac);
                    }
                    //Guardar Venta
                    
                    request.setAttribute("c", pr);
                    request.setAttribute("fecha", fe);
                    request.setAttribute("credi", cre);
                    
                    System.err.println(c.isCredito());
                    System.err.println(c.getFecha());
                    
                    if(c.isCredito() == true)
                    {
                        abono = 0;
                    }else if(c.isCredito() == false)
                    {
                        abono = total;
                    }
                    System.err.println(abono);
                    
                    cm = new Compra(numeroserie,c.getFecha(), total, c.isCredito(), abono, c.getIdCo());
                    
                    System.out.println("la compra es "+cm);
                     
                    gcom.crearCompra(cm);
                    //Guardar Detalle ventas
                    //int idv=Integer.parseInt(vdao.IdVentas());
                    for (int i = 0; i < lista.size(); i++) 
                    {
                        
                        gcom.crearDetalles(numeroserie, lista.get(i).getIdP(), lista.get(i).getSubtotal(), lista.get(i).getCantidad());
                        gcom.ProveedorProducto(c.getIdCo(), lista.get(i).getIdP());
                        
                    }
                    /*lista=new ArrayList<>();*/
                    
                    request.getRequestDispatcher("ControladorCompra?menu=NuevaVenta&accion=default").forward(request, response);
                    break;
                default:                    
                    c = new Compra1();
                    lista = new ArrayList<Compra1>();
                    item = 0;
                    total = 0;                   
                    numeroserie = gcom.GenerarSerie();
                    if (numeroserie == null) {
                        numeroserie = "000000001";                        
                        request.setAttribute("nserie", numeroserie);
                    } else {
                        int incrementar = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
