package shared.transfer;

import shared.transfer.staff.Employee;

import java.io.Serializable;
import java.util.Date;

public class OrderList implements Serializable
{
  private int orders_id;
  private Employee employee_id;
  private Customer customer_id;
  private Date date;

  public OrderList(int orders_id, Employee employee_id, Customer customer_id,
      Date date)
  {
    this.orders_id = orders_id;
    this.employee_id = employee_id;
    this.customer_id = customer_id;
    this.date = date;
  }

  public int getOrders_id()
  {
    return orders_id;
  }

  public Employee getEmployee_id()
  {
    return employee_id;
  }

  public Customer getCustomer_id()
  {
    return customer_id;
  }

  public Date getDate()
  {
    return date;
  }
}
