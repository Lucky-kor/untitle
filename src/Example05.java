import java.sql.*;

public class Example05 {
    public static void main(String[] args) throws SQLException {

        String URL = "jdbc:mysql://127.0.0.1:3306/instagram";
        String USER = "root";
        String PASSWORD = "q1w2e3r4";

        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = conn.createStatement();

        String SQL = "SELECT u.username as username , COUNT(p.id) AS post_count " +
                "FROM Users as u " +
                "left join Posts as p ON u.id = p.user_id " +
                "GROUP BY u.username";
        ResultSet rs = statement.executeQuery(SQL);

        while(rs.next()) {
            System.out.println(rs.getString("username") + " " +
                    rs.getString("post_count"));
        }
    }
}
