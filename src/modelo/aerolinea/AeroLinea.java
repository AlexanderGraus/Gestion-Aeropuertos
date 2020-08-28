package modelo.aerolinea;

public class AeroLinea {
    private int id;
    
    private String nombre;

    public AeroLinea() {
    }

    public AeroLinea(String nombre) {
        this.nombre = nombre;
        
    }

    public int getId(){
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
