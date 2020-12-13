package persistance.orderlistDAO;

import persistance.JDBCController;
import shared.transfer.Customer;
import shared.transfer.OrderList;
import shared.transfer.products.Product;
import shared.transfer.staff.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderListDAOImpl implements OrderListDAO
{
  private static OrderListDAOImpl orderInstance;
  private JDBCController controller;

  private OrderListDAOImpl()
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

  public static synchronized OrderListDAOImpl getInstance()
  {
    if (orderInstance == null)
    {
      orderInstance = new OrderListDAOImpl();
    }
    return orderInstance;
  }

  @Override public OrderList addNewOrder(int order_id, Employee employee_id,
      Customer customer_id, Date date)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO OrderList(orders_id, employee_id, customer_id, date) VALUES(?,?,?,?);");
      statement.setInt(1, order_id);
      statement.setObject(2, employee_id);
      statement.setObject(3, customer_id);
      statement.setObject(4, date);
      statement.executeQuery();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return new OrderList(order_id, employee_id, customer_id, date);
  }

  @Override public List<OrderList> viewAllOrders(String searchCriteria)
  {
    ArrayList<OrderList> result = new ArrayList<>();
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection
          .prepareStatement("SELECT * FROM OrderList WHERE order_id LIKE ?");
      statement.setString(1, "%" + searchCriteria + "%");
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next())
      {
        int order_id = resultSet.getInt("order_id");
        Employee employee_id = (Employee) resultSet.getObject("employee_id");
        Customer customer_id = (Customer) resultSet.getObject("customer_id");
        Date date = (Date) resultSet.getObject("date");
        OrderList newOrder = new OrderList(order_id, employee_id, customer_id,
            date);
        result.add(newOrder);
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return result;
  }

  @Override public void updateAnOrder(OrderList order)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "UPDATE OrderList SET order_id = ?, employee_id = ?, customer_id = ?, date = ?");
      statement.setInt(1, order.getOrders_id());
      statement.setObject(2, order.getEmployee_id());
      statement.setObject(3, order.getCustomer_id());
      statement.setObject(4, order.getDate());
      statement.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public void deleteAnOrder(OrderList order)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection
          .prepareStatement("DELETE FROM OrderList WHERE order_id = ?");
      statement.setInt(1, order.getOrders_id());
      statement.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }
}

