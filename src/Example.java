import java.sql.*;

public class Example {
    public static void main(String[] args) throws SQLException {

        String URL = "jdbc:mysql://127.0.0.1:3306/instagram";
        String USER = "root";
        String PASSWORD = "q1w2e3r4";

        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = conn.createStatement();

        String SQL = "SELECT username, password FROM Users";
        ResultSet rs = statement.executeQuery(SQL);

        while(rs.next()) {
            System.out.println(rs.getString("username") + " " +
                    rs.getString("password"));
        }
    }
}
