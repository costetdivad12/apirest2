package mx.edu.iebem.api2.models;

public class empleados {
    private int id;
    private  int checador;
    private String rfc;
    private String nombre_completo;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChecador() {
        return this.checador;
    }

    public void setChecador(int checador) {
        this.checador = checador;
    }

    public String getRfc() {
        return this.rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre_completo() {
        return this.nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }
}

    
