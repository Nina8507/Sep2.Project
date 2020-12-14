package persistance.staffDAO;

import persistance.JDBCController;
import shared.transfer.User;
import shared.transfer.UserAction;
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
import java.util.Objects;

public class StaffDAOImpl implements StaffDAO
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

  @Override public Staff createNewEmployee(String username, String password, String role,
      int staff_id, int cprNr, String fname, String lname, Address address_id,
      String phoneNo, Date startDate, double salary)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO Staff(staff_id, cnpNr, fname, lname, address_id, phoneNo, startDate, salary, user_id, password, role) VALUES(?, ?,?, ?, ?, ?, ?, ?, ?,? ,?);");
      statement.setInt(1, staff_id);
      statement.setInt(2, cprNr);
      statement.setString(3, fname);
      statement.setString(4, lname);
      statement.setObject(5, address_id.getAddress_id());
      statement.setString(6, phoneNo);
      statement.setDate(7, (java.sql.Date) startDate);
      statement.setDouble(8, salary);
      statement.setString(9, username);
      statement.setString(10, password);
      statement.setString(11, role);
      statement.executeQuery();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return new Employee(username, password, role, staff_id, cprNr, fname, lname,
        address_id, phoneNo, startDate, salary);
  }

  @Override public Staff createNewSecretary(String username, String password, String role,
      int staff_id, int cprNr, String fname, String lname, Address address_id,
      String phoneNo, Date startDate, double salary)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO Staff(staff_id, cnpNr, fname, lname, address_id, phoneNo, startDate, salary, user_id, password, role) VALUES(?, ?, ?, ?, ?, ?,?, ?, ?,? ,?);");
      statement.setInt(1, staff_id);
      statement.setInt(2, cprNr);
      statement.setString(3, fname);
      statement.setString(4, lname);
      statement.setObject(5, address_id.getAddress_id());
      statement.setString(6, phoneNo);
      statement.setDate(7, (java.sql.Date) startDate);
      statement.setDouble(8, salary);
      statement.setString(9, username);
      statement.setString(10, password);
      statement.setString(11, role);
      statement.executeQuery();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return new Secretary(username, password, role, staff_id, cprNr, fname, lname,
        address_id, phoneNo, startDate, salary);
  }

  @Override public Staff createNewManager(String username, String password, String role,
      int staff_id, int cprNr, String fname, String lname, Address address_id,
      String phoneNo, Date startDate, double salary)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO Staff(staff_id, cnpNr, fname, lname, address_id, phoneNo, startDate, salary, user_id, password, role) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?,? ,?);");
      statement.setInt(1, staff_id);
      statement.setInt(2, cprNr);
      statement.setString(3, fname);
      statement.setString(4, lname);
      statement.setObject(5, address_id.getAddress_id());
      statement.setString(6, phoneNo);
      statement.setDate(7, (java.sql.Date) startDate);
      statement.setDouble(8, salary);
      statement.setString(9, username);
      statement.setString(10, password);
      statement.setString(11, role);
      statement.executeQuery();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return new Management(username, password, role, staff_id, cprNr, fname, lname,
        address_id, phoneNo, startDate, salary);
  }

  @Override public Staff searchStaffByCprNr(int cprNr)
  {
    Staff employee = null, secretary = null, management = null;
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM Staff JOIN Address ON address_id = id WHERE cprNr = ?");
      statement.setInt(1, cprNr);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        String username = resultSet.getString("user_id");
        String password = resultSet.getString("password");
        String role = resultSet.getString("role");
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
         employee = new Employee(username, password, role, staff_id, cprNr,
            fname, lname, address, phoneNo, startDate, salary);
         secretary = new Secretary(username, password, role, staff_id, cprNr,
            fname, lname, address, phoneNo, startDate, salary);
         management = new Management(username, password, role, staff_id, cprNr,
            fname, lname, address, phoneNo, startDate, salary);
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    if(cprNr == Integer.parseInt(UserAction.MANAGER.toString()))
    {
      return management;
    }else if(cprNr == Integer.parseInt(UserAction.EMPLOYEE.toString()))
    {
      return employee;
    }else if(cprNr == Integer.parseInt(UserAction.SECRETARY.toString()))
    {
      return secretary;
    } else
      return null;
  }

  @Override public List<Staff> viewAllStaffByStaffName(String searchCriteria)
  {
    ArrayList<Staff> staffResult = new ArrayList<>();
    Staff management = null, secretary = null, employee = null;
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection
          .prepareStatement("SELECT * FROM Staff WHERE searchCriteria = ?");
      statement.setString(1, searchCriteria);
      ResultSet resultSet = statement.executeQuery();

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
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        String role = resultSet.getString("role");
        Address address_id = new Address(address, street, streetNumber, city_id,
            country_id);
        employee = new Employee(username, password, role, staff_id, cprNr, searchCriteria, lname,
            address_id, phoneNo, startDate, salary);
        secretary = new Secretary(username, password, role, staff_id, cprNr, searchCriteria, lname,
            address_id, phoneNo, startDate, salary);
        management = new Management(username, password, role, staff_id, cprNr, searchCriteria, lname,
            address_id, phoneNo, startDate, salary);

      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    if(staffResult.equals(UserAction.MANAGER.toString()))
    {
      staffResult.add(management);
    } else if(staffResult.equals(UserAction.SECRETARY.toString()))
    {
      staffResult.add(secretary);
    } else if(staffResult.equals(UserAction.EMPLOYEE.toString()))
    {
      staffResult.add(employee);
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
          "UPDATE Staff SET staff_id = ?, cprNr = ?, fname = ?, lname = ?, address_id = ?, phoneNo = ?, startDate = ?, salary = ?, user_id = ?, password = ?, role = ?");
      statement.setInt(1, staff.getStaff_id());
      statement.setInt(2, staff.getCprNr());
      statement.setString(3, staff.getFname());
      statement.setString(4, staff.getLname());
      statement.setObject(5, staff.getAddress_id());
      statement.setString(6, staff.getPhoneNo());
      statement.setDate(7, (java.sql.Date) staff.getStartDate());
      statement.setDouble(8, staff.getSalary());
      statement.setString(9, staff.getUsername());
      statement.setString(10, staff.getPassword());
      statement.setString(11, staff.getRole());
      statement.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }
}
