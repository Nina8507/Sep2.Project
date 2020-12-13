package client.views.adminview;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.model.adminclientmodel.AdminClientModel;
import client.views.ViewController;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import shared.transfer.products.Product;
import shared.transfer.UserAction;

import java.beans.PropertyChangeEvent;

public class MainViewController implements ViewController
{
  @FXML private TableView<Product> tableView = new TableView<>();
  @FXML private TableColumn<Product, Integer> columnProduct_id;
  @FXML private TableColumn<Product, String> columnProductName;
  @FXML private TableColumn<Product, Integer> columnMeasurements;
  @FXML private TableColumn<Product, String> columnMaterial;
  @FXML private TableColumn<Product, Integer> columnQuantity;
  @FXML private TableColumn<Product, String> columnColor;
  @FXML private TableColumn<Product, Double> columnPurchasePrice;
  @FXML private TableColumn<Product, Double> columnSalePrice;

  @FXML AnchorPane rightContent;

  @FXML private Button onDashboardButton;
  @FXML private Button onProductButton;
  @FXML private Button onSupplierButton;
  @FXML private Button onOrdersButton;
  @FXML private Button onStaffButton;
  @FXML private Button onCustomerButton;
  @FXML private Button onActivityLogButton;
  @FXML private Button onSignOutButton;
  @FXML private Button onChatButton;

  private ViewHandler viewHandler;
  private MainViewVM mainViewVM;
  private AdminClientModel adminClientModel;


  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.mainViewVM = viewModelFactory.getMainViewVM();
//    columnProduct_id.setCellValueFactory(new PropertyValueFactory<>("product_id"));
//    columnProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
//    columnMeasurements.setCellValueFactory(new PropertyValueFactory<>("measurements"));
//    columnMaterial.setCellValueFactory(new PropertyValueFactory<>("material"));
//    columnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
//    columnColor.setCellValueFactory(new PropertyValueFactory<>("color"));
//    columnPurchasePrice.setCellValueFactory(new PropertyValueFactory<>("purchasePrice"));
//    columnSalePrice.setCellValueFactory(new PropertyValueFactory<>("salePrice"));
    //adminClientModel.addListener(UserAction.PRODUCT_LIST.toString(), this::getProductListToView);


    mainViewVM.setRightContentNode(rightContent);
  }

  private void getProductListToView(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      ObservableList<Product> products = (ObservableList<Product>) evt.getNewValue();
      tableView.getItems().clear();
      tableView.getItems().addAll(products);
    });
  }

  public void onDashboardButton(ActionEvent actionEvent)
  {

  }

  public void onProductButton(ActionEvent actionEvent)
  {
    mainViewVM.getProductList();
  }

  public void onSupplierButton(ActionEvent actionEvent)
  {
    mainViewVM.getSupplierList();
  }

  public void onOrdersButton(ActionEvent actionEvent)
  {

  }

  public void onStaffButton(ActionEvent actionEvent)
  {
      viewHandler.openStaffView();
//      mainViewVM.getStaffList();
  }

  public void onCustomerButton(ActionEvent actionEvent)
  {
    mainViewVM.getCustomerList();
  }

  public void onActivityLogButton(ActionEvent actionEvent)
  {
  }

  public void onSignOutButton(ActionEvent actionEvent)
  {
  }

  public void onChatButton(ActionEvent actionEvent)
  {
  }


}
