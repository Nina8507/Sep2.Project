package persistance.staffDAO;

import shared.transfer.staff.Employee;

class StaffDAOTest
{
  StaffDAOImpl staffDAO;
  Employee employee, employee1, employee2;

  @org.junit.jupiter.api.Test void createNewEmployee()
  {
    staffDAO.createNewEmployee(employee);
    staffDAO.createNewEmployee(employee1);
    staffDAO.createNewEmployee(employee2);

  }
}