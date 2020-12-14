package client.views.staff.addnewstaff.addemployee;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import shared.transfer.UserAction;

public class AddEmployeeController implements ViewController
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
  private AddEmployeeVM addEmployeeVM;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.addEmployeeVM = viewModelFactory.getAddEmployeeVM();
    cityTextField.textProperty().bindBidirectional(addEmployeeVM.cityProperty());
    zipCodeTextField.textProperty().bindBidirectional(addEmployeeVM.zipcodeProperty());
    streetTextField.textProperty().bindBidirectional(addEmployeeVM.streetProperty());
    emailTextField.textProperty().bindBidirectional(addEmployeeVM.emailProperty());
    phoneNumberTextField.textProperty().bindBidirectional(addEmployeeVM.phoneNoProperty());
    salaryTextField.textProperty().bindBidirectional(addEmployeeVM.salaryProperty());
    cprTextField.textProperty().bindBidirectional(addEmployeeVM.cprNrProperty());
    fullNameTextField.textProperty().bindBidirectional(addEmployeeVM.nameProperty());
    staff_idText.textProperty().bindBidirectional(addEmployeeVM.staff_idProperty());
    onSetRoleTextField.textProperty().bindBidirectional(addEmployeeVM.setRoleProperty());
    startDateTextField.textProperty().bindBidirectional(addEmployeeVM.startDateProperty());
    passwordTextField.textProperty().bindBidirectional(addEmployeeVM.passwordProperty());
    usernameTextField.textProperty().bindBidirectional(addEmployeeVM.usernameProperty());
    registerResponse.textProperty().bindBidirectional(addEmployeeVM.responseLabelProperty());

    addEmployeeVM.responseLabelProperty().addListener(observable -> {
      if(UserAction.CREATE_NEW_EMPLOYEE.toString().equals("Employee Created!"))
      {
        viewHandler.openStaffView();
      }
    });
  }

  public void onCreateButton(ActionEvent actionEvent)
  {
    addEmployeeVM.createNewStaff();
  }


}
