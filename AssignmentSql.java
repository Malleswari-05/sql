import java.sql.*;

public class AssignmentSql {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/cse";
        String username = "root";
        String password = "Mysql@28";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            String sql = "update StudentInfo set name=\"riya\" where id=101";
            statement.executeUpdate(sql);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM StudentInfo");

            while (resultSet.next()) {
                // Process the data here
                String data = resultSet.getString("name");
                System.out.println(data);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
