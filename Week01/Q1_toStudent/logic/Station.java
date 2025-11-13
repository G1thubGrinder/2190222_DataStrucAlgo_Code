package HW.Week1.Q1_toStudent.logic;

public class Station {
	private String name;
	private int number;
	
	public Station(String name, int number) {
		this.name = name;
		if(number < 0) {this.number = 0;}
		else {this.number = number;}
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setNumber(int newNum) {
		if(newNum < 0) {this.number = 0;}
		else {this.number = newNum;}
	}
	
	public int getNumber() {
		return number;
	}
}
	

