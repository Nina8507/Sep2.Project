package server.model.usermodel;

import persistance.loginDAO.UserDAO;
import persistance.loginDAO.UserDAOImpl;
import shared.transfer.User;
import shared.transfer.products.DamageProduct;
import shared.transfer.products.Product;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class UserServerModelManager implements UserServerModel
{
  private UserDAO userDAO;
  private PropertyChangeSupport support;
  private List<User> users;

  public UserServerModelManager()
  {
    userDAO = UserDAOImpl.getInstance();
    support = new PropertyChangeSupport(this);
    users = new ArrayList<>();
  }

  @Override public User validateUser(User user)
  {
    System.out.println(user);
    return userDAO.validateUser(user);
  }
  @Override public List<User> getUsers()
  {
    if (users.size() == 0)
      users = userDAO.getUsers();
    return users;
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
