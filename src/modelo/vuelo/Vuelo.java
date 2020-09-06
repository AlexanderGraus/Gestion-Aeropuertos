package modelo.vuelo;

//en un vuelo hay muchos pasajeros

import modelo.Pasajero;

public class Vuelo {

    private int id;
    
    private String nombre;

    private String ciudadOrigen;

    private String ciudadDestino;

    private float precio;

    private int idEmpresa;
    
    public Vuelo() {
    }

    public Vuelo(int id,String nombre, String ciudadOrigen, String ciudadDestino, float precio,int idEmpresa) {
        this.id = id;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.precio = precio;
        this.idEmpresa = idEmpresa;
      
    }
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
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
    public int getIdEmpresa(){
        return idEmpresa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
