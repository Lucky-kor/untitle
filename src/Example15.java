import java.sql.*;
import java.util.ArrayList;

public class Example15 {
    public static void main(String[] args) throws SQLException {

        String URL = "jdbc:mysql://127.0.0.1:3306/instagram";
        String USER = "root";
        String PASSWORD = "q1w2e3r4";

        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = conn.createStatement();

        String SQL = "DELETE FROM Posts WHERE user_id = 5";
        int count = statement.executeUpdate(SQL);

        System.out.println(count);

//        String SQL2 = "SELECT p.id FROM Posts as p WHERE user_id = 5;";
//
//        ResultSet rs = statement.executeQuery(SQL2);
//
//        ArrayList<Integer> list = new ArrayList<>();
//        while(rs.next()) {
//            list.add(rs.getInt("p.id"));
//        }
//
//        for(Integer idx: list) {
//            PreparedStatement pstm;
//
//            statement.execute("DELETE FROM post_comments WHERE post_id = " + idx);
//
//            pstm = conn.prepareStatement("DELETE FROM post_comments WHERE post_id = ?");
//            pstm.setInt(1, idx);
//
//            pstm.execute();
//
//            pstm = conn.prepareStatement("DELETE FROM post_likes WHERE post_id = ?");
//            pstm.setInt(1, idx);
//
//            pstm.execute();
//
//            pstm = conn.prepareStatement("DELETE FROM posts_hashtags WHERE post_id = ?");
//            pstm.setInt(1, idx);
//
//            pstm.execute();
//            pstm.close();
//        }
//
//        String SQL5 = "DELETE from posts where user_id = 5";
//        statement.executeUpdate(SQL5);

//        PreparedStatement pstm;
//
//        String SQL3 = "DELETE FROM post_comments WHERE post_id = %d";
//        pstm = conn.prepareStatement("DELETE FROM post_comments WHERE post_id = ?");
//        pstm.setInt(1, list.get(0));
//
//        pstm.execute();
//        pstm.close();


    }
}
