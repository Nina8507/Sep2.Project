package client.model.usermodel;

import client.networking.Client;
import shared.transfer.User;
import shared.transfer.staff.Management;
import shared.transfer.staff.Staff;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class UserClientModelManager implements UserClientModel
{
  private Client client;
  private PropertyChangeSupport support;
  private Staff loggedInUser;

  public UserClientModelManager(Client client)
  {
    this.client = client;
    support = new PropertyChangeSupport(this);
  }

  @Override public void login(
      java.lang.String username, java.lang.String password)
  {
    //User user = new User(username, password);
    Management user = new Management(username, password, "Management");
    client.login(user);
  }

  @Override public List<User> getUserList()
  {
    return client.getUserList();
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void addListener(java.lang.String name,
      PropertyChangeListener listener)
  {
    if (name == null || "".equals(name))
      addListener(listener);
    else
    {
      support.addPropertyChangeListener(name, listener);
    }
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }
  @Override public void removeListener(java.lang.String name,
      PropertyChangeListener listener)
  {
    if (name == null || "".equals(name))
      removeListener(listener);
    else
    {
      support.removePropertyChangeListener(name, listener);
    }
  }
}