package shared.transfer.address;

public class Address
{
  private int address_id;
  private String street;
  private int streetNumber;
  private City city;
  private Country country;

  public Address(int address_id, String street, int streetNumber, City city,
      Country country)
  {
    this.address_id = address_id;
    this.street = street;
    this.streetNumber = streetNumber;
    this.city = city;
    this.country = country;
  }

  public int getAddress_id()
  {
    return address_id;
  }

  public String getStreet()
  {
    return street;
  }

  public int getStreetNumber()
  {
    return streetNumber;
  }

  public City getCity()
  {
    return city;
  }

  public Country getCountry()
  {
    return country;
  }
}
