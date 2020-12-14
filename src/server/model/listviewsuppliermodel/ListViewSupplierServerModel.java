package server.model.listviewsuppliermodel;

import shared.transfer.Supplier;
import shared.util.Subject;

public interface ListViewSupplierServerModel extends Subject
{
  Supplier getSupplierValues(Supplier getSupplier);
}
