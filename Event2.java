import java.util.ArrayList;

public class Event2 {
	
	private String eventName;
	private int attemptsAllowed;
	
	private ArrayList<Event2> events = new ArrayList<> ();
	
	public Event2(String eventName, int attemptsAllowed) {
		this.eventName = eventName;
		this.attemptsAllowed = attemptsAllowed;
		
	}
	public Event2() {
		this.eventName = "temp";
		this.attemptsAllowed = -1;
				
	}
	
	public String getEventName() {
		return eventName;
	}
	public int getAttemptsAllowed() {
		return attemptsAllowed;
	}
	
	public boolean checkEvent(String check) {
		
		boolean hit = false;
		
		for(Event2 e: events) {
			if(check.equals(e.getEventName())){
				hit = true;
				return hit;
				
				

			}
			
		
		}
		return hit;
	}
	
	public void addEvent(String temp, int att) {
		
		events.add(new Event2(temp, att));
		
	}
	
	public Event2 retrieveEvent(String testName) {
		
		
		
		Event2 p2 = new Event2();
		return p2;
	}
	public Event2 retrieveE(String check) {
		Event2 e1 = new Event2();
		for(Event2 e: events) {
			if(check.equals(e.getEventName()))
				e1 = e;
		
		}
		return e1;
	}
	
}

