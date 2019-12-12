/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author USER
 */
public class DetalleVen 
{
    String idven;
    String producto;
    int precio;
    int cantidad;

    public DetalleVen() {
    }

    public DetalleVen(String idven, String producto, int precio, int cantidad) {
        this.idven = idven;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getIdven() {
        return idven;
    }

    public void setIdven(String idven) {
        this.idven = idven;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DetalleVen{" + "idven=" + idven + ", producto=" + producto + ", precio=" + precio + ", cantidad=" + cantidad + '}';
    }

    
    
    
    
}
