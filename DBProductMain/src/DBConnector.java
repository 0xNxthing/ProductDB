import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private final Connection connection;

    public DBConnector() {

        String host = "jdbc:h2:~/test";
        String username = "admin";
        String password = "admin";

        try {
            this.connection = DriverManager.getConnection(host, username, password);
            System.out.println("DB Connected");
        } catch (SQLException e) {
            throw new RuntimeException("DB not connected", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
