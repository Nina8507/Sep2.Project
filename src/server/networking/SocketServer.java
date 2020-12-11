package server.networking;

import server.model.adminmodel.AdminServerModel;
import server.model.usermodel.UserServerModel;

import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  private UserServerModel userServerModel;
  private AdminServerModel adminServerModel;

  public SocketServer(UserServerModel userServerModel, AdminServerModel adminServerModel)
  {
    this.userServerModel = userServerModel;
    this.adminServerModel = adminServerModel;
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
              userServerModel, adminServerModel);

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
