package client.model.adminclientmodel;

import client.networking.Client;
import shared.transfer.User;
import shared.transfer.products.Product;
import shared.transfer.UserAction;
import shared.transfer.staff.Staff;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class AdminClientModelManager implements AdminClientModel
{
  private Client client;
  private PropertyChangeSupport support;
  private User user;

  public AdminClientModelManager(Client client)
  {
    this.client = client;
    support = new PropertyChangeSupport(this);
    client.addListener(UserAction.PRODUCT_LIST.toString(), this::getProductList);
    client.addListener(UserAction.STAFF_LIST.toString(), this::getStaffList);
  }

  private void getStaffList(PropertyChangeEvent evt)
  {
    List<Staff> staffList = (List<Staff>) evt.getNewValue();
    support.firePropertyChange(evt.getPropertyName(), null, staffList);
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

  @Override public void logoutUser()
  {
    client.logoutUser(user);
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
