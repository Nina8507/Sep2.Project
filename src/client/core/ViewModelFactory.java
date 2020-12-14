package client.core;

import client.views.adminview.MainViewVM;
import client.views.login.LoginVM;
import client.views.supplier.SupplierVM;
import client.views.supplier.addsupplier.AddSupplierVM;

public class ViewModelFactory
{
  private LoginVM loginVM;
  private MainViewVM mainViewVM;
  private SupplierVM supplierVM;
  private AddSupplierVM addSupplierVM;
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
  public SupplierVM getSupplierVM()
  {
    if(supplierVM == null)
    {
      supplierVM = new SupplierVM(modelFactory.getSupplierClientModel());
    }
    return supplierVM;
  }
  public AddSupplierVM getAddSupplierVM()
  {
    if(addSupplierVM == null)
    {
      addSupplierVM = new AddSupplierVM(modelFactory.getAddSupplierClientModel());
    }
    return addSupplierVM;
  }
}
