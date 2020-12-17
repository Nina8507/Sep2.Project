package client.views.product.addproduct;

import client.model.productclientmodel.addproduct.AddProductClientModel;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AddProductVM
{
  private StringProperty purchasePrice = new SimpleStringProperty();
  private StringProperty salesPrice = new SimpleStringProperty();
  private StringProperty color = new SimpleStringProperty();
  private StringProperty quantity = new SimpleStringProperty();
  private StringProperty productName = new SimpleStringProperty();
  private StringProperty productId = new SimpleStringProperty();
  private StringProperty measurement = new SimpleStringProperty();
  private StringProperty material = new SimpleStringProperty();

  private AddProductClientModel addProductClientModel;

  public AddProductVM(AddProductClientModel addProductClientModel)
  {
    this.addProductClientModel = addProductClientModel;
  }

  public StringProperty purchasePriceProperty()
  {
    return purchasePrice;
  }

  public Property<String> salesPriceProperty()
  {
    return salesPrice;
  }

  public Property<String> colorProperty()
  {
    return color;
  }

  public Property<String> quantityProperty()
  {
    return quantity;
  }

  public Property<String> productNameProperty()
  {
    return productName;
  }

  public Property<String> productIdProperty()
  {
    return productId;
  }

  public Property<String> measurementProperty()
  {
    return measurement;
  }

  public Property<String> materialProperty()
  {
    return material;
  }


  public void addNewProduct()
  {
    addProductClientModel
        .addNewProduct(purchasePrice.get(), salesPrice.get(), color.get(),
            quantity.get(), productName.get(), productId.get(),
            measurement.get(), material.get());
  }
}
