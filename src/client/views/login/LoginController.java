package client.views.login;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController implements ViewController
{
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
  }

  public void onLoginButton(ActionEvent evt)
  {
    loginVM.login();
    viewHandler.openStaffView();
  }

  public void onRegisterButton(ActionEvent evt)
  {
    loginVM.clear();
    viewHandler.openRegisterView();
  }

}
