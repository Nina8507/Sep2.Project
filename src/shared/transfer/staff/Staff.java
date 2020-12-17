package shared.transfer.staff;

import shared.transfer.User;

public abstract class Staff extends User
{
  private java.lang.String staff_id;
  private java.lang.String cprNr;
  private java.lang.String name;
  private java.lang.String street;
  private java.lang.String city;
  private java.lang.String zipcode;
  private java.lang.String country;
  private java.lang.String phoneNo;
  private java.lang.String startDate;
  private java.lang.String salary;
  private java.lang.String username;
  private java.lang.String password;
  private java.lang.String role;

  public Staff(
      java.lang.String username, java.lang.String password, java.lang.String role)
  {
    super(username, password, role);
  }

  public Staff(
      java.lang.String username, java.lang.String password, java.lang.String role, java.lang.String staff_id,
      java.lang.String cprNr, java.lang.String name, java.lang.String street, java.lang.String city, java.lang.String zipcode,
      java.lang.String country, java.lang.String phoneNo, java.lang.String startDate, java.lang.String salary)
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
  public Staff(java.lang.String username, java.lang.String password)
  {
    super(username, password);
  }
  public java.lang.String getStaff_id()
  {
    return staff_id;
  }

  public java.lang.String getCprNr()
  {
    return cprNr;
  }

  public java.lang.String getName()
  {
    return name;
  }

  public java.lang.String getStreet()
  {
    return street;
  }

  public java.lang.String getCity()
  {
    return city;
  }

  public java.lang.String getZipcode()
  {
    return zipcode;
  }

  public java.lang.String getCountry()
  {
    return country;
  }

  public java.lang.String getPhoneNo()
  {
    return phoneNo;
  }

  public java.lang.String getStartDate()
  {
    return startDate;
  }

  public java.lang.String getSalary()
  {
    return salary;
  }

  @Override public java.lang.String getUsername()
  {
    return username;
  }

  @Override public java.lang.String getPassword()
  {
    return password;
  }

  @Override public java.lang.String getRole()
  {
    return role;
  }
}
