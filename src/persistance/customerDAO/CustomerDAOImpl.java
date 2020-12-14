package persistance.customerDAO;

import persistance.JDBCController;
import shared.transfer.Customer;

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
    ArrayList<Customer> result = null;
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection
          .prepareStatement("SELECT * FROM Customer WHERE  LIKE ?");
      statement.setString(1, "%" + searchCriteria + "%");
      ResultSet resultSet = statement.executeQuery();
      result = new ArrayList<>();
      while (resultSet.next())
      {
        String customer_id = resultSet.getString("customer_id");
        String name = resultSet.getString("name");
        String streetName = resultSet.getString("streetName");
        String city = resultSet.getString("city");
        String country = resultSet.getString("country");
        String zipcode = resultSet.getString("zipcode");
        String phoneNo = resultSet.getString("phoneNo");
        Date orderDate = resultSet.getDate("orderDate");
        int orderNumber = resultSet.getInt("orderNumber");
        int quantityOrdered = resultSet.getInt("quantityOrdered");
        double price = resultSet.getDouble("price");
        Customer customer = new Customer(customer_id, name, city, streetName,
            country, zipcode, phoneNo, orderDate, orderNumber, quantityOrdered,
            price);
        result.add(customer);
      }

    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }

    return result;
  }
}
