package persistance.supplierDAO;

import shared.transfer.Product;
import shared.transfer.Supplier;
import shared.transfer.address.Address;

import java.util.List;

public interface SupplierDAO
{
  Supplier addNewSupplier(int supplier_id, Product product, String supplierName,
      int cvrNr, Address address_id, String email, String phoneNo);
  List<Supplier> viewAllSuppliers(String searchCriteria);
  void deleteSupplier(Supplier supplier);
  void updateSupplier(Supplier supplier);
}
