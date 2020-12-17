package shared.transfer;

import shared.transfer.products.Product;

import java.io.Serializable;

public class Inventory implements Serializable
{
  private String product_id;
  private String supplier_id;

  public Inventory(String product_id, String supplier_id)
  {
    this.product_id = product_id;
    this.supplier_id = supplier_id;
  }

  public String getProduct_id()
  {
    return product_id;
  }

  public String getSupplier_id()
  {
    return supplier_id;
  }
}
