package server.networking;

import server.model.ServerModel;

import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  private ServerModel serverModel;

  public SocketServer(ServerModel serverModel)
  {
    this.serverModel = serverModel;
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
              serverModel);

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
