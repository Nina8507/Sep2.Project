package shared.transfer.staff;

import java.util.Date;

public class Employee extends Staff
{

  private Employee(int cprNr, String fname, String lname, String email,
      Address address, String phoneNumber, Date startDate, double salary)
  {
    super(cprNr, fname, lname, email, address, phoneNumber, startDate, salary);
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

  @Override public Address getAddress()
  {
    return super.getAddress();
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
