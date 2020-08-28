package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD{
    
    public static Connection getConnection() {
    Connection conexion = null;
    
    //modificar estos valores segun tu base de datos
    String nombreBD ="aeropuertos", user = "root", password ="";
    
    try {
        
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/"+nombreBD+
                "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                user,password);
    } catch (SQLException ex) {
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }
    return conexion;
    }
}
