package shared.transfer.address;

import java.io.Serializable;

public class Country implements Serializable
{
  private int country_id;
  private String countryName;

  public Country(int country_id, String countryName)
  {
    this.country_id = country_id;
    this.countryName = countryName;
  }

  public int getCountry_id()
  {
    return country_id;
  }

  public String getCountryName()
  {
    return countryName;
  }
}

