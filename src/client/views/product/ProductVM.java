package client.views.product;

import client.model.productclientmodel.product.ProductClientModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeSupport;

public class ProductVM
{
  private StringProperty searchField = new SimpleStringProperty();
  private ProductClientModel productClientModel;
  private PropertyChangeSupport support;

  public ProductVM(ProductClientModel productClientModel)
  {
    this.productClientModel = productClientModel;
    support = new PropertyChangeSupport(this);
  }


  public StringProperty searchFieldProperty()
  {
    return searchField;
  }
}
