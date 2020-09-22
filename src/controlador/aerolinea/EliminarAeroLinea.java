/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.aerolinea;

import javax.swing.JOptionPane;
import modelo.aerolinea.AeroLinea;
import modelo.aerolinea.AeroLineaModel;


/**
 *
 * @author ale61
 */
public class EliminarAeroLinea {

    public EliminarAeroLinea(AeroLinea linea) {
        int res = JOptionPane.showConfirmDialog (null, "Seguro que desea eliminar la aerolinea "+linea.getNombre()+"?",
                "Atencion!",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        
        if(res == 0){
            JOptionPane.showMessageDialog(null, (AeroLineaModel.delete(linea)) ? 
                    "Aerolinea eliminada con exito!": "Error al eliminar la aerolinea");
        }
    }
    
}
