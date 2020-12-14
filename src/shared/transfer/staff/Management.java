package shared.transfer.staff;

import shared.transfer.address.Address;

import java.io.Serializable;
import java.util.Date;

public class Management extends Staff implements Serializable
{

  public Management(String username, String password, String role,  int staff_id, int cprNr,
      String fname, String lname, Address address_id, String phoneNo,
      Date startDate, double salary)
  {
    super(username, password, role, staff_id, cprNr, fname, lname, address_id,
        phoneNo, startDate, salary);
  }

  public Management(String username, String password, String role)
  {
    super(username, password, role);
  }
  @Override public int getStaff_id()
  {
    return super.getStaff_id();
  }

  @Override public int getCprNr()
  {
    return super.getCprNr();
  }

  @Override public String getFname()
  {
    return super.getFname();
  }

  @Override public String getLname()
  {
    return super.getLname();
  }

  @Override public String getRole() {return super.getRole();}


  @Override public String getUsername()
  {
    return super.getUsername();
  }

  @Override public String getPassword()
  {
    return super.getPassword();
  }

  @Override public Address getAddress_id()
  {
    return super.getAddress_id();
  }

  @Override public String getPhoneNo()
  {
    return super.getPhoneNo();
  }

  @Override public Date getStartDate()
  {
    return super.getStartDate();
  }

  @Override public double getSalary()
  {
    return super.getSalary();
  }
}
