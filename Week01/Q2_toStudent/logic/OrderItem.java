package HW.Week1.Q2_toStudent.logic;

public class OrderItem {
	private Item item;
	private int itemAmount;
	
	public OrderItem(Item item, int itemAmount) {
		this.item = item;
		setItemAmount(itemAmount);
	}
	
	public void increaseItemAmount(int amount) {
		if(amount >= 0) {
			this.itemAmount = itemAmount + amount;
		}
	}
	
	public int calculateTotalPrice() {
		return item.getPricePerPiece()*itemAmount;
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public int getItemAmount() {
		return itemAmount;
	}
	
	public void setItemAmount(int itemAmount) {
		if(itemAmount <= 0 ) {this.itemAmount = 0;}
		else {this.itemAmount = itemAmount;}
	}
	
}
