package client.views.supplier.addsupplier;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import shared.transfer.UserAction;

public class AddSupplierController implements ViewController
{
  @FXML private TextField responseLabel;
  @FXML private TextField cityTextField;
  @FXML private TextField zipCodeTextField;
  @FXML private TextField streetTextField;
  @FXML private TextField phoneNumberTextField;
  @FXML private TextField lastNameTextField;
  @FXML private TextField firstNameTextField;
  @FXML private TextField cvrTextField;
  @FXML private TextField supplier_idTextField;
  @FXML private TextField emailTextField;
  @FXML private TextField countryTextField;
  @FXML private Button createButton;

  private AddSupplierVM addSupplierVM;
  private ViewHandler viewHandler;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.addSupplierVM = viewModelFactory.getAddSupplierVM();
    this.viewHandler = viewHandler;
    supplier_idTextField.textProperty().bindBidirectional(addSupplierVM.supplier_idProperty());
    firstNameTextField.textProperty().bindBidirectional(addSupplierVM.fnameProperty());
    lastNameTextField.textProperty().bindBidirectional(addSupplierVM.lnameProperty());
    cvrTextField.textProperty().bindBidirectional(addSupplierVM.cvrNrProperty());
    emailTextField.textProperty().bindBidirectional(addSupplierVM.emailProperty());
    phoneNumberTextField.textProperty().bindBidirectional(addSupplierVM.phoneNoProperty());
    cityTextField.textProperty().bindBidirectional(addSupplierVM.citYProperty());
    zipCodeTextField.textProperty().bindBidirectional(addSupplierVM.zipCodeProperty());
    streetTextField.textProperty().bindBidirectional(addSupplierVM.streetNoProperty());
    countryTextField.textProperty().bindBidirectional(addSupplierVM.countryProperty());
    responseLabel.textProperty().bind(addSupplierVM.registerResponseProperty());
    addSupplierVM.registerResponseProperty().addListener(((observableValue, s, t1) -> {
      if(UserAction.ADD_NEW_SUPPLIER.toString().equals("Supplier Created"))
      {
        viewHandler.openSupplierView();
      }
    }));
  }

  public void onCreateButton(javafx.event.ActionEvent actionEvent)
  {
    addSupplierVM.createNewSupplier();
  }
}
