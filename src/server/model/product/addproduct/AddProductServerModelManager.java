package server.model.product.addproduct;

import persistance.productDAO.ProductDAO;
import persistance.productDAO.ProductDAOImpl;
import shared.transfer.UserAction;
import shared.transfer.products.Product;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class AddProductServerModelManager implements AddProductServerModel
{

  private PropertyChangeSupport support;
  private ProductDAO productDAO;
  private List<Product> productList;

  public AddProductServerModelManager()
  {
    support = new PropertyChangeSupport(this);
    productDAO = ProductDAOImpl.getInstance();
  }

  @Override public String addNewProduct(Product productToAdd)
  {
    Product product = new Product(productToAdd.getProduct_id(),
        productToAdd.getProductName(), productToAdd.getMeasurements(),
        productToAdd.getMaterial(), productToAdd.getQuantity(),
        productToAdd.getColor(), productToAdd.getPurchasePrice(),
        productToAdd.getSalePrice());

    if(productList.contains(product))
    {
      return "Product Exist!";
    } else
    {
      productDAO.addNewProduct(product);
      support.firePropertyChange(UserAction.ADD_NEW_PRODUCT.toString(), null, product);
    }
    return "Product Added To List!";
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
