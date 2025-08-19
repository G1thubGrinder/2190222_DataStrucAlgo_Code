package HW.Week2.Q3.logic.card;
import HW.Week2.Q3.logic.game.*;

public class DrawTwoCard extends BaseCard {
	private CardSymbol symbol;
	public DrawTwoCard(CardColor color) {
		super(color);
		setSymbol(CardSymbol.DRAW);
	}

	public void play() {
		GameLogic.getInstance().setTopCard(this);
		GameLogic.getInstance().draw(2);
	}
	
	public boolean ruleCheck() {
		BaseCard topCard = GameLogic.getInstance().getTopCard();
		if(topCard.getColor().equals(this.getColor())) {
			return true;
		}
		return false;
	}
}
