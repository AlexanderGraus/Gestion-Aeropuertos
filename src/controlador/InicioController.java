package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.table.DefaultTableModel;
import modelo.aeropuerto.Aeropuerto;
import modelo.aeropuerto.AeropuertoModel;
import vista.Inicio;

public class InicioController {
    private Inicio vistaInicio;
    public InicioController(){
        vistaInicio = new Inicio();
        vistaInicio.setVisible(true);
        vistaInicio.setLocationRelativeTo(null);
        
        cargarAeropuertos();
        oyentes();
    }

    protected void cargarAeropuertos() {
        Aeropuerto[] aeros;

            //traigo los aeropuertos de la BD
            aeros = AeropuertoModel.getAeropuertos();
            
            //creo un modelo para la tabla
            DefaultTableModel modeloTabla = new DefaultTableModel();
            
            modeloTabla.addColumn("Nombre del Aeropuerto");
            modeloTabla.addColumn("Ciudad");
            modeloTabla.addColumn("Pais");
            for (Aeropuerto aero : aeros) {
                modeloTabla.addRow(aero.imprimir());
            }
            vistaInicio.tablaAero.setModel(modeloTabla);
            

    }

    private void oyentes() {
        vistaInicio.bAgregar.addActionListener((ActionEvent ae) -> {
            new AgregarAeropuerto(vistaInicio);
        });
        
        vistaInicio.bDatos.addActionListener((ActionEvent ae) -> {
            //guardar el aeropuerto seleccionado
            int fila = vistaInicio.tablaAero.getSelectedRow();
            String nombre = (String)vistaInicio.tablaAero.getModel().getValueAt(fila, 0);
            System.out.println(nombre);
            new VerAeropuerto(vistaInicio,nombre);
        });

    }
}
