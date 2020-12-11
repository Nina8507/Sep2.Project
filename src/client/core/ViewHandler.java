package client.core;

import client.views.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Stage mainStage;
  private Scene loginScene;
  private Scene mainViewScene;
  private Scene staffScene;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
    mainStage = new Stage();
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

  public void openStaffView()
  {
    try
    {
      if (staffScene == null)
      {
        staffScene = getScene("../views/staff/Staff.fxml");
      }
      mainStage.setTitle("Staff");
      mainStage.setScene(staffScene);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
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

}
