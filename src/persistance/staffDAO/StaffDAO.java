package persistance.staffDAO;

import shared.transfer.address.Address;
import shared.transfer.staff.Staff;

import java.util.Date;

public interface StaffDAO
{
  Staff createNewStaff(int cprNr, String fname, String lname, String email,
      Address address, String phoneNo, Date startDate, double salary);
  Staff searchStaffByCprNr(int cnpNr);
}
