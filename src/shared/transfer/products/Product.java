package shared.transfer.products;

import java.io.Serializable;


public class Product implements Serializable
{
  private String product_id;
  private String productName;
  private String measurements;
  private String material;
  private String quantity;
  private String color;
  private String purchasePrice;
  private String salePrice;

  public Product(String product_id, String productName, String measurements,
      String material, String quantity, String color, String purchasePrice,
      String salePrice)
  {
    this.product_id = product_id;
    this.productName = productName;
    this.measurements = measurements;
    this.material = material;
    this.quantity = quantity;
    this.color = color;
    this.purchasePrice = purchasePrice;
    this.salePrice = salePrice;
  }

  public String getProduct_id()
  {
    return product_id;
  }

  public String getProductName()
  {
    return productName;
  }

  public String getMeasurements()
  {
    return measurements;
  }

  public String getMaterial()
  {
    return material;
  }

  public String getQuantity()
  {
    return quantity;
  }

  public String getColor()
  {
    return color;
  }

  public String getPurchasePrice()
  {
    return purchasePrice;
  }

  public String getSalePrice()
  {
    return salePrice;
  }
}
