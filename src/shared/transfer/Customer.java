package shared.transfer;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable
{
  private String customer_id;
  private String name;
  private String streetName;
  private String city;
  private String country;
  private String zipcode;
  private String phoneNo;
  private Date orderDate;
  private int orderNumber;
  private int quantityOrdered;
  private double price;

  public Customer(String customer_id, String name,
      String streetName, String city, String country, String zipcode,
      String phoneNo, Date orderDate, int orderNumber, int quantityOrdered,
      double price)
  {
    this.customer_id = customer_id;
    this.name = name;
    this.streetName = streetName;
    this.city = city;
    this.country = country;
    this.zipcode = zipcode;
    this.phoneNo = phoneNo;
    this.orderDate = orderDate;
    this.orderNumber = orderNumber;
    this.quantityOrdered = quantityOrdered;
    this.price = price;
  }

  public String getCustomer_id()
  {
    return customer_id;
  }

  public String getName()
  {
    return name;
  }

  public String getStreetName()
  {
    return streetName;
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

  public String getPhoneNo()
  {
    return phoneNo;
  }

  public Date getOrderDate()
  {
    return orderDate;
  }

  public int getOrderNumber()
  {
    return orderNumber;
  }

  public int getQuantityOrdered()
  {
    return quantityOrdered;
  }

  public double getPrice()
  {
    return price;
  }
}
