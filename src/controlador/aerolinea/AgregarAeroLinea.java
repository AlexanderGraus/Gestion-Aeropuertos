package controlador.aerolinea;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import modelo.aerolinea.AeroLinea;
import modelo.aerolinea.AeroLineaModel;
import vista.aeropuerto.Inicio;
import controlador.aeropuerto.InicioController;
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
        
        vista.bAgregar.addActionListener((ActionEvent ae) ->{
            AeroLinea linea = new AeroLinea();
            linea.setNombre(vista.cajaNombre.getText());
            
            //inserto la nueva aerolinea en la BD
            JOptionPane.showMessageDialog(null,(AeroLineaModel.create(linea)) ? 
                    "Aerolinea ingresada con exito": "Error al ingresar la aerolinea");
            
            vista.dispose();
            

        });
    }
}
