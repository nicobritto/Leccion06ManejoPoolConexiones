package datos;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    /*subiendo git*/
 /*cadena de conexion hacia  mysql*/
    private static final String JDBC_UR = "jdbc:mysql://localhost:3306/test?useSSl=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";
    
    public static BasicDataSource getDataSource(){
        BasicDataSource ds= new BasicDataSource();
        ds.setUrl(JDBC_UR);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        //definimos el tamaño inicial del pool de conexiones
        ds.setInitialSize(5);
        return ds;
    }

   public static Connection getConnection() throws SQLException {

        return getDataSource().getConnection();

    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Statement smtm) {
        try {
            smtm.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement smtm) {
        try {
            smtm.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
