import java.sql.*;

public class JDBCExampleH2 {
    public static void main(String[] args) {
        try {
            // Registering H2 JDBC Driver
            Class.forName("org.h2.Driver");

            // Creating connection
            try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:newDB", "user", "")) {
                // use Connection object here
                try (Statement statement = connection.createStatement()) {
                    // Create tables if they don't exist
                    statement.execute("CREATE TABLE IF NOT EXISTS Persons (\n" +
                            "  PersonID int,\n" +
                            "  LastName varchar(255),\n" +
                            "  FirstName varchar(255),\n" +
                            "  Address varchar(255),\n" +
                            "  City varchar(255)\n" +
                            ");");

                    statement.execute("CREATE TABLE IF NOT EXISTS Book (\n" +
                            "  Id INT PRIMARY KEY,\n" +
                            "  Title VARCHAR(32) NOT NULL,\n" +
                            "  Type VARCHAR(32),\n" +
                            "  Description VARCHAR(50)\n" +
                            ");");

                    // Insert data into tables
                    statement.executeUpdate("INSERT INTO Persons VALUES (1, 'Andrewson', 'Andrew', 'Novak 1', 'Warsaw');" +
                            "INSERT INTO Persons VALUES (2, 'Addams', 'Adam', 'Adamson 1', 'Adamville');");

                    statement.executeUpdate("INSERT INTO Book VALUES (1, 'Java beginner', 'Programming', 'Programming in Java from scratch');");

                    // Retrieve and print data from Persons table
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM Persons");
                    while (resultSet.next()) {
                        System.out.println("PersonID " + resultSet.getInt(1));
                        System.out.println("LastName " + resultSet.getString(2));
                        System.out.println("FirstName " + resultSet.getString(3));
                        System.out.println("Address " + resultSet.getString(4));
                        System.out.println("City " + resultSet.getString(5));
                    }

                    // Retrieve and print data from Book table
                    resultSet = statement.executeQuery("SELECT * FROM Book");
                    while (resultSet.next()) {
                        System.out.println("Book ID " + resultSet.getInt(1));
                        System.out.println("Title " + resultSet.getString(2));
                        System.out.println("Type " + resultSet.getString(3));
                        System.out.println("Description " + resultSet.getString(4));
                    }
                } catch (SQLException exp) {
                    exp.printStackTrace(); // exception handling
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
