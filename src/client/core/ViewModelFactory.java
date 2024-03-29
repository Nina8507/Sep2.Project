package client.core;

import client.views.mainview.MainViewVM;
import client.views.login.LoginVM;
import client.views.product.ProductVM;
import client.views.product.addproduct.AddProductVM;
import client.views.staff.StaffVM;
import client.views.staff.addnewstaff.addemployee.AddEmployeeVM;
import client.views.staff.addnewstaff.addnewsecretary.AddSecretaryVM;
import client.views.supplier.SupplierVM;
import client.views.supplier.addsupplier.AddSupplierVM;
import client.views.supplier.listviewsupplier.ListViewSupplierVM;

public class ViewModelFactory
{
  private LoginVM loginVM;
  private MainViewVM mainViewVM;
  private SupplierVM supplierVM;
  private StaffVM staffVM;
  private AddSupplierVM addSupplierVM;
  private ListViewSupplierVM listViewSupplierVM;
  private AddEmployeeVM addEmployeeVM;
  private ProductVM productVM;
  private AddProductVM addProductVM;
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

  public ListViewSupplierVM getListViewSupplierVM()
  {
    if(listViewSupplierVM == null)
    {
      listViewSupplierVM = new ListViewSupplierVM(modelFactory.getListViewSupplierClientModel());
    }
    return listViewSupplierVM;
  }

  public StaffVM getStaffVM()
  {
    if(staffVM == null)
    {
      staffVM = new StaffVM(modelFactory.getStaffClientModel());
    }
    return staffVM;
  }

  public AddEmployeeVM getAddEmployeeVM()
  {
    if(addEmployeeVM == null)
    {
      addEmployeeVM = new AddEmployeeVM(modelFactory.getAddEmployeeClientModel());
    }
    return addEmployeeVM;
  }

  public ProductVM getProductVM()
  {
    if(productVM == null)
    {
      productVM = new ProductVM(modelFactory.getProductClientModel());
    }
    return productVM;
  }

  public AddProductVM getAddProductVm()
  {
    if(addProductVM == null)
    {
      addProductVM = new AddProductVM(modelFactory.getAddProductClientModel());
    }
    return addProductVM;
  }
}
