package controlador;

import vista.Inicio;


public class VerAeropuerto {
    
    private vista.VerAeropuerto vista;
    
    public VerAeropuerto(Inicio vistaInicio){
        vista = new vista.VerAeropuerto(vistaInicio,true);
    }
}
