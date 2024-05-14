import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

    public class Example17 {
        public static void main(String[] args) throws SQLException {

            String URL = "jdbc:mysql://127.0.0.1:3306/instagram";
            String USER = "root";
            String PASSWORD = "q1w2e3r4";

            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conn.createStatement();

            String SQL = "DELETE FROM Users WHERE id = 10";
            int count = statement.executeUpdate(SQL);

        }
    }
