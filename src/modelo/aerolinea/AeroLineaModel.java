package modelo.aerolinea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static modelo.ConexionBD.getConnection;

public class AeroLineaModel {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public static AeroLinea[] getAeroLineas() {
        AeroLinea lineas[] = null;
        Connection conexion = null;

        try {
            conexion = getConnection();
            ps = conexion.prepareStatement("select count(*) as 'filas' from empresa");
            rs = ps.executeQuery();
            if (rs.next()) {
                lineas = new AeroLinea[rs.getInt("filas")];
            }

            ps = conexion.prepareStatement("select id,nombre from empresa");
            rs = ps.executeQuery();

            int i = 0;
            while (rs.next()) {
                lineas[i] = new AeroLinea(rs.getInt("id"), rs.getString("nombre"));
                i++;
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("SQl Error: " + ex);
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(AeroLineaModel.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return lineas;
    }

    public static boolean create(AeroLinea aerolinea) {
        Connection conexion = null;
        boolean estado = true;
        int res = 0;
        try {
            conexion = getConnection();
            ps = conexion.prepareStatement("INSERT into empresa (nombre) values (?)");

            ps.setString(1, aerolinea.getNombre());

            res = ps.executeUpdate();

            estado = res > 0;

            ps.close();

        } catch (SQLException ex) {
            System.err.println("SQL Error: " + ex);
            estado = false;

        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                System.err.println("SQL Error: " + ex);
            }
        }
        return estado;
    }
}
