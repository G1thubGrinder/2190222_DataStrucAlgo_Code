package HW.Week2.Q1.logic;
import java.util.*;

public class Region {
	private String name;
	private ArrayList<Player> playerList;
	private ArrayList<Quest> questList;
	
	public Region(String name) {
		setName(name);
		playerList = new ArrayList<Player>();
		questList = new ArrayList<Quest>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(name.isBlank()) {
			this.name = "Nowhere";
		}
		else {
			this.name = name;
		}
	}
	
	public ArrayList<Player> getPlayerList(){
		return playerList;
	}
	
	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}
	
	public ArrayList<Quest> getQuestList(){
		return questList;
	}
	
	public void setQuestList(ArrayList<Quest> questList) {
		this.questList = questList;
	}
	
	public int getPlayerCount() {
		return playerList.size();
	}
	
	public double getRegionRank() {
		double total = 0;
		double count = 0;
		for(Player p : playerList) {
			total += p.getRank();
			count++;
		}
		return (double) Math.round(total*100/count)/100;
	}
	
	public ArrayList<Quest> getAvailableQuests(Player viewer){
		ArrayList<Quest> availableQuest = new ArrayList<Quest>();
		for(Quest q : questList) {
			if(q.getAuthor() != viewer && q.getStatus() == Status.AVAILABLE) {
				availableQuest.add(q);
			}
		}
		return availableQuest;
	}
	
	public void addPlayerToRegion(Player p) {
		playerList.add(p);
	}
	
	public void addQuestToRegion(Quest q) {
		questList.add(q);
	}
	
	
}
