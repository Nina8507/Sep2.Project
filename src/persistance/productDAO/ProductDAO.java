package persistance.productDAO;

import shared.transfer.products.Product;

import java.util.List;

public interface ProductDAO
{
  String addNewProduct(Product product);
  Product searchProductByProduct_id(String product_id);
  List<Product> viewAllProductsByProductName(String searchCriteria);
  void updateProduct(Product product);
  void deleteProduct(Product product);

}