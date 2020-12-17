package shared.transfer;

public class Address
{
  private String address_id;
  private String street;
  private String streetNumber;
  private String  city;
  private String country;

  public Address(String address_id, String street, String streetNumber,
      String city, String country)
  {
    this.address_id = address_id;
    this.street = street;
    this.streetNumber = streetNumber;
    this.city = city;
    this.country = country;
  }

  public String getAddress_id()
  {
    return address_id;
  }

  public String getStreet()
  {
    return street;
  }

  public String getStreetNumber()
  {
    return streetNumber;
  }

  public String getCity()
  {
    return city;
  }

  public String getCountry()
  {
    return country;
  }
}
