import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertIntoDummyData {
    public static void main(String[] args) {
        try {
            String URL = "jdbc:mysql://127.0.0.1:3306/instagram";
            String USER = "root";
            String PASSWORD = "q1w2e3r4";

            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conn.createStatement();

            String sqlInsertUsers = "INSERT INTO users (username, password) VALUES " +
                    "('user1', 'password1'), ('user2', 'password2'), ('user3', 'password3'), " +
                    "('user4', 'password4'), ('user5', 'password5'), ('user6', 'password6'), " +
                    "('user7', 'password7'), ('user8', 'password8'), ('user9', 'password9'), " +
                    "('user10', 'password10')";

            String sqlInsertPosts = "INSERT INTO posts (image, message, user_id) VALUES " +
                    "(NULL, 'Hello World', 1), (NULL, 'Learning Java', 2), " +
                    "(NULL, 'At the beach', 3), (NULL, 'Eating pizza', 4), " +
                    "(NULL, 'Watching a movie', 5), (NULL, 'At a concert', 6), " +
                    "(NULL, 'Playing games', 7), (NULL, 'Reading a book', 8), " +
                    "(NULL, 'Visiting museums', 9), (NULL, 'Going hiking', 10)";
            String sqlInsertComments = "INSERT INTO post_comments (comment, user_id, post_id) VALUES " +
                    "('Nice post!', 1, 1), ('Love this!', 2, 1), ('So cool!', 3, 2), " +
                    "('Wow!', 4, 3), ('Great pic!', 5, 3), ('Cant agree more!', 6, 4), " +
                    "('LOL', 7, 5), ('Thats awesome!', 8, 6), ('Yummy!', 9, 7), ('Interesting!', 10, 8)";

            String sqlInsertLikes = "INSERT INTO post_likes (user_id, post_id) VALUES " +
                    "(1, 1), (2, 1), (3, 1), (4, 2), (5, 2), " +
                    "(6, 3), (7, 3), (8, 4), (9, 5), (10, 5)";

            String sqlInsertFollows = "INSERT INTO follow_follower (follower_id, user_id) VALUES " +
                    "(1, 2), (1, 3), (2, 3), (2, 4), (3, 4), " +
                    "(3, 5), (4, 5), (4, 6), (5, 6), (5, 7)";
            String sqlInsertHashtags = "INSERT INTO hashtags (name) VALUES " +
                    "('summer'), ('java'), ('beach'), ('pizza'), ('movie'), " +
                    "('concert'), ('games'), ('book'), ('museum'), ('hiking')";
            String sqlInsertPostsHashtags = "INSERT INTO posts_hashtags (hashtag_id, post_id) VALUES " +
                    "(1, 1), (2, 2), (3, 3), (4, 4), (5, 5), " +
                    "(6, 6), (7, 7), (8, 8), (9, 9), (10, 10)";

            statement.executeUpdate(sqlInsertUsers);
            statement.executeUpdate(sqlInsertFollows);
            statement.executeUpdate(sqlInsertPosts);
            statement.executeUpdate(sqlInsertHashtags);
            statement.executeUpdate(sqlInsertPostsHashtags);
            statement.executeUpdate(sqlInsertComments);
            statement.executeUpdate(sqlInsertLikes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
