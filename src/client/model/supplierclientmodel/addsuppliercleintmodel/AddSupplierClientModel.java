package client.model.supplierclientmodel.addsuppliercleintmodel;

import shared.util.Subject;

public interface AddSupplierClientModel extends Subject
{
  void createNewSupplier(String supplier_id, String fName, String lName, String cvrNr, String email, String phoneNo,
     String city, String zipcode, String street, String country );
}
