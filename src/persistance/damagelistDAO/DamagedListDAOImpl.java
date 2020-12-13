package persistance.damagelistDAO;

import persistance.JDBCController;
import shared.transfer.products.DamageProduct;
import shared.transfer.products.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DamagedListDAOImpl implements DamagedListDAO
{
  private static DamagedListDAOImpl damagedListInstance;
  private JDBCController controller;

  private DamagedListDAOImpl()
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

  private static synchronized DamagedListDAOImpl getInstance()
  {
    if (damagedListInstance == null)
    {
      damagedListInstance = new DamagedListDAOImpl();
    }
    return damagedListInstance;
  }

  @Override public List<DamageProduct> showDamageProductList(
      String searchCriteria)
  {
    ArrayList<DamageProduct> result = null;
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM DamagedProductList WHERE product_id LIKE ?");
      statement.setString(1, "%" + searchCriteria + "%");
      ResultSet resultSet = statement.executeQuery();
      resultSet = (ResultSet) new ArrayList<DamageProduct>();
      while (resultSet.next())
      {
        int damagedList_id = resultSet.getInt("damagedProduct_id");
        Product product = (Product) resultSet.getObject("product_id");
        Date date = (Date) resultSet.getObject("date");
        DamageProduct damageProduct = new DamageProduct(damagedList_id, product,
            date);
        result.add(damageProduct);
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return result;
  }

  @Override public DamageProduct addDamagedProduct(Product damagedProduct,
      int damagedProduct_id, Date date)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO DamageProductList(damageProduct_id, product_id, date) VALUES(?,?,?);");
      statement.setInt(1, damagedProduct_id);
      statement.setObject(2, damagedProduct);
      statement.setObject(3, date);
      statement.executeQuery();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return new DamageProduct(damagedProduct_id, damagedProduct, date);
  }

  @Override public void deleteDamagedProduct(DamageProduct damageProduct)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "DELETE FROM DamageProductList WHERE damageProduct_id = ?");
      statement.setInt(1, damageProduct.getDamagedProduct_id());
      statement.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }
}


