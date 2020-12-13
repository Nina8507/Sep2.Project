package client.core;

import client.views.adminview.MainViewVM;
import client.views.login.LoginVM;
import client.views.staff.StaffVM;

public class ViewModelFactory
{
  private LoginVM loginVM;
  private MainViewVM mainViewVM;
  private ModelFactory modelFactory;
  private ClientFactory clientFactory;
   public ViewModelFactory(ModelFactory modelFactory, ClientFactory cf)
   {
     this.modelFactory = modelFactory;
     clientFactory = cf;
   }
   public LoginVM getLoginVM()
   {
     if(loginVM == null)
     {
       loginVM = new LoginVM(modelFactory.getUserClientModel(), clientFactory.getClient());
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
