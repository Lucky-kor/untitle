import java.sql.*;

    import java.sql.*;

    public class Example03 {
        public static void main(String[] args) throws SQLException {

            String URL = "jdbc:mysql://127.0.0.1:3306/instagram";
            String USER = "root";
            String PASSWORD = "q1w2e3r4";

            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conn.createStatement();

            String SQL = "select distinct u.username from users u " +
                    "join posts p " +
                    "on u.id = p.user_id ";
            ResultSet rs = statement.executeQuery(SQL);

            while(rs.next()) {
                System.out.println(rs.getString("username"));
            }
        }
    }
