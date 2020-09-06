package controlador.aerolinea;

import java.awt.event.ActionEvent;
import vista.aeropuerto.Inicio;
public class AgregarAeroLinea {
    private vista.aerolinea.AgregarAeroLinea vista;
    
    public AgregarAeroLinea(Inicio vistaInicio){
        this.vista = new vista.aerolinea.AgregarAeroLinea(vistaInicio,true);
        vista.setLocationRelativeTo(null);
        oyentes();
        vista.setVisible(true);
    }

    private void oyentes() {
        vista.bCancelar.addActionListener((ActionEvent ae) -> {
            vista.dispose();
        });
    }
}
