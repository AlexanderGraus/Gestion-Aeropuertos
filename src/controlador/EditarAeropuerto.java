package controlador;

import static gestor_aeropuertos.Gestor_Aeropuertos.controlInicio;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.aerolinea.AeroLinea;
import modelo.aerolinea.AeroLineaModel;
import modelo.aeropuerto.Aeropuerto;
import modelo.aeropuerto.AeropuertoModel;
import vista.Inicio;

public class EditarAeropuerto {

    private vista.AgregarAeropuerto vista;
    private String nombre;

    public EditarAeropuerto(Inicio vistaInicio, String nombre) {
        //voy a usar la misma vista que AgregarAeropuerto pero le cambio los titulos
        this.vista = new vista.AgregarAeropuerto(vistaInicio, true);
        this.vista.etiqTitulo.setText("Editar Aeropuerto");
        this.vista.bAgregar.setText("Editar");
        
        this.nombre = nombre;
        oyentes();
        cargarAeropuerto();
        cargarAeroLineas();
        
        
        this.vista.setVisible(true);

    }

    private void cargarAeropuerto() {
        Aeropuerto aeropuerto = AeropuertoModel.getAeropuertoByNombre(nombre);

        this.vista.cajaNombre.setText(nombre);
        this.vista.cajaCiudad.setText(aeropuerto.getCiudad());
        this.vista.cajaPais.setText(aeropuerto.getPais());

        //cargo las aerolineas en un model
        DefaultListModel modelo = new DefaultListModel();
        for (AeroLinea a : aeropuerto.getLineas()) {
            modelo.addElement(a);
        }

        this.vista.lista.setModel(modelo);
    }
    
    private void cargarAeroLineas() {
        AeroLinea lineas[];

        lineas = AeroLineaModel.getAeroLineas();

        DefaultListModel modeloLista = new DefaultListModel();
        for (AeroLinea linea : lineas) {
            modeloLista.addElement(linea);
        }
        
        

        vista.lista.setModel(modeloLista);
    }
    
    private void oyentes() {
        this.vista.bCancelar.addActionListener((ActionEvent ae) ->{
            this.vista.dispose();
        });
        
        this.vista.bAgregar.addActionListener((ActionEvent ae) ->{
            Aeropuerto aeropuerto = new Aeropuerto();
            
            //cargo los datos del nuevo aeropuerto segun los datos de la vista
            aeropuerto.setNombre(vista.cajaNombre.getText());
            aeropuerto.setCiudad(vista.cajaCiudad.getText());
            aeropuerto.setPais(vista.cajaPais.getText());
            AeroLinea lineas[] = new AeroLinea[vista.lista.getSelectedValuesList().size()];
            lineas = vista.lista.getSelectedValuesList().toArray(lineas);
            aeropuerto.setLineas(lineas);
            
            //el id no lo puedo sacar de la vista sino de la BD
            aeropuerto.setId(AeropuertoModel.getIdAeropuertoByNombre(nombre));

            JOptionPane.showMessageDialog(null, (AeropuertoModel.update(aeropuerto)) ? 
                    "Aeropuerto editado con exito":"Error al editar el aeropuerto");
            controlInicio.cargarAeropuertos();
            vista.dispose();
        });
    }
}

