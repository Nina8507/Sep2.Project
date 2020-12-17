package server.model.supplierModel.listviewsuppliermodel;

import persistance.supplierDAO.SupplierDAO;
import persistance.supplierDAO.SupplierDAOImpl;
import shared.transfer.Supplier;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ListViewSupplierServerModelManager implements ListViewSupplierServerModel
{
  private PropertyChangeSupport support;
  private SupplierDAO supplierDAO;

  public ListViewSupplierServerModelManager()
  {
    support = new PropertyChangeSupport(this);
    supplierDAO = SupplierDAOImpl.getInstance();
  }
  @Override public Supplier getSupplierValues(Supplier getSupplier)
  {
    return supplierDAO.getSupplier(getSupplier);
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
