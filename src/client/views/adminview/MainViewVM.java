package client.views.adminview;

import client.model.adminclientmodel.AdminClientModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transfer.Product;
import shared.transfer.UserAction;
import shared.util.Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class MainViewVM implements Subject
{
  private AdminClientModel adminClientModel;
  private ObservableList<Product> products;
  private PropertyChangeSupport support;

  public MainViewVM(AdminClientModel adminClientModel)
  {
    this.adminClientModel = adminClientModel;
    support = new PropertyChangeSupport(this);
    adminClientModel.addListener(UserAction.PRODUCT_LIST.toString(), this::sendProductListToView);
  }

  private void sendProductListToView(PropertyChangeEvent evt)
  {
    List<Product> tempProductList = (List<Product>) evt.getNewValue();
    products = FXCollections.observableArrayList(tempProductList);
    for(int i = 0; i < tempProductList.size(); i++)
    {
      System.out.println(tempProductList.get(i).getProduct_id() + tempProductList.get(i).getProductName() + );
    }
  }

  public void getProductList()
  {
    adminClientModel.getProductList();
  }

  public void getSupplierList()
  {
    adminClientModel.getSupplierList();
  }

  public void getStaffList()
  {
    adminClientModel.getStaffList();
  }

  public void getCustomerList()
  {
    adminClientModel.getCustomerList();
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
