package Negocio;

public class Producto 
{
    private String idPo;
    private String nombrePo;
    private String cantidadPo;
    private String precioCompraPo;
    private String precioVentaPo;
    private String nombreFotoPo;
   
    public Producto()
    {
        this.idPo="";
        this.nombrePo="";
        this.cantidadPo="";
        this.precioCompraPo="";
        this.precioVentaPo="";
        this.nombreFotoPo="";
    }

    public Producto(String idPo, String nombrePo, String cantidadPo, String precioCompraPo, String precioVentaPo, String nombreFotoPo) 
    {
        this.idPo = idPo;
        this.nombrePo = nombrePo;
        this.cantidadPo = cantidadPo;
        this.precioCompraPo = precioCompraPo;
        this.precioVentaPo = precioVentaPo;
        this.nombreFotoPo = nombreFotoPo;
    }

    public String getIdPo() {
        return idPo;
    }

    public void setIdPo(String idPo) {
        this.idPo = idPo;
    }

    public String getNombrePo() {
        return nombrePo;
    }

    public void setNombrePo(String nombrePo) {
        this.nombrePo = nombrePo;
    }

    public String getCantidadPo() {
        return cantidadPo;
    }

    public void setCantidadPo(String cantidadPo) {
        this.cantidadPo = cantidadPo;
    }

    public String getPrecioCompraPo() {
        return precioCompraPo;
    }

    public void setPrecioCompraPo(String precioCompraPo) {
        this.precioCompraPo = precioCompraPo;
    }

    public String getPrecioVentaPo() {
        return precioVentaPo;
    }

    public void setPrecioVentaPo(String precioVentaPo) {
        this.precioVentaPo = precioVentaPo;
    }

    public String getNombreFotoPo() {
        return nombreFotoPo;
    }

    public void setNombreFotoPo(String nombreFotoPo) {
        this.nombreFotoPo = nombreFotoPo;
    }

    @Override
    public String toString() {
        return "Producto{" + "idPo=" + idPo + ", nombrePo=" + nombrePo + ", cantidadPo=" + cantidadPo + ", precioCompraPo=" + precioCompraPo + ", precioVentaPo=" + precioVentaPo + ", nombreFotoPo=" + nombreFotoPo + '}';
    }
      
}
