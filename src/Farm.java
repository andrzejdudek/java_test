
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
			answer+=PlayerLanguage.NotEnoughRabbits;
			answer+=PlayerLanguage.OnFarm;
		}
		if(NoSheep==true) {
			NoSheep=false;
			answer+=PlayerLanguage.NotEnoughSheep;
			answer+=PlayerLanguage.OnFarm;
		}
		if(NoPigs==true) {
			NoPigs=false;
			answer+=PlayerLanguage.NotEnoughPigs;
			answer+=PlayerLanguage.OnFarm;
		}
		if(NoCows==true) {
			NoCows=false;
			answer+=PlayerLanguage.NotEnoughCows;
			answer+=PlayerLanguage.OnFarm;
		}
		if(NoHorses==true) {
			NoHorses=false;
			answer+=PlayerLanguage.NotEnoughHorses;
			answer+=PlayerLanguage.OnFarm;
		}
		if (NoSmallDogs == true) {
			NoSmallDogs = false;
			answer += PlayerLanguage.NotEnoughSmallDogs;
			answer+=PlayerLanguage.OnFarm;
		}
		if (NoBigDogs == true) {
			NoBigDogs = false;
			answer += PlayerLanguage.NotEnoughBigDogs;
			answer+=PlayerLanguage.OnFarm;
		}
		
			
			
			return answer;
		
	}
	
}
