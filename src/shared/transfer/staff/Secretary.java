package shared.transfer.staff;

import java.util.Date;

public class Secretary extends Staff
{
  protected Secretary(int cpr, String name, String email, Address address,
      String phoneNumber, Date startDate, double salary)
  {
    super(cpr, name, email, address, phoneNumber, startDate, salary);
  }

  @Override public int getCpr()
  {
    return super.getCpr();
  }

  @Override public String getName()
  {
    return super.getName();
  }

  @Override public String getEmail()
  {
    return super.getEmail();
  }

  @Override public Address getAddress()
  {
    return super.getAddress();
  }

  @Override public String getPhoneNumber()
  {
    return super.getPhoneNumber();
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
