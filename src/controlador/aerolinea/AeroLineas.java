package controlador.aerolinea;

import vista.aeropuerto.Inicio;
public class AeroLineas {
    private vista.aerolinea.AeroLineas vista;
    
    public AeroLineas(Inicio vistaInicio){
        //creo la vista
        vista = new vista.aerolinea.AeroLineas(vistaInicio,true);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}
