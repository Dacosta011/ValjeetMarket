package Negocio;

public class Usuario 
{
    private String idU;
    private String nombreU;
    private String tipo;
    private String clave;

    public Usuario()
    {
        this.idU="";
        this.nombreU="";
        this.tipo="";
        this.clave="";
    }
    
    public Usuario(String idU, String nombreU, String tipo, String clave) 
    {
        this.idU = idU;
        this.nombreU = nombreU;
        this.tipo = tipo;
        this.clave = clave;
    }

    public String getIdU() {
        return idU;
    }

    public void setIdU(String idU) {
        this.idU = idU;
    }

    public String getNombreU() {
        return nombreU;
    }

    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idU=" + idU + ", nombreU=" + nombreU + ", tipo=" + tipo + ", clave=" + clave + '}';
    }
       
}