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
      int measurements, String material, int quantity, String color,
      double purchasePrice, double salePrice)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO Products(product_id, productName, measurements, material, quantity, color, purchasePrice, salePrice) VALUES(?,?,?,?,?,?,?, ?);");
      statement.setInt(1, product_id);
      statement.setString(2, productName);
      statement.setInt(3, measurements);
      statement.setString(4, material);
      statement.setInt(5, quantity);
      statement.setString(6, color);
      statement.setDouble(7, purchasePrice);
      statement.setDouble(8, salePrice);
      statement.executeQuery();
      return new Product(product_id, productName, measurements, material,
          quantity, color, purchasePrice, salePrice);

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
          "UPDATE Products SET product_id = ?, productName = ?, measurements = ?, material = ?, quantity = ?, color = ?, purchasePrice = ?, salePrice = ?");
      statement.setInt(1, product.getProduct_id());
      statement.setString(2, product.getProductName());
      statement.setInt(3, product.getMeasurements());
      statement.setString(4, product.getMaterial());
      statement.setInt(5, product.getQuantity());
      statement.setString(6, product.getColor());
      statement.setDouble(7, product.getPurchasePrice());
      statement.setDouble(8, product.getSalePrice());
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
      if (resultSet.next())
      {
        String productName = resultSet.getString("productName");
        int measurements = resultSet.getInt("measurements");
        String material = resultSet.getString("material");
        int quantity = resultSet.getInt("quantity");
        String color = resultSet.getString("color");
        double purchasePrice = resultSet.getDouble("purchasePrice");
        double salePrice = resultSet.getDouble("salePrice");
        Product product = new Product(product_id, productName, measurements,
            material, quantity, color, purchasePrice, salePrice);
        return product;
      }
      else
      {
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
        int measurements = resultSet.getInt("measurements");
        String material = resultSet.getString("material");
        int quantity = resultSet.getInt("quantity");
        String color = resultSet.getString("color");
        double purchasePrice = resultSet.getDouble("purchasePrice");
        double salePrice = resultSet.getDouble("salePrice");
        Product product = new Product(product_id, productName, measurements,
            material, quantity, color, purchasePrice,salePrice );
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
