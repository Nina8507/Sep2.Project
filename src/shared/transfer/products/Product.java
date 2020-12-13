package shared.transfer.products;

import shared.transfer.UserAction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable, ProductsInterface
{
  private int product_id;
  private String productName;
  private int measurements;
  private String material;
  private int quantity;
  private String color;
  private double purchasePrice;
  private double salePrice;
  private DamageProduct damageProduct;

  public boolean isDamaged() {
    return damageProduct != null;
  }

  public DamageProduct getDamageReport(){

    return damageProduct;

  }

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

  public Product(DamageProduct damageProduct)
  {
    this.damageProduct = damageProduct;
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

  public Product getDamagedProduct(Product damagedProductFromProdList)
  {
    List<Product> allProducts = new ArrayList<>(); // size = 0
    for (int i = 0; i < allProducts.size(); i++)
    {
      if (allProducts.get(i).equals(UserAction.DAMAGED_PRODUCT.toString()))
      {
        allProducts.remove(damagedProductFromProdList);
      }
    }
    return damagedProductFromProdList;
  }

  @Override public List<Product> removeProductFromProductList(Product product)
  {
    List<Product> allProducts = new ArrayList<>();
    for(int i = 0; i < allProducts.size(); i++)
    {
      if(allProducts.get(i).equals(UserAction.MOVE_PRODUCT_TO_DAMAGE_LIST.toString()))
      {
        allProducts.remove(getDamagedProduct(product));
      }
    }
    return allProducts;
  }

  @Override public List<DamageProduct> addProductToDamageList(DamageProduct damagedProductFromDamList)
  {
    List<DamageProduct> damageProducts = new ArrayList<>();
    List<Product> allProducts = new ArrayList<>();
    for(int i = 0; i < damageProducts.size(); i++)
    {
      if(allProducts.get(i).equals(damagedProductFromDamList))
      {
        damageProducts.add(damagedProductFromDamList);
      }
    }
    return damageProducts;
  }
}
