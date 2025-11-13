package HW.Week2.Q3.logic.card;
import HW.Week2.Q3.logic.game.*;

public class NumberCard extends BaseCard{
	private CardSymbol symbol;
	public NumberCard(CardColor color, CardSymbol symbol) {
		super(color);
		setSymbol(symbol);
	}
	
	public void play() {
		GameLogic.getInstance().setTopCard(this);
	}
	
	public boolean ruleCheck() {
		BaseCard topCard = GameLogic.getInstance().getTopCard();
		if(topCard.getColor().equals(this.getColor()) || topCard.getSymbol().equals(this.getSymbol())) {
			return true;
		}
		return false;
	}
}
