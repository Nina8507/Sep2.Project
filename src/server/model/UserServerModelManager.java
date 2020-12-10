package server.model;

import persistance.loginDAO.UserDAO;
import persistance.loginDAO.UserDAOImpl;
import shared.transfer.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;

public class UserServerModelManager implements UserServerModel
{
  private UserDAO userDAO;
  private PropertyChangeSupport support;

  public UserServerModelManager()
  {
    userDAO = UserDAOImpl.getInstance();
    support = new PropertyChangeSupport(this);
  }

  @Override public String validateUser(User user)
  {
    System.out.println("ServerModelManager" + userDAO.validateUser(user));
    return userDAO.validateUser(user);
  }

  @Override public User registerUser(User user)
  {
    return userDAO.registerUser(user);
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
      addListener(listener);
    else
    {
      support.addPropertyChangeListener(name, listener);
    }
  }
}
