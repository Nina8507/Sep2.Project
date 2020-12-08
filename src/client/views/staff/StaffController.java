package client.views.staff;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class StaffController implements ViewController
{
  @FXML private JFXButton onDashboardButton;
  @FXML private JFXButton onProductsButton;
  @FXML private JFXButton onSupplierButton;
  @FXML private JFXButton onOrdersButton;
  @FXML private JFXButton onStaffButton;
  @FXML private JFXButton onCustomerButton;
  @FXML private JFXButton onChatButton;
  @FXML private JFXButton onSignOutButton;
  @FXML private TextField searchStaffTextProperty;
  @FXML private JFXButton onAddStaffButton;
  @FXML private JFXButton onDeleteStaffButton;
  @FXML private JFXButton onEditStaffButton;

  private ViewHandler viewHandler;
  private StaffVM staffVM;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.staffVM = staffVM;

    searchStaffTextProperty.textProperty()
        .bindBidirectional(staffVM.searchStaffTextProperty());
  }
  public void onAddStaffButton()
  {
    staffVM.openAddStaffView();
  }
  public void onDeleteStaffButton()
  {
    staffVM.openDeleteStaffView();
  }
  public void onEditStaffButton()
  {
    staffVM.openEditStaffView();
  }
}
