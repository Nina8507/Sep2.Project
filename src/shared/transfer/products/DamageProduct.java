package shared.transfer.products;

import java.io.Serializable;
import java.util.Date;

public class DamageProduct implements Serializable
{
  private String damageProduct_id;
  private String product;
  private String date;

  public DamageProduct(String damageProduct_id, String product, String date)
  {
    this.damageProduct_id = damageProduct_id;
    this.product = product;
    this.date = date;
  }

  public String getDamageProduct_id()
  {
    return damageProduct_id;
  }

  public String getProduct()
  {
    return product;
  }

  public String getDate()
  {
    return date;
  }
}
