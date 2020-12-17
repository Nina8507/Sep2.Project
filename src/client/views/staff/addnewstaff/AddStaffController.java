package client.views.staff.addnewstaff;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;

public class AddStaffController implements ViewController
{
  private ViewHandler viewHandler;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
  }

  public void onSecretaryButton(ActionEvent actionEvent)
  {
    viewHandler.openAddEmployeeView();
  }

  public void onEmployeeButton(ActionEvent actionEvent)
  {
    viewHandler.openAddEmployeeView();
  }

  public void onManagerButton(ActionEvent actionEvent)
  {
    viewHandler.openAddEmployeeView();
  }

  public void onCreateButton(ActionEvent actionEvent)
  {
  }
}
