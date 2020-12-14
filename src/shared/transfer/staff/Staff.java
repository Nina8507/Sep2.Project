package shared.transfer.staff;

import shared.transfer.User;
import shared.transfer.address.Address;

import java.util.Date;

public abstract class Staff extends User
{
  private int staff_id;
  private int cprNr;
  private String fname;
  private String lname;
  private Address address_id;
  private String phoneNo;
  private Date startDate;
  private double salary;
  private String username;
  private String password;
  private String role;

  public Staff(String username, String password, String role)
  {
    super(username, password, role);
  }

  public Staff(String username, String password, String role, int staff_id, int cprNr,
      String fname, String lname,
      Address address_id, String phoneNo, Date startDate, double salary)
  {
    super(username, password, role);
    this.staff_id = staff_id;
    this.cprNr = cprNr;
    this.fname = fname;
    this.lname = lname;
    this.address_id = address_id;
    this.phoneNo = phoneNo;
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

  @Override public String getUsername()
  {
    return super.getUsername();
  }
  @Override public String getRole()
  {
    return super.getRole();
  }

  @Override public String getPassword()
  {
    return super.getPassword();
  }

  public Address getAddress_id()
  {
    return address_id;
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
