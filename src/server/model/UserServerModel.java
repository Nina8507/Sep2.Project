package server.model;

import shared.transfer.User;
import shared.util.Subject;

public interface UserServerModel extends Subject
{
  String validateUser(User user);
  User registerUser(User user);
}
