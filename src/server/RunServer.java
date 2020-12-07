package server;

import server.model.ServerModel;
import server.model.ServerModelManager;
import server.networking.SocketServer;

import java.sql.SQLException;

public class RunServer
{
  public static void main(String[] args) throws SQLException
  {
    ServerModel serverModel = new ServerModelManager();
    SocketServer socketServer = new SocketServer(serverModel);
    socketServer.startServer();
  }
}
