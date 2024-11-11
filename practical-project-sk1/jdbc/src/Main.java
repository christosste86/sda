import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        try (final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Nirvana308813")) {
            try (Statement statement = connection.createStatement()){
                System.out.println("connection");
                statement.execute("create table if not exists Books (Id INT PRIMARY KEY, Title VARCHAR(32) NOT NULL, Type VARCHAR(32), Description VARCHAR(50))");
                statement.execute("insert into Books (Id, Title, Type, Description ) values (1, 'Java medior', 'Programming', 'Programming in Java for mediors')");
            }
        } catch (SQLException exp) {
            System.out.println(exp);
        }
    }
}