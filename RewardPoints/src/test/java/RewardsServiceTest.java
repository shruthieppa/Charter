import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import model.Order;
import service.OrderService;
import service.RewardsService;

@ExtendWith(MockitoExtension.class)
class RewardsServiceTest {

	  @InjectMocks
	  RewardsService rewardsService;

	  @Mock
	  private OrderService mockOrderService;
	 

	  @Test
	  void findByCustomerId_whenAmountIsGreaterThan100() {
	    List<Order> orders = new ArrayList<>();
	    Order order = new Order();
	    order.setCustomerId(123);
	    order.setAmount(120);//20*2 =40n + 50 = 90 points 
	    orders.add(order);
	    Mockito.when(mockOrderService.findOrdersByCustomerId(Mockito.anyLong())).thenReturn(orders);
	   // doReturn(orders).when(mockOrderService).findOrdersByCustomerId(anyLong());
	    long points = rewardsService.findByCustomerId(123L);
	    assertEquals(90, points);
	  }

	  @Test
	  void findByCustomerId_whenAmountIsBetween50And100() {
	    List<Order> orders = new ArrayList<>();
	    Order order = new Order();
	    order.setCustomerId(123);
	    order.setAmount(80); //80-50 = 30*1 = 30 points
	    orders.add(order);
	    doReturn(orders).when(mockOrderService).findOrdersByCustomerId(anyLong());
	    long points = rewardsService.findByCustomerId(123L);
	    assertEquals(30, points);
	  }

	  @Test
	  void findByCustomerId_whenAmountIsLessThan50() {
	    List<Order> orders = new ArrayList<>();
	    Order order = new Order();
	    order.setCustomerId(123);
	    order.setAmount(40);//below 50 no points
	    orders.add(order);
	    doReturn(orders).when(mockOrderService).findOrdersByCustomerId(anyLong());
	    long points = rewardsService.findByCustomerId(123L);
	    assertEquals(0, points);
	  }
	}