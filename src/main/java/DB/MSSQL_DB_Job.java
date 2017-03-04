package DB;

import java.sql.*;

public class MSSQL_DB_Job {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String url = "jdbc:sqlserver://svua1006;DatabaseName=TestDB;";

        String userName = "sa";
        String password = "h#u_lLk1";

        Connection connection = DriverManager.getConnection(url, userName, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        statement.execute("if not exists (select * from sysobjects where name='allusers' and xtype='U') CREATE TABLE allusers (id integer PRIMARY KEY, name varchar(100))");

        int last = 0;

        try {
            ResultSet resultSetReading = statement.executeQuery("SELECT TOP 1 * FROM allusers ORDER BY id DESC");
            resultSetReading.first();
            last = resultSetReading.getInt("id");
            resultSetReading.close();
        } catch (Exception e) {
        }

        PreparedStatement preparedStatement = connection.prepareStatement("insert into allusers  (id, name) values(?,?)");

        int i = 0;
        preparedStatement.setInt(++i, ++last);
        preparedStatement.setString(++i, "Міша");
        preparedStatement.addBatch();

        int j = 0;
        preparedStatement.setInt(++j, ++last);
        preparedStatement.setString(++j, "Гріша");
        preparedStatement.addBatch();

        preparedStatement.executeBatch();

        ResultSet resultSetSQLwriting = statement.executeQuery("select * from allusers");
        while (resultSetSQLwriting.next()) {
            System.out.println(resultSetSQLwriting.getInt("id") + " : " + resultSetSQLwriting.getString("name"));
        }


        resultSetSQLwriting.close();
        preparedStatement.close();
        connection.close();
    }

}
