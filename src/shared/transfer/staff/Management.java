package shared.transfer.staff;

import java.util.Date;

public class Management extends Staff
{

  private Management(int cpr, String fname, String lname, String email,
      Address address, String phoneNumber, Date startDate, double salary)
  {
    super(cpr, fname, lname, email, address, phoneNumber, startDate, salary);
  }

  @Override public int getCpr()
  {
    return super.getCpr();
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
