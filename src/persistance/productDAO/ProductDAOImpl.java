package persistance.productDAO;

import persistance.JDBCController;
import shared.transfer.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductDAOImpl implements ProductDAO
{

  private static ProductDAOImpl productInstance;
  private JDBCController controller;

  private ProductDAOImpl()
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

  public static synchronized ProductDAOImpl getInstance()
  {
    if (productInstance == null)
    {
      productInstance = new ProductDAOImpl();
    }
    return productInstance;
  }

  @Override public Product addNewProduct(int product_id, String productName,
      int length, int width, int height, String material, int quantity,
      String color, double price)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO Products(product_id, productName, length, width, height, material, quantity, color, price) VALUES(?,?,?,?,?,?,?,?,?)");
      statement.setInt(1, product_id);
      statement.setString(2, productName);
      statement.setInt(3, length);
      statement.setInt(4, width);
      statement.setInt(5, height);
      statement.setString(6, material);
      statement.setInt(7, quantity);
      statement.setString(8, color);
      statement.setDouble(9, price);
      statement.executeQuery();
      return new Product(product_id, productName, length, width, height, material, quantity, color, price);

    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public void updateProduct(Product product)
  {

  }

  @Override public Product searchProductByProduct_id(int product_id)
  {
    return null;
  }

  @Override public List<Product> viewAllProductsByProductName(
      String productName)
  {
    return null;
  }

  @Override public void deleteProduct(Product product)
  {

  }
}
