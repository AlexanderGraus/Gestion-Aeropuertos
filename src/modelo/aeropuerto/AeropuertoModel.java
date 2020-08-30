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

            ps = conexion.prepareStatement("SELECT nombre,ciudad,pais from aeropuerto ORDER BY nombre ASC");
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

    public static Aeropuerto getAeropuertoByNombre(String nombre) {
        Aeropuerto aeropuerto = new Aeropuerto();
        Connection conexion = null;
        AeroLinea[] lineas= null;

        try {
            conexion = getConnection();

            //pregunto primero cuantas aerolineas tiene ese aeropuerto
            ps = conexion.prepareStatement("SELECT COUNT(e.id) AS filas FROM aeropuerto "
                    + "INNER JOIN union_empresa_aeropuerto AS uea ON aeropuerto.id = uea.idAeropuerto "
                    + "INNER JOIN empresa AS e ON uea.idEmpresa= e.id AND aeropuerto.nombre = ?");
            ps.setString(1, nombre);
            rs = ps.executeQuery();

            if (rs.next()) {
                //creo el vector con tantos lugares como aerolineas
                int nLineas = rs.getInt("filas");
                
                lineas = new AeroLinea[nLineas];
                
                //hago la consulta para todos los datos de ese aeropuerto
                ps = conexion.prepareStatement("SELECT a.id, a.ciudad, a.pais,"
                        + " e.id as idLinea, e.nombre as nombreLinea FROM aeropuerto AS a "
                        + "INNER JOIN union_empresa_aeropuerto AS uea ON a.id = uea.idAeropuerto "
                        + "INNER JOIN empresa AS e ON uea.idEmpresa= e.id AND a.nombre = ?");
                ps.setString(1, nombre);
                rs = ps.executeQuery();
                
                int i=0;
                while(rs.next()){
                    if(i==0){
                        aeropuerto.setId(rs.getInt("id"));
                        aeropuerto.setNombre(nombre);
                        aeropuerto.setCiudad(rs.getString("ciudad"));
                        aeropuerto.setPais(rs.getString("pais"));
                        lineas[i] = new AeroLinea(rs.getInt("idLinea"),rs.getString("nombreLinea"));
                        
                        i++;
                    }else{
                        lineas[i] = new AeroLinea(rs.getInt("idLinea"),rs.getString("nombreLinea"));
                        i++;
                        
                    }
                }
                ps.close();
                aeropuerto.setLineas(lineas);
            }
        } catch (SQLException ex) {
            System.err.println("SQL Error: " + ex);
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                System.err.println("SQL Error: " + ex);
            }
        }
        return aeropuerto;
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
                        ps.setInt(1, linea.getId());
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
