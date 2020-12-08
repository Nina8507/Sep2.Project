package persistance.productDAO;

import shared.transfer.Product;

import java.util.List;

public interface ProductDAO
{
  Product addNewProduct(int product_id, String productName, int length,
      int width, int height, String material, int quantity, String color,
      double price);
  void updateProduct(Product product);
  Product searchProductByProduct_id(int product_id);
  List<Product> viewAllProductsByProductName(String productName);
  void deleteProduct(Product product);
}
