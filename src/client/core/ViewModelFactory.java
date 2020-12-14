package client.core;

import client.views.adminview.MainViewVM;
import client.views.login.LoginVM;
import client.views.staff.StaffVM;

public class ViewModelFactory
{
  private LoginVM loginVM;
  private MainViewVM mainViewVM;
  private ModelFactory modelFactory;
   public ViewModelFactory(ModelFactory modelFactory)
   {
     this.modelFactory = modelFactory;
   }
   public LoginVM getLoginVM()
   {
     if(loginVM == null)
     {
       loginVM = new LoginVM(modelFactory.getUserClientModel());
     }
     return loginVM;
   }

  public MainViewVM getMainViewVM()
  {
    if(mainViewVM == null)
    {
      mainViewVM = new MainViewVM(modelFactory.getAdminClientModel());
    }
    return mainViewVM;
  }

}
