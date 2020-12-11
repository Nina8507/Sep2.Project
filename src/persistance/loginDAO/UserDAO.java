package persistance.loginDAO;

import shared.transfer.User;

import java.sql.SQLException;

public interface UserDAO
{
  String validateUser(User user);
}
