package Negocio;

public class Compra1 
{
    private int item;
    private String idCo;
    private String fecha;
    private String descripcion;
    private double precio;
    private int cantidad;
    private double total;
    private double subtotal;
    private boolean credito;
    private int abono;
    private String idP;

    public Compra1()
    {
        this.idCo="";
        this.idP="";
        this.fecha="";
        this.total=0.0;
        this.abono=0;
        this.credito=false;
        this.item=0;
        this.descripcion="";
        this.precio=0.0;
        this.cantidad=0;
        this.subtotal=0.0;
    }

    public Compra1(int item, String idCo, String fecha, String descripcion, double precio, int cantidad, double total, double subtotal, boolean credito, int abono, String idP) {
        this.item = item;
        this.idCo = idCo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = total;
        this.subtotal = subtotal;
        this.credito = credito;
        this.abono = abono;
        this.idP = idP;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getIdCo() {
        return idCo;
    }

    public void setIdCo(String idCo) {
        this.idCo = idCo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public boolean isCredito() {
        return credito;
    }

    public void setCredito(boolean credito) {
        this.credito = credito;
    }

    public int getAbono() {
        return abono;
    }

    public void setAbono(int abono) {
        this.abono = abono;
    }

    public String getIdP() {
        return idP;
    }

    public void setIdP(String idP) {
        this.idP = idP;
    }

    @Override
    public String toString() {
        return "Compra{" + "item=" + item + ", idCo=" + idCo + ", fecha=" + fecha + ", descripcion=" + descripcion + ", precio=" + precio + ", cantidad=" + cantidad + ", total=" + total + ", subtotal=" + subtotal + ", credito=" + credito + ", abono=" + abono + ", idP=" + idP + '}';
    }

    
   

    
}