package client.model.supplierclientmodel.listviewsupplier;

import client.networking.Client;
import shared.transfer.Supplier;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ListViewSupplierClientModelManager
    implements ListViewSupplierClientModel
{
  private PropertyChangeSupport support;
  private Client client;

  public ListViewSupplierClientModelManager(Client client)
  {
    this.client = client;
    support = new PropertyChangeSupport(this);
  }

  @Override public void getSelectedSupplierValues(String supplier_id,
      String fName, String lName, String cvrNr, String street, String city,
      String country, String zipcode, String email, String phoneNo)
  {
    Supplier supplier = new Supplier(supplier_id, fName, lName, cvrNr,
        street, city, country, zipcode, email, phoneNo);
    client.getSupplierValues(supplier);
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
