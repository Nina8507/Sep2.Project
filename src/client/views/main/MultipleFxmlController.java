package client.views.main;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.awt.event.ActionEvent;

public class MultipleFxmlController
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
  void handelButtonDashboardAction(ActionEvent event)
  {
    System.out.println("You clicked Dashboard");
    FxmlLoader object = new FxmlLoader();
    Pane view = object.getPage("dashboard");
    mainPane.setCenter(view);
  }

  @FXML
  void handelButtonProductAction(ActionEvent event)
  {
    System.out.println("You clicked Dashboard");
    FxmlLoader object = new FxmlLoader();
    Pane view = object.getPage("Product");
    mainPane.setCenter(view);

  }

  @FXML
  void handelButtonSuppliersAction(ActionEvent event)
  {
    System.out.println("You clicked Dashboard");
    FxmlLoader object = new FxmlLoader();
    Pane view = object.getPage("../supplier");
    mainPane.setCenter(view);

  }

  @FXML
  void handelButtonOrderAction(ActionEvent event)
  {
    System.out.println("You clicked Dashboard");
    FxmlLoader object = new FxmlLoader();
    Pane view = object.getPage("Order");
    mainPane.setCenter(view);

  }

  @FXML
  void handelButtonEmployersAction(ActionEvent event)
  {
    System.out.println("You clicked Dashboard");
    FxmlLoader object = new FxmlLoader();
    Pane view = object.getPage("Employer");
    mainPane.setCenter(view);
  }

  @FXML
  void handelButtonCostumerAction(ActionEvent event)
  {
    System.out.println("You clicked Dashboard");
    FxmlLoader object = new FxmlLoader();
    Pane view = object.getPage("Costumer");
    mainPane.setCenter(view);
  }

  @FXML
  void handelButtonActivityLogAction(ActionEvent event)
  {
    System.out.println("You clicked Dashboard");
    FxmlLoader object = new FxmlLoader();
    Pane view = object.getPage("ActivityLog");
    mainPane.setCenter(view);
  }

  @FXML
  void handelButtonRegistrationAction(ActionEvent event)
  {
    System.out.println("You clicked Dashboard");
    FxmlLoader object = new FxmlLoader();
    Pane view = object.getPage("Registration");
    mainPane.setCenter(view);
  }

  @FXML
  void handelButtonSignOutAction(ActionEvent event)
  {
    System.out.println("You clicked Dashboard");
    FxmlLoader object = new FxmlLoader();
    Pane view = object.getPage("SignOut");
    mainPane.setCenter(view);
  }



}