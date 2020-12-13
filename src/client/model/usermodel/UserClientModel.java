package client.model.usermodel;

import shared.transfer.User;
import shared.util.Subject;

import java.util.List;

public interface UserClientModel extends Subject
{
  void login(String username, String password);
  List<User> getUserList();
}
