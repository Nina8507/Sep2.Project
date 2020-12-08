package client.views.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MultipleFxmlHandlerJavaFX extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
    Scene scene = new Scene(root);
    stage.show();

  }

  public static void main(String[] args)
  {
    launch(args);
  }
}
