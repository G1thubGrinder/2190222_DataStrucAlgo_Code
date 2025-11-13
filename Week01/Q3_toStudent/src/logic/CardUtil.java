package HW.Week1.Q3_toStudent.src.logic;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class CardUtil {
	
	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {
		return list.contains(card);
	}
	
	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {
		return list.contains(deck);
	}
	
	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {
		for(UnitDeck ud: deckList) {
			if(ud.existsInDeck(cardToTest)) return true;
		}
		return false;
	}
	
	public static ArrayList<UnitCard> getCardsFromFile(String filename){
		File fileToRead = new File("C:/Users/Asus/Desktop/Eclipse_work/DataAlgo/src/HW/Week1/Q3_toStudent/"+filename);
		Scanner scanner = null;
		try {
			scanner = new Scanner(fileToRead);
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
			return null;
		}
		ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();
		while(scanner.hasNextLine()) {
			String res = scanner.nextLine();
			try {
				String[] spli = res.split(",");
				UnitCard newCard = new UnitCard(spli[0], Integer.parseInt(spli[1]), Integer.parseInt(spli[2]), Integer.parseInt(spli[3]), spli[4]); 
				cardsFromFile.add(newCard);
			}
			catch(Exception e) {
				System.out.println(e);
				return null;
			}	
		}
		scanner.close();
		return cardsFromFile;
	}

	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {
		
		for(int i = 0; i < cardList.size(); i++) {
			System.out.println(i + ") " + cardList.get(i));
			if(verbose) {
				System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
				System.out.println(cardList.get(i).getFlavorText());
				if(i < cardList.size()-1) System.out.println("-----");
			}
		}
	}
	
	public static void printDeck(UnitDeck ud) {
		
		if(ud.getCardsInDeck().size() == 0) {
			System.out.println("EMPTY DECK");
		}else {
			for(CardCounter cc : ud.getCardsInDeck()) {
				System.out.println(cc);
			}
		}
		
		System.out.println("Total Cards: " + ud.cardCount());
	}
	
	public static void printDeckList(ArrayList<UnitDeck> deckList) {
		
		
		for(int i = 0; i < deckList.size(); i++) {
			System.out.println(i + ") " + deckList.get(i).getDeckName());
			printDeck(deckList.get(i));
			if(i < deckList.size()-1) System.out.println("-----");
		}
	}
}
