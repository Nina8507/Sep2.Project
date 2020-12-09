package client.views.main;

import client.core.ViewModelFactory;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class MainController
{
  @FXML
  private JFXButton dashboard_btn;

  @FXML
  private JFXButton product_btn;

  @FXML
  private JFXButton supplier_btn;

  @FXML
  private JFXButton order_btn;

  @FXML
  private JFXButton employee_btn;

  @FXML
  private JFXButton costumer_btn;

  @FXML
  private JFXButton chat_btn;

  @FXML
  private JFXButton registration_btn;

  @FXML
  private JFXButton activityLog_btn;

  @FXML
  private BorderPane mainPane;

  @FXML
  private Pane contentPane;


  public void setContent(Node node) {
    contentPane.getChildren().clear(); // removes current pane
    contentPane.getChildren().add(node); // add the new pane to the current pane.
  }

/*  @FXML
  void handelButtonDashboardAction(ActionEvent event)
  {
    System.out.println("You clicked Dashboard");
    FxmlLoader object = new FxmlLoader();
    Pane view = object.getPage("dashboard");
    mainPane.setCenter(view);
  } */



  @FXML
  void handelButtonProductAction(ActionEvent event) throws IOException
  {

    System.out.println("You clicked Product");
    FxmlLoader object = new FxmlLoader();
    Pane view = object.getPage("Product");
    mainPane.setCenter(view);


    Parent productParent = FXMLLoader.load(getClass().getResource("products.fxml"));

    Scene productsScene = new Scene(productParent);

    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

    window.setScene(productsScene);
    window.show();

  }

  @FXML
  void handelButtonSuppliersAction(ActionEvent event)
  {
    System.out.println("You clicked Supplier");
    FxmlLoader object = new FxmlLoader();
    Pane view = object.getPage("../supplier");
    mainPane.setCenter(view);

  }

 /* @FXML
  void handelButtonOrderAction(ActionEvent event)
  {
    System.out.println("You clicked Order");
    FxmlLoader object = new FxmlLoader();
    Pane view = object.getPage("Order");
    mainPane.setCenter(view);

  }
  */


  /*@FXML
  void handelButtonEmployersAction(ActionEvent event)
  {
    System.out.println("You clicked Staff");
    FxmlLoader object = new FxmlLoader();
    Pane view = object.getPage("Staff");
    mainPane.setCenter(view);
  }*/

  @FXML
  void handelButtonCostumerAction(ActionEvent event)
  {
    System.out.println("You clicked Costumer");
    FxmlLoader object = new FxmlLoader();
    Pane view = object.getPage("Costumer");
    mainPane.setCenter(view);
  }

  public void init()
  {
    // init
  }
  /*

  @FXML
  void handelButtonActivityLogAction(ActionEvent event)
  {
    System.out.println("You clicked Activity Log");
    FxmlLoader object = new FxmlLoader();
    Pane view = object.getPage("ActivityLog");
    mainPane.setCenter(view);
  }
*/

 /* @FXML
  void handelButtonRegistrationAction(ActionEvent event)
  {
    System.out.println("You clicked Registration");
    FxmlLoader object = new FxmlLoader();
    Pane view = object.getPage("Registration");
    mainPane.setCenter(view);
  }
*/

  /*@FXML
  void handelButtonSignOutAction(ActionEvent event)
  {
    System.out.println("You clicked Sign out");
    FxmlLoader object = new FxmlLoader();
    Pane view = object.getPage("SignOut");
    mainPane.setCenter(view);
  }
   */



}