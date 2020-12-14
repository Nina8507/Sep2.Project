package client.model.addemployeeclientmodel;

import shared.util.Subject;

public interface AddEmployeeClientModel extends Subject
{
  void createNewEmployee(String staff_id, String cprNr, String name, String street, String city, String zipcode,
      String country, String phoneNo, String startDate, String salary, String username, String password, String role);
}
