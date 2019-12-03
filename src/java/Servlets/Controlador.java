/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestion.GestionProducto;
import Negocio.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    Producto p = new Producto();
    GestionProducto pdao = new GestionProducto();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Producto")) {
            switch (accion) 
            {
                case "Listar":
                    ArrayList<Producto> lista = pdao.getTodos();
                    System.out.println(lista);
                    
                    request.setAttribute("productos", lista);
                    break;
                    
                case "Agregar":
                    String id = request.getParameter("txtid");
                    String Nombre = request.getParameter("txtNombres");
                    double pre = Double.parseDouble(request.getParameter("txtPre"));
                    String fot = request.getParameter("txtFoto");
                    
                    
                    p.setIdPo(id);
                    p.setNombrePo(Nombre);
                    p.setCantidadPo("0");
                    p.setPrecioCompraPo(Double.toString(pre));
                    double precioventa = (pre*0.2)+pre;
                    p.setPrecioVentaPo(Double.toString(precioventa));
                    p.setNombreFotoPo(fot);
                    pdao.guardaProducto(p);
         
                    //request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                    
                    
                case "Editar":
                    String idp =(request.getParameter("id"));
                    System.out.println(idp);
                    Producto pr = pdao.buscarProducto(idp);
                    System.out.println(pr);
                    request.setAttribute("productoe", pr);
                    //response.sendRedirect("Controlador?menu=Producto&accion=Listar");
                   // request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                    
                case "Actualizar":
                    String id1 = request.getParameter("txtid");
                    String Nombre1 = request.getParameter("txtNombres");
                    double pre1 = Double.parseDouble(request.getParameter("txtPre"));
                    String fot1 = request.getParameter("txtFoto");
                    
                    p.setIdPo(id1);
                    p.setNombrePo(Nombre1);
                    p.setCantidadPo("0");
                    p.setPrecioCompraPo(Double.toString(pre1));
                    double precioventa1 = (pre1*0.2)+pre1;
                    p.setPrecioVentaPo(Double.toString(precioventa1));
                    p.setNombreFotoPo(fot1);
                    pdao.modificarDemandante(p, id1);
                    //request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                    
                case "Delete":
                    String idp2 = (request.getParameter("id"));
                    pdao.eliminarProducto(idp2);
                    //request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                    
                default:                    
                    throw new AssertionError();
            }
            
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
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
