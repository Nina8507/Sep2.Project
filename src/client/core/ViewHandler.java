package client.core;

import client.views.ViewController;
import client.views.staff.StaffController;
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
  private Scene staffScene;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory, Stage stage)
  {
    this.viewModelFactory = viewModelFactory;
    mainStage = stage;
  }

  public void start()
  {
    openLoginView();
    //openMainViewScene();
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
      if(mainViewScene == null)
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
  private AnchorPane staffPane;
  public void openStaffView()
  {

    if (staffPane == null) {
      try
      {
        System.out.println("PATH: " + getClass().getResource("../views/staff/Staff.fxml"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/staff/Staff.fxml"));
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


//    try
//    {
//      if (staffScene == null)
//      {
//        staffScene = getScene("../views/staff/Staff.fxml");
//      }
//      mainStage.setTitle("Staff");
//      mainStage.setScene(staffScene);
//    }
//    catch (Exception e)
//    {
//      e.printStackTrace();
//    }
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

  private void setMainRightArea(Node node) {
    viewModelFactory.getMainViewVM().setRightArea(node);
  }

}
