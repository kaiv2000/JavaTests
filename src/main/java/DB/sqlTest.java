package DB;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class sqlTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String url = "jdbc:sqlserver://svua1006;DatabaseName=TestDB;";

        String userName = "sa";
        String password = "h#u_lLk1";

        Connection connection = DriverManager.getConnection(url, userName, password);

        DatabaseMetaData md = connection.getMetaData();

        System.out.println( md.getSQLKeywords());

    }

}
