import java.sql.*;

public class Example07 {
    public static void main(String[] args) throws SQLException {

        String URL = "jdbc:mysql://127.0.0.1:3306/instagram";
        String USER = "root";
        String PASSWORD = "q1w2e3r4";

        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = conn.createStatement();

        String SQL = "SELECT p.id as id, count(pl.id) as count from Posts as p " +
                "join post_likes as pl " +
                "on pl.post_id = p.id " +
                "group by p.id " +
                "having count >= 5";
        ResultSet rs = statement.executeQuery(SQL);

        while(rs.next()) {
            System.out.println(rs.getString("id") + " " + rs.getInt("count"));
        }
    }
}
