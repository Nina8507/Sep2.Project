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
    this.product = product;z
    this.date = date;
  }

  public DamageProduct getDamageProduct()
  {
    return damageProduct_id;
  }

  public Date getDate()
  {
    return date;
  }

}
