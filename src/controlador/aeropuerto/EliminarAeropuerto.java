
package controlador.aeropuerto;

import static gestor_aeropuertos.Gestor_Aeropuertos.controlInicio;
import javax.swing.JOptionPane;
import modelo.aeropuerto.AeropuertoModel;

public class EliminarAeropuerto {

    public EliminarAeropuerto(String nombre) {
        int res = JOptionPane.showConfirmDialog (null, "Seguro que desea eliminar el aeropuerto "+nombre+"?",
                "Atencion!",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        
        if(res == 0){
            JOptionPane.showMessageDialog(null, (AeropuertoModel.deleteByNombre(nombre)) ? 
                    "Aeropuerto eliminado con exito!": "Error al eliminar aeropuerto");
            //recargo la lista de aeropuertos
            controlInicio.cargarAeropuertos();
        }
    }
    
}
