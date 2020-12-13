package shared.transfer.products;

import java.io.Serializable;

public class ProductCategory implements Serializable
{
  private int prodCategory_id;
  private String categoryName;
  private String categoryDescription;

  public ProductCategory(int prodCategory_id, String categoryName,
      String categoryDescription)
  {
    this.prodCategory_id = prodCategory_id;
    this.categoryName = categoryName;
    this.categoryDescription = categoryDescription;
  }

  public int getProdCategory_id()
  {
    return prodCategory_id;
  }

  public String getCategoryName()
  {
    return categoryName;
  }

  public String getCategoryDescription()
  {
    return categoryDescription;
  }
}
