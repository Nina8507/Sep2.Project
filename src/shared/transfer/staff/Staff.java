package shared.transfer.staff;

import java.util.Date;

public abstract class Staff
{
   private int cpr;
   private String name;
   private String email;
   private Address address;
   private String phoneNumber;
   private Date startDate;
   private double salary;

  protected Staff(int cpr, String name, String email, Address address,
      String phoneNumber, Date startDate, double salary)
  {
    this.cpr = cpr;
    this.name = name;
    this.email = email;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.startDate = startDate;
    this.salary = salary;
  }

  public int getCpr()
  {
    return cpr;
  }

  public String getName()
  {
    return name;
  }

  public String getEmail()
  {
    return email;
  }

  public Address getAddress()
  {
    return address;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
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
