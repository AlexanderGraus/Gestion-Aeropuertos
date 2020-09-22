package controlador.aerolinea;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import modelo.aerolinea.AeroLinea;
import modelo.aerolinea.AeroLineaModel;
import vista.aeropuerto.Inicio;
public class EditarAeroLinea {
    private vista.aerolinea.AgregarAeroLinea vista;
    private AeroLinea linea;
    public EditarAeroLinea(Inicio vistaInicio,AeroLinea linea){
        this.vista = new vista.aerolinea.AgregarAeroLinea(vistaInicio,true);
        this.linea = linea;
        //voy a usar la misma vista que AgregarAeroLinea pero le cambio los titulos
        vista.etiqTitulo.setText("Editar Aerolinea");
        vista.bAgregar.setText("Editar");
        vista.setLocationRelativeTo(null);
        oyentes();
        cargarAeroLinea();
        vista.setVisible(true);
    }

    private void oyentes() {
        vista.bCancelar.addActionListener((ActionEvent ae) -> {
            vista.dispose();
        });
        
        vista.bAgregar.addActionListener((ActionEvent ae) ->{
            linea.setNombre(vista.cajaNombre.getText());
            
            //modifico la nueva aerolinea en la BD
            JOptionPane.showMessageDialog(null,(AeroLineaModel.update(linea)) ? 
                    "Aerolinea editada con exito": "Error al editar la aerolinea");
            
            vista.dispose();
            

        });
    }

    private void cargarAeroLinea() {
        vista.cajaNombre.setText(linea.getNombre());
        
    }
}

