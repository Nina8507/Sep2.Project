package persistance.orderlistDAO;

import shared.transfer.Customer;
import shared.transfer.OrderList;
import shared.transfer.staff.Employee;

import java.util.Date;
import java.util.List;

public interface OrderListDAO
{
  OrderList addNewOrder(int order_id, Employee employee_id, Customer customer_id, Date date);
  List<OrderList> viewAllOrders(String searchCriteria);
  void updateAnOrder(OrderList order);
  void deleteAnOrder(OrderList order);
}
