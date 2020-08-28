package modelo.aeropuerto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ConexionBD;
import modelo.aerolinea.AeroLinea;

public class AeropuertoModel extends ConexionBD {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public static Aeropuerto[] getAeropuertos() {
        Aeropuerto aeros[] = null;
        Connection conexion = null;
        try {
            conexion = getConnection();
            ps = conexion.prepareStatement("select count(*) as 'filas' from aeropuerto");
            rs = ps.executeQuery();
            if (rs.next()) {
                aeros = new Aeropuerto[rs.getInt("filas")];
            }
            rs.close();

            ps = conexion.prepareStatement("select nombre,ciudad,pais from aeropuerto");
            rs = ps.executeQuery();

            int i = 0;
            while (rs.next()) {
                aeros[i] = new Aeropuerto(rs.getString("nombre"), rs.getString("ciudad"), rs.getString("pais"));
                i++;
            }
            rs.close();

        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(AeropuertoModel.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return aeros;
    }

    public static boolean create(Aeropuerto aeropuerto) {
        Connection conexion = getConnection();
        boolean estado = true;
        int res = 0;
        try {
            ps = conexion.prepareStatement("insert into aeropuerto (nombre,ciudad,pais) values (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, aeropuerto.getNombre());
            ps.setString(2, aeropuerto.getCiudad());
            ps.setString(3, aeropuerto.getPais());

            res = ps.executeUpdate();

            if (res > 0) {
                
                ResultSet insertId = ps.getGeneratedKeys();

                if (insertId.next()) {
                    //me guardo el id del ultimo aeropuerto insertado
                    aeropuerto.setId(insertId.getInt(1));
                    
                    //inserto todas las aerolineas de ese aeropuerto
                    for (AeroLinea linea : aeropuerto.getLineas()) {
                        
                        ps = conexion.prepareStatement("insert into `union_empresa_aeropuerto` (`idEmpresa`,`idAeropuerto`) values (?,?)");
                        System.out.println(linea.getId());
                        ps.setInt(1, linea.getId());
                        System.out.println(aeropuerto.getId());
                        ps.setInt(2, aeropuerto.getId());

                        res = ps.executeUpdate();
                        estado = res > 0;

                    }
                }
                ps.close();
            }

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
