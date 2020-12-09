package shared.transfer;

import shared.transfer.address.Address;

import java.io.Serializable;

public class Supplier implements Serializable
{
  private int supplier_id;
  private Product product;
  private String supplierName;
  private int cvrNr;
  private Address address_id;
  private String email;
  private String phoneNo;

  public Supplier( int supplier_id, Product product, String supplierName, int cvrNr,
      Address address_id, String email, String phoneNo)
  {
    this.supplier_id = supplier_id;
    this.product = product;
    this.supplierName = supplierName;
    this.cvrNr = cvrNr;
    this.address_id = address_id;
    this.email = email;
    this.phoneNo = phoneNo;
  }

  public int getSupplier_id()
  {
    return supplier_id;
  }

  public Product getProduct()
  {
    return product;
  }

  public String getSupplierName()
  {
    return supplierName;
  }

  public int getCvrNr()
  {
    return cvrNr;
  }

  public Address getAddress_id()
  {
    return address_id;
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