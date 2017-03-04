package DB;

import java.sql.*;

public class MSSQL_DB_Home {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:sqlserver://localhost;DatabaseName=TestDB;integratedSecurity=true;";

        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        System.out.println("JDBC driver version is " + connection.getMetaData().getDatabaseProductName());


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
