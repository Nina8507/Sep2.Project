package client.model.usermodel;

import shared.util.Subject;

public interface UserClientModel extends Subject
{
  void login(String username, String password);
}
