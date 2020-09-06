/*
Proyecto para la gestion de multiples aeropuertos.
 */
package gestor_aeropuertos;

import controlador.aeropuerto.InicioController;

/**
 *
 * @author Alexander Graus
 */
public class Gestor_Aeropuertos {


    public static InicioController controlInicio;
    
    public static void main(String[] args) {
        controlInicio = new InicioController();
    }
    
}
