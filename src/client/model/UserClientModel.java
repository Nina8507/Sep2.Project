package client.model;

import shared.util.Subject;

public interface UserClientModel extends Subject
{
  void login(String username, String password);
  void registerUser(String username, String password);
}
