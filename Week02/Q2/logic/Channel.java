package HW.Week2.Q2.logic;
import java.util.*;

public class Channel {
	private String name;
	private ArrayList<Message> messageList;
	
	public Channel(String name) {
		setName(name);
		this.messageList = new ArrayList<Message>();
	}
	
	public void addMessage(Message message) {
		this.messageList.add(message);
	}
	
	public void setName(String name) {
		if(name.isBlank()) {
			this.name = "off-topic";
		}
		else {
			this.name = name;
		}
	}
	
	public int getMessageCount() {
		return messageList.size();
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Message> getMessageList(){
		return messageList;
	}
}
