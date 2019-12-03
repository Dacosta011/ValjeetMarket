package Negocio;

public class Proveedor 
{
    private String idP;
    private String nombreP;

    public Proveedor()
    {
        this.idP="";
        this.nombreP="";
    }

    public Proveedor(String idP, String nombreP) 
    {
        this.idP = idP;
        this.nombreP = nombreP;
    }

    public String getIdP() {
        return idP;
    }

    public void setIdP(String idP) {
        this.idP = idP;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "idP=" + idP + ", nombreP=" + nombreP + '}';
    }   
}