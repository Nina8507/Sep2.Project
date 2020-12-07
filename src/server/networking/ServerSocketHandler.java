package server.networking;

import server.model.UserServerModel;
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
  private UserServerModel userServerModel;
  private ObjectInputStream inFromClient;
  private ObjectOutputStream outToClient;

  public ServerSocketHandler(Socket socket, UserServerModel userServerModel) throws IOException
  {
    this.socket = socket;
    this.userServerModel = userServerModel;
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
            String loginResult = userServerModel.validateUser(user);
            System.out.println("---RESULT: " + loginResult);
            Request response = new Request(UserAction.LOGIN_RESULT.toString(), loginResult);
            System.out.println("ServerSocketHandler " + response.getRequestArg().toString());
            outToClient.writeObject(response);
          } else if(request.getRequestType().equals(UserAction.REGISTER_USER.toString()))
          {
            System.out.println("SocketHandler" + request.getRequestArg());
            userServerModel.registerUser((User) request.getRequestArg());
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
