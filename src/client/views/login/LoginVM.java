package client.views.login;

import client.model.UserClientModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transfer.UserAction;

import java.beans.PropertyChangeEvent;

public class LoginVM
{
  private UserClientModel userClientModel;
  private StringProperty username, password, loginResponse;

  public LoginVM(UserClientModel userClientModel)
  {
    this.userClientModel = userClientModel;
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    loginResponse = new SimpleStringProperty();
    userClientModel.addListener(UserAction.LOGIN_RESULT.toString(),
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
    userClientModel.login(username.get(), password.get());
  }

  public void clear()
  {
    username.set("");
    password.set("");
    loginResponse.set("");
  }
}
