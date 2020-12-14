package persistance.staffDAO;

import shared.transfer.address.Address;
import shared.transfer.staff.Staff;

import java.util.Date;
import java.util.List;

public interface StaffDAO
{
  Staff createNewEmployee(String username, String password, String role, int staff_id, int cprNr, String fname, String lname,
      Address address_id, String phoneNo, Date startDate, double salary);
  Staff createNewSecretary(String username, String role, String password,int staff_id, int cprNr, String fname, String lname,
      Address address_id, String phoneNo, Date startDate, double salary);
  Staff createNewManager(String username, String password, String role, int staff_id, int cprNr, String fname, String lname,
      Address address_id, String phoneNo, Date startDate, double salary);
  Staff searchStaffByCprNr(int cprNr);
  List<Staff>  viewAllStaffByStaffName(String searchCriteria);
  void deleteStaff(Staff staff);
  void updateStaff(Staff staff);
}
