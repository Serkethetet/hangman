package hangman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public List<String> getWords() {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/hangman?"
                            + "user=root&password=Altic/Puntra7$&useLegacyDatetimeCode=false&serverTimezone=UTC");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from hangman.words");

            List<String> words = new ArrayList<>();

            while (resultSet.next()) {
                String word = resultSet.getString("word");
                words.add(word);
            }
            return words;
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            close();
        }
        return null;
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}