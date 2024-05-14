import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Example11 {
    public static void main(String[] args) throws SQLException {

        String URL = "jdbc:mysql://127.0.0.1:3306/instagram";
        String USER = "root";
        String PASSWORD = "q1w2e3r4";

        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = conn.createStatement();

        String SQL = "INSERT INTO post_likes (user_id, post_id) VALUES " +
                "(6, 3), (7, 3), (8, 3), (9, 3), (2, 3);";
        int count = statement.executeUpdate(SQL);

        System.out.println(count);
//        while(rs.next()) {
//            System.out.println(rs.getString("ff.follower_id") + " " + rs.getInt("count(*)"));
//        }
    }
}
