package shared.transfer.address;

import java.io.Serializable;

public class City implements Serializable
{
  private int city_id;
  private Country country;
  private String cityName;
  private int zipcode;

  public City(int city_id, Country country, String cityName, int zipcode)
  {
    this.city_id = city_id;
    this.country = country;
    this.cityName = cityName;
    this.zipcode = zipcode;
  }

  public int getCity_id()
  {
    return city_id;
  }

  public Country getCountry()
  {
    return country;
  }

  public String getCityName()
  {
    return cityName;
  }

  public int getZipcode()
  {
    return zipcode;
  }
}
