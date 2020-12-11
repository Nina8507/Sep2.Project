package client.model.usermodel;

import client.networking.Client;
import shared.transfer.User;
import shared.transfer.UserAction;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UserClientModelManager implements UserClientModel
{
  private Client client;
  private PropertyChangeSupport support;
  private User loggedInUser;

  public UserClientModelManager(Client client)
  {
    this.client = client;
    support = new PropertyChangeSupport(this);
  }

  @Override public void login(String username, String password)
  {
    loggedInUser = new User(username, password);
    client.login(loggedInUser);
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void addListener(String name,
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
  @Override public void removeListener(String name,
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