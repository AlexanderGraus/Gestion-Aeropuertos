package modelo.vuelo;

//en un vuelo hay muchos pasajeros

import modelo.Pasajero;

public class Vuelo {

    private String id;

    private String ciudadOrigen;

    private String ciudadDestino;

    private float precio;

    private int idEmpresa;
    
    public Vuelo() {
    }

    public Vuelo(String id, String ciudadOrigen, String ciudadDestino, float precio,int idEmpresa) {
        this.id = id;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.precio = precio;
        this.idEmpresa = idEmpresa;
      
    }
    
    public String getId() {
        return id;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public float getPrecio() {
        return precio;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    
}
