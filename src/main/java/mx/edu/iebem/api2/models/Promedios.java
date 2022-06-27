package mx.edu.iebem.api2.models;

public class Promedios {
    private String Curp;
    private String CT;
    private  String Nombre_full;
    private Double PROMEDIO_NIVEL; 
    private String sello_sep ;
    private String selo_estatal;
    private String folio_sep;
    private String fecha_sep;




    public String getCurp() {
        return this.Curp;
    }

    public void setCurp(String Curp) {
        this.Curp = Curp;
    }

    public String getCT() {
        return this.CT;
    }

    public void setCT(String CT) {
        this.CT = CT;
    }

    public String getNombre_full() {
        return this.Nombre_full;
    }

    public void setNombre_full(String Nombre_full) {
        this.Nombre_full = Nombre_full;
    }

    public Double getPROMEDIO_NIVEL() {
        return this.PROMEDIO_NIVEL;
    }

    public void setPROMEDIO_NIVEL(Double PROMEDIO_NIVEL) {
        this.PROMEDIO_NIVEL = PROMEDIO_NIVEL;
    }

    public String getSello_sep() {
        return this.sello_sep;
    }

    public void setSello_sep(String sello_sep) {
        this.sello_sep = sello_sep;
    }

    public String getSelo_estatal() {
        return this.selo_estatal;
    }

    public void setSelo_estatal(String selo_estatal) {
        this.selo_estatal = selo_estatal;
    }

    public String getFolio_sep() {
        return this.folio_sep;
    }

    public void setFolio_sep(String folio_sep) {
        this.folio_sep = folio_sep;
    }

    public String getFecha_sep() {
        return this.fecha_sep;
    }

    public void setFecha_sep(String fecha_sep) {
        this.fecha_sep = fecha_sep;
    }

}
