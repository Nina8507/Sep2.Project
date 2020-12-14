package server.model.usermodel;

import shared.transfer.User;
import shared.transfer.staff.Staff;
import shared.util.Subject;

import java.util.List;

public interface UserServerModel extends Subject
{
  Staff validateUser(User user);
  List<User> getUsers();
}
