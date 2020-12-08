package persistance.customerDAO;

import persistance.JDBCController;
import shared.transfer.Customer;
import shared.transfer.address.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO
{
  private static CustomerDAOImpl customerInstance;
  private JDBCController controller;

  private CustomerDAOImpl()
  {
    try
    {
      DriverManager.registerDriver(new org.postgresql.Driver());
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    controller = JDBCController.getInstance();
  }

  public static synchronized CustomerDAOImpl getInstance()
  {
    if (customerInstance == null)
    {
      customerInstance = new CustomerDAOImpl();
    }
    return customerInstance;
  }

  @Override public List<Customer> viewAllCustomers(String searchCriteria)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM Customer WHERE  LIKE ?");
      statement.setString(1, "%" + searchCriteria + "%");
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Customer> result = new ArrayList<>();
      while(resultSet.next())
      {
        int customer_id = resultSet.getInt("customer_id");
        String fname = resultSet.getString("fname");
        String lname = resultSet.getString("lname");
        Address address_id = (Address) resultSet.getObject("address_id");
        String phoneNo = resultSet.getString("phoneNo");
        Date orderDate = resultSet.getDate("orderDate");
        int orderNumber = resultSet.getInt("orderNumber");
        int quantityOrdered = resultSet.getInt("quantityOrdered");
        double price = resultSet.getDouble("price");
        Customer customer = new Customer(customer_id, fname, lname, address_id, phoneNo, orderDate, orderNumber, quantityOrdered, price);
        result.add(customer);
      }
      return result;
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }

    return null;
  }
}
