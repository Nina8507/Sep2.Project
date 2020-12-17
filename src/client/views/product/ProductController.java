package client.views.product;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ProductController implements ViewController
{
  @FXML private TextField searchField;
  @FXML private Button addProduct;
  @FXML private Button editButton;
  @FXML private Button moveToDamageListBtn;
  @FXML private Button deleteProduct;

  private ViewHandler viewHandler;
  private ProductVM productVM;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.productVM = viewModelFactory.getProductVM();
    searchField.textProperty().bindBidirectional(productVM.searchFieldProperty());
  }

  public void moveToDamageList(ActionEvent actionEvent)
  {

  }

  public void editButton(ActionEvent actionEvent)
  {
    viewHandler.openProductView();
  }

  public void addProduct(ActionEvent actionEvent)
  {

  }

  public void handleSearchAction(ActionEvent actionEvent)
  {
  }

  public void deleteProduct(ActionEvent actionEvent)
  {
  }
}
