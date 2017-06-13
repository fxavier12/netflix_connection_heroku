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
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://ec2-23-21-220-152.compute-1.amazonaws.com:5432/d2g5ka61g7jr8jt";
        Properties props = new Properties();
        props.setProperty("user","cerhbpdhvcekbp");
        props.setProperty("password","a55b0317ddb4fb9128a2a3c103bcd6e6a2ec25e0b08d95dc50601f4f52fff32f");
        props.setProperty("sslmode","require");
        c = DriverManager.getConnection(url, props);
    	System.out.println("banco de dados conectado!");
        return c;
    }

    
}
