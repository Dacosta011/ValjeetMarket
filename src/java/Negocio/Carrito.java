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
public class Carrito {
    
    int item;
    int idProducto;
    String nombres;
    String nombreFoto;
    int precioCompra;
    int cantidad;
    int subtotal;

    public Carrito() {
    }

    public Carrito(int item, int idProducto, String nombres, String nombreFoto, int precioCompra, int cantidad, int subtotal) {
        this.item = item;
        this.idProducto = idProducto;
        this.nombres = nombres;
        this.nombreFoto = nombreFoto;
        this.precioCompra = precioCompra;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNombreFoto() {
        return nombreFoto;
    }

    public void setNombreFoto(String nombreFoto) {
        this.nombreFoto = nombreFoto;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "Carrito{" + "item=" + item + ", idProducto=" + idProducto + ", nombres=" + nombres + ", nombreFoto=" + nombreFoto + ", precioCompra=" + precioCompra + ", cantidad=" + cantidad + ", subtotal=" + subtotal + '}';
    }
    
    
}
