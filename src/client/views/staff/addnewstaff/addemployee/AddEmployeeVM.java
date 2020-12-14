package client.views.staff.addnewstaff.addemployee;

import client.model.addemployeeclientmodel.AddEmployeeClientModel;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transfer.UserAction;

import java.beans.PropertyChangeEvent;

public class AddEmployeeVM
{
  private StringProperty city = new SimpleStringProperty();
  private StringProperty zipcode = new SimpleStringProperty();
  private StringProperty email = new SimpleStringProperty();
  private StringProperty salary = new SimpleStringProperty();
  private StringProperty role = new SimpleStringProperty();
  private StringProperty country = new SimpleStringProperty();
  private StringProperty name = new SimpleStringProperty();
  private StringProperty cprNr = new SimpleStringProperty();
  private StringProperty staff_id = new SimpleStringProperty();
  private StringProperty username = new SimpleStringProperty();
  private StringProperty password = new SimpleStringProperty();
  private StringProperty street = new SimpleStringProperty();
  private StringProperty phoneNo = new SimpleStringProperty();
  private StringProperty startDate = new SimpleStringProperty();
  private StringProperty registerResponse = new SimpleStringProperty();

  private AddEmployeeClientModel addEmployeeClientModel;

  public AddEmployeeVM(AddEmployeeClientModel addEmployeeClientModel)
  {
    this.addEmployeeClientModel = addEmployeeClientModel;
    addEmployeeClientModel.addListener(UserAction.CREATE_NEW_EMPLOYEE.toString(), this::onCreatingANewEmployee);
  }

  private void onCreatingANewEmployee(PropertyChangeEvent evt)
  {
    String result = (String) evt.getNewValue();
    Platform.runLater(() -> {
      registerResponse.setValue(result);
    });
  }

  public StringProperty cityProperty()
  {
    return city;
  }

  public StringProperty zipcodeProperty()
  {
    return zipcode;
  }

  public StringProperty streetProperty()
  {
    return street;
  }

  public StringProperty emailProperty()
  {
    return email;
  }

  public StringProperty phoneNoProperty()
  {
    return phoneNo;
  }

  public StringProperty salaryProperty()
  {
    return salary;
  }

  public StringProperty cprNrProperty()
  {
    return cprNr;
  }

  public StringProperty setRoleProperty()
  {
    return role;
  }

  public StringProperty startDateProperty()
  {
    return startDate;
  }

  public StringProperty nameProperty()
  {
    return name;
  }

  public StringProperty staff_idProperty()
  {
    return staff_id;
  }

  public StringProperty passwordProperty()
  {
    return password;
  }

  public StringProperty usernameProperty()
  {
    return username;
  }

  public StringProperty responseLabelProperty()
  {
    return registerResponse;
  }

  public void createNewStaff()
  {
    addEmployeeClientModel
        .createNewEmployee(staff_id.get(), name.get(), cprNr.get(), street.get(),
            city.get(), zipcode.get(), country.get(), phoneNo.get(),
            startDate.get(), salary.get(), username.get(), password.get(),
            role.get());
  }
}
