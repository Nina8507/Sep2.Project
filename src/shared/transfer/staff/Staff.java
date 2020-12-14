package shared.transfer.staff;

import shared.transfer.User;
import shared.transfer.address.Address;

import java.util.Date;

public abstract class Staff extends User
{
  private String staff_id;
  private String cprNr;
  private String name;
  private String street;
  private String city;
  private String zipcode;
  private String country;
  private String phoneNo;
  private String startDate;
  private String salary;
  private String username;
  private String password;
  private String role;

  public Staff(String username, String password, String role)
  {
    super(username, password, role);
  }

  public Staff(String username, String password)
  {
    super(username, password);
  }

  public Staff(String username, String password, String role, String staff_id,
      String cprNr, String name, String street, String city, String zipcode,
      String country, String phoneNo, String startDate, String salary)
  {
    super(username, password, role);
    this.staff_id = staff_id;
    this.cprNr = cprNr;
    this.name = name;
    this.street = street;
    this.city = city;
    this.zipcode = zipcode;
    this.country = country;
    this.phoneNo = phoneNo;
    this.startDate = startDate;
    this.salary = salary;
  }

  public String getStaff_id()
  {
    return staff_id;
  }

  public String getCprNr()
  {
    return cprNr;
  }

  public String getName()
  {
    return name;
  }

  public String getStreet()
  {
    return street;
  }

  public String getCity()
  {
    return city;
  }

  public String getZipcode()
  {
    return zipcode;
  }

  public String getCountry()
  {
    return country;
  }

  public String getPhoneNo()
  {
    return phoneNo;
  }

  public String getStartDate()
  {
    return startDate;
  }

  public String getSalary()
  {
    return salary;
  }

  @Override public String getUsername()
  {
    return username;
  }

  @Override public String getPassword()
  {
    return password;
  }

  @Override public String getRole()
  {
    return role;
  }
}
