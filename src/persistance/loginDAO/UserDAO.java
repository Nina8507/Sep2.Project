package persistance.loginDAO;

import shared.transfer.User;

public interface UserDAO
{
  String validateUser(User user);
  User registerUser(User user);
}
