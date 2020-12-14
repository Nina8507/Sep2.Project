package persistance.staffDAO;

import shared.transfer.address.Address;
import shared.transfer.staff.Employee;
import shared.transfer.staff.Management;
import shared.transfer.staff.Secretary;
import shared.transfer.staff.Staff;

import java.util.Date;
import java.util.List;

public interface StaffDAO
{
  Staff createNewEmployee(Employee employee);
  Staff createNewSecretary(Secretary secretary);
  Staff createNewManager(Management management);

  Staff searchStaffByCprNr(int cprNr);
  List<Staff>  viewAllStaffByStaffName(String searchCriteria);
  void deleteStaff(Staff staff);
  void updateStaff(Staff staff);
}
