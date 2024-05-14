import java.sql.*;

public class Example09 {
    public static void main(String[] args) throws SQLException {

        String URL = "jdbc:mysql://127.0.0.1:3306/instagram";
        String USER = "root";
        String PASSWORD = "q1w2e3r4";

        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = conn.createStatement();

        String SQL = "select ff.follower_id , count(*) " +
                "from follow_follower ff " +
                "group by ff.follower_id " +
                "having count(*) = (select MAX(cnt) from ( " +
                "select count(*) as cnt " +
                "from follow_follower ff " +
                "group by ff.follower_id " +
                ") as sq)";
        ResultSet rs = statement.executeQuery(SQL);

        while(rs.next()) {
            System.out.println(rs.getString("ff.follower_id") + " " + rs.getInt("count(*)"));
        }
    }
}
