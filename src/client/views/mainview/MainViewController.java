package client.views.mainview;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.model.adminclientmodel.AdminClientModel;
import client.views.ViewController;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import shared.transfer.products.Product;


import java.beans.PropertyChangeEvent;

public class MainViewController implements ViewController
{
  @FXML private Button signOutButton;
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

  private ViewHandler viewHandler;
  private MainViewVM mainViewVM;


  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.mainViewVM = viewModelFactory.getMainViewVM();

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

  public void onDashboardButton()
  {

  }

  public void onProductButton()
  {
    viewHandler.openProductView();
  }

  public void onSupplierButton()
  {
    viewHandler.openSupplierView();
  }

  public void onOrdersButton()
  {

  }

  public void onStaffButton()
  {
      viewHandler.openStaffView();
  }

  public void onCustomerButton()
  {
    mainViewVM.getCustomerList();
  }

  public void onActivityLogButton()
  {
  }

  public void onSignOutButton()
  {
    mainViewVM.logoutUser();
  }

  public void onChatButton()
  {
  }


}
