package HW.Week2.Q2.logic;
import java.util.*;

public class Server {
	private String name;
	private User owner;
	private ArrayList<Channel> channelList;
	private ArrayList<User> memberList;
	
	public Server(String name,  User owner, TemplateType template) {
		this.owner = owner;
		this.channelList = new ArrayList<Channel>();
		this.memberList = new ArrayList<User>();
		addUser(owner);
		setName(name);	
		if(template == TemplateType.BASIC) {
			addChannel(owner, "general");
		}
		else if(template == TemplateType.GAMING) {
			addChannel(owner, "gaming");
		}
		else {
			addChannel(owner, "homework-help");
		}
	}
	 
	public boolean isMemberInServer(User userToCheck) {
		return memberList.contains(userToCheck);
	}
	
	public Channel addChannel(User user, String channelName) {
		if(user != owner) {return null;}
		Channel c = new Channel(channelName);
		channelList.add(c);
		return c;
	}
	
	public User addUser(User user) {
		if(!memberList.contains(user)) {
			memberList.add(user);
			user.addJoinedServersList(this);
			return user;
		}
		else {
			return null;
		}
	}
	
	public boolean kickUser(User kicker, User kicked) throws Exception{
		if(!kicker.equals(owner)) {
			throw new Exception("The users has no permission to kick other users");
		}
		else if(!memberList.contains(kicked) || kicked.equals(owner)){
			return false;
		}
		else {
			memberList.remove(kicked);
			kicked.getJoinedServersList().remove(this);
			return true;
		}
	}
	
	public void setName(String name) {
		if(name.isBlank()) {
			this.name = owner.getName() + " home";
		}
		else {
			this.name = name;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public ArrayList<Channel> getChannelList(){
		return channelList;
	}
	
	public ArrayList<User> getMemberList(){
		return memberList;
	}
}
