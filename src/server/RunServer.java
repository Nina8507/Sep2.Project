package server;

import server.model.usermodel.UserServerModel;
import server.model.usermodel.UserServerModelManager;
import server.networking.SocketServer;

import java.sql.SQLException;

public class RunServer
{
  public static void main(String[] args) throws SQLException
  {
    UserServerModel userServerModel = new UserServerModelManager();
    SocketServer socketServer = new SocketServer(userServerModel);
    socketServer.startServer();
  }
}
