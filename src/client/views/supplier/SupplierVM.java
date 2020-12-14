package client.views.supplier;

import client.model.supplierclientmodel.SupplierClientModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import shared.transfer.Supplier;
import shared.util.Subject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SupplierVM implements Subject
{
  private SupplierClientModel supplierClientModel;
  private ObservableList<Supplier> suppliers;
  private PropertyChangeSupport support;
  private AnchorPane rightContent;
  private StringProperty searchSupplierTextProperty= new SimpleStringProperty();

  public SupplierVM(SupplierClientModel supplierClientModel)
  {
    this.supplierClientModel = supplierClientModel;
    support = new PropertyChangeSupport(this);
  }

  public void setRightContentNode(AnchorPane rightContent)
  {
    this.rightContent = rightContent;
  }

  public StringProperty searchSupplierTextProperty()
  {
    return searchSupplierTextProperty;
  }
  public void setRightArea(Node node)
  {
    rightContent.getChildren().clear();
    rightContent.getChildren().add(node);
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
