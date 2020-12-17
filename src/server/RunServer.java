package server;

import server.model.addemployeemodel.AddEmployeeServerModel;
import server.model.addemployeemodel.AddEmployeeServerModelManager;
import server.model.supplierModel.addsuppliermodel.AddSupplierServerModel;
import server.model.supplierModel.addsuppliermodel.AddSupplierServerModelManager;
import server.model.adminmodel.AdminServerModel;
import server.model.adminmodel.AdminServerModelManager;
import server.model.supplierModel.listviewsuppliermodel.ListViewSupplierServerModel;
import server.model.supplierModel.listviewsuppliermodel.ListViewSupplierServerModelManager;
import server.model.product.addproduct.AddProductServerModel;
import server.model.product.addproduct.AddProductServerModelManager;
import server.model.supplierModel.SupplierServerModel;
import server.model.supplierModel.SupplierServerModelManager;
import server.model.usermodel.UserServerModel;
import server.model.usermodel.UserServerModelManager;
import server.networking.SocketServer;

public class RunServer
{
  public static void main(String[] args)
  {
    UserServerModel userServerModel = new UserServerModelManager();
    AdminServerModel adminServerModel = new AdminServerModelManager();
    SupplierServerModel supplierServerModel = new SupplierServerModelManager();
    AddSupplierServerModel addSupplierServerModel = new AddSupplierServerModelManager();
    AddEmployeeServerModel addEmployeeServerModel = new AddEmployeeServerModelManager();
    AddProductServerModel addProductServerModel = new AddProductServerModelManager();
    ListViewSupplierServerModel listViewSupplierServerModel = new ListViewSupplierServerModelManager();
    SocketServer socketServer = new SocketServer(userServerModel,
        adminServerModel, supplierServerModel, addSupplierServerModel,
        listViewSupplierServerModel, addEmployeeServerModel, addProductServerModel);
    socketServer.startServer();
  }
}
