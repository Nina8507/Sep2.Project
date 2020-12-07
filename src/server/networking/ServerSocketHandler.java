package server.networking;

import server.model.ServerModel;
import shared.transfer.Request;
import shared.transfer.User;
import shared.transfer.UserAction;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private ServerModel serverModel;
  private ObjectInputStream inFromClient;
  private ObjectOutputStream outToClient;

  public ServerSocketHandler(Socket socket, ServerModel serverModel) throws IOException
  {
    this.socket = socket;
    this.serverModel = serverModel;
  }

  @Override public void run()
  {
    try
    {
      inFromClient = new ObjectInputStream(socket.getInputStream());
      outToClient = new ObjectOutputStream(socket.getOutputStream());

      while(true)
      {
        try
        {
          Request request = (Request) inFromClient.readObject();
          if(request.getRequestType().equals(UserAction.LOGIN_REQUEST.toString()))
          {
            System.out.println("Login requested!");
            User user = (User) request.getRequestArg();
            String loginResult = serverModel.validateUser(user);
            System.out.println("---RESULT: " + loginResult);
            Request response = new Request(UserAction.LOGIN_RESULT.toString(), loginResult);
            System.out.println("ServerSocketHandler " + response.getRequestArg().toString());
            outToClient.writeObject(response);
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
