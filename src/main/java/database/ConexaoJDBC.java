package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author danmo
 */
public class ConexaoJDBC {
    Connection c;
    public Connection ConectaBD() throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection("postgres://cerhbpdhvcekbp:a55b0317ddb4fb9128a2a3c103bcd6e6a2ec25e0b08d95dc50601f4f52fff32f@ec2-23-21-220-152.compute-1.amazonaws.com:5432/d2g5ka61g7jr8ja55b0317ddb4fb9128a2a3c103bcd6e6a2ec25e0b08d95dc50601f4f52fff32f");
    	System.out.println("banco de dados conectado!");
        return c;
    }

    
}
