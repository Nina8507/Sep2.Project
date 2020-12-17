package client.views.mainview;

import client.model.adminclientmodel.AdminClientModel;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import shared.transfer.products.Product;
import shared.transfer.UserAction;
import shared.transfer.staff.Staff;
import shared.util.Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class MainViewVM implements Subject
{
  private AdminClientModel adminClientModel;
  private ObservableList<Product> products;
  private ObservableList<Staff> allStaffList;
  private PropertyChangeSupport support;
  private AnchorPane rightContent;

  public MainViewVM(AdminClientModel adminClientModel)
  {
    this.adminClientModel = adminClientModel;
    support = new PropertyChangeSupport(this);
    adminClientModel.addListener(UserAction.PRODUCT_LIST.toString(),
        this::sendProductListToView);
    adminClientModel.addListener(UserAction.STAFF_LIST.toString(),
        this::sendStaffListToView);
  }

  private void sendStaffListToView(PropertyChangeEvent evt)
  {
    List<Staff> tempStaffList = (List<Staff>) evt.getNewValue();
    allStaffList = FXCollections.observableList(tempStaffList);
  }

  private void sendProductListToView(PropertyChangeEvent evt)
  {
    List<Product> tempProductList = (List<Product>) evt.getNewValue();
    products = FXCollections.observableArrayList(tempProductList);
    for (int i = 0; i < tempProductList.size(); i++)
    {
      System.out.println(tempProductList.get(i));
    }
  }

  public void logoutUser()
  {
    adminClientModel.logoutUser();
    Platform.exit();
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

  public void setRightArea(Node node)
  {
    rightContent.getChildren().clear();
    rightContent.getChildren().add(node);
  }

  public void setRightContentNode(AnchorPane rightContent)
  {
    this.rightContent = rightContent;
  }

}
