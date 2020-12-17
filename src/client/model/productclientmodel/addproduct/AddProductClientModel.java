package client.model.productclientmodel.addproduct;

import shared.util.Subject;

public interface AddProductClientModel extends Subject
{
  void addNewProduct(String material, String measurement, String productId, String productName, String quantity, String color,
      String salesPrice, String purchasePrice);
}
