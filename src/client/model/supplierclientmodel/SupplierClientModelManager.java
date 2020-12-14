package client.model.supplierclientmodel;

import client.networking.Client;
import shared.transfer.UserAction;
import shared.transfer.address.Address;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SupplierClientModelManager implements SupplierClientModel
{
  private PropertyChangeSupport support;
  private Client client;

  public SupplierClientModelManager(Client client)
  {
    this.client = client;
    support = new PropertyChangeSupport(this);
    client.addListener(UserAction.ADD_NEW_SUPPLIER.toString(), this::onCreatedNewSupplier);
  }

  private void onCreatedNewSupplier(PropertyChangeEvent evt)
  {
    support.firePropertyChange(evt);
  }

  @Override public void addANewSupplier(int supplier_id, String supplierName,
      int cvrNr, Address address_id, String email, String phoneNo)
  {

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
