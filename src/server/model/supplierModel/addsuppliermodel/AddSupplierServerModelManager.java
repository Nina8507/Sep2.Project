package server.model.supplierModel.addsuppliermodel;

import persistance.supplierDAO.SupplierDAO;
import persistance.supplierDAO.SupplierDAOImpl;
import shared.transfer.Supplier;
import shared.transfer.UserAction;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class AddSupplierServerModelManager implements AddSupplierServerModel
{
  private PropertyChangeSupport support;
  private SupplierDAO supplierDAO;
  private List<Supplier> supplierList;

  public AddSupplierServerModelManager()
  {
    support = new PropertyChangeSupport(this);
    supplierDAO = SupplierDAOImpl.getInstance();
  }

  @Override public String createNewSupplier(Supplier supplierToCreate)
  {
    Supplier supplier = new Supplier(supplierToCreate.getSupplier_id(),
        supplierToCreate.getfName(), supplierToCreate.getlName(),
        supplierToCreate.getCvrNr(), supplierToCreate.getStreet(),
        supplierToCreate.getCity(), supplierToCreate.getCountry(),
        supplierToCreate.getZipcode(), supplierToCreate.getEmail(),
        supplierToCreate.getPhoneNo());

    if (supplierList.contains(supplier))
    {
      return "Supplier already in list!";
    }
    else
    {
      supplierDAO.addSupplier(supplier);
      support.firePropertyChange(UserAction.ADD_NEW_SUPPLIER.toString(), null, supplier);
      return "Supplier Created";
    }
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
