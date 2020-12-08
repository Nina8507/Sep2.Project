package client.views.main;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.net.URL;

public class FxmlLoader
{
  private Pane view;

  public Pane getPage(String fileName)
  {
    try
    {
      URL fileUrl = MultipleFxmlHandlerJavaFX.class
          .getResource("/MultipleFxmlHandlerJavaFX/" + fileName + ".fxml");
      if (fileUrl == null)
      {
        throw new java.io.FileNotFoundException("Fxml file wasn't found");
      }

      view = new FXMLLoader().load(fileUrl);
    }

    catch (Exception e)
    {
      System.out.println("No page " + fileName + "Please check FxmlLoader.");
    }
    return view;
  }
}

