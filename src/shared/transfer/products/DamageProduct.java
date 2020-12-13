package shared.transfer.products;

import java.io.Serializable;
import java.util.Date;

public class DamageProduct implements Serializable
{
  private DamageProduct damageProduct_id;
  private Product product;
  private Date date;

  public DamageProduct(DamageProduct damageProduct_id, Product product, Date date)
  {
    this.damageProduct_id = damageProduct_id;
    this.product = product;
    this.date = date;
  }

  public DamageProduct getDamageProduct_id()
  {
    return damageProduct_id;
  }

  public Product getProduct()
  {
    return product;
  }

  public Date getDate()
  {
    return date;
  }
}
