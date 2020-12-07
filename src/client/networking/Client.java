package client.networking;

import shared.transfer.User;
import shared.util.Subject;

public interface Client extends Subject
{
  void login(User user);
  void registerUser(User user);
}
