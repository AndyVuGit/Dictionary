import java.sql.*;
import java.util.*;

import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class Driver {

    public static void main(String[] arg) throws Exception
    {
      Class.forNAme("com.mysql.jdbc.Driver").newInstance();
      Connection connection;
      Statement select;

      try{
        connection = DriverManager.getConnection("jdbcmysql:///words", "root", "password");
        select = connection.createStatement();

        String userInput;
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter your word: ");
        userInput = reader.nextLine();

        Statement sqlCommand = connection.createStatement();
        sqlCommand.executeQuery("SELECT japanese FROM words WHERE english = \"" + userInput + "\"");

        reader.close();
      }
      catch (SQLException e)
      {
        System.out.println("Error occured");
      }
    }
}
