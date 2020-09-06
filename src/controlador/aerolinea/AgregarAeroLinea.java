package controlador.aerolinea;

import vista.aeropuerto.Inicio;
public class AgregarAeroLinea {
    private vista.aerolinea.AgregarAeroLinea vista;
    
    public AgregarAeroLinea(Inicio vistaInicio){
        this.vista = new vista.aerolinea.AgregarAeroLinea(vistaInicio,true);
        vista.setLocationRelativeTo(null);

        vista.setVisible(true);
    }
}
