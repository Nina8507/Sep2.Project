package client.views.supplier.addsupplier;

import client.model.addsuppliercleintmodel.AddSupplierClientModel;
import client.networking.Client;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transfer.UserAction;

import java.beans.PropertyChangeEvent;

public class AddSupplierVM
{
  private StringProperty supplier_id = new SimpleStringProperty();
  private StringProperty lname = new SimpleStringProperty();
  private StringProperty fname = new SimpleStringProperty();
  private StringProperty cvrNr = new SimpleStringProperty();
  private StringProperty email = new SimpleStringProperty();
  private StringProperty phoneNo = new SimpleStringProperty();
  private StringProperty streetNo = new SimpleStringProperty();
  private StringProperty city = new SimpleStringProperty();
  private StringProperty zipCode = new SimpleStringProperty();
  private StringProperty country = new SimpleStringProperty();
  private StringProperty registerResponse = new SimpleStringProperty();

  private AddSupplierClientModel addSupplierClientModel;

  public AddSupplierVM(AddSupplierClientModel addSupplierClientModel)
  {
    this.addSupplierClientModel = addSupplierClientModel;
    addSupplierClientModel.addListener(UserAction.ADD_NEW_SUPPLIER.toString(), this ::onCreateNewSupplier);
  }

  private void onCreateNewSupplier(PropertyChangeEvent evt)
  {
    String result = (String) evt.getNewValue();
    Platform.runLater(() -> {
      registerResponse.setValue(result);
    });
  }

  public StringProperty supplier_idProperty()
  {
    return supplier_id;
  }

  public StringProperty fnameProperty()
  {
    return fname;
  }

  public StringProperty lnameProperty()
  {
    return lname;
  }

  public StringProperty cvrNrProperty()
  {
    return cvrNr;
  }

  public StringProperty emailProperty()
  {
    return email;
  }

  public StringProperty phoneNoProperty()
  {
    return phoneNo;
  }

  public StringProperty citYProperty()
  {
    return city;
  }

  public StringProperty zipCodeProperty()
  {
    return zipCode;
  }

  public StringProperty streetNoProperty()
  {
    return streetNo;
  }

  public StringProperty countryProperty()
  {
    return country;
  }

  public StringProperty registerResponseProperty()
  {
    return registerResponse;
  }

  public void createNewSupplier()
  {
    addSupplierClientModel
        .createNewSupplier(supplier_id.get(), fname.get(), lname.get(),
            cvrNr.get(), email.get(), phoneNo.get(), city.get(), zipCode.get(),
            streetNo.get(), country.get());
  }

}
