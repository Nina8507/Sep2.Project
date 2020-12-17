package shared.transfer;

import java.io.Serializable;

public class OrderList implements Serializable
{
  private String orders_id;
  private String employee_id;
  private String customer_id;
  private String date;

  public OrderList(String orders_id, String employee_id, String customer_id,
      String date)
  {
    this.orders_id = orders_id;
    this.employee_id = employee_id;
    this.customer_id = customer_id;
    this.date = date;
  }

  public String getOrders_id()
  {
    return orders_id;
  }

  public String getEmployee_id()
  {
    return employee_id;
  }

  public String getCustomer_id()
  {
    return customer_id;
  }

  public String getDate()
  {
    return date;
  }
}
