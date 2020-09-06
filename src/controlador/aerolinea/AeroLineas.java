package controlador.aerolinea;

import javax.swing.DefaultListModel;
import modelo.aerolinea.AeroLinea;
import modelo.aerolinea.AeroLineaModel;
import vista.aeropuerto.Inicio;
public class AeroLineas {
    private vista.aerolinea.AeroLineas vista;
    
    public AeroLineas(Inicio vistaInicio){
        //creo la vista
        vista = new vista.aerolinea.AeroLineas(vistaInicio,true);
        vista.setLocationRelativeTo(null);
        cargarAerolineas();
        vista.setVisible(true);
    }
    
    private void cargarAerolineas(){
        AeroLinea lineas[] = AeroLineaModel.getAeroLineas();
        
        DefaultListModel modelo = new DefaultListModel();
        for(AeroLinea a: lineas){
            modelo.addElement(a);
        }
        
        vista.lista.setModel(modelo);
    }
}
