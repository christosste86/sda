import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3307/sda");
        dataSource.setUser("root");
        dataSource.setPassword("Nirvana813");
        
        // Establishing connection using DriverManager
        try (final Connection connection = dataSource.getConnection()) {
            // Executing query using Statement
            try (Statement statement = connection.createStatement()) {
                // executeQuery example
                final ResultSet resultSet = statement.executeQuery("SELECT * FROM Persons");
                while (resultSet.next()) {
                    System.out.println("PersonID " + resultSet.getInt(1));
                    System.out.println("LastName " + resultSet.getString(2));
                    System.out.println("FirstName " + resultSet.getString(3));
                    System.out.println("Address " + resultSet.getString(4));
                    System.out.println("City " + resultSet.getString(5));
                }

                try (Statement statement1 = connection.createStatement()) {
                    ResultSet resultSet1 = connection.getMetaData().getTables(null, null, "Book", null);
                    if (resultSet1.next()){
                        // Table exists, drop it
                        statement1.execute("DROP TABLE Book");
                        System.out.println("Table Book dropped.");
                    }
                    // Create the table
                    boolean isResultSetReturned = statement1.execute("create table Book (Id INT PRIMARY KEY, Title VARCHAR(32) NOT NULL, Type VARCHAR(32), Description VARCHAR(50))");
                    System.out.println(isResultSetReturned);
                    // Insert values into the table
                    int rowsAffected = statement1.executeUpdate("insert into Book values(1, 'Java beginner', 'Programming', 'Programming in Java from scratch')");
                    System.out.println(rowsAffected + " row(s) inserted into Book table.");
                }

            } catch (SQLException exp) {
                exp.printStackTrace(); // exception handling
            }
        }
    }
}

