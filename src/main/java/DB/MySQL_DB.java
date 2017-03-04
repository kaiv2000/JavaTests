package DB;

import java.sql.*;

public class MySQL_DB {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/sakila?useSSL=false&autoReconnect=true";
        String userName = "root";
        String password = "admin";

        Connection connection = DriverManager.getConnection(url, userName, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        statement.execute("create table IF NOT EXISTS allusers(id integer primary key auto_increment, " + "name varchar(100))");

        int last = 0;

        try {
            ResultSet resultSetReading = statement.executeQuery("SELECT id  FROM allusers ORDER BY id DESC LIMIT 1");
            resultSetReading.first();
            last = resultSetReading.getInt("id");
            resultSetReading.close();
        } catch (Exception e) {
        }


        PreparedStatement preparedStatement = connection.prepareStatement("insert into allusers  (id, name) values(?,?)");

        int i = 0;
        preparedStatement.setInt(++i, ++last);
        preparedStatement.setString(++i, "Іван");
        preparedStatement.addBatch();

        int j = 0;
        preparedStatement.setInt(++j, ++last);
        preparedStatement.setString(++j, "Петро");
        preparedStatement.addBatch();

        preparedStatement.executeBatch();

        ResultSet resultSetSQLwriting = statement.executeQuery("select * from allusers");
        while (resultSetSQLwriting.next()) {
            System.out.println(resultSetSQLwriting.getInt("id") + " : " + resultSetSQLwriting.getString("name"));
        }


        resultSetSQLwriting.close();
        statement.close();
        connection.close();

    }
}
