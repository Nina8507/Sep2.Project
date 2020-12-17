package server.networking;

import server.model.addemployeemodel.AddEmployeeServerModel;
import server.model.supplierModel.addsuppliermodel.AddSupplierServerModel;
import server.model.adminmodel.AdminServerModel;
import server.model.supplierModel.listviewsuppliermodel.ListViewSupplierServerModel;
import server.model.product.addproduct.AddProductServerModel;
import server.model.supplierModel.SupplierServerModel;
import server.model.usermodel.UserServerModel;

import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  private UserServerModel userServerModel;
  private AdminServerModel adminServerModel;
  private SupplierServerModel supplierServerModel;
  private AddSupplierServerModel addSupplierServerModel;
  private ListViewSupplierServerModel listViewSupplierServerModel;
  private AddEmployeeServerModel addEmployeeServerModel;
  private AddProductServerModel addProductServerModel;

  public SocketServer(UserServerModel userServerModel,
      AdminServerModel adminServerModel,
      SupplierServerModel supplierServerModel,
      AddSupplierServerModel addSupplierServerModel,
      ListViewSupplierServerModel listViewSupplierServerModel,
      AddEmployeeServerModel addEmployeeServerModel,
      AddProductServerModel addProductServerModel)
  {
    this.userServerModel = userServerModel;
    this.adminServerModel = adminServerModel;
    this.supplierServerModel = supplierServerModel;
    this.addSupplierServerModel = addSupplierServerModel;
    this.listViewSupplierServerModel = listViewSupplierServerModel;
    this.addEmployeeServerModel = addEmployeeServerModel;
    this.addProductServerModel = addProductServerModel;
  }

  public void startServer()
  {
    {
      try
      {
        ServerSocket serverSocket = new ServerSocket(2910);
        System.out.println("Starting server...");

        while (true)
        {
          Socket socket = serverSocket.accept();
          ServerSocketHandler socketHandler = new ServerSocketHandler(socket,
              userServerModel, adminServerModel, supplierServerModel,
              addSupplierServerModel, listViewSupplierServerModel,
              addEmployeeServerModel, addProductServerModel);

          Thread t = new Thread(socketHandler);
          t.start();
        }
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }
}
