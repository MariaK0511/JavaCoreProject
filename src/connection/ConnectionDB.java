package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
    static final String host = "127.0.0.1";
    static final String post = "5432";
    static final String base = "postgres";
    static final String user = "postgres";
    static final String pass = "root";

    String url = "jdbc:postgresql://" + host + ":" + post + "/" + base;
    Connection connection = null;
    Statement statement = null;

    public Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(url, user, pass);
        if (connection != null) {
            System.out.println("connection ok");
        } else {
            System.out.println("connection failed");
        }
        statement = connection.createStatement();
        return connection;
    }
}
