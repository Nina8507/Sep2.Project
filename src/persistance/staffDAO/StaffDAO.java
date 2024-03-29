package persistance.staffDAO;

import shared.transfer.staff.Employee;
import shared.transfer.staff.Management;
import shared.transfer.staff.Secretary;
import shared.transfer.staff.Staff;

import java.util.List;

public interface StaffDAO<T>
{
  Staff createNewEmployee(Employee employee);
  Staff createNewSecretary(Secretary secretary);
  Staff createNewManager(Management management);

  Staff searchStaffByCprNr(int cprNr);
  List<Staff>  viewAllStaffByStaffName(java.lang.String searchCriteria);
  void deleteStaff(Staff staff);
  void updateStaff(Staff staff);
}
