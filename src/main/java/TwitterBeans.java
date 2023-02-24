import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class TwitterBeans {

    @Inject
    private Twitter twitter;

    public void creatTweet(String content, String author){
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/twitter?user=root&password=");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO twitter.tweets (content, author, created_at, updated_at) values (?, ?, NOW(), NOW())"
                );


        ){
            preparedStatement.setString(1, content);
            preparedStatement.setString(2, author);
            preparedStatement.execute();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Twitter> getTweets() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/twitter?user=root&password=");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM twitter.tweets")
        ) {
            ArrayList<Twitter> tweets = new ArrayList<>();

            while (resultSet.next()) {
                tweets.add(new Twitter(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                ));
            }

            return tweets;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
