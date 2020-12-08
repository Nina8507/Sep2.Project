package shared.transfer.staff;

import shared.transfer.address.Address;

import java.io.Serializable;
import java.util.Date;

public class Employee extends Staff implements Serializable
{

  public Employee(int staff_id, int cprNr, String fname, String lname, String email,
      Address address_id, String phoneNo, Date startDate, double salary)
  {
    super(staff_id, cprNr, fname, lname, email, address_id, phoneNo, startDate, salary);
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

  @Override public String getEmail()
  {
    return super.getEmail();
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
