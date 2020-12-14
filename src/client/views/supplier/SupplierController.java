package client.views.supplier;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.model.supplierclientmodel.SupplierClientModel;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import shared.transfer.address.Address;
import shared.transfer.products.Product;

public class SupplierController implements ViewController
{

  @FXML private TextField searchSupplierTextField;

  @FXML private TableView<Product> supplierTable = new TableView<>();
  @FXML private TableColumn<Product, Integer> supplier_id;
  @FXML private TableColumn<Product, String> supplierName;
  @FXML private TableColumn<Product, Integer> cvr_nr;
  @FXML private TableColumn<Product, Object> address_id;
  @FXML private TableColumn<Product, String> email;
  @FXML AnchorPane rightContent;

  private ViewHandler viewHandler;
  private SupplierVM supplierVM;
  private SupplierClientModel supplierClientModel;


  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.supplierVM = viewModelFactory.getSupplierVM();
    supplierVM.setRightContentNode(rightContent);
    searchSupplierTextField.textProperty().bindBidirectional(supplierVM.searchSupplierTextProperty());
    supplier_id.setCellValueFactory(new PropertyValueFactory<>("supplier_id"));
    supplierName.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
    cvr_nr.setCellValueFactory(new PropertyValueFactory<>("cvr_nr"));
    address_id.setCellValueFactory(new PropertyValueFactory<>("address_id"));
    email.setCellValueFactory(new PropertyValueFactory<>("email"));

  }
  public void onAddSupplierButton()
  {
    viewHandler.openAddNewSupplierPane();
  }

  public void onEditSupplierButton()
  {

  }

  public void onDeleteSupplierButton()
  {

  }

  public void onUpdateSupplierButton()
  {

  }

}

