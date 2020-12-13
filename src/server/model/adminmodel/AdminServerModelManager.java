package server.model.adminmodel;

import persistance.productDAO.ProductDAO;
import persistance.productDAO.ProductDAOImpl;
import persistance.staffDAO.StaffDAO;
import persistance.staffDAO.StaffDAOImpl;
import shared.transfer.Customer;
import shared.transfer.products.Product;
import shared.transfer.Supplier;
import shared.transfer.UserAction;
import shared.transfer.staff.Staff;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class AdminServerModelManager implements AdminServerModel
{
  private PropertyChangeSupport support;
  private ProductDAO productDAO;
  private StaffDAO staffDAO;
  private List<Product> products;
  private List<Supplier> suppliers;
  private List<Staff> staffList;
  private List<Customer> customers;

  public AdminServerModelManager()
  {
    productDAO = ProductDAOImpl.getInstance();
    staffDAO = StaffDAOImpl.getInstance();
    support = new PropertyChangeSupport(this);
    products = new ArrayList<>();
    suppliers = new ArrayList<>();
    staffList = new ArrayList<>();
    customers = new ArrayList<>();
  }

  @Override public void getProductList()
  {
    support.firePropertyChange(UserAction.PRODUCT_LIST.toString(), null,
        new ArrayList<>(productDAO.viewAllProductsByProductName("products")));
  }

  @Override public void getStaffList()
  {
    support.firePropertyChange(UserAction.STAFF_LIST.toString(), null,
        new ArrayList<>(staffDAO.viewAllStaffByStaffName("staff")));
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
