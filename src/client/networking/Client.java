package client.networking;

import shared.transfer.User;
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

}
