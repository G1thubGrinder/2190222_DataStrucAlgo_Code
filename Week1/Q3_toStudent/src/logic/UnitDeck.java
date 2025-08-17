package HW.Week1.Q3_toStudent.src.logic;
import java.util.*;

public class UnitDeck {
	private ArrayList<CardCounter> cardsInDeck;
	private String deckName;
	
	public UnitDeck(String deckName) {
		cardsInDeck = new ArrayList<CardCounter>();
		setDeckName(deckName);
	}
	
	public void addCard(UnitCard newCard, int count) {
		if(count > 0) {
			for(CardCounter cc : cardsInDeck) {
				if(cc.getCard() == newCard) {
					cc.setCount(cc.getCount() + count);
					return;
				}
			}
			cardsInDeck.add(new CardCounter(newCard, count));
		}
	}
	
	public void removeCard(UnitCard toRemove, int count) {
		if(count > 0) {
			for(CardCounter cc : cardsInDeck) {
				if(cc.getCard() == toRemove) {
					if (cc.getCount() <= count) {
						cardsInDeck.remove(cc);
					}
					cc.setCount(cc.getCount() - count);
					return;
				}
			}
		}
	}
	
	public int cardCount() {
		int sum = 0;
		for(CardCounter cc : cardsInDeck) {
			sum += cc.getCount();
		}
		return sum;
	}
	
	public boolean existsInDeck(UnitCard card) {
		for(CardCounter cc : cardsInDeck) {
			if(cc.getCard() == card)return true;
		}
		return false;
	}
	
	public boolean equals(UnitDeck other) {
		return this.getDeckName().equalsIgnoreCase(other.getDeckName());
	}
	
	public void setDeckName(String deckName) {
		if(deckName.isBlank()) {this.deckName = "Untitled Deck";}
		else {this.deckName = deckName;}
	}
	
	public String getDeckName() {
		return deckName;
	}
	
	public ArrayList<CardCounter> getCardsInDeck() {
		return cardsInDeck;
	}
	
	public void setCardsInDeck(ArrayList<CardCounter> cardsInDeck) {
		this.cardsInDeck = cardsInDeck;
	}
}

