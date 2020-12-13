package persistance.productDAO;

import shared.transfer.products.Product;

import java.util.List;

public interface ProductDAO
{
  Product addNewProduct(int product_id, String productName, int measurements,
      String material, int quantity, String color, double purchasePrice,double salePrice);
  void updateProduct(Product product);
  Product searchProductByProduct_id(int product_id);
  List<Product> viewAllProductsByProductName(String searchCriteria);
  void deleteProduct(Product product);
}