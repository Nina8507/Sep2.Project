package client.views.product.addproduct;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddProductController implements ViewController
{
  @FXML private TextField purchasePriceTextField;
  @FXML private TextField salesPriceTextField;
  @FXML private TextField colorTextField;
  @FXML private TextField quantityTextField;
  @FXML private TextField productNameTextField;
  @FXML private TextField productIDTextField;
  @FXML private TextField measurementTextField;
  @FXML private TextField materialTextField;


  private ViewHandler viewHandler;
  private AddProductVM addProductVM;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.addProductVM = viewModelFactory.getAddProductVm();
    purchasePriceTextField.textProperty().bindBidirectional(addProductVM.purchasePriceProperty());
    salesPriceTextField.textProperty().bindBidirectional(addProductVM.salesPriceProperty());
    colorTextField.textProperty().bindBidirectional(addProductVM.colorProperty());
    quantityTextField.textProperty().bindBidirectional(addProductVM.quantityProperty());
    productNameTextField.textProperty().bindBidirectional(addProductVM.productNameProperty());
    productIDTextField.textProperty().bindBidirectional(addProductVM.productIdProperty());
    measurementTextField.textProperty().bindBidirectional(addProductVM.measurementProperty());
    materialTextField.textProperty().bindBidirectional(addProductVM.materialProperty());
  }
  public void onCreateButton(ActionEvent actionEvent)
  {
    addProductVM.addNewProduct();
  }


}
