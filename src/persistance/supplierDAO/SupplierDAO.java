package persistance.supplierDAO;

import shared.transfer.Supplier;

import java.util.List;

public interface SupplierDAO
{
  Supplier addSupplier(Supplier supplier);
  Supplier getSupplier(Supplier supplier);
  List<Supplier> viewAllSuppliers(String searchCriteria);
  void deleteSupplier(Supplier supplier);
  void updateSupplier(Supplier supplier);
}
