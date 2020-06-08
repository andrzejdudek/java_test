
public class Farm extends Player{
	
	boolean NoSmallDogs = false;
	boolean NoBigDogs = false;
	
	public Farm() {
		rabbits=60;
		sheep=24;
		pigs=20;
		cows=12;
		horses=6;
		smalldog=4;
		bigdog=2;
	}
	boolean checkrabbits(String wanted) {
		//Checking if is enough animals in farm for player to change to
			boolean answer=false;
			if (wanted.equals("sheep")==true) {
				
				
				if(sheep>=1) {
					answer=true;
						
				} else {
					NoSheep=true;
					answer=false;
				}
			}
			return answer;
	}
	
	boolean checksheep(String wanted) {
		boolean answer=false;
		switch(wanted) {
		
		case "rabbits":
			
			if(rabbits>=6) {
				answer=true;
			} else {
				NoRabbits=true;
				answer=false;
			}
			
			break;
		
		case "pigs":
			if(pigs>=1) {
				answer=true;
				} else {
				NoPigs=true;
				answer=false;
			}
			
			break;
		
		case "smalldog":
			if(smalldog>=1) {
				answer=true;
				} else {
				NoSmallDogs=true;
				answer=false;

			}
			
			break;
			
		}
		return answer;
	}
	
	boolean checkpigs(String wanted) {
		boolean answer=false;
		switch (wanted) {
			
		case "sheep":
				
			if(sheep>=2) {
				answer=true;
			} else {
				NoSheep=true;
				answer=false;
			}
				
			break;
				
		case "cows":
				
			if(cows>=1) {
				answer=true;
			} else {
				NoCows=true;
				answer=false;
			}
			break;
				
		}
		return answer;
	}
	
	boolean checkcows(String wanted) {
		
		boolean answer = false;
		switch(wanted) {
		
		case "pigs":
			
			if(pigs>=3) {
				answer = true;
			} else {
				NoPigs=true;
				answer = false;
			}
			
			break;
		
		case "horses":
			if(horses>=1) {
				answer = true;
			} else {
				NoHorses=true;
				answer = false;
			}
			
			break;
		
		case "bigdog":
			if(bigdog>=1) {
				answer = true;
			} else {
				NoBigDogs=true;
				answer = false;
			}
			
			break; 
			
		}
		return answer;
	}
	
	boolean checkhorses(String wanted) {
		boolean answer=false;
		if (wanted.equals("cows")==true) {
			
			if(cows>=2){
				answer=true;
			} else {
				NoCows=true;
				answer = false;
			}
			
			
		}
		return answer;
	}
	
	
	String ErrorMessage() {
		String answer = new String();
		
			if(NoRabbits==true) {
				NoRabbits=false;
				answer+="Not enough rabbits on farm. ";
			}
			if(NoSheep==true) {
				NoSheep=false;
				answer+="Not enough sheep on farm. ";
			}
			if(NoPigs==true) {
				NoPigs=false;
				answer+="Not enough pigs on farm. ";
			}
			if(NoCows==true) {
				NoCows=false;
				answer+="Not enough cows on farm. ";
			}
			if(NoHorses==true) {
				NoHorses=false;
				answer+="Not enough horses on farm. ";
			}
			if(NoSmallDogs==true) {
				NoSmallDogs=false;
				answer+="Not enough small dogs on farm";
			}
			if(NoBigDogs==true) {
				NoBigDogs=false;
				answer+="Not enough big dogs on farm";
			}
		
			
			
			return answer;
		
	}
	
}
