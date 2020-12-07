package client.views.login;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController implements ViewController
{
  @FXML private Label loginResultLabel;
  @FXML private TextField usernameTextField;
  @FXML private TextField passwordTextField;
  @FXML private Button onLoginButton;
  @FXML private Button onRegisterButton;

  private ViewHandler viewHandler;
  private LoginVM loginVM;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.loginVM = viewModelFactory.getLoginVM();
    usernameTextField.textProperty()
        .bindBidirectional(loginVM.usernameProperty());
    passwordTextField.textProperty()
        .bindBidirectional(loginVM.passwordTextProperty());
    loginResultLabel.textProperty()
        .bindBidirectional(loginVM.loginResponseProperty());
    //loginVM.loginResponseProperty().addListener(
       // (observableValue, oldValue, newValue) -> onLoginResult(newValue));
    loginResultLabel.textProperty().addListener(this::onLoginResult);
  }

  private void onLoginResult(Observable observable, String old, String response)
  {
    if ("OK".equals(response))
    {
      viewHandler.openLoggedInSuccessfulView();
    }
  }

  public void onLoginButton(ActionEvent evt)
  {
    loginVM.login();
    //viewHandler.openRegisterView();
  }

  public void onRegisterButton(ActionEvent evt)
  {
    loginVM.clear();
    viewHandler.openRegisterView();
  }

}
