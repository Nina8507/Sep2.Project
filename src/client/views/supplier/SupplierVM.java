package client.views.supplier;

import client.core.ViewHandler;
import client.model.supplierModel.SupplierClientModel;
import client.model.usermodel.UserClientModel;

public class SupplierVM
{
  private ViewHandler viewHandler;
  private SupplierClientModel supplierClientModel;
  private UserClientModel userClientModel;

  public SupplierVM(ViewHandler viewHandler, SupplierClientModel supplierClientModel, UserClientModel userClientModel)
  {
    this.viewHandler = viewHandler;
    this.supplierClientModel = supplierClientModel;


  }

}
