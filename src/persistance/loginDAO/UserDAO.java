package persistance.loginDAO;

import shared.transfer.User;
import shared.transfer.staff.Staff;

import java.util.List;

public interface UserDAO
{
  Staff validateUser(User user);
  List<User> getUsers();
}
