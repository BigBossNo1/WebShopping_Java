
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbContext {
    Connection _connection = null;

    public DbContext(String url, String username, String password) {
        try {
            //Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try {
                //connection
                _connection = DriverManager.getConnection(url, username, password);
                System.out.println("connected");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    public DbContext() {
        this("jdbc:sqlserver://localhost:1433;databaseName=Web_Shopping", "sa", "354503");
    }

    public static void main(String[] args) {
        new DbContext();
    }

}

