package client.model.staffmodel.allstaffmodel;

import client.model.staffmodel.allstaffmodel.StaffClientModel;
import client.networking.Client;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class StaffClientModelManager implements StaffClientModel
{
  private PropertyChangeSupport support;
  private Client client;

  public StaffClientModelManager(Client client)
  {
    support = new PropertyChangeSupport(this);
    this.client = client;
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
