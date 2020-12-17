package client.model.staffmodel.addsecretaryclientmodel;

import shared.util.Subject;

public interface AddSecretaryClientModel extends Subject
{
  void createNewSecretary(String city, String zipcode, String email, String salary, String role, String country,
      String name, String cprNr, String staffId, String username, String password, String street, String phoneNumber);
}
