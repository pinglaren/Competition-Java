import java.util.ArrayList;


public class Result2 {

	private Double attemptResult;
	private Participant2 attemptParticipant;
	private Event2 attemptEvent;
	
	private ArrayList<Result2> results = new ArrayList<>();
	
	Participant2 p1 = new Participant2();
	

	
	public Result2(Double attemptResult, Participant2 attemptParticipant, Event2 attemptEvent) {
		this.attemptResult = attemptResult;
		this.attemptParticipant = attemptParticipant;
		this.attemptEvent = attemptEvent;

	}
	
	public Result2() {
		this.attemptResult = 0.0;
		this.attemptParticipant = new Participant2();
		this.attemptEvent = new Event2();
		
		
	}
	
	public Double getAttemptResult() {
		return attemptResult;
	}
	
	public Participant2 getAttemptParticipant() {
		return attemptParticipant;
	}
	
	public Event2 getAttemptEvent() {
		return attemptEvent;
	}
	
	public int attemptsPerEvent(int part, String event) {
		int count = 0;
		
		for(Result2 r: results) {
			
			if(r.attemptParticipant.getNumber() == part && r.attemptEvent.getEventName().equals(event)) {
				count++;
				
				
			}
		}
		System.out.println(count);
		return count;
	}
		
//	public boolean checkResultAmount() {
//		
//	}
	
	public void createResult(Participant2 p1, Event2 e1, int number, String event, Double result) {
		Participant2 pnew = p1.retrievePart(number);
		Event2 enew = e1.retrieveE(event);
		Result2 rnew = new Result2(result, pnew, enew);
		results.add(rnew);
		
	}
	
	
//	r.attemptEvent.getEventName().equals(event) && 
		
	
	

}