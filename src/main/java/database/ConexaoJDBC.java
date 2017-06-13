package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 *
 * @author danmo
 */
public class ConexaoJDBC {
    Connection c;
    public Connection ConectaBD() throws SQLException, ClassNotFoundException{
         String dbUrl = System.getenv("JDBC_DATABASE_URL");
        c = DriverManager.getConnection(dbUrl);
    	System.out.println("banco de dados conectado!");
        return c;
    }

    
}
