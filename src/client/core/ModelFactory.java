package client.core;

import client.model.adminclientmodel.AdminClientModel;
import client.model.adminclientmodel.AdminClientModelManager;
import client.model.usermodel.UserClientModel;
import client.model.usermodel.UserClientModelManager;

public class ModelFactory
{
  private UserClientModel userClientModel;
  private AdminClientModel adminClientModel;
  private ClientFactory clientFactory;

  public ModelFactory(ClientFactory clientFactory)
  {
    this.clientFactory = clientFactory;
  }
  public UserClientModel getUserClientModel()
  {
    if(userClientModel == null)
    {
      userClientModel = new UserClientModelManager(clientFactory.getClient());
    }
    return userClientModel;
  }

  public AdminClientModel getAdminClientModel()
  {
    if(adminClientModel == null)
    {
      adminClientModel = new AdminClientModelManager(clientFactory.getClient());
    }
    return adminClientModel;
  }
}
