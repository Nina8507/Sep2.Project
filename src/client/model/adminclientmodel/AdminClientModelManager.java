package client.model.adminclientmodel;

import client.networking.Client;
import shared.transfer.Product;
import shared.transfer.UserAction;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class AdminClientModelManager implements AdminClientModel
{
  private Client client;
  private PropertyChangeSupport support;

  public AdminClientModelManager(Client client)
  {
    this.client = client;
    support = new PropertyChangeSupport(this);
    client.addListener(UserAction.PRODUCT_LIST.toString(), this::getProductList);
  }

  private void getProductList(PropertyChangeEvent evt)
  {
    List<Product> products = (List<Product>) evt.getNewValue();
    support.firePropertyChange(evt.getPropertyName(), null, products);
  }

  @Override public void getProductList()
  {
    client.getProductList();
  }

  @Override public void getSupplierList()
  {
    client.getSupplierList();
  }

  @Override public void getStaffList()
  {
    client. getStaffList();
  }

  @Override public void getCustomerList()
  {
    client.getCustomerList();
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
