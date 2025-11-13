package HW.Week2.Q4.logic.unit;

public class FlyingUnit extends BaseUnit{
	public FlyingUnit(int startColumn, int startRow, boolean isWhite, String name){
		super(startColumn, startRow, isWhite, name);
		this.hp = 2;
		this.isFlying = true;
	}
	@Override
	public boolean move(int direction) {
		if(direction == 0) {
			if(this.getRow() >= 0 && this.getRow() <= 2) {
				this.setRow(this.getRow() + 2);
				return true;
			}
			return false;
		} 
		else if(direction == 1) {
			if(this.getColumn() >= 0 && this.getColumn() <= 2) {
				this.setColumn(this.getColumn() + 2);
				return true;
			}
			return false;
		}
		else if(direction == 2) {
			if(this.getRow() <= 4 && this.getRow() >= 2) {
				this.setRow(this.getRow() - 2);
				return true;
			}
			return false;
		}
		else if(direction == 3) {
			if(this.getColumn() <= 4 && this.getColumn() >= 2) {
				this.setColumn(this.getColumn() - 2);
				return true;
			}
			return false;	
		}
		else return false;
	}
}
