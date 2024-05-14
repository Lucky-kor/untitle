import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
    public static void main(String[] args) {
        try {
            String URL = "jdbc:mysql://127.0.0.1:3306/instagram";
            String USER = "root";
            String PASSWORD = "q1w2e3r4";

            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conn.createStatement();

            String usersSQL = "CREATE TABLE Users ( " +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "username VARCHAR(255) NOT NULL, " +
                    "password VARCHAR(255) NOT NULL)";
            statement.execute(usersSQL);

            String follow_followerSQL = "CREATE TABLE follow_follower ( " +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "follower_id INT, " +
                    "user_id INT, " +
                    "FOREIGN KEY (follower_id) REFERENCES Users(id) ON DELETE CASCADE, " +
                    "FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE CASCADE)";

            statement.execute(follow_followerSQL);
            String postsSQL = "CREATE TABLE Posts ( " +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "image BLOB, " +
                    "message TEXT, " +
                    "created_at DATETIME DEFAULT CURRENT_TIMESTAMP, " +
                    "total_likes INT, " +
                    "total_comments INT, " +
                    "user_id INT, " +
                    "FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE CASCADE)";

            statement.execute(postsSQL);
            String hashtagSQL = "CREATE TABLE hashtags ( " +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(255))";

            statement.execute(hashtagSQL);
            String posthashtagSQL = "CREATE TABLE posts_hashtags ( " +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "hashtag_id INT, " +
                    "post_id INT, " +
                    "FOREIGN KEY (hashtag_id) REFERENCES hashtags(id) ON DELETE CASCADE, " +
                    "FOREIGN KEY (post_id) REFERENCES posts(id) ON DELETE CASCADE)";

            statement.execute(posthashtagSQL);
            String postlikeSQL = "CREATE TABLE post_likes ( " +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "created_at DATETIME DEFAULT CURRENT_TIMESTAMP, " +
                    "user_id INT, " +
                    "post_id INT, " +
                    "FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE CASCADE, " +
                    "FOREIGN KEY (post_id) REFERENCES Posts(id) ON DELETE CASCADE)";

            statement.execute(postlikeSQL);
            String postcommentSQL = "CREATE TABLE post_comments ( " +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "comment VARCHAR(255), " +
                    "created_at DATETIME DEFAULT CURRENT_TIMESTAMP, " +
                    "user_id INT, " +
                    "post_id INT, " +
                    "FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE CASCADE, " +
                    "FOREIGN KEY (post_id) REFERENCES Posts(id) ON DELETE CASCADE)";
            statement.execute(postcommentSQL);
//            System.out.println("instagram 데이터베이스가 생성되었습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
