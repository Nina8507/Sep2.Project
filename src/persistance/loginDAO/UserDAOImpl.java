package persistance.loginDAO;

import persistance.JDBCController;
import shared.transfer.User;

import java.sql.*;

public class UserDAOImpl implements UserDAO
{
  private static UserDAOImpl userInstance;
  private JDBCController controllerJDBC;

  private UserDAOImpl()
  {
    try
    {
      DriverManager.registerDriver(new org.postgresql.Driver());
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    controllerJDBC = JDBCController.getInstance();
  }

  public static synchronized UserDAOImpl getInstance()
  {
    if (userInstance == null)
    {
      userInstance = new UserDAOImpl();
    }
    return userInstance;
  }

  @Override public String validateUser(User user)
  {
    try (Connection connection = controllerJDBC.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM userlogin WHERE username = ? AND userpassword = ?");
      statement.setString(1, user.getUsername());
      statement.setString(2, user.getPassword());
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();
      System.out.println(resultSet);
      if (resultSet.next())
      {
        return "OK!";
      }
      else
      {
        return "ERROR";
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }
}
