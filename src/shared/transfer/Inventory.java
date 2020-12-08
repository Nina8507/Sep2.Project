package shared.transfer;

import java.io.Serializable;

public class Inventory implements Serializable
{
  private Product product_id;
  private Supplier supplier_id;

  public Inventory(Product product_id, Supplier supplier_id)
  {
    this.product_id = product_id;
    this.supplier_id = supplier_id;
  }

  public Product getProduct_id()
  {
    return product_id;
  }

  public Supplier getSupplier_id()
  {
    return supplier_id;
  }
}
