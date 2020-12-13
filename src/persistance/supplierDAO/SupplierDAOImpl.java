package persistance.supplierDAO;

import persistance.JDBCController;
import shared.transfer.products.Product;
import shared.transfer.Supplier;
import shared.transfer.address.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO
{
  private static SupplierDAOImpl supplierInstance;
  private JDBCController controller;

  private SupplierDAOImpl()
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

  public static synchronized SupplierDAOImpl getInstance()
  {
    if (supplierInstance == null)
    {
      supplierInstance = new SupplierDAOImpl();
    }
    return supplierInstance;
  }

  @Override public Supplier addNewSupplier(int supplier_id, Product product,
      String supplierName, int cvrNr, Address address_id, String email,
      String phoneNo)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO Suppliers(supplier_id, product_id, supplierName, cvrNr, address_id, email, phoneNo) VALUES(?, ?, ?, ?, ?, ?, ?);");
      statement.setInt(1, supplier_id);
      statement.setInt(2, product.getProduct_id());
      statement.setString(3, supplierName);
      statement.setInt(4, cvrNr);
      statement.setInt(5, address_id.getAddress_id());
      statement.setString(6, email);
      statement.setString(7, phoneNo);
      statement.executeUpdate();
      return new Supplier(supplier_id, product, supplierName, cvrNr, address_id,
          email, phoneNo);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public List<Supplier> viewAllSuppliers(String searchCriteria)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM Suppliers JOIN Products ON product_id = id WHERE  LIKE ?");
      statement.setString(1, "%" + searchCriteria + "%");
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Supplier> result = new ArrayList<>();
      while (resultSet.next())
      {
        int supplier_id = resultSet.getInt("supplier_id");
        Product product = (Product) resultSet.getObject("product");
        String supplierName = resultSet.getString("supplierName");
        int cvrNr = resultSet.getInt("cvrNr");
        Address address_id = (Address) resultSet.getObject("address_id");
        String email = resultSet.getString("email");
        String phoneNo = resultSet.getString("phoneNo");
        Supplier supplier = new Supplier(supplier_id, product, supplierName, cvrNr, address_id, email, phoneNo);
        result.add(supplier);
      }
      return result;
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public void deleteSupplier(Supplier supplier)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection
          .prepareStatement("DELETE FROM Suppliers WHERE supplier_id = ?");
      statement.setInt(1, supplier.getSupplier_id());
      statement.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public void updateSupplier(Supplier supplier)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "UPDATE Suppliers SET supplier_id = ?, product_id = ?, supplierName = ?, cvrNr = ?, address_id = ?, email = ?, phoneNo = ?");
      statement.setInt(1, supplier.getSupplier_id());
      statement.setObject(2, supplier.getProduct());
      statement.setString(3, supplier.getSupplierName());
      statement.setInt(4, supplier.getCvrNr());
      statement.setObject(5, supplier.getAddress_id());
      statement.setString(6, supplier.getEmail());
      statement.setString(7, supplier.getPhoneNo());
      statement.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }
}
