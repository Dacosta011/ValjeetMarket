package Negocio;

public class Compra 
{
    private String idCo;
    private String fecha;
    private int total;
    private boolean credito;
    private int abono;
    private String idP;

    public Compra()
    {
        this.idCo="";
        this.idP="";
        this.fecha="";
        this.total=0;
        this.abono=0;
        this.credito=false;
    }

    public Compra(String idCo, String fecha, int total, boolean credito, int abono, String idP) {
        this.idCo = idCo;
        this.fecha = fecha;
        this.total = total;
        this.credito = credito;
        this.abono = abono;
        this.idP = idP;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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
        return "Compra{" + "idCo=" + idCo + ", fecha=" + fecha + ", total=" + total + ", credito=" + credito + ", abono=" + abono + ", idP=" + idP + '}';
    }

    
}