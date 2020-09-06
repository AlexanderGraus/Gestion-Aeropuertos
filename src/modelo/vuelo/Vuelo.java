package modelo;

//en un vuelo hay muchos pasajeros
public class Vuelo {

    private String id;

    private String ciudadOrigen;

    private String ciudadDestino;

    private float precio;

    private Pasajero listaPasajeros[];

    private int pasajerosMax;

    private int pasajerosReserv;

    public Vuelo() {
    }

    public Vuelo(String id, String ciudadOrigen, String ciudadDestino, float precio, int pasajerosMax) {
        this.id = id;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.precio = precio;
        this.pasajerosMax = pasajerosMax;
        this.pasajerosReserv = 0;//cuando creo un vuelo nuevo no tiene pasajeros ya reservados
        this.listaPasajeros = new Pasajero[pasajerosMax];// la lista de pasajeros va a tener como numero max la capacidad del avion.
    }
    
    
    public void agregarPasajero(Pasajero pasajero) {
        
        listaPasajeros[pasajerosReserv] = pasajero;
        pasajerosReserv++;
    }
    
    /*hay dos maneras de acceder a un pasajero:
    o a traves de su pasaporte
    o a traves de su iterador en la lista pasajeros[]
    */
    
    public Pasajero getPasajero(String pasaporte) {
        Pasajero p = null;
        for(int i=0;i<listaPasajeros.length;i++){
            if(pasaporte.equals(listaPasajeros[i].getPasaporte())){
                p = listaPasajeros[i];
                break;
            }
        }
        return p;
    }
    
    public Pasajero getPasajero(int i) {
        if(i>=listaPasajeros.length){
            //si el iterador marca una posicion que no existe en el arreglo
            //ese pasajero no existe
            return null;
        }else{
            return listaPasajeros[i];
        }
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

    public int getPasajerosMax() {
        return pasajerosMax;
    }

    public int getPasajerosReserv() {
        return pasajerosReserv;
    }
    
}
