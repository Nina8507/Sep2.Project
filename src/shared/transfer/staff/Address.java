package shared.transfer.staff;

public class Address
{
  private String city;
  private String street;
  private int streetNumber;
  private int zipCode;
  private String country;

  public Address(String city, String street, int streetNumber, int zipCode,
      String country)
  {
    this.city = city;
    this.street = street;
    this.streetNumber = streetNumber;
    this.zipCode = zipCode;
    this.country = country;
  }
  public String getCity()
  {
    return city;
  }

  public String getStreet()
  {
    return street;
  }

  public int getStreetNumber()
  {
    return streetNumber;
  }

  public int getZipCode()
  {
    return zipCode;
  }

  public String getCountry()
  {
    return country;
  }
}
