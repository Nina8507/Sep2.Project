package server.model.usermodel;

import shared.transfer.User;
import shared.util.Subject;

public interface UserServerModel extends Subject
{
  String validateUser(User user);
}
