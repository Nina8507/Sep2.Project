package client.core;

import client.views.ViewController;
import client.views.staff.StaffController;
import client.views.supplier.SupplierController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Stage mainStage;
  private Scene loginScene;
  private Scene mainViewScene;
  private AnchorPane supplierPane;
  private AnchorPane staffPane;
  private AnchorPane addNewSupplierPane;
  private AnchorPane productPane;
  private AnchorPane listSupplierPane;
  private AnchorPane addNewStaffPane;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory, Stage stage)
  {
    this.viewModelFactory = viewModelFactory;
    mainStage = stage;
  }

  public void start()
  {
    openLoginView();
    mainStage.show();
  }

  public void openLoginView()
  {
    try
    {
      if (loginScene == null)
      {
        loginScene = getScene("../views/login/Login.fxml");
      }
      mainStage.setTitle("Login");
      mainStage.setScene(loginScene);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public void openMainViewScene()
  {
    try
    {
      if (mainViewScene == null)
      {
        mainViewScene = getScene("../views/adminview/MainView.fxml");
      }
      mainStage.setTitle("Management");
      mainStage.setScene(mainViewScene);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public void openStaffView()
  {

    if (staffPane == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("../views/staff/Staff.fxml"));
        staffPane = loader.load();
        StaffController controller = loader.getController();
        controller.init(this, viewModelFactory);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    setMainRightArea(staffPane);

  }

  public void openSupplierView()
  {
    if (supplierPane == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("../views/Supplier.fxml"));
        supplierPane = loader.load();
        SupplierController controller = loader.getController();
        controller.init(this, viewModelFactory);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    setMainRightArea(supplierPane);
  }

  public void openAddNewSupplierPane()
  {
    if (addNewSupplierPane == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("../views/AddSupplier.fxml"));
        addNewSupplierPane = loader.load();
        SupplierController controller = loader.getController();
        controller.init(this, viewModelFactory);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    setMainRightArea(addNewSupplierPane);
  }

  public void openProductView()
  {
    if (productPane == null)
    {
      FXMLLoader loader = new FXMLLoader(
          getClass().getResource("../views/Product.fxml"));
      try
      {
        productPane = loader.load();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      SupplierController controller = loader.getController();
      controller.init(this, viewModelFactory);
    }
    setMainRightArea(productPane);
  }

  public void openListViewSupplier()
  {
    if (listSupplierPane == null)
    {
      FXMLLoader loader = new FXMLLoader(
          getClass().getResource("../views/supplier/ListViewSuppliers.fxml"));
      try
      {
        listSupplierPane = loader.load();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      SupplierController controller = loader.getController();
      controller.init(this, viewModelFactory);
    }
    setMainRightArea(listSupplierPane);
  }

  public void openAddNewStaffView()
  {
    if (addNewStaffPane == null)
    {
      FXMLLoader loader = new FXMLLoader(
          getClass().getResource("../views/staff/addnewstaff/AddStaff.fxml"));
      try
      {
        addNewStaffPane = loader.load();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      SupplierController controller = loader.getController();
      controller.init(this, viewModelFactory);
    }
    setMainRightArea(addNewStaffPane);
  }

  private Scene getScene(String s) throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(s));
    Parent root = loader.load();
    ViewController view = loader.getController();
    view.init(this, viewModelFactory);
    return new Scene(root);
  }

  private void setMainRightArea(Node node)
  {
    viewModelFactory.getMainViewVM().setRightArea(node);
  }

}
