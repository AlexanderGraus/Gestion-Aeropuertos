package modelo.vuelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static modelo.ConexionBD.getConnection;

public class VueloModel {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public static Vuelo[] getVuelosByIdEmpresa(int idEmpresa) {
        Vuelo vuelos[] = null;
        Connection conexion = null;

        try {
            conexion = getConnection();
            ps = conexion.prepareStatement("SELECT count(id) as 'filas' FROM vuelo WHERE idEmpresa = ?");
            ps.setInt(1, idEmpresa);

            rs = ps.executeQuery();

            if (rs.next()) {
                vuelos = new Vuelo[rs.getInt("filas")];

                ps = conexion.prepareStatement("SELECT id, nombre, origen,destino,precio"
                        + " FROM vuelo WHERE idEmpresa = ?");
                ps.setInt(1, idEmpresa);
                rs = ps.executeQuery();
                
                int i=0;
                while(rs.next()){
                    vuelos[i]= new Vuelo(rs.getInt("id"),rs.getString("nombre"),
                            rs.getString("origen"),rs.getString("destino"),
                            rs.getFloat("precio"), rs.getInt("idEmpresa"));
                    
                    i++;
                }
            }

        } catch (SQLException ex) {
            System.err.println("SQL Error: " + ex);
        }finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                System.err.println("SQL Error: " + ex);
            }
        }
        return vuelos;
    }
}
