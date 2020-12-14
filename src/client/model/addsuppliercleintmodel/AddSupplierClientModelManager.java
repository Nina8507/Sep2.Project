package client.model.addsuppliercleintmodel;

import client.networking.Client;
import shared.transfer.Supplier;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddSupplierClientModelManager implements AddSupplierClientModel
{
  private PropertyChangeSupport support;
  private Client client;

  public AddSupplierClientModelManager(Client client)
  {
    this.client = client;
    support = new PropertyChangeSupport(this);

  }

  @Override public void createNewSupplier(String supplier_id, String fName,
      String lName, String cvrNr, String email, String phoneNo, String city,
      String zipcode, String street, String country)
  {
    Supplier supplierToCreate = new Supplier(supplier_id, fName, lName, cvrNr,
        email, phoneNo, zipcode, street, country, city);
    client.createNewSupplier(supplierToCreate);
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
