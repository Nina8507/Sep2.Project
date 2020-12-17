package shared.transfer;

import java.io.Serializable;

public class Supplier implements Serializable
{
  private String supplier_id;
  private String fName;
  private String lName;
  private String cvrNr;
  private String street;
  private String city;
  private String country;
  private String zipcode;
  private String email;
  private String phoneNo;

  public Supplier(String supplier_id, String fName, String lName, String cvrNr,
      String street, String city, String country, String zipcode, String email,
      String phoneNo)
  {
    this.supplier_id = supplier_id;
    this.fName = fName;
    this.lName = lName;
    this.cvrNr = cvrNr;
    this.street = street;
    this.city = city;
    this.country = country;
    this.zipcode = zipcode;
    this.email = email;
    this.phoneNo = phoneNo;
  }

  public String getSupplier_id()
  {
    return supplier_id;
  }

  public String getfName()
  {
    return fName;
  }

  public String getlName()
  {
    return lName;
  }

  public String getCvrNr()
  {
    return cvrNr;
  }

  public String getStreet()
  {
    return street;
  }

  public String getCity()
  {
    return city;
  }

  public String getCountry()
  {
    return country;
  }

  public String getZipcode()
  {
    return zipcode;
  }

  public String getEmail()
  {
    return email;
  }

  public String getPhoneNo()
  {
    return phoneNo;
  }
}