package client.views.loginresult;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoginResult implements ViewController
{
  @FXML private Label loginResultLabel;

  public void onExitButton(ActionEvent actionEvent)
  {
    System.exit(0);
  }

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {

  }
}
