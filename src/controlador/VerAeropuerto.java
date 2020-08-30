package controlador;

import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import modelo.aerolinea.AeroLinea;
import modelo.aeropuerto.Aeropuerto;
import modelo.aeropuerto.AeropuertoModel;
import vista.Inicio;


public class VerAeropuerto {
    
    private vista.VerAeropuerto vista;
    private String nombre;
    public VerAeropuerto(Inicio vistaInicio, String nombre){
        this.vista = new vista.VerAeropuerto(vistaInicio,true);
        this.nombre = nombre;
        cargarAeropuerto();
        oyentes();
        vista.setVisible(true);
        
        
    }

    private void cargarAeropuerto() {
        Aeropuerto aeropuerto = AeropuertoModel.getAeropuertoByNombre(nombre);
        
        vista.cajaNombre.setText(nombre);
        vista.cajaCiudad.setText(aeropuerto.getCiudad());
        vista.cajaPais.setText(aeropuerto.getPais());
        
        //cargo las aerolineas en un model
        DefaultListModel modelo = new DefaultListModel();
        for(AeroLinea a: aeropuerto.getLineas()){
            modelo.addElement(a);
        }
        
        vista.lista.setModel(modelo);
    }

    private void oyentes() {
        vista.bCerrar.addActionListener((ActionEvent ae) ->{
            vista.dispose();
        });
    }
    
}
