package client.views.staff;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transfer.address.Address;
import shared.transfer.staff.Staff;

import java.util.Date;

public class StaffController implements ViewController
{

  @FXML private TableView<Staff> staffTable;
  @FXML private TableColumn<Staff, Integer> staff_idColumn;
  @FXML private TableColumn<Staff, Integer> cprNrColumn;
  @FXML private TableColumn<Staff, String> lnameColumn;
  @FXML private TableColumn<Staff, String> fnameColumn;
  @FXML private TableColumn<Staff, String> emailColumn;
  @FXML private TableColumn<Staff, Address> addressColumn;
  @FXML private TableColumn<Staff, String> phoneNoColumn;
  @FXML private TableColumn<Staff, Date> startDateColumn;
  @FXML private TableColumn<Staff, Integer> salaryColumn;

  private ViewHandler viewHandler;
  private StaffVM staffVM;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    //this.staffVM = viewModelFactory.getStaffVM();
//    staff_idColumn.setCellValueFactory(new PropertyValueFactory<>("staff_id"));
//    cprNrColumn.setCellValueFactory(new PropertyValueFactory<>("cprNr"));
//    lnameColumn.setCellValueFactory(new PropertyValueFactory<>("lname"));
//    fnameColumn.setCellValueFactory(new PropertyValueFactory<>("fname"));
//    emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
//    addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
//    phoneNoColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
//    startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
//    salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
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
