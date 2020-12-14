package client.views.staff.addnewstaff;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddStaffController implements ViewController
{

  @FXML private  TextField passwordTextField;
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

  private AddStaffVM addStaffVM;
  private ViewHandler viewHandler;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.addStaffVM = viewModelFactory.getAddStaffVM();
    cityTextField.textProperty().bindBidirectional(addStaffVM.cityProperty());
    zipCodeTextField.textProperty().bindBidirectional(addStaffVM.zipcodeProperty());
    streetTextField.textProperty().bindBidirectional(addStaffVM.streetProperty());
    emailTextField.textProperty().bindBidirectional(addStaffVM.emailProperty());
    phoneNumberTextField.textProperty().bindBidirectional(addStaffVM.phoneNoProperty());
    salaryTextField.textProperty().bindBidirectional(addStaffVM.salaryProperty());
    cprTextField.textProperty().bindBidirectional(addStaffVM.cprNrProperty());
    fullNameTextField.textProperty().bindBidirectional(addStaffVM.nameProperty());
    staff_idText.textProperty().bindBidirectional(addStaffVM.staff_idProperty());
    onSetRoleTextField.textProperty().bindBidirectional(addStaffVM.setRoleProperty());
    startDateTextField.textProperty().bindBidirectional(addStaffVM.startDateProperty());
    passwordTextField.textProperty().bindBidirectional(addStaffVM.passwordProperty());
    usernameTextField.textProperty().bindBidirectional(addStaffVM.usernameProperty());

  }

  public void onCreateButton(ActionEvent actionEvent)
  {
    addStaffVM.createNewStaff();
  }


}
