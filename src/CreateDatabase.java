import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) {
        try {
            String URL = "jdbc:mysql://127.0.0.1:3306";
            String USER = "root";
            String PASSWORD = "q1w2e3r4";

            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conn.createStatement();

            String createDatabaseSQL = "" +
                    "CREATE DATABASE IF NOT EXISTS instagram";
            statement.execute(createDatabaseSQL);
            System.out.println("instagram 데이터베이스가 생성되었습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
