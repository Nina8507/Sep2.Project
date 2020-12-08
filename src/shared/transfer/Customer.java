package shared.transfer;

import shared.transfer.address.Address;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable
{
  private int customer_id;
  private String fname;
  private String lname;
  private Address address_id;
  private String phoneNo;
  private Date orderDate;
  private int orderNumber;
  private int quantityOrdered;
  private double price;

  public Customer(int customer_id, String fname, String lname, Address address_id,
      String phoneNo, Date orderDate, int orderNumber, int quantityOrdered,
      double price)
  {
    this.customer_id = customer_id;
    this.fname = fname;
    this.lname = lname;
    this.address_id = address_id;
    this.phoneNo = phoneNo;
    this.orderDate = orderDate;
    this.orderNumber = orderNumber;
    this.quantityOrdered = quantityOrdered;
    this.price = price;
  }

  public int getCustomer_id()
  {
    return customer_id;
  }

  public String getFname()
  {
    return fname;
  }

  public String getLname()
  {
    return lname;
  }

  public Address getAddress_id()
  {
    return address_id;
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
