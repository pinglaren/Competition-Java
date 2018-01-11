

import java.util.Scanner;

public class Competition2 {

	private Scanner keyboard = new Scanner (System.in);
	
	String eventEntered =  "";
	Result2 r1 = new Result2();
	Event2 t1 = new Event2();
	Participant2 p1 = new Participant2();
	static int number = 100;
	
	private String readString() {
		String str = keyboard.nextLine();
		return str;
	}
	
	
	
	private void addEvent() {
		String trimmedName = "";
		
		while(trimmedName.isEmpty()) {
			System.out.print("Event name: ");
			String eventName = readString().toLowerCase();
			trimmedName = eventName.trim();
			
			if(trimmedName.isEmpty()) {
			System.out.println("Error: name can't be empty!");
			
			}
			
		}
		
		String normalizedEventName = trimmedName.substring(0,1).toUpperCase() + trimmedName.substring(1);
		
		boolean found = t1.checkEvent(normalizedEventName);
			
		if(found) {
			System.out.println("Error: " + normalizedEventName + " has already been added");
			run();
			
			
			
		}if(!found) {
			System.out.print("Attempts allowed: ");
			int attempts = keyboard.nextInt();
			keyboard.nextLine();
			
			while(attempts < 1) {
				System.out.println("Error: too low, must allow at least one attempt: ");
				System.out.print("Attempts allowed: ");
				attempts = keyboard.nextInt();
				keyboard.nextLine();
			}
			
			t1.addEvent(normalizedEventName, attempts);
				
			System.out.println(normalizedEventName + " added");
		}
		
		
		
		
		
	}
		
	private void addParticipant() {
		
		String trimmedFirstName = "";
		String trimmedLastName = "";
		String trimmedTeamName = "";
		
		while(trimmedFirstName.isEmpty()) {
			System.out.print("First name: ");
			String entryFirstName = readString().toLowerCase();
			trimmedFirstName = entryFirstName.trim();
			
			if(trimmedFirstName.isEmpty()) {
				System.out.println("Error: name can't be empty!");
			}
		}
		
		String normalizedFirstName = trimmedFirstName.substring(0,1).toUpperCase() + trimmedFirstName.substring(1);

		while(trimmedLastName.isEmpty()) {
			System.out.print("Last name: ");
			String entryLastName = readString().toLowerCase();
			trimmedLastName = entryLastName.trim();
		
			if(trimmedLastName.isEmpty()) {
				System.out.println("Error: name can't be empty!");
			}
		}
		
		String normalizedLastName = trimmedLastName.substring(0,1).toUpperCase() + trimmedLastName.substring(1);
		
		while(trimmedTeamName.isEmpty()) {
			System.out.print("team: ");
			String entryTeamName = readString().toLowerCase();
			trimmedTeamName = entryTeamName.trim();
		
			if(trimmedTeamName.isEmpty()) {
				System.out.println("Error: name can't be empty!");
			}
		}
		
		String normalizedTeamName = trimmedTeamName.substring(0,1).toUpperCase() + trimmedTeamName.substring(1);
		
		p1.addPartList(normalizedFirstName, normalizedLastName, normalizedTeamName, number);
		
		System.out.println(normalizedFirstName + " " + normalizedLastName + " from " + normalizedTeamName + " with number " + number + " has been added");
		number++;
	}
	
	private void removeParticipant() {
		
		System.out.print("Number: ");
		int numberTest = keyboard.nextInt();
		keyboard.nextLine();
		
	    boolean found =	p1.checkPartNo(numberTest);
	
	    if(found) {
	    	p1.removePartList(numberTest);
	    }
	    if(!found) {
	    	System.out.println("Error: no participant with " + numberTest + " exists");
	    }
	}
	
	private void addResult() {
		
		int found = 0;
		
		
		System.out.print("Number: ");
		int partNumber = keyboard.nextInt();
		keyboard.nextLine();
		
		
		if(p1.checkPartNo(partNumber))
			found++;
		
		switch (found) {
			
			case 0: 
			System.out.println("Error no participant with number " + partNumber + " found!");
			run();
			break;
			
			
		
			case 1: 
			System.out.print("Event: ");
			String eventSearch = readString();
			
			
			if(!t1.checkEvent(eventSearch)) {
				System.out.println("Error: no event called \"" + eventSearch + "\" found!" );
				break;
			}else {
				found++;
				
				
			}
			
			while(found == 2) {
				Event2 echeck = t1.retrieveE(eventSearch);
				Participant2 pcheck = p1.retrievePart(partNumber);
				int count = r1.attemptsPerEvent(partNumber, eventSearch) ;
				
				if(count >= echeck.getAttemptsAllowed()) {
					System.out.println("Error: " + pcheck.getFirstName() + " " + pcheck.getLastName() + " from " + pcheck.getTeam() + " has already made " + echeck.getAttemptsAllowed()+ " attempts in " + echeck.getEventName() + ".");
					found++;
					break;
					
				}
					
				System.out.print("Results for" + pcheck.getFirstName() + " " + pcheck.getLastName() + " from " + pcheck.getTeam()+ " in " + echeck.getEventName() + ":");
				Double result = keyboard.nextDouble();
				keyboard.nextLine();
			
				if(result > 0) {
					
					found++;
					System.out.println("Result has been added");
					r1.createResult(p1, t1, partNumber, eventSearch, result);
				}
					
			}
			
			
		}
	}
		
	private void handleCommando() {
	      System.out.print("Command> ");
	      String commando = keyboard.nextLine();
	      switch (commando) {

	      case "add event":
	    	  addEvent();
	    	  break;
	    	  
	      case "add participant":
	    	  addParticipant();
	    	  break;
	    	  
	      case "remove participant":
	      	  removeParticipant();
	          break;
	      
	      case "add result":
	          addResult();
	    	  break;
	    	  
	    
	      default:
	    	  break;

	      }
	  }
	  private void run() {
	      do {
	          handleCommando();
	      } while (true);
	  }

	  public static void main(String [] args) {
	      new Competition2().run();
	  }
}