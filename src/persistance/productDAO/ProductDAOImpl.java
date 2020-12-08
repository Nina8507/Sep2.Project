package persistance.productDAO;

import persistance.JDBCController;
import shared.transfer.Product;

import java.sql.*;
import java.util.ArrayList;
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
          "INSERT INTO Products(product_id, productName, length, width, height, material, quantity, color, price) VALUES(?,?,?,?,?,?,?,?,?);");
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
      return new Product(product_id, productName, length, width, height,
          material, quantity, color, price);

    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public void updateProduct(Product product)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "UPDATE Products SET product_id = ?, productName = ?, length = ?, width = ?, height = ?, material = ?, quantity = ?, color = ?, price = ?");
      statement.setInt(1, product.getProduct_id());
      statement.setString(2, product.getProductName());
      statement.setInt(3, product.getLength());
      statement.setInt(4, product.getWidth());
      statement.setInt(5, product.getHeight());
      statement.setString(6, product.getMaterial());
      statement.setInt(7, product.getQuantity());
      statement.setString(8, product.getColor());
      statement.setDouble(9, product.getPrice());
      statement.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public Product searchProductByProduct_id(int product_id)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection
          .prepareStatement(" SELECT * FROM Products WHERE product_id = ?");
      statement.setInt(1, product_id);
      ResultSet resultSet = statement.executeQuery();
      if(resultSet.next())
      {
        String productName = resultSet.getString("productName");
        int length = resultSet.getInt("length");
        int width = resultSet.getInt("width");
        int height = resultSet.getInt("height");
        String material = resultSet.getString("material");
        int quantity = resultSet.getInt("quantity");
        String color = resultSet.getString("color");
        double price = resultSet.getInt("price");
        Product product = new Product(product_id, productName, length, width,
            height, material, quantity, color, price);
        return product;
      } else {
        return null;
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public List<Product> viewAllProductsByProductName(
      String searchCriteria)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection
          .prepareStatement("SELECT * FROM Products WHERE productName LIKE ?");
      statement.setString(1, "%" + searchCriteria + "%");
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Product> result = new ArrayList<>();
      while (resultSet.next())
      {
        int product_id = resultSet.getInt("product_id");
        String productName = resultSet.getString("productName");
        int length = resultSet.getInt("length");
        int width = resultSet.getInt("width");
        int height = resultSet.getInt("height");
        String material = resultSet.getString("material");
        int quantity = resultSet.getInt("quantity");
        String color = resultSet.getString("color");
        double price = resultSet.getInt("price");
        Product product = new Product(product_id, productName, length, width,
            height, material, quantity, color, price);
        result.add(product);
      }
      return result;
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public void deleteProduct(Product product)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection
          .prepareStatement("DELETE FROM Products WHERE product_id = ?");
      statement.setInt(1, product.getProduct_id());
      statement.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }
}
