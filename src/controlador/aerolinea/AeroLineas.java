package controlador.aerolinea;

import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import modelo.aerolinea.AeroLinea;
import modelo.aerolinea.AeroLineaModel;
import vista.aeropuerto.Inicio;
public class AeroLineas {
    private vista.aerolinea.AeroLineas vista;
    private Inicio vistaInicio;
    public AeroLineas(Inicio vistaInicio){
        //creo la vista
        this.vistaInicio = vistaInicio;
        vista = new vista.aerolinea.AeroLineas(vistaInicio,true);
        vista.setLocationRelativeTo(null);
        cargarAerolineas();
        oyentes();
        vista.setVisible(true);
    }
    
    protected void cargarAerolineas(){
        AeroLinea lineas[] = AeroLineaModel.getAeroLineas();
        
        DefaultListModel modelo = new DefaultListModel();
        for(AeroLinea a: lineas){
            modelo.addElement(a);
        }
        
        vista.lista.setModel(modelo);
    }

    private void oyentes() {
        vista.bAgregar.addActionListener((ActionEvent ae) -> {
            new AgregarAeroLinea(vistaInicio);
            //recargo la lista de aerolineas despues de haber hecho la insercion
            cargarAerolineas();
        });
    }
}
