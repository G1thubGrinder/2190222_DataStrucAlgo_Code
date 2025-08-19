package HW.Week2.Q3.logic.utility;
import HW.Week2.Q3.logic.game.*;
import java.util.ArrayList;

import HW.Week2.Q3.logic.card.BaseCard;

public class GameLogicUtility {
	public static boolean drawRule() {
		ArrayList<BaseCard> hand = GameLogic.getInstance().getHand();
		for(BaseCard bc : hand) {
			if(bc.ruleCheck()) {
				return false;
			}
		}
		return true;
	}
}
