package client.model.supplierclientmodel;

import shared.transfer.address.Address;
import shared.util.Subject;

public interface SupplierClientModel extends Subject
{
  void addANewSupplier(int supplier_id, String supplierName, int cvrNr,
      Address address_id, String email, String phoneNo);
}
