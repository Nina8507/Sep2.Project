package persistance.loginDAO;

import persistance.JDBCController;
import shared.transfer.User;

import java.sql.*;


public class UserDAOImpl implements UserDAO
{
  private static UserDAOImpl userInstance;
  private JDBCController controller;

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
    controller = JDBCController.getInstance();
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
    try (Connection connection = controller.getConnection())
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

  @Override public User registerUser(User user)
  {
    try(Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO User(username, userpassword) VALUES (?, ?)");
      statement.setString(1, user.getUsername());
      statement.setString(2, user.getPassword());
      statement.executeQuery();
      return new User(user.getUsername(), user.getPassword());
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }
}
