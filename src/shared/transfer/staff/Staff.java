package shared.transfer.staff;

import shared.transfer.address.Address;

import java.util.Date;

public abstract class Staff
{
  private int staff_id;
  private int cprNr;
  private String fname;
  private String lname;
  private String email;
  private Address address;
  private String phoneNo;
  private Date startDate;
  private double salary;

  protected Staff( int staff_id, int cprNr, String fname, String lname, String email,
      Address address, String phoneNumber, Date startDate, double salary)
  {
    this.staff_id = staff_id;
    this.cprNr = cprNr;
    this.fname = fname;
    this.lname = lname;
    this.email = email;
    this.address = address;
    this.phoneNo = phoneNumber;
    this.startDate = startDate;
    this.salary = salary;
  }

  public int getStaff_id()
  {
    return staff_id;
  }

  public int getCprNr()
  {
    return cprNr;
  }

  public String getFname()
  {
    return fname;
  }

  public String getLname()
  {
    return lname;
  }

  public String getEmail()
  {
    return email;
  }

  public Address getAddress()
  {
    return address;
  }

  public String getPhoneNo()
  {
    return phoneNo;
  }

  public Date getStartDate()
  {
    return startDate;
  }

  public double getSalary()
  {
    return salary;
  }
}
