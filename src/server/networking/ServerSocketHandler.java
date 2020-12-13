package server.networking;

import server.model.adminmodel.AdminServerModel;
import server.model.usermodel.UserServerModel;
import shared.transfer.Request;
import shared.transfer.User;
import shared.transfer.UserAction;

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
  private ObjectInputStream inFromClient;
  private ObjectOutputStream outToClient;

  public ServerSocketHandler(Socket socket, UserServerModel userServerModel, AdminServerModel adminServerModel)
  {
    this.socket = socket;
    this.userServerModel = userServerModel;
    this.adminServerModel = adminServerModel;
    adminServerModel.addListener(UserAction.PRODUCT_LIST.toString(), this::sendProductListToView);
  }

  private void sendProductListToView(PropertyChangeEvent evt)
  {
    try
    {
      outToClient.writeObject(new Request(evt.getPropertyName(), evt.getNewValue()));
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

      while(true)
      {
        try
        {
          Request request = (Request) inFromClient.readObject();
          if(request.getRequestType().equals(UserAction.LOGIN_REQUEST.toString()))
          {
            System.out.println("Login requested!");
            User user = (User) request.getRequestArg();
            String loginResult = userServerModel.validateUser(user); // "OK!"
            Request r = new Request(UserAction.LOGIN_RESULT.toString(), "OK!");
            outToClient.writeObject(r);
          } else if(request.getRequestType().equals(UserAction.PRODUCT_LIST.toString()))
          {
            adminServerModel.getProductList();
          } else if(request.getRequestType().equals(UserAction.STAFF_LIST.toString()))
          {
            adminServerModel.getStaffList();
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
