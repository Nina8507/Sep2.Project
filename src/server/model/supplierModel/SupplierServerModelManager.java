package server.model.supplierModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SupplierServerModelManager implements SupplierServerModel
{
    private PropertyChangeSupport support;

    public  SupplierServerModelManager()
    {
      support = new PropertyChangeSupport(this);
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
