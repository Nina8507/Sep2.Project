package shared.transfer.staff;

import java.io.Serializable;

public class Management extends Staff implements Serializable
{
  public Management(
      java.lang.String username, java.lang.String password, java.lang.String role)
  {
    super(username, password, role);
  }

  public Management(java.lang.String username, java.lang.String password)
  {
    super(username, password);
  }

  public Management(
      java.lang.String username, java.lang.String password, java.lang.String role,
      java.lang.String staff_id, java.lang.String cprNr, java.lang.String name, java.lang.String street, java.lang.String city,
      java.lang.String zipcode, java.lang.String country, java.lang.String phoneNo, java.lang.String startDate,
      java.lang.String salary)
  {
    super(username, password, role, staff_id, cprNr, name, street, city,
        zipcode, country, phoneNo, startDate, salary);
  }

  @Override public java.lang.String getStaff_id()
  {
    return super.getStaff_id();
  }

  @Override public java.lang.String getCprNr()
  {
    return super.getCprNr();
  }

  @Override public java.lang.String getName()
  {
    return super.getName();
  }

  @Override public java.lang.String getStreet()
  {
    return super.getStreet();
  }

  @Override public java.lang.String getCity()
  {
    return super.getCity();
  }

  @Override public java.lang.String getZipcode()
  {
    return super.getZipcode();
  }

  @Override public java.lang.String getCountry()
  {
    return super.getCountry();
  }

  @Override public java.lang.String getPhoneNo()
  {
    return super.getPhoneNo();
  }

  @Override public java.lang.String getStartDate()
  {
    return super.getStartDate();
  }

  @Override public java.lang.String getSalary()
  {
    return super.getSalary();
  }

  @Override public java.lang.String getUsername()
  {
    return super.getUsername();
  }

  @Override public java.lang.String getPassword()
  {
    return super.getPassword();
  }

  @Override public java.lang.String getRole()
  {
    return super.getRole();
  }
}
