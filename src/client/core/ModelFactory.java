package client.core;

import client.model.addsuppliercleintmodel.AddSupplierClientModel;
import client.model.addsuppliercleintmodel.AddSupplierClientModelManager;
import client.model.adminclientmodel.AdminClientModel;
import client.model.adminclientmodel.AdminClientModelManager;
import client.model.listviewsupplier.ListViewSupplierClientModel;
import client.model.listviewsupplier.ListViewSupplierClientModelManager;
import client.model.staffmodel.StaffClientModel;
import client.model.staffmodel.StaffClientModelManager;
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
}
