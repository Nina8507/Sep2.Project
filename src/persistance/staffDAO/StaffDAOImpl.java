package persistance.staffDAO;

import persistance.JDBCController;
import shared.transfer.address.Address;
import shared.transfer.address.City;
import shared.transfer.address.Country;
import shared.transfer.staff.Employee;
import shared.transfer.staff.Management;
import shared.transfer.staff.Secretary;
import shared.transfer.staff.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*public class StaffDAOImpl implements StaffDAO
{
  private static StaffDAOImpl staffInstance;
  private JDBCController controller;

  private StaffDAOImpl()
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

  public static synchronized StaffDAOImpl getInstance()
  {
    if (staffInstance == null)
    {
      staffInstance = new StaffDAOImpl();
    }
    return staffInstance;
  }

  @Override public Staff createNewEmployee(int staff_id, int cprNr,
      String fname, String lname, Address address_id, String phoneNo,
      Date startDate, double salary)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO Staff(staff_id, cnpNr, fname, lname, address_id, phoneNo, startDate, salary) VALUES(?, ?, ?, ?, ?, ?, ?, ?);");
      statement.setInt(1, staff_id);
      statement.setInt(2, cprNr);
      statement.setString(3, fname);
      statement.setString(4, lname);
      statement.setInt(6, address_id.getAddress_id());
      statement.setString(7, phoneNo);
      statement.setDate(8, (java.sql.Date) startDate);
      statement.setDouble(9, salary);
      statement.executeQuery();
      return new Employee(staff_id, cprNr, fname, lname, address_id,
          phoneNo, startDate, salary);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public Staff createNewSecretary(int staff_id, int cprNr,
      String fname, String lname, Address address_id, String phoneNo,
      Date startDate, double salary)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO Staff(staff_id, cnpNr, fname, lname,address_id, phoneNo, startDate, salary) VALUES(?, ?, ?, ?, ?, ?, ?, ?);");
      statement.setInt(1, staff_id);
      statement.setInt(2, cprNr);
      statement.setString(3, fname);
      statement.setString(4, lname);
      statement.setInt(6, address_id.getAddress_id());
      statement.setString(7, phoneNo);
      statement.setDate(8, (java.sql.Date) startDate);
      statement.setDouble(9, salary);
      statement.executeQuery();
      return new Secretary(staff_id, cprNr, fname, lname, address_id,
          phoneNo, startDate, salary);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();

    }
  }

  @Override public Staff createNewManager(int staff_id, int cprNr, String fname,
      String lname, String email, Address address_id, String phoneNo,
      Date startDate, double salary)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO Staff(staff_id, cnpNr, fname, lname, email ,address_id, phoneNo, startDate, salary) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);");
      statement.setInt(1, staff_id);
      statement.setInt(2, cprNr);
      statement.setString(3, fname);
      statement.setString(4, lname);
      statement.setString(5, email);
      statement.setInt(6, address_id.getAddress_id());
      statement.setString(7, phoneNo);
      statement.setDate(8, (java.sql.Date) startDate);
      statement.setDouble(9, salary);
      statement.executeQuery();
      return new Management(staff_id, cprNr, fname, lname, email, address_id,
          phoneNo, startDate, salary);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public Staff searchStaffByCprNr(int cprNr)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM Staff JOIN Address ON address_id = id WHERE cprNr = ?");
      statement.setInt(1, cprNr);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        int staff_id = resultSet.getInt("staff_id");
        String fname = resultSet.getString("fname");
        String lname = resultSet.getString("lname");
        String email = resultSet.getString("email");
        int address_id = resultSet.getInt("address_id");
        String street = resultSet.getString("street");
        int streetNumber = resultSet.getInt("streetNumber");
        City city = (City) resultSet.getObject("city");
        Country country = (Country) resultSet.getObject("country");
        String phoneNo = resultSet.getString("phoneNo");
        Date startDate = resultSet.getDate("startDate");
        double salary = resultSet.getDouble("salary");
        Address address = new Address(address_id, street, streetNumber, city,
            country);
        Staff employee = new Employee(staff_id, cprNr, fname, lname, email,
            address, phoneNo, startDate, salary);
        Staff secretary = new Secretary(staff_id, cprNr, fname, lname, email,
            address, phoneNo, startDate, salary);
        Staff management = new Management(staff_id, cprNr, fname, lname, email,
            address, phoneNo, startDate, salary);
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public List<Staff> viewAllStaffByStaffName(String searchCriteria)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection
          .prepareStatement("SELECT * FROM Staff WHERE searchCriteria = ?");
      statement.setString(1, searchCriteria);
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Secretary> secretaryResult = new ArrayList<>();
      ArrayList<Employee> employeeResult = new ArrayList<>();
      ArrayList<Management> managerResult = new ArrayList<>();
      while (resultSet.next())
      {
        int staff_id = resultSet.getInt("staff_id");
        String lname = resultSet.getString("lname");
        int cprNr = resultSet.getInt("cprNr");
        String email = resultSet.getString("email");
        int address = resultSet.getInt("address_id");
        String street = resultSet.getString("street");
        int streetNumber = resultSet.getInt("streetNumber");
        City city_id = (City) resultSet.getObject("city_id");
        Country country_id = (Country) resultSet.getObject("country_id");
        String phoneNo = resultSet.getString("phoneNo");
        Date startDate = resultSet.getDate("startDate");
        double salary = resultSet.getDouble("salary");
        Address address_id = new Address(address, street, streetNumber, city_id,
           country_id);
        Staff employee = new Employee(staff_id, cprNr, searchCriteria, lname,
            address_id, phoneNo, startDate, salary);
        Staff secretary = new Secretary(staff_id, cprNr, searchCriteria, lname,
            address_id, phoneNo, startDate, salary);
        Staff management = new Management(staff_id, cprNr, searchCriteria, lname,
            address_id, phoneNo, startDate, salary);
        secretaryResult.add((Secretary) secretary);
        employeeResult.add((Employee) employee);
        managerResult.add((Management) management);
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public void deleteStaff(Staff staff)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection
          .prepareStatement("DELETE FROM Staff WHERE staff_id = ?");
      statement.setInt(1, staff.getStaff_id());
      statement.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public void updateStaff(Staff staff)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "UPDATE Staff SET staff_id = ?, cprNr = ?, fname = ?, lname = ?, address_id = ?, phoneNo = ?, startDate = ?, salary = ?");
      statement.setInt(1, staff.getStaff_id());
      statement.setInt(2, staff.getCprNr());
      statement.setString(3, staff.getFname());
      statement.setString(4, staff.getLname());
      statement.setObject(6, staff.getAddress_id());
      statement.setString(7, staff.getPhoneNo());
      statement.setDate(8, (java.sql.Date) staff.getStartDate());
      statement.setDouble(9, staff.getSalary());
      statement.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }
}*/
