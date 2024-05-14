import java.sql.*;

public class Example10 {
    public static void main(String[] args) throws SQLException {

        String URL = "jdbc:mysql://127.0.0.1:3306/instagram";
        String USER = "root";
        String PASSWORD = "q1w2e3r4";

        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = conn.createStatement();

        String SQL = "UPDATE Users SET username = 'newUSer1' WHERE username = 'user1'";
        statement.executeUpdate(SQL);

//        while(rs.next()) {
//            System.out.println(rs.getString("ff.follower_id") + " " + rs.getInt("count(*)"));
//        }
    }
}
