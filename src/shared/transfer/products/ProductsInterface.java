package shared.transfer.products;

import java.util.List;

public interface ProductsInterface
{
  List<Product> removeProductFromProductList(Product product);
  List<DamageProduct> addProductToDamageList(DamageProduct product);
}
