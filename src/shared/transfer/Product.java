package shared.transfer;

import java.io.Serializable;

public class Product implements Serializable
{
  private int product_id;
  private String productName;
  private int length, width, height ;
  private String material;
  private int quantity;
  private String color;
  private double price;

  public Product(int product_id, String productName, int length, int width, int height,
      String material, int quantity, String color, double price)
  {
    this.product_id = product_id;
    this.productName = productName;
    this.length = length;
    this.width = width;
    this.height = height;
    this.material = material;
    this.quantity = quantity;
    this.color = color;
    this.price = price;
  }

  public int getProduct_id()
  {
    return product_id;
  }

  public String getProductName()
  {
    return productName;
  }

  public int getLength()
  {
    return length;
  }

  public int getWidth()
  {
    return width;
  }

  public int getHeight()
  {
    return height;
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

  public double getPrice()
  {
    return price;
  }
}
