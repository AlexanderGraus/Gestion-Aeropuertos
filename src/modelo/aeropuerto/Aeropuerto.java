package modelo.aeropuerto;

import modelo.aerolinea.AeroLinea;

public class Aeropuerto {
    private int id;
    
    private String nombre;

    private String ciudad;

    private String pais;
    
    private AeroLinea[] lineas;
    
    public Aeropuerto() {
    }

    public Aeropuerto(String nombre, String ciudad, String pais) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
    }
    
    public Aeropuerto(String nombre, String ciudad, String pais,AeroLinea[] lineas) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.lineas = lineas;
    }
    public int getId(){
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public AeroLinea[] getLineas(){
        return lineas;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setLineas(AeroLinea[] lineas){
        this.lineas = lineas;
    }
    public String[] imprimir(){
        String[] aeropuerto = {this.nombre,this.ciudad,this.pais};
        return aeropuerto;
    }
    
}
