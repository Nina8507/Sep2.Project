package client.model.staffmodel.addemployeeclientmodel;

import client.networking.Client;
import shared.transfer.UserAction;
import shared.transfer.staff.Employee;
import shared.transfer.staff.Staff;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddEmployeeClientModelManager implements AddEmployeeClientModel
{
  private PropertyChangeSupport support;
  private Client client;

  public AddEmployeeClientModelManager(Client client)
  {
    this.client = client;
    support = new PropertyChangeSupport(this);
    client.addListener(UserAction.CREATE_NEW_EMPLOYEE.toString(), evt -> {
      support.firePropertyChange(evt);
    });
  }

  @Override public void createNewEmployee(
      java.lang.String staff_id, java.lang.String cprNr,
      java.lang.String name, java.lang.String street, java.lang.String city, java.lang.String zipcode, java.lang.String country,
      java.lang.String phoneNo, java.lang.String startDate, java.lang.String salary, java.lang.String username,
      java.lang.String password, java.lang.String role)
  {
    Staff employeeToCreate = new Employee(staff_id, cprNr,
        name, street, city, zipcode, country,
        phoneNo, startDate, salary, username,
        password, role);
    client.createNewEmployee(employeeToCreate);
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void addListener(java.lang.String name,
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

  @Override public void removeListener(java.lang.String name,
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
