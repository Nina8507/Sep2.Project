package server.model.addemployeemodel;

import persistance.staffDAO.StaffDAO;
import persistance.staffDAO.StaffDAOImpl;
import shared.transfer.UserAction;
import shared.transfer.staff.Employee;
import shared.transfer.staff.Staff;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class AddEmployeeServerModelManager implements AddEmployeeServerModel
{

  private PropertyChangeSupport support;
  private StaffDAO staffDAO;
  private List<Staff> staffList;

  public AddEmployeeServerModelManager()
  {
    support = new PropertyChangeSupport(this);
    staffDAO = StaffDAOImpl.getInstance();
  }

  @Override public String createNewEmployee(Employee employeeToCreate)
  {
    Staff staff = new Employee(employeeToCreate.getStaff_id(),
        employeeToCreate.getName(), employeeToCreate.getCprNr(),
        employeeToCreate.getStreet(), employeeToCreate.getCity(),
        employeeToCreate.getCountry(), employeeToCreate.getZipcode(),
        employeeToCreate.getPhoneNo(), employeeToCreate.getStartDate(),
        employeeToCreate.getSalary(), employeeToCreate.getUsername(),
        employeeToCreate.getPassword(), employeeToCreate.getRole());

    if(staffList.contains(staff))
    {
      return "Employee Exists!";
    } else
    {
      staffDAO.createNewEmployee((Employee) staff);
      support.firePropertyChange(UserAction.CREATE_NEW_EMPLOYEE.toString(), null, staff);
      return "Employee Created!";
    }
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void addListener(String name,
      PropertyChangeListener listener)
  {
    if (name == null || "".equals(name))
      addListener(listener);
    else
    {
      support.addPropertyChangeListener(name, listener);
    }
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  @Override public void removeListener(String name,
      PropertyChangeListener listener)
  {
    if (name == null || "".equals(name))
      removeListener(listener);
    else
    {
      support.removePropertyChangeListener(name, listener);
    }
  }
}
