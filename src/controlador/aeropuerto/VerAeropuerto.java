package controlador.aeropuerto;

import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import modelo.aerolinea.AeroLinea;
import modelo.aeropuerto.Aeropuerto;
import modelo.aeropuerto.AeropuertoModel;
import vista.aeropuerto.Inicio;


public class VerAeropuerto {
    
    private vista.aeropuerto.VerAeropuerto vista;
    private String nombre;
    public VerAeropuerto(Inicio vistaInicio, String nombre){
        this.vista = new vista.aeropuerto.VerAeropuerto(vistaInicio,true);
        this.nombre = nombre;
        cargarAeropuerto();
        oyentes();
        vista.setVisible(true);
        
        
    }

    private void cargarAeropuerto() {
        Aeropuerto aeropuerto = AeropuertoModel.getAeropuertoByNombre(nombre);
        
        vista.cajaNombre.setText(nombre);
        vista.cajaNombre.setEditable(false);
        vista.cajaCiudad.setText(aeropuerto.getCiudad());
        vista.cajaCiudad.setEditable(false);
        vista.cajaPais.setText(aeropuerto.getPais());
        vista.cajaPais.setEditable(false);
        
        //cargo las aerolineas en un model
        DefaultListModel modelo = new DefaultListModel();
        for(AeroLinea a: aeropuerto.getLineas()){
            modelo.addElement(a);
        }
        
        vista.lista.setModel(modelo);
        //vista.lista.setEnabled(false);
    }

    private void oyentes() {
        vista.bCerrar.addActionListener((ActionEvent ae) ->{
            vista.dispose();
        });
    }
    
}
