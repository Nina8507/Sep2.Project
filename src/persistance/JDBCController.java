package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCController
{
  private static JDBCController instance;

  private JDBCController(){}

  public static synchronized JDBCController getInstance()
  {
    if(instance == null)
    {
      instance = new JDBCController();
    }
    return instance;
  }
  public Connection getConnection() throws SQLException
  {
    return DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/postgres?currentSchema=sep2database",
        "postgres", "Nina1985");
  }
}
