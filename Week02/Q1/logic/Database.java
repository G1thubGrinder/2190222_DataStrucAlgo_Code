package HW.Week2.Q1.logic;
import java.util.*;

public class Database {
	private ArrayList<Player> playerList;
	private ArrayList<Region> regionList;
	
	public Database() {
		this.playerList = new ArrayList<Player>();
		this.regionList = new ArrayList<Region>();
	}
	
	public Database(ArrayList<Player> playerList, ArrayList<Region> regionList) {
		setPlayerList(playerList);
		setRegionList(regionList);
	}
	
	public Player addPlayer(String name, Region region) throws Exception{
		for(Player p : playerList) {
			if(name.equals(p.getName())){
				throw new Exception("This player is already exists");
			}
		}
		Player newPlayer = new Player(name);
		playerList.add(newPlayer);
		region.addPlayerToRegion(newPlayer);
		return newPlayer;
	}
	
	public boolean addRegion(String name) {
		for(Region r : regionList) {
			if(name.equals(r.getName())) {
				return false;
			}
		}
		Region newRegion = new Region(name);
		regionList.add(newRegion);
		return true;
	}
	
	public Region getRegionByName(String name) {
		for(Region r : regionList) {
			if(name.equals(r.getName())) {
				return r;
			}
		}
		return null;
	}
	
	public void addQuest(Player author, Region region, String name, String description) {
		Quest q = new Quest(author, region, name, description);
		region.addQuestToRegion(q);
	}
	
	public ArrayList<Player> getPlayerList(){
		return playerList;
	}
	
	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}
	
	public ArrayList<Region> getRegionList(){
		return regionList;
	}
	
	public void setRegionList(ArrayList<Region> regionList) {
		this.regionList = regionList;
	}
}

