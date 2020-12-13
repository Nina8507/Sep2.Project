package persistance.damagelistDAO;

import shared.transfer.products.DamageProduct;
import shared.transfer.products.Product;

import java.util.Date;
import java.util.List;

public interface DamagedListDAO
{
  List<DamageProduct> showDamageProductList(String searchCriteria);
  DamageProduct addDamagedProduct(Product damagedProduct,int damagedProduct_id, Date date);
  void deleteDamagedProduct(DamageProduct damageProduct);
}
