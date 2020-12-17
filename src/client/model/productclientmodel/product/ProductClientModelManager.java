package client.model.productclientmodel.product;

import client.model.productclientmodel.product.ProductClientModel;
import client.networking.Client;

import java.beans.PropertyChangeListener;

public class ProductClientModelManager implements ProductClientModel
{
  private Client client;

  public ProductClientModelManager(Client client)
  {
    this.client = client;
  }

  @Override public void addListener(PropertyChangeListener listener)
  {

  }

  @Override public void addListener(String name,
      PropertyChangeListener listener)
  {

  }

  @Override public void removeListener(PropertyChangeListener listener)
  {

  }

  @Override public void removeListener(String name,
      PropertyChangeListener listener)
  {

  }
}
