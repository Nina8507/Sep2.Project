package persistance.loginDAO;

import persistance.JDBCController;
import shared.transfer.User;
import shared.transfer.staff.Employee;
import shared.transfer.staff.Management;
import shared.transfer.staff.Secretary;
import shared.transfer.staff.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

  @Override public Staff validateUser(User user)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM staff WHERE user_id = ? AND password = ?");
      statement.setString(1, user.getUsername());
      statement.setString(2, user.getPassword());
      statement.setString(3, user.getRole());
      ResultSet resultSet = statement.executeQuery();

      if (resultSet.next())
      {
        String user_id = resultSet.getString("user_id");
        String password = resultSet.getString("password");

        Staff validateUser = (Staff) new User(user_id, password);

        if(validateUser instanceof Employee){
          return validateUser;
        } else if(validateUser instanceof Secretary){
          return validateUser;
        } else if(validateUser instanceof Management)
        {
          return validateUser;
        }
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public List<User> getUsers()
  {
    ArrayList<User> result = new ArrayList<>();
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection
          .prepareStatement("SELECT user_id, password, role FROM STAFF WHERE");
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next())
      {
        String user_id = resultSet.getString("user_id");
        String password = resultSet.getString("password");
        String role = resultSet.getString("role");

        User userList = new User(user_id, password, role);
        result.add(userList);
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return result;
  }
}
