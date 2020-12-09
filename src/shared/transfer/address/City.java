package shared.transfer.address;

import java.io.Serializable;

public class City implements Serializable
{
  private int city_id;
  private Country country_id;
  private String cityName;
  private int zipcode;

  public City(int city_id, Country country_id, String cityName, int zipcode)
  {
    this.city_id = city_id;
    this.country_id = country_id;
    this.cityName = cityName;
    this.zipcode = zipcode;
  }

  public int getCity_id()
  {
    return city_id;
  }

  public Country getCountry_id()
  {
    return country_id;
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
