package client.views.staff;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import shared.transfer.address.Address;
import shared.transfer.staff.Staff;

import java.util.Date;

public class StaffController implements ViewController
{

  @FXML private TableView<Staff> staffTable;
  @FXML private TableColumn<Staff, Integer> staff_id;
  @FXML private TableColumn<Staff, Integer> cprNr;
  @FXML private TableColumn<Staff, String> lname;
  @FXML private TableColumn<Staff, String> fname;
  @FXML private TableColumn<Staff, String> email;
  @FXML private TableColumn<Staff, Address> address;
  @FXML private TableColumn<Staff, String> phoneNo;
  @FXML private TableColumn<Staff, Date> startDate;
  @FXML private TableColumn<Staff, Integer> salary;


  private ViewHandler viewHandler;
  private StaffVM staffVM;


  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.staffVM = staffVM;

  }
  @FXML void onAddStaffButton(ActionEvent event)
  {

  }

  @FXML void onDeleteStaffButton(ActionEvent event)
  {

  }

  @FXML void onEditStaffButtons(ActionEvent event)
  {

  }

  @FXML void onSearchStaffTextField(ActionEvent event)
  {

  }

  @FXML void onUpdateStaffButton(ActionEvent event)
  {

  }


}
