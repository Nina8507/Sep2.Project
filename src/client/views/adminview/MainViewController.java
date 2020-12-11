package client.views.adminview;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainViewController implements ViewController
{
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


  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.mainViewVM = viewModelFactory.getMainViewVM();
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
    mainViewVM.getStaffList();
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
