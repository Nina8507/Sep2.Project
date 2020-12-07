package client.core;

import client.model.UserClientModel;
import client.model.UserClientModelManager;

public class ModelFactory
{
  private UserClientModel userClientModel;
  private ClientFactory clientFactory;

  public ModelFactory(ClientFactory clientFactory)
  {
    this.clientFactory = clientFactory;
  }
  public UserClientModel getClientModel()
  {
    if(userClientModel == null)
    {
      userClientModel = new UserClientModelManager(clientFactory.getClient());
    }
    return userClientModel;
  }
}
