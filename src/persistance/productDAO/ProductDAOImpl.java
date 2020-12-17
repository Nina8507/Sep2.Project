package persistance.productDAO;

import persistance.JDBCController;
import shared.transfer.products.Product;

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

  @Override public String addNewProduct(Product product)
  {
    String result = "";
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO Products(product_id, productName, measurements, material, quantity, color, purchasePrice, salePrice) VALUES(?,?,?,?,?,?,?, ?);");
      statement.setString(1, product.getProduct_id());
      statement.setString(2, product.getProductName());
      statement.setString(3, product.getMeasurements());
      statement.setString(4, product.getMaterial());
      statement.setString(5, product.getQuantity());
      statement.setString(6, product.getColor());
      statement.setString(7, product.getPurchasePrice());
      statement.setString(8, product.getSalePrice());
      statement.executeQuery();

      Product productAdded = new Product(product.getProduct_id(),
          product.getProductName(), product.getMeasurements(),
          product.getMaterial(), product.getQuantity(), product.getColor(),
          product.getPurchasePrice(), product.getSalePrice());

    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
      return result;
  }

  @Override public void updateProduct(Product product)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "UPDATE Products SET product_id = ?, productName = ?, measurements = ?, material = ?, quantity = ?, color = ?, purchasePrice = ?, salePrice = ?");
      statement.setString(1, product.getProduct_id());
      statement.setString(2, product.getProductName());
      statement.setString(3, product.getMeasurements());
      statement.setString(4, product.getMaterial());
      statement.setString(5, product.getQuantity());
      statement.setString(6, product.getColor());
      statement.setString(7, product.getPurchasePrice());
      statement.setString(8, product.getSalePrice());
      statement.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public Product searchProductByProduct_id(String product_id)
  {
    Product product = null;
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection
          .prepareStatement(" SELECT * FROM Products WHERE product_id = ?");
      statement.setString(1, product_id);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        String productName = resultSet.getString("productName");
        String measurements = resultSet.getString("measurements");
        String material = resultSet.getString("material");
        String quantity = resultSet.getString("quantity");
        String color = resultSet.getString("color");
        String purchasePrice = resultSet.getString("purchasePrice");
        String salePrice = resultSet.getString("salePrice");
        product = new Product(product_id, productName, measurements, material,
            quantity, color, purchasePrice, salePrice);
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
    return product;
  }

  @Override public List<Product> viewAllProductsByProductName(
      String searchCriteria)
  {
    ArrayList<Product> result = new ArrayList<>();
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection
          .prepareStatement("SELECT * FROM Products WHERE productName LIKE ?");
      statement.setString(1, "%" + searchCriteria + "%");
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next())
      {
        String product_id = resultSet.getString("product_id");
        String productName = resultSet.getString("productName");
        String measurements = resultSet.getString("measurements");
        String material = resultSet.getString("material");
        String quantity = resultSet.getString("quantity");
        String color = resultSet.getString("color");
        String purchasePrice = resultSet.getString("purchasePrice");
        String salePrice = resultSet.getString("salePrice");
        Product product = new Product(product_id, productName, measurements,
            material, quantity, color, purchasePrice, salePrice);
        result.add(product);
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return result;
  }

  @Override public void deleteProduct(Product product)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection
          .prepareStatement("DELETE FROM Products WHERE product_id = ?");
      statement.setString(1, product.getProduct_id());
      statement.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

}
