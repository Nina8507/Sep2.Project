package persistance.staffDAO;

import shared.transfer.address.Address;
import shared.transfer.staff.Staff;

import java.util.Date;
import java.util.List;

public interface StaffDAO
{
  Staff createNewEmployee(int staff_id, int cprNr, String fname, String lname,
      Address address_id, String phoneNo, Date startDate, double salary);
  Staff createNewSecretary(int staff_id, int cprNr, String fname, String lname,
      Address address_id, String phoneNo, Date startDate, double salary);
  Staff createNewManager(int staff_id, int cprNr, String fname, String lname,
      Address address_id, String phoneNo, Date startDate, double salary);
  Staff addNewUserEmployee(String username, String password);
  Staff addNewUserSecretary(String username, String password);
  Staff addNewManagement(String username, String password);
  Staff searchStaffByCprNr(int cnpNr);
  List<Staff>  viewAllStaffByStaffName(String searchCriteria);
  void deleteStaff(Staff staff);
  void updateStaff(Staff staff);
}
