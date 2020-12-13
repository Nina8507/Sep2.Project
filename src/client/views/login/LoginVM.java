package client.views.login;


import client.model.usermodel.UserClientModel;
import client.networking.Client;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transfer.User;
import shared.transfer.UserAction;
import shared.util.Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class LoginVM implements Subject
{
  private UserClientModel userClientModel;
  private ObservableList<User> users;
  private Client client;
  private StringProperty username, password;
  private PropertyChangeSupport support;

  public LoginVM(UserClientModel userClientModel, Client client)
  {
    this.client = client;
    this.userClientModel = userClientModel;
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    support = new PropertyChangeSupport(this);
    client.addListener(UserAction.LOGIN_RESULT.toString(), this::loginResultFromDbs);
  }

  private void loginResultFromDbs(PropertyChangeEvent propertyChangeEvent)
  {
    Platform.runLater(() -> {
      support.firePropertyChange(UserAction.LOGIN_RESULT.toString(), null,
          propertyChangeEvent);
    });
  }

  public StringProperty usernameProperty()
  {
    return username;
  }

  public StringProperty passwordTextProperty()
  {
    return password;
  }

  public void login()
  {
    userClientModel.login(username.get(), password.get());
  }

  public void getUsers()
  {
    ArrayList<User> userList = client.getUserList();
    users = FXCollections.observableList(userList);
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
