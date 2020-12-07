package client.views.loginresult;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;

public class LoginResult implements ViewController
{
  public void onExitButton(ActionEvent actionEvent)
  {
    System.exit(0);
  }

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {

  }
}
