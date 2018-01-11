import java.util.ArrayList;

public class Participant2 {
	
	private String firstName;
	private String lastName;
	private String team;
	private int number;
	
	private ArrayList<Participant2> contestants = new ArrayList<> ();

	
	public Participant2(String firstName, String lastName, String team, int number) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.team = team;
		this.number = number;
	}
	public Participant2() {
		this.firstName = "temp";
		this.lastName = "temp";
		this.team = "temp";
		this.number = -1;
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getTeam() {
		return team;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void addPartList(String fn, String ln, String team, int num) {
		Participant2  p2 = new Participant2(fn, ln, team, num);
		contestants.add(p2);
		return;
		
	}
	public boolean checkPartNo(int testNo) {
		boolean foundNo = false;
		
		for(Participant2 p: contestants) {
			if(p.getNumber() == testNo) {
				foundNo = true;
				return foundNo;
				
			}
		
		}
		return foundNo;
	
	}
	
	public void removePartList(int No) {
		for(Participant2 p: contestants) {
			if(p.getNumber() == No) {
				System.out.println(p.toString());
				contestants.remove(p);
				break;
			}
		}
	}
	
	public Participant2 retrievePart(int testNo) {
		for(Participant2 p: contestants) {
			if(p.getNumber() == testNo) {
				Participant2 p1 = new Participant2 (p.getFirstName(), p.getLastName(), p.getTeam(), p.getNumber());
				return p1;
			}
		}
		Participant2 p1 = new Participant2();
		return p1;
	}
	
		

	
	@Override
	public String toString () {
		return this.getFirstName() + " " + this.getLastName() + " from " + this.getTeam() + " with number " + this.getNumber() + " removed";
	}
		
}



