package server;

import server.model.addemployeemodel.AddEmployeeServerModel;
import server.model.addemployeemodel.AddEmployeeServerModelManager;
import server.model.addsuppliermodel.AddSupplierServerModel;
import server.model.addsuppliermodel.AddSupplierServerModelManager;
import server.model.adminmodel.AdminServerModel;
import server.model.adminmodel.AdminServerModelManager;
import server.model.listviewsuppliermodel.ListViewSupplierServerModel;
import server.model.listviewsuppliermodel.ListViewSupplierServerModelManager;
import server.model.supplierModel.SupplierServerModel;
import server.model.supplierModel.SupplierServerModelManager;
import server.model.usermodel.UserServerModel;
import server.model.usermodel.UserServerModelManager;
import server.networking.SocketServer;

import java.sql.SQLException;

public class RunServer
{
  public static void main(String[] args)
  {
    UserServerModel userServerModel = new UserServerModelManager();
    AdminServerModel adminServerModel = new AdminServerModelManager();
    SupplierServerModel supplierServerModel = new SupplierServerModelManager();
    AddSupplierServerModel addSupplierServerModel = new AddSupplierServerModelManager();
    AddEmployeeServerModel addEmployeeServerModel = new AddEmployeeServerModelManager();
    ListViewSupplierServerModel listViewSupplierServerModel = new ListViewSupplierServerModelManager();
    SocketServer socketServer = new SocketServer(userServerModel,
        adminServerModel, supplierServerModel, addSupplierServerModel,
        listViewSupplierServerModel, addEmployeeServerModel);
    socketServer.startServer();
  }
}
