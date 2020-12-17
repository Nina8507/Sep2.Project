package client.views.supplier.listviewsupplier;

import client.model.supplierclientmodel.listviewsupplier.ListViewSupplierClientModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ListViewSupplierVM
{
  private ListViewSupplierClientModel listViewSupplierClientModel;
  private StringProperty supplier_id, fName, lName, cvrNr, street, city, country, zipcode, email, phoneNo;

  public ListViewSupplierVM(
      ListViewSupplierClientModel listViewSupplierClientModel)
  {
    this.listViewSupplierClientModel = listViewSupplierClientModel;
    supplier_id = new SimpleStringProperty();
    fName = new SimpleStringProperty();
    lName = new SimpleStringProperty();
    cvrNr = new SimpleStringProperty();
    street = new SimpleStringProperty();
    city = new SimpleStringProperty();
    country = new SimpleStringProperty();
    zipcode = new SimpleStringProperty();
    email = new SimpleStringProperty();
    phoneNo = new SimpleStringProperty();
  }

  public void getSelectedSupplierValues()
  {
    listViewSupplierClientModel
        .getSelectedSupplierValues(supplier_id.get(), fName.get(), lName.get(),
            cvrNr.get(), street.get(), city.get(), country.get(), zipcode.get(),
            email.get(), phoneNo.get());
  }
}
