package persistance.loginDAO;

import shared.transfer.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO
{
  User validateUser(User user);
  List<User> getUsers();
}
