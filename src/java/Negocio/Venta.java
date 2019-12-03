package Negocio;

public class Venta 
{
    private String idVe;
    private String idU;
    private String fecha;
    private int total;
    private int abono;
    private boolean credito;

    public Venta()
    {
        this.idVe="";
        this.idU="";
        this.fecha="";
        this.total=0;
        this.abono=0;
        this.credito=false;
    }

    public Venta(String idVe, String idU, String fecha, int total, int abono, boolean credito) {
        this.idVe = idVe;
        this.idU = idU;
        this.fecha = fecha;
        this.total = total;
        this.abono = abono;
        this.credito = credito;
    }

    public String getIdVe() {
        return idVe;
    }

    public void setIdVe(String idVe) {
        this.idVe = idVe;
    }

    public String getIdU() {
        return idU;
    }

    public void setIdU(String idU) {
        this.idU = idU;
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

    public int getAbono() {
        return abono;
    }

    public void setAbono(int abono) {
        this.abono = abono;
    }

    public boolean isCredito() {
        return credito;
    }

    public void setCredito(boolean credito) {
        this.credito = credito;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVe=" + idVe + ", idU=" + idU + ", fecha=" + fecha + ", total=" + total + ", abono=" + abono + ", credito=" + credito + '}';
    }
    

}