package HW.Week2.Q4.logic.unit;

import java.util.ArrayList;

public class RangeUnit extends BaseUnit{
	public RangeUnit(int startColumn, int startRow, boolean isWhite, String name){
		super(startColumn, startRow, isWhite, name);
		this.hp = 2;
	}
	
	@Override
	public void attack(ArrayList<BaseUnit> targetPieces) {
		for(BaseUnit bu : targetPieces) {
			if(((this.isWhite()) && (bu.getColumn() == this.getColumn()) && (bu.getRow() == this.getRow() + 1))
				|| ((!this.isWhite()) && (bu.getColumn() == this.getColumn()) && (bu.getRow() == this.getRow() - 1))) {
				System.out.println(this.getName() + " attacks " + bu.getName());
				bu.hp -= this.power;
			}
		}
	}
}
