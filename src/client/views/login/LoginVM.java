package client.views.login;

import client.model.ClientModel;
import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transfer.UserAction;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

public class LoginVM
{
  private ClientModel clientModel;
  private StringProperty username, password, loginResponse;

  public LoginVM(ClientModel clientModel)
  {
    this.clientModel = clientModel;
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    loginResponse = new SimpleStringProperty();
    clientModel.addListener(UserAction.LOGIN_RESULT.toString(),
        this::displayMessageLabel);
    System.out.println(loginResponse);
  }

  private void displayMessageLabel(PropertyChangeEvent propertyChangeEvent)
  {
    loginResponse.setValue((String) propertyChangeEvent.getNewValue());
  }

  public StringProperty usernameProperty()
  {
    return username;
  }

  public StringProperty passwordTextProperty()
  {
    return password;
  }

  public StringProperty loginResponseProperty()
  {
    return loginResponse;
  }

  public void login()
  {
    clientModel.login(username.get(), password.get());
  }

  public void clear()
  {
    username.set("");
    password.set("");
    loginResponse.set("");
  }
}
