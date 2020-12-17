package client.model.productclientmodel.addproduct;

import client.networking.Client;
import shared.transfer.products.Product;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddProductClientModelManager implements AddProductClientModel
{
  private Client client;
  private PropertyChangeSupport support;

  public AddProductClientModelManager(Client client)
  {
    this.client = client;
    support = new PropertyChangeSupport(this);
  }

  @Override public void addNewProduct(String material, String measurement,
      String productId, String productName, String quantity, String color,
      String salesPrice, String purchasePrice)
  {
    Product productToAdd = new Product(productId, productName, measurement,
        material, quantity, color, purchasePrice, salesPrice);
    client.addNewProduct(productToAdd);
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
