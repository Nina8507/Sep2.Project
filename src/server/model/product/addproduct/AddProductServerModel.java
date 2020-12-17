package server.model.product.addproduct;

import shared.transfer.products.Product;
import shared.util.Subject;

public interface AddProductServerModel extends Subject
{
  String addNewProduct(Product productToAdd);
}
