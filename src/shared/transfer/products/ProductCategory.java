package shared.transfer.products;

import java.io.Serializable;

public class ProductCategory implements Serializable
{
  private String prodCategory_id;
  private String categoryName;
  private String categoryDescription;

  public ProductCategory(String prodCategory_id, String categoryName,
      String categoryDescription)
  {
    this.prodCategory_id = prodCategory_id;
    this.categoryName = categoryName;
    this.categoryDescription = categoryDescription;
  }

  public String getProdCategory_id()
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
