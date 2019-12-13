/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestion.GenerarSerie;
import Gestion.GestionCompra;
import Gestion.GestionProducto;
import Gestion.GestionUsuario;
import Gestion.GestionVenta;
import Negocio.Carrito;
import Negocio.DetalleVen;
import Negocio.Producto;
import Negocio.Usuario;
import Negocio.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Controlador1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String numeroserie = "";

    GestionProducto pg = new GestionProducto();
    Producto pro = new Producto();
    ArrayList<Producto> productos = new ArrayList<Producto>();

    ArrayList<Carrito> carrito = new ArrayList<Carrito>();
    int item = 0;
    int total = 0;
    int cantidad = 1;

    int idp;
    Carrito car = new Carrito();

    Usuario em = new Usuario();
    GestionUsuario edao = new GestionUsuario();

    GestionCompra gcom = new GestionCompra();

    Venta ven = new Venta();
    GestionVenta gven = new GestionVenta();
    ArrayList<Venta> ventas = new ArrayList<Venta>();

    ArrayList<Venta> list = new ArrayList<Venta>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        switch (accion) {
            case "Comprar":
                total = 0;
                idp = Integer.parseInt(request.getParameter("id"));
                pro = pg.buscarProducto(Integer.toString(idp));
                item = item + 1;

                car = new Carrito(item, Integer.parseInt(pro.getIdPo()), pro.getNombrePo(), pro.getNombreFotoPo(), Integer.parseInt(pro.getPrecioVentaPo()), cantidad, cantidad * Integer.parseInt(pro.getPrecioVentaPo()));

                carrito.add(car);

                for (int i = 0; i < carrito.size(); i++) {
                    total = total + carrito.get(i).getSubtotal();
                }

                numeroserie = gven.GenerarSerie();
                if (numeroserie == null) {
                    numeroserie = "000000001";
                    request.setAttribute("nserie", numeroserie);
                } else {
                    int incrementar = Integer.parseInt(numeroserie);
                    GenerarSerie gs = new GenerarSerie();
                    numeroserie = gs.NumeroSerie(incrementar);
                    request.setAttribute("nserie", numeroserie);
                }

                //System.out.println(carrito);
                request.setAttribute("total", total);
                request.setAttribute("usuario", em);
                request.setAttribute("carrito", carrito);
                request.setAttribute("contador", carrito.size());
                request.getRequestDispatcher("carrito.jsp").forward(request, response);

                break;

            case "AgregarCarrito":

                String idus = request.getParameter("idus");
                System.out.println("El id del usuario es " + idus);

                idp = Integer.parseInt(request.getParameter("id"));
                pro = pg.buscarProducto(Integer.toString(idp));
                item = item + 1;

                car = new Carrito(item, Integer.parseInt(pro.getIdPo()), pro.getNombrePo(), pro.getNombreFotoPo(), Integer.parseInt(pro.getPrecioVentaPo()), cantidad, cantidad * Integer.parseInt(pro.getPrecioVentaPo()));

                carrito.add(car);

                System.out.println(carrito);

                numeroserie = gven.GenerarSerie();
                if (numeroserie == null) {
                    numeroserie = "000000001";
                    request.setAttribute("nserie", numeroserie);
                } else {
                    int incrementar = Integer.parseInt(numeroserie);
                    GenerarSerie gs = new GenerarSerie();
                    numeroserie = gs.NumeroSerie(incrementar);
                    request.setAttribute("nserie", numeroserie);
                }

                request.setAttribute("contador", carrito.size());
                request.setAttribute("usuario", em);
                request.getRequestDispatcher("Controlador1?accion=llenar").forward(request, response);

                break;

            case "Carrito":
                total = 0;
                request.setAttribute("carrito", carrito);

                for (int i = 0; i < carrito.size(); i++) {
                    total = total + carrito.get(i).getSubtotal();
                }

                numeroserie = gven.GenerarSerie();
                if (numeroserie == null) {
                    numeroserie = "000000001";
                    request.setAttribute("nserie", numeroserie);
                } else {
                    int incrementar = Integer.parseInt(numeroserie);
                    GenerarSerie gs = new GenerarSerie();
                    numeroserie = gs.NumeroSerie(incrementar);
                    request.setAttribute("nserie", numeroserie);
                }

                request.setAttribute("total", total);
                request.setAttribute("usuario", em);
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;

            case "llenar":

                //carrito.removeAll(carrito);
                productos = pg.getTodos();

                //System.out.println(productos);
                request.setAttribute("contador", carrito.size());
                request.setAttribute("usuario", em);
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("indexVenta.jsp").forward(request, response);

                break;

            case "Buscar":
                ArrayList<Producto> productos2 = new ArrayList<Producto>();

                String nompro = request.getParameter("buscarp");
                System.out.println(nompro);
                productos = pg.getTodos();

                for (Producto producto : productos) {
                    if (producto.getNombrePo().equals(nompro)) {
                        System.out.println(producto);
                        pro = pg.buscarProducto(producto.getIdPo());
                        productos2.add(pro);
                    }
                }
                //System.out.println(productos);

                numeroserie = gven.GenerarSerie();
                if (numeroserie == null) {
                    numeroserie = "000000001";
                    request.setAttribute("nserie", numeroserie);
                } else {
                    int incrementar = Integer.parseInt(numeroserie);
                    GenerarSerie gs = new GenerarSerie();
                    numeroserie = gs.NumeroSerie(incrementar);
                    request.setAttribute("nserie", numeroserie);
                }

                request.setAttribute("contador", carrito.size());
                request.setAttribute("usuario", em);
                request.setAttribute("productos", productos2);
                request.getRequestDispatcher("indexVenta.jsp").forward(request, response);

                break;

            case "Eliminar2":

                int idpro2 = Integer.parseInt(request.getParameter("idp"));
                for (int i = 0; i < carrito.size(); i++) {
                    if (carrito.get(i).getIdProducto() == idpro2) {
                        carrito.remove(i);
                        item = item - 1;
                    }
                }

                numeroserie = gven.GenerarSerie();
                if (numeroserie == null) {
                    numeroserie = "000000001";
                    request.setAttribute("nserie", numeroserie);
                } else {
                    int incrementar = Integer.parseInt(numeroserie);
                    GenerarSerie gs = new GenerarSerie();
                    numeroserie = gs.NumeroSerie(incrementar);
                    request.setAttribute("nserie", numeroserie);
                }
                //request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);

                request.setAttribute("usuario", em);

                break;

            case "Ingresar":

                String user = request.getParameter("txtuser");
                String pass = request.getParameter("txtpass");

                System.out.println("usuario: " + user + " " + "pass: " + pass);

                em = edao.validar(user, pass);

                System.out.println(em);

                if (!"".equals(em.getIdU())) {
                    System.out.println("holaa");
                    if ("Admin".equals(em.getTipo())) {
                        request.setAttribute("usuario", em);
                        request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);

                    } else {
                        request.setAttribute("usuario", em);
                        request.getRequestDispatcher("Controlador1?accion=llenar").forward(request, response);
                    }
                } else {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }

                break;

            case "Salir":

                System.out.println("TODOS SON " + carrito.size());

                carrito.removeAll(carrito);
                list.removeAll(list);

                System.out.println("LOS ELIMINADOS SON " + carrito.size());
                request.getRequestDispatcher("index.jsp").forward(request, response);

                break;

            case "Factura":

                ventas = gven.Buscarenta(em.getIdU());

                numeroserie = gven.GenerarSerie();
                if (numeroserie == null) {
                    numeroserie = "000000001";
                    request.setAttribute("nserie", numeroserie);
                } else {
                    int incrementar = Integer.parseInt(numeroserie);
                    GenerarSerie gs = new GenerarSerie();
                    numeroserie = gs.NumeroSerie(incrementar);
                    request.setAttribute("nserie", numeroserie);
                }
                //request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);

                request.setAttribute("usuario", em);
                request.setAttribute("ventas", ventas);
                request.getRequestDispatcher("FacturasCliente.jsp").forward(request, response);

                break;

            case "Detalle":

                String idven = request.getParameter("idven");

                ArrayList<DetalleVen> detalles = new ArrayList<DetalleVen>();
                DetalleVen detv = new DetalleVen();

                detalles = gven.detalle(idven);

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
                //request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);

                request.setAttribute("usuario", em);
                request.setAttribute("detalles", detalles);
                request.getRequestDispatcher("DetalleVenta.jsp").forward(request, response);

                break;

            case "Compra":
                int abono = 0;
                String sa = request.getParameter("checre");
                boolean cre;

                if ("on".equals(sa)) {
                    cre = true;
                    abono = 0;
                } else {
                    cre = false;
                    abono = total;
                }

                Venta ven = new Venta(numeroserie, em.getIdU(), "2019-12-10", total, abono, cre);

                System.out.println(ven);

                productos = pg.getTodos();
                for (Carrito cars : carrito) {
                    for (Producto pros : productos) {
                        if (cars.getIdProducto() == Integer.parseInt(pros.getIdPo())) {
                            if (cars.getCantidad() > Integer.parseInt(pros.getCantidadPo())) {
                                request.setAttribute("ok", true);
                                request.setAttribute("mens", "No Hay Productos Suficientes Para El Producto " + " " + pros.getNombrePo());

                                System.out.println("No Hay Productos Suficientes Para El Producto " + " " + pros.getNombrePo());

                                carrito.removeAll(carrito);

                                request.getRequestDispatcher("Controlador1?accion=Carrito").forward(request, response);

                                //request.getRequestDispatcher("Controlador1?accion=llenar").forward(request, response);
                            } else if (cars.getCantidad() <= Integer.parseInt(pros.getCantidadPo())) {
                                if (gven.crearVenta(ven) == true) {

                                    for (int i = 0; i < carrito.size(); i++) {
                                        DetalleVen deve = new DetalleVen(numeroserie, Integer.toString(carrito.get(i).getIdProducto()), carrito.get(i).getPrecioCompra(), carrito.get(i).getCantidad());
                                        System.out.println(deve);
                                        gven.crearDetallesVenta(deve);
                                        gven.ClienteProducto(em.getIdU(), Integer.toString(carrito.get(i).getIdProducto()));

                                        pro = pg.buscarProducto(Integer.toString(carrito.get(i).getIdProducto()));

                                        int sac = Integer.parseInt(pro.getCantidadPo()) - carrito.get(i).getCantidad();
                                        pg.ActualizaDatos(Integer.toString(carrito.get(i).getIdProducto()), sac);
                                    }

                                    request.setAttribute("yea", true);

                                    request.getRequestDispatcher("Controlador1?accion=Factura").forward(request, response);
                                    carrito.removeAll(carrito);
                                }
                            }
                        }
                    }

                }

                break;

            case "Registrar":

                String id = request.getParameter("txtid");
                String nom = request.getParameter("txtnom");
                String tip = request.getParameter("tipous");
                String Pass = request.getParameter("txtpass1");

                Usuario us = new Usuario(id, nom, tip, Pass);

                edao.guardaUsuario(us);

                request.getRequestDispatcher("index.jsp").forward(request, response);

                break;

            case "ActualizaCantidad":
                int idp = Integer.parseInt(request.getParameter("idp"));
                int Can = Integer.parseInt(request.getParameter("Cantidad"));

                for (int i = 0; i < carrito.size(); i++) {
                    if (carrito.get(i).getIdProducto() == idp) {
                        carrito.get(i).setCantidad(Can);
                        int st = carrito.get(i).getPrecioCompra() * Can;
                        carrito.get(i).setSubtotal(st);
                    }
                }
                break;

            case "Pagos":

                list.removeAll(list);
                ventas = gven.Buscarenta(em.getIdU());

                for (Venta venta : ventas) {
                    if (venta.getAbono() < venta.getTotal()) {
                        list.add(venta);
                        System.out.println("las facturas son " + list);
                    }
                }
                //request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);

                request.setAttribute("usuario", em);
                request.setAttribute("ventas", list);
                request.getRequestDispatcher("Pagos.jsp").forward(request, response);

                break;

            case "poner":

                String idvent = request.getParameter("idven");

                ventas = gven.Buscarenta(em.getIdU());

                for (Venta venta : ventas) {
                    if (venta.getIdVe().equals(idvent)) {
                        String idv = venta.getIdVe();
                        int tot = venta.getTotal();
                        int deu = venta.getTotal() - venta.getAbono();

                        request.setAttribute("idv", idv);
                        request.setAttribute("tot", tot);
                        request.setAttribute("deu", deu);
                    }
                }
                request.setAttribute("usuario", em);
                request.setAttribute("ventas", list);
                request.getRequestDispatcher("Pagos.jsp").forward(request, response);

                break;

            case "Pagar":

                String idv1 = (request.getParameter("hidd"));
                

                ventas = gven.Buscarenta(em.getIdU());
                if (idv1 != "") 
                {
                    int abn = Integer.parseInt(request.getParameter("txtabon"));
                    for (Venta venta : ventas) {
                        if (venta.getIdVe().equals(idv1)) {
                            if (venta.getAbono() + abn <= venta.getTotal()) {
                                int pg = venta.getAbono() + abn;

                                gven.ActualizaAbono(idv1, pg);

                                request.setAttribute("qw", true);
                                request.getRequestDispatcher("Controlador1?accion=Pagos").forward(request, response);

                                System.out.println("el nuevo abono es de " + pg);
                            } else if (venta.getAbono() + abn > venta.getTotal()) {
                                request.setAttribute("qw", false);
                                request.getRequestDispatcher("Controlador1?accion=Pagos").forward(request, response);
                            }

                        }
                    }
                } else {
                    request.setAttribute("qe", true);
                    request.getRequestDispatcher("Controlador1?accion=Pagos").forward(request, response);
                }

                //System.out.println("el id es "+ idv1+" "+"y el abono es de "+abn);
                break;

            default:

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
