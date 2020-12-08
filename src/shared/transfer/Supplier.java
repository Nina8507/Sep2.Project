package shared.transfer;

import shared.transfer.address.Address;

import java.io.Serializable;

public class Supplier implements Serializable
{
  private int supplier_id;
  private Product product;
  private String supplierName;
  private int cvrNr;
  private Address address;
  private String email;

  public Supplier( int supplier_id, Product product, String supplierName, int cvrNr,
      Address address, String email)
  {
    this.supplier_id = supplier_id;
    this.product = product;
    this.supplierName = supplierName;
    this.cvrNr = cvrNr;
    this.address = address;
    this.email = email;
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

  public Address getAddress()
  {
    return address;
  }

  public String getEmail()
  {
    return email;
  }
}