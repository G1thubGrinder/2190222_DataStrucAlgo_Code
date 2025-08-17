package HW.Week1.Q2_toStudent.logic;

import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItem> orderItemList;
	private static int totalOrderCount = 0;
	private int orderNumber;
	
	public Order() {
		this.orderItemList = new ArrayList<OrderItem>();
		this.orderNumber = 0;
		totalOrderCount += 1;
	}

	public OrderItem addItem(Item item, int amount) {
		for(OrderItem o : orderItemList) {
			if(o.getItem() == item) {
				o.increaseItemAmount(amount);
				return o;
			}
		}
		OrderItem i = new OrderItem(item, amount);
		orderItemList.add(i);
		return i;
	}

	public int calculateOrderTotalPrice() {
		int sum = 0;
		for(OrderItem oi : orderItemList) {
			sum += oi.calculateTotalPrice();
		}
		return sum;
	}

	public static int getTotalOrderCount() {
		return totalOrderCount;
	}
	
	public static void resetTotalOrderCount() {
		totalOrderCount = 0;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	
	
}
