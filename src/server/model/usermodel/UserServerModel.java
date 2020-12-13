package server.model.usermodel;

import shared.transfer.User;
import shared.util.Subject;

import java.util.List;

public interface UserServerModel extends Subject
{
  String validateUser(User user);

  List<User> getUsers();
}
