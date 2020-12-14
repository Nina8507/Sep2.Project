package client.views.supplier.listviewsupplier;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import shared.transfer.Supplier;

import java.awt.event.ActionEvent;

public class ListViewSupplierController implements ViewController
{
  @FXML private ListView listView;
  private Button onSelectSupplierButton;

  private ViewHandler viewHandler;
  private ListViewSupplierVM listViewSupplierVM;
  private Supplier supplier;


  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.listViewSupplierVM = viewModelFactory.getListViewSupplierVM();

    listView.getItems().add(supplier.getSupplier_id());
    listView.getItems().add(supplier.getlName());
    listView.getItems().add(supplier.getfName());
    listView.getItems().add(supplier.getCvrNr());
    listView.getItems().add(supplier.getStreet());
    listView.getItems().add(supplier.getCity());
    listView.getItems().add(supplier.getCountry());
    listView.getItems().add(supplier.getZipcode());
    listView.getItems().add(supplier.getEmail());
    listView.getItems().add(supplier.getPhoneNo());

    listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    onSelectSupplierButton.setOnAction( actionEvent -> {
      ObservableList supplierViewList = listView.getSelectionModel().getSelectedIndices();
    });
  }
  public void setOnSelectSupplierButton(ActionEvent actionEvent)
  {
    listViewSupplierVM.getSelectedSupplierValues();
  }

}
