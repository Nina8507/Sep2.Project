package shared.transfer.staff;

import shared.transfer.address.Address;

import java.io.Serializable;
import java.util.Date;

public class Secretary extends Staff implements Serializable
{

  public Secretary(String username, String password, String role)
  {
    super(username, password, role);
  }

  public Secretary(String username, String password)
  {
    super(username, password);
  }

  public Secretary(String username, String password, String role,
      String staff_id, String cprNr, String name, String street, String city,
      String zipcode, String country, String phoneNo, String startDate,
      String salary)
  {
    super(username, password, role, staff_id, cprNr, name, street, city,
        zipcode, country, phoneNo, startDate, salary);
  }

  @Override public String getStaff_id()
  {
    return super.getStaff_id();
  }

  @Override public String getCprNr()
  {
    return super.getCprNr();
  }

  @Override public String getName()
  {
    return super.getName();
  }

  @Override public String getStreet()
  {
    return super.getStreet();
  }

  @Override public String getCity()
  {
    return super.getCity();
  }

  @Override public String getZipcode()
  {
    return super.getZipcode();
  }

  @Override public String getCountry()
  {
    return super.getCountry();
  }

  @Override public String getPhoneNo()
  {
    return super.getPhoneNo();
  }

  @Override public String getStartDate()
  {
    return super.getStartDate();
  }

  @Override public String getSalary()
  {
    return super.getSalary();
  }

  @Override public String getUsername()
  {
    return super.getUsername();
  }

  @Override public String getPassword()
  {
    return super.getPassword();
  }

  @Override public String getRole()
  {
    return super.getRole();
  }
}
