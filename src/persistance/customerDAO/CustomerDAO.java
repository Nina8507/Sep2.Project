package persistance.customerDAO;

import shared.transfer.Customer;

import java.util.List;

public interface CustomerDAO
{
  List<Customer> viewAllCustomers(String searchCriteria);
}
