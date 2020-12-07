package client.views.register;

import client.model.ClientModel;
import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;

public class RegisterVM
{
  private ClientModel clientModel;
  private StringProperty username, password;

  public RegisterVM(ClientModel clientModel)
  {
    this.clientModel = clientModel;
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

  }
}
