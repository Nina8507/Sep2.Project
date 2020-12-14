package server.model.addemployeemodel;

import shared.transfer.staff.Employee;
import shared.util.Subject;

public interface AddEmployeeServerModel extends Subject
{
  String createNewEmployee(Employee employeeToCreate);
}
