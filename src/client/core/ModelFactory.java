package client.core;

import client.model.staffmodel.addemployeeclientmodel.AddEmployeeClientModel;
import client.model.staffmodel.addemployeeclientmodel.AddEmployeeClientModelManager;
import client.model.supplierclientmodel.addsuppliercleintmodel.AddSupplierClientModel;
import client.model.supplierclientmodel.addsuppliercleintmodel.AddSupplierClientModelManager;
import client.model.adminclientmodel.AdminClientModel;
import client.model.adminclientmodel.AdminClientModelManager;
import client.model.supplierclientmodel.listviewsupplier.ListViewSupplierClientModel;
import client.model.supplierclientmodel.listviewsupplier.ListViewSupplierClientModelManager;
import client.model.productclientmodel.product.ProductClientModel;
import client.model.productclientmodel.product.ProductClientModelManager;
import client.model.productclientmodel.addproduct.AddProductClientModel;
import client.model.productclientmodel.addproduct.AddProductClientModelManager;
import client.model.staffmodel.allstaffmodel.StaffClientModel;
import client.model.staffmodel.allstaffmodel.StaffClientModelManager;
import client.model.supplierclientmodel.SupplierClientModel;
import client.model.supplierclientmodel.SupplierClientModelManager;
import client.model.usermodel.UserClientModel;
import client.model.usermodel.UserClientModelManager;

public class ModelFactory
{
  private UserClientModel userClientModel;
  private AdminClientModel adminClientModel;
  private SupplierClientModel supplierClientModel;
  private AddSupplierClientModel addSupplierClientModel;
  private ListViewSupplierClientModel listViewSupplierClientModel;
  private StaffClientModel staffClientModel;
  private AddEmployeeClientModel addEmployeeClientModel;
  private ProductClientModel productClientModel;
  private AddProductClientModel addProductClientModel;
  private ClientFactory clientFactory;

  public ModelFactory(ClientFactory clientFactory)
  {
    this.clientFactory = clientFactory;
  }
  public UserClientModel getUserClientModel()
  {
    if(userClientModel == null)
    {
      userClientModel = new UserClientModelManager(clientFactory.getClient());
    }
    return userClientModel;
  }

  public AdminClientModel getAdminClientModel()
  {
    if(adminClientModel == null)
    {
      adminClientModel = new AdminClientModelManager(clientFactory.getClient());
    }
    return adminClientModel;
  }

  public SupplierClientModel getSupplierClientModel()
  {
    if(supplierClientModel == null)
    {
      supplierClientModel = new SupplierClientModelManager(clientFactory.getClient());
    }
    return supplierClientModel;
  }

  public AddSupplierClientModel getAddSupplierClientModel()
  {
    if(addSupplierClientModel == null)
    {
      addSupplierClientModel = new AddSupplierClientModelManager(clientFactory.getClient());
    }
    return addSupplierClientModel;
  }
  public ListViewSupplierClientModel getListViewSupplierClientModel()
  {
    if(listViewSupplierClientModel == null)
    {
      listViewSupplierClientModel = new ListViewSupplierClientModelManager(clientFactory.getClient());
    }
    return listViewSupplierClientModel;
  }
  public StaffClientModel getStaffClientModel()
  {
    if(supplierClientModel == null)
    {
      staffClientModel = new StaffClientModelManager(clientFactory.getClient());
    }
    return staffClientModel;
  }
  public AddEmployeeClientModel getAddEmployeeClientModel()
  {
    if (addEmployeeClientModel == null)
    {
      addEmployeeClientModel = new AddEmployeeClientModelManager(clientFactory.getClient());
    }
    return addEmployeeClientModel;
  }

  public ProductClientModel getProductClientModel()
  {
    if(productClientModel == null)
    {
      productClientModel = new ProductClientModelManager(clientFactory.getClient());
    }
    return productClientModel;
  }


  public AddProductClientModel getAddProductClientModel()
  {
    if(addProductClientModel == null)
    {
      addProductClientModel = new AddProductClientModelManager(clientFactory.getClient());
    }
    return addProductClientModel;
  }
}
