package client.model.adminclientmodel;

import shared.util.Subject;

public interface AdminClientModel extends Subject
{
  void getProductList();
  void getSupplierList();
  void getStaffList();
  void getCustomerList();
}
