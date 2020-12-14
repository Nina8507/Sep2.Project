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

  @Override public Staff createNewEmployee(Employee employee)
  {
    Staff createEmployee = null;
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO employee (staff_id, cnpNr, name, street, city, country, zipcode, phoneNo, startDate, salary, user_id, password, role) VALUES(?,?,? ?,?, ?, ?, ?, ?, ?, ?,? ,?);");
      statement.setString(1, employee.getStaff_id());
      statement.setString(2, employee.getCprNr());
      statement.setString(3, employee.getName());
      statement.setString(4, employee.getStreet());
      statement.setString(5, employee.getCity());
      statement.setString(6, employee.getCountry());
      statement.setString(7, employee.getZipcode());
      statement.setString(8, employee.getPhoneNo());
      statement.setString(9, employee.getStartDate());
      statement.setString(10, employee.getSalary());
      statement.setString(11, employee.getUsername());
      statement.setString(12, employee.getPassword());
      statement.setString(13, employee.getRole());
      statement.executeQuery();

      createEmployee = new Employee(employee.getStaff_id(), employee.getCprNr(),
          employee.getName(), employee.getStreet(), employee.getCity(),
          employee.getCountry(), employee.getZipcode(), employee.getPhoneNo(),
          employee.getStartDate(), employee.getSalary(), employee.getUsername(),
          employee.getPassword(), employee.getRole());
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return createEmployee;
  }

  @Override public Staff createNewSecretary(Secretary secretary)
  {
    Staff createSecretary = null;
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO employee (staff_id, cnpNr, name, street, city, country, zipcode, phoneNo, startDate, salary, user_id, password, role) VALUES(?,?,? ?,?, ?, ?, ?, ?, ?, ?,? ,?);");
      statement.setString(1, secretary.getStaff_id());
      statement.setString(2, secretary.getCprNr());
      statement.setString(3, secretary.getName());
      statement.setString(4, secretary.getStreet());
      statement.setString(5, secretary.getCity());
      statement.setString(6, secretary.getCountry());
      statement.setString(7, secretary.getZipcode());
      statement.setString(8, secretary.getPhoneNo());
      statement.setString(9, secretary.getStartDate());
      statement.setString(10, secretary.getSalary());
      statement.setString(11, secretary.getUsername());
      statement.setString(12, secretary.getPassword());
      statement.setString(13, secretary.getRole());
      statement.executeQuery();

      createSecretary = new Secretary(secretary.getStaff_id(),
          secretary.getCprNr(), secretary.getName(), secretary.getStreet(),
          secretary.getCity(), secretary.getCountry(), secretary.getZipcode(),
          secretary.getPhoneNo(), secretary.getStartDate(),
          secretary.getSalary(), secretary.getUsername(),
          secretary.getPassword(), secretary.getRole());
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return createSecretary;
  }

  @Override public Staff createNewManager(Management management)
  {
    Staff createManager = null;
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO employee (staff_id, cnpNr, name, street, city, country, zipcode, phoneNo, startDate, salary, user_id, password, role) VALUES(?,?,? ?,?, ?, ?, ?, ?, ?, ?,? ,?);");
      statement.setString(1, management.getStaff_id());
      statement.setString(2, management.getCprNr());
      statement.setString(3, management.getName());
      statement.setString(4, management.getStreet());
      statement.setString(5, management.getCity());
      statement.setString(6, management.getCountry());
      statement.setString(7, management.getZipcode());
      statement.setString(8, management.getPhoneNo());
      statement.setString(9, management.getStartDate());
      statement.setString(10, management.getSalary());
      statement.setString(11, management.getUsername());
      statement.setString(12, management.getPassword());
      statement.setString(13, management.getRole());
      statement.executeQuery();

      createManager = new Management(management.getStaff_id(),
          management.getCprNr(), management.getName(), management.getStreet(),
          management.getCity(), management.getCountry(),
          management.getZipcode(), management.getPhoneNo(),
          management.getStartDate(), management.getSalary(),
          management.getUsername(), management.getPassword(),
          management.getRole());
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return createManager;
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
      statement.setString(1, staff.getStaff_id());
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
          "UPDATE Staff SET staff_id = ?, cprNr = ?, name = ?, street = ?, city =?, country=?, zipcode=?, phoneNo = ?, startDate = ?, salary = ?, user_id = ?, password = ?, role = ?");
      statement.setString(1, staff.getStaff_id());
      statement.setString(2, staff.getCprNr());
      statement.setString(3, staff.getName());
      statement.setString(4, staff.getStreet());
      statement.setString(5, staff.getCity());
      statement.setString(6, staff.getCountry());
      statement.setString(7, staff.getZipcode());
      statement.setString(8, staff.getSalary());
      statement.setString(9, staff.getUsername());
      statement.setString(10, staff.getPassword());
      statement.setString(11, staff.getRole());
      statement.setString(12, staff.getPhoneNo());
      statement.setString(13, staff.getStartDate());
      statement.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }
}
