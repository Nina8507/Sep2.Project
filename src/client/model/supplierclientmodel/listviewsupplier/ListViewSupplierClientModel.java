package client.model.supplierclientmodel.listviewsupplier;

import shared.util.Subject;

public interface ListViewSupplierClientModel extends Subject
{
  void getSelectedSupplierValues(String supplier_id, String fName, String lName, String cvrNr, String street,
      String city, String country, String zipcode, String email, String phoneNo);
}
