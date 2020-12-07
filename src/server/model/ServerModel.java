package server.model;

import shared.transfer.User;
import shared.util.Subject;

public interface ServerModel extends Subject
{
  String validateUser(User user);
}
