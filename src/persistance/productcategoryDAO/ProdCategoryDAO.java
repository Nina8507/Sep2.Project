package persistance.productcategoryDAO;

import shared.transfer.products.ProductCategory;

import java.util.List;

public interface ProdCategoryDAO
{
  ProductCategory addNewCategory(int prodCategory_id, String categoryName,
      String categoryDescription);
  List<ProductCategory> viewAllCategoriesByName(String searchCriteria);
  void updateCategory(ProductCategory category);
  void deleteCategory(ProductCategory category);
}