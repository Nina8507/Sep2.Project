package client.views.staff.addnewstaff.addnewsecretary;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddSecretaryController implements ViewController
{
  @FXML private Label registerResponse;
  @FXML private TextField passwordTextField;
  @FXML private TextField usernameTextField;
  @FXML private  TextField staff_idText;
  @FXML private  TextField fullNameTextField;
  @FXML private  TextField cityTextField;
  @FXML private  TextField zipCodeTextField;
  @FXML private  TextField streetTextField;
  @FXML private  TextField emailTextField;
  @FXML private  TextField phoneNumberTextField;
  @FXML private  TextField salaryTextField;
  @FXML private  TextField cprTextField;
  @FXML private  TextField startDateTextField;
  @FXML private  TextField onSetRoleTextField;

  private ViewHandler viewHandler;
  private AddSecretaryVM addSecretaryVM;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    //this.addSecretaryVM = viewModelFactory.getAddSecretaryClientModel();

    cityTextField.textProperty().bindBidirectional(addSecretaryVM.cityProperty());
    zipCodeTextField.textProperty().bindBidirectional(addSecretaryVM.zipcodeProperty());
    streetTextField.textProperty().bindBidirectional(addSecretaryVM.streetProperty());
    emailTextField.textProperty().bindBidirectional(addSecretaryVM.emailProperty());
    phoneNumberTextField.textProperty().bindBidirectional(addSecretaryVM.phoneNoProperty());
    salaryTextField.textProperty().bindBidirectional(addSecretaryVM.salaryProperty());
    cprTextField.textProperty().bindBidirectional(addSecretaryVM.cprNrProperty());
    fullNameTextField.textProperty().bindBidirectional(addSecretaryVM.nameProperty());
    staff_idText.textProperty().bindBidirectional(addSecretaryVM.staff_idProperty());
    onSetRoleTextField.textProperty().bindBidirectional(addSecretaryVM.setRoleProperty());
    startDateTextField.textProperty().bindBidirectional(addSecretaryVM.startDateProperty());
    passwordTextField.textProperty().bindBidirectional(addSecretaryVM.passwordProperty());
    usernameTextField.textProperty().bindBidirectional(addSecretaryVM.usernameProperty());
    registerResponse.textProperty().bindBidirectional(addSecretaryVM.responseLabelProperty());

  }

  public void onCreateButton(ActionEvent actionEvent)
  {
    addSecretaryVM.createNewStaff();
  }

}
