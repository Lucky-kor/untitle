import java.sql.*;

public class Example04 {
    public static void main(String[] args) throws SQLException {

        String URL = "jdbc:mysql://127.0.0.1:3306/instagram";
        String USER = "root";
        String PASSWORD = "q1w2e3r4";

        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = conn.createStatement();

        String SQL = "SELECT message FROM Posts " +
                "WHERE created_at >= CURRENT_TIMESTAMP - INTERVAL 1 DAY";
        ResultSet rs = statement.executeQuery(SQL);

//        rs.last();
//        int length = rs.getRow();
//        rs.beforeFirst();
//        System.out.println(length);
        int count = 0;
        while(rs.next()) {
            System.out.println(rs.getString("message"));
            count++;
        }

        System.out.println(count);
    }
}
