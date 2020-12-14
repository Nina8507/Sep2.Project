package client.networking;

import shared.transfer.Supplier;
import shared.transfer.User;
import shared.transfer.staff.Staff;
import shared.util.Subject;

import java.util.ArrayList;

public interface Client extends Subject
{
  void login(User user);
  ArrayList<User> getUserList();
  void getProductList();
  void getSupplierList();
  void getStaffList();
  void getCustomerList();

  void createNewSupplier(Supplier supplierToCreate);
  void logoutUser(User user);
  void getSupplierValues(Supplier supplier);
}
