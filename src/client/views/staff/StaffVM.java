package client.views.staff;

import client.model.staffmodel.StaffClientModel;
import client.networking.Client;

public class StaffVM
{
  private StaffClientModel staffClientModel;

  public StaffVM(StaffClientModel staffClientModel)
  {
    this.staffClientModel = staffClientModel;
  }
}
