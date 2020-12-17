package server.networking;

import server.model.addemployeemodel.AddEmployeeServerModel;
import server.model.supplierModel.addsuppliermodel.AddSupplierServerModel;
import server.model.adminmodel.AdminServerModel;
import server.model.supplierModel.listviewsuppliermodel.ListViewSupplierServerModel;
import server.model.product.addproduct.AddProductServerModel;
import server.model.supplierModel.SupplierServerModel;
import server.model.usermodel.UserServerModel;
import shared.transfer.Request;
import shared.transfer.Supplier;
import shared.transfer.User;
import shared.transfer.UserAction;
import shared.transfer.products.Product;
import shared.transfer.staff.Employee;
import shared.transfer.staff.Staff;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private UserServerModel userServerModel;
  private AdminServerModel adminServerModel;
  private AddSupplierServerModel addSupplierServerModel;
  private AddEmployeeServerModel addEmployeeServerModel;
  private ListViewSupplierServerModel listViewSupplierServerModel;
  private SupplierServerModel supplierServerModel;
  private AddProductServerModel addProductServerModel;
  private ObjectInputStream inFromClient;
  private ObjectOutputStream outToClient;

  public ServerSocketHandler(Socket socket, UserServerModel userServerModel,
      AdminServerModel adminServerModel,
      SupplierServerModel supplierServerModel,
      AddSupplierServerModel addSupplierServerModel,
      ListViewSupplierServerModel listViewSupplierServerModel,
      AddEmployeeServerModel addEmployeeServerModel,
      AddProductServerModel addProductServerModel)
  {
    this.socket = socket;
    this.userServerModel = userServerModel;
    this.adminServerModel = adminServerModel;
    this.supplierServerModel = supplierServerModel;
    this.addSupplierServerModel = addSupplierServerModel;
    this.listViewSupplierServerModel = listViewSupplierServerModel;
    this.addEmployeeServerModel = addEmployeeServerModel;
    this.addProductServerModel = addProductServerModel;

    adminServerModel.addListener(UserAction.PRODUCT_LIST.toString(),
        this::sendProductListToView);
  }

  private void sendProductListToView(PropertyChangeEvent evt)
  {
    try
    {
      outToClient
          .writeObject(new Request(evt.getPropertyName(), evt.getNewValue()));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void run()
  {
    try
    {
      inFromClient = new ObjectInputStream(socket.getInputStream());
      outToClient = new ObjectOutputStream(socket.getOutputStream());

      while (true)
      {
        try
        {
          Request request = (Request) inFromClient.readObject();
          if (request.getRequestType()
              .equals(UserAction.LOGIN_RESULT.toString()))
          {
            System.out.println("Login requested!");
            User user = (User) request.getRequestArg();
            Staff loginUser = (Staff) userServerModel.validateUser(user);
            Request response = new Request(UserAction.LOGIN_RESULT.toString(),
                loginUser);
            System.out.println(response);
            outToClient.writeObject(response);
          }
          else if (request.getRequestType()
              .equals(UserAction.USER_LIST.toString()))
          {
            userServerModel.getUsers();
          }
          else if (request.getRequestType()
              .equals(UserAction.PRODUCT_LIST.toString()))
          {
            adminServerModel.getProductList();
          }
          else if (request.getRequestType()
              .equals(UserAction.STAFF_LIST.toString()))
          {
            adminServerModel.getStaffList();
          }
          else if (request.getRequestType()
              .equals(UserAction.ADD_NEW_SUPPLIER.toString()))
          {
            Supplier supplierToCreate = (Supplier) request.getRequestArg();
            addSupplierServerModel.createNewSupplier(supplierToCreate);
          }
          else if (request.getRequestType()
              .equals(UserAction.LOGOUT_USER.toString()))
          {
            //userServerModel.logoutUser()
          }
          else if (request.getRequestType()
              .equals(UserAction.GET_VALUES_FROM_DAO.toString()))
          {
            Supplier getSupplier = (Supplier) request.getRequestArg();
            Supplier supplierValues = listViewSupplierServerModel
                .getSupplierValues(getSupplier);
          }
          else if (request.getRequestType()
              .equals(UserAction.CREATE_NEW_EMPLOYEE.toString()))
          {
            Employee employeeToCreate = (Employee) request.getRequestArg();
            addEmployeeServerModel.createNewEmployee(employeeToCreate);
          } else if(request.getRequestType().equals(UserAction.ADD_NEW_PRODUCT.toString()))
          {
            Product productToAdd = (Product) request.getRequestArg();
            addProductServerModel.addNewProduct(productToAdd);
          }
        }
        catch (ClassNotFoundException e)
        {
          e.printStackTrace();
        }
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
