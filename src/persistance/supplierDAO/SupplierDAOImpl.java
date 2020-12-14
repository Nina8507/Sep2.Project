package persistance.supplierDAO;

import persistance.JDBCController;
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

  @Override public Supplier addSupplier(Supplier supplier)
  {
    Supplier newSupplier = null;
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO Suppliers(supplier_id, fName, lName, cvrNr, street, city, country, zipcode, email, phoneNo) VALUES(?, ?, ?, ?,?,?,?,?, ?,?);");
      statement.setString(1, supplier.getSupplier_id());
      statement.setString(2, supplier.getfName());
      statement.setString(3, supplier.getlName());
      statement.setString(4, supplier.getCvrNr());
      statement.setString(5, supplier.getStreet());
      statement.setString(6, supplier.getCity());
      statement.setString(7, supplier.getCountry());
      statement.setString(8, supplier.getZipcode());
      statement.setString(9, supplier.getEmail());
      statement.setString(10, supplier.getPhoneNo());
      statement.executeUpdate();
      newSupplier = new Supplier(supplier.getSupplier_id(), supplier.getfName(),
          supplier.getlName(), supplier.getCvrNr(), supplier.getStreet(),
          supplier.getCity(), supplier.getCountry(), supplier.getZipcode(),
          supplier.getEmail(), supplier.getPhoneNo());
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return newSupplier;
  }

  @Override public Supplier getSupplier(Supplier supplier)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM supplier WHERE supplier_id = ?, fName = ?, lName = ?, cvrNr = ?, street = ?, city = ?, country = ?, zipcode = ?, email = ?, phoneNo = ? ");
      statement.setString(1, supplier.getSupplier_id());
      statement.setString(2,supplier.getfName());
      statement.setString(3, supplier.getlName());
      statement.setString(4, supplier.getCvrNr());
      statement.setString(5, supplier.getStreet());
      statement.setString(6, supplier.getCity());
      statement.setString(7, supplier.getCountry());
      statement.setString(8, supplier.getZipcode());
      statement.setString(9, supplier.getEmail());
      statement.setString(10, supplier.getPhoneNo());
      ResultSet resultSet = statement.executeQuery();

      if(resultSet.next())
      {
        String supplier_id = resultSet.getString("supplier_id");
        String fName = resultSet.getString("fName");
        String lName = resultSet.getString("lName");
        String cvrNr = resultSet.getString("cvrNr");
        String street = resultSet.getString("street");
        String city = resultSet.getString("city");
        String country = resultSet.getString("country");
        String zipcode = resultSet.getString("zipcode");
        String email = resultSet.getString("email");
        String phoneNo = resultSet.getString("phoneNo");

        Supplier supplierToReturn = new Supplier(supplier_id,fName,lName, cvrNr,street, city, country, zipcode, email, phoneNo);

        return supplierToReturn;
      }
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
          "SELECT * FROM Suppliers WHERE supplier_id = id LIKE ?");
      statement.setString(1, "%" + searchCriteria + "%");
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Supplier> result = new ArrayList<>();
      while (resultSet.next())
      {
        String supplier_id = resultSet.getString("supplier_id");
        String fName = resultSet.getString("fName");
        String lName = resultSet.getString("lName");
        String cvrNr = resultSet.getString("cvrNr");
        String street = resultSet.getString("street");
        String city = resultSet.getString("city");
        String country = resultSet.getString("country");
        String zipcode = resultSet.getString("zipcode");
        String email = resultSet.getString("email");
        String phoneNo = resultSet.getString("phoneNo");
        Supplier supplier = new Supplier(supplier_id, fName, lName, cvrNr,
            street, city, country, zipcode, email, phoneNo);
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
      statement.setString(1, supplier.getSupplier_id());
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
          "UPDATE Suppliers SET supplier_id = ?, fname = ?, lname = ?, cvrNr = ?, street = ?, city = ?, country = ?, zipcode = ?, email = ?, phoneNo = ?");
      statement.setString(1, supplier.getSupplier_id());
      statement.setString(2, supplier.getfName());
      statement.setString(3, supplier.getlName());
      statement.setString(4, supplier.getCvrNr());
      statement.setString(5, supplier.getStreet());
      statement.setString(6, supplier.getCity());
      statement.setString(7, supplier.getCountry());
      statement.setString(8, supplier.getZipcode());
      statement.setString(9, supplier.getEmail());
      statement.setString(10, supplier.getPhoneNo());
      statement.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }
}
