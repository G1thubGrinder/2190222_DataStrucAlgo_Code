package HW.Week2.Q4.logic.unit;
import java.util.*;

public class BaseUnit {
	private int row;
	private int column;
	private boolean isWhite;
	private String name;
	protected int hp;
	protected int power;
	protected boolean isFlying;
	
	public BaseUnit(int startColumn, int startRow, boolean isWhite, String name) {
		this.power = 1;
		this.isFlying = false;
		this.hp = 2;
		setColumn(startColumn);
		setRow(startRow);
		setIsWhite(isWhite);
		setName(name);
	}
	
	public boolean move(int direction) {
		if(direction == 0) {
			if(this.row != 4) {
				this.row += 1;
				return true;
			}
			return false;
		}
		else if(direction == 1) {
			if(this.column != 4) {
				this.column += 1;
				return true;
			}
			return false;
		}
		else if(direction == 2) {
			if(this.row != 0) {
				this.row -= 1;
				return true;
			}
			return false;
		}
		else if(direction == 3) {
			if(this.column != 0) {
				this.column -= 1;
				return true;
			}
			return false;	
		}
		else return false;
	}
	
	public void attack(ArrayList<BaseUnit> targetPieces) {
		for(BaseUnit bu : targetPieces) {
			if(!bu.isFlying && (bu.getColumn() == this.getColumn()) && (bu.getRow() == this.getRow())) {
				System.out.println(this.getName() + " attacks " + bu.getName());
				bu.hp -= this.power;
			}
		}
	}
	
	public int getColumn() {return column;}
	public int getRow() {return row;}
	public boolean isWhite() {return isWhite;}
	public String getName() {return name;}
	public int getHp() {return hp;}
	public int getPower() {return power;}
	public boolean isFlying() {return isFlying;}
	
	public void setColumn(int column) {
		if(column > 4) this.column = 4;
		else if(column < 0) this.column = 0;
		else this.column = column;
	}
	public void setRow(int row) {
		if(row > 4) this.row = 4;
		else if(row < 0) this.row = 0;
		else this.row = row;
	}
	public void setIsWhite(boolean isWhite) {this.isWhite = isWhite;}
	public void setName(String name) {this.name = name;}
	public void setHp(int hp) {this.hp = hp;}
	public void setPower(int power) {this.power = power;}
	public void setIsFlying(boolean isFlying) {this.isFlying = isFlying;}
}
