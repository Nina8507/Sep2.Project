package client.views.register;

import client.model.UserClientModel;
import javafx.beans.property.Property;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RegisterVM
{
  private UserClientModel userClientModel;
  private StringProperty username, password;

  public RegisterVM(UserClientModel userClientModel)
  {
    this.userClientModel = userClientModel;
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
  }

  public Property<String> enterUsernameProperty()
  {
    return username;
  }

  public Property<String> enterPasswordProperty()
  {
    return password;
  }

  public Property<String> reEnterPassProperty()
  {
    return password;
  }

  public void registerUser()
  {
    userClientModel.registerUser(username.get(), password.get());
  }
}
