package client.model.staffmodel.addemployeeclientmodel;

import shared.util.Subject;

public interface AddEmployeeClientModel extends Subject
{
  void createNewEmployee(String city, String zipcode, String email, String salary, String role, String country,
      String name, String cprNr, String staffId, String username, String password, String street, String phoneNumber);
}
