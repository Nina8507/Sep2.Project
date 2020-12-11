package shared.transfer;

import java.io.Serializable;

public class Product implements Serializable
{
  private int product_id;
  private String productName;
  private int measurements;
  private String material;
  private int quantity;
  private String color;
  private double purchasePrice;
  private double salePrice;

  public Product(int product_id, String productName, int measurements,
      String material, int quantity, String color, double purchasePrice,double salePrice)
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

  public int getProduct_id()
  {
    return product_id;
  }

  public String getProductName()
  {
    return productName;
  }

  public int getMeasurements()
  {
    return measurements;
  }

  public String getMaterial()
  {
    return material;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public String getColor()
  {
    return color;
  }

  public double getPurchasePrice()
  {
    return purchasePrice;
  }

  public double getSalePrice()
  {
    return salePrice;
  }
}
