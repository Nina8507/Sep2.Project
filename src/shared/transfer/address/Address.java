package shared.transfer.address;

public class Address
{
  private int address_id;
  private String street;
  private int streetNumber;
  private City city_id;
  private Country country_id;

  public Address(int address_id, String street, int streetNumber, City city_id,
      Country country)
  {
    this.address_id = address_id;
    this.street = street;
    this.streetNumber = streetNumber;
    this.city_id = city_id;
    this.country_id = country;
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

  public City getCity_id()
  {
    return city_id;
  }

  public Country getCountry_id()
  {
    return country_id;
  }
}
