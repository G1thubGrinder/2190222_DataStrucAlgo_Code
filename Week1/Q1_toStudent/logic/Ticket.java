package HW.Week1.Q1_toStudent.logic;

public class Ticket {
	private int type;
	private int priceperstation;
	
	private Station start;
	private Station end;
	
	public Ticket(int type,Station start,Station end) {
		setType(type);
		setStation(start,end);
	}
	
	public int getType() {
		return type;
	}
	
	public int getPricePerStation() {
		return priceperstation;
	}
	
	public Station getStart() {
		return start;
	}
	
	public Station getEnd() {
		return end;
	}
	
	public void setType(int type) {
		if(type == 0) {
			this.type = 0;
			this.priceperstation = 30;
		}
		else if(type == 2) {
			this.type = 2;
			this.priceperstation = 25;
		}
		else {
			this.type = 1;
			this.priceperstation = 30;
		}
	}
	
	public void setStation(Station start,Station end) {
		this.start = start;
		this.end = end;
	}
	
	public double calculatePrice() {
		if(!this.isStationValid(this.start, this.end)) return -1;
		int dis = this.getStationDistance(this.start, this.end);
		if (type == 0 && dis > 4) {
			return dis*priceperstation*0.8;
		}
		else if(type == 2) {return dis*priceperstation*0.6;}
		return dis*priceperstation;
	}
	
	public String getDescription() {
		String typename;
		
		switch(type) {
		case 0:
			typename = "Student";
			break;
		case 1:
			typename = "Adult";
			break;
		case 2:
			if (isStationValid(start, end)) {
				typename = "Elderly";
			}
			else {
				typename = "Invalid";
			}
			break;
		default:
			typename = "Invalid";
		}
		
		return typename+" Ticket, from "+ this.start.getName() +" to "+this.end.getName();
	}
	
	public boolean isStationValid(Station start,Station end) {
		if (type == 2 && this.getStationDistance(start, end) > 6) {
			return false;
		}

		if (start == end || start.getName().equals(end.getName())) {
			return false;
		}
		return true;
	}
	
	public int getStationDistance(Station start,Station end) {
		return Math.abs(start.getNumber()-end.getNumber());
	}
	
}
