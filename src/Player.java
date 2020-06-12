//Player class. Include data about his animals, and trading 
public class Player {
	String name;
	int rabbits=0;
	int sheep=0;
	int pigs=0;
	int cows=0;
	int horses=0;
	int smalldog=0;
	int bigdog=0;
	
	boolean NoRabbits = false;
	boolean NoSheep = false;
	boolean NoPigs = false;
	boolean NoCows = false;
	boolean NoHorses = false;
	boolean WrongName= false;
	
	Language PlayerLanguage = new Language("English");;
	
	public Player() {
		PlayerLanguage = new Language("English");
	}
	public Player(String s) {
		name=s;
		PlayerLanguage = new Language("English");
	}
	
boolean checkrabbits(String wanted) {
	//Checking if is enough animals in farm for player to change to
		boolean answer=false;
		if (wanted.equals("sheep")==true) {
			
			if(rabbits>=6){
				answer=true;
				
			} else {
				NoRabbits=true;
				answer=false;

			}
		}
		return answer;
	}
	
void traderabbits() {
	//Adding and removing animals
		rabbits-=6;
		sheep++;
	}
	
boolean checksheep(String wanted) {
		boolean answer=false;
		switch(wanted) {
		
		case "rabbits":
			
			if(sheep>=1) {
				answer=true;
			} else {
				NoSheep=true;
				answer=false;
			}
			
			break;
		
		case "pigs":
			if(sheep>=2) {
				answer=true;
				} else {
				NoSheep=true;
				answer=false;
			}
			
			break;
		
		case "smalldog":
			if(sheep>=1) {
				answer=true;
				} else {
				NoSheep=true;
				answer=false;

			}
			
			break;
			
		}
		return answer;
	}
	
void tradesheep(String wanted) {
	switch(wanted) {
	
	case "rabbits":
		sheep--;
		rabbits+=6;
		
		break;
	
	case "pigs":
		sheep-=2;
		pigs++;
	
		break;
	
	case "smalldog":
		smalldog++;
		sheep--;
		
		break;
	}
}

boolean checkpigs(String wanted) {
	boolean answer=false;
	switch (wanted) {
		
	case "sheep":
			
		if(pigs>=1) {
			answer=true;
		} else {
			NoPigs=true;
			answer=false;
		}
			
		break;
			
	case "cows":
			
		if(pigs>=3) {
			answer=true;
		} else {
			NoPigs=true;
			answer=false;
		}
		break;
			
	}
	return answer;
}

void tradepigs(String wanted) {
	
	switch (wanted) {
	
	case "sheep":
		
		pigs--;
		sheep+=2;
		
		break;
		
	case "cows":
		
		pigs-=3;
		cows++;
	
		break;
	}
}

boolean checkcows(String wanted) {
	
	boolean answer = false;
	switch(wanted) {
	
	case "pigs":
		
		if(cows>=1) {
			answer = true;
		} else {
			NoCows=true;
			answer = false;
		}
		
		break;
	
	case "horses":
		if(cows>=2) {
			answer = true;
		} else {
			NoCows=true;
			answer = false;
		}
		
		break;
	
	case "bigdog":
		if(cows>=1) {
			answer = true;
		} else {
			NoCows=true;
			answer = false;
		}
		
		break; 
		
	}
	return answer;
}

void tradecows(String wanted) {
	switch(wanted) {
	
	case "pigs":
		cows--;
		pigs+=3;
		
		break;
	
	case "horses":
		cows-=2;
		horses++;
		
		break;
	
	case "bigdog":
		bigdog++;
		cows--;
		
		break; 
	}
}

boolean checkhorses(String wanted) {
	boolean answer=false;
	if (wanted.equals("cows")==true) {
		
		if(horses>=1){
			answer=true;
		} else {
			NoHorses=true;
			answer = false;
		}
		
		
	}
	return answer;
}

void tradehorses() {
		
	horses--;
	cows+=2;
}


boolean checkUnits(String given, String wanted) {
	//Checking if trade is possible
	boolean answer = false;
		
		switch (given) {
		
		case "rabbits":
			if(checkrabbits(wanted)==true) {
				answer =true;
			}
			
			break;
			
			
		case "sheep":
			if(checksheep(wanted)==true) {
				answer =true;
			}			
			
			break;
			
			
		case "pigs":
			if(checkpigs(wanted)==true) {
				answer =true;
			}
						
			break;
			
			
		case "cows":
			if(checkcows(wanted)==true) {
				answer =true;
			}
			
			break;
			
		case "horses":
			if(checkhorses(wanted)==true) {
				answer =true;
			}
			
			break;
			
		}
		return answer;
	}

void tradeUnits(String given, String wanted) {
	//Trading animals
	switch (given) {
	
	case "rabbits":
		traderabbits();
		
		break;
		
		
	case "sheep":
		tradesheep(wanted);			
		
		break;
		
		
	case "pigs":
		tradepigs(wanted);
					
		break;
		
		
	case "cows":
		tradecows(wanted);
		
		break;
		
	case "horses":
		tradehorses();
		
		break;
		
	}
}


String ErrorMessage() {
	String answer = new String();
	
		if(NoRabbits==true) {
			NoRabbits=false;
			answer+=PlayerLanguage.NotEnoughRabbits;
		}
		if(NoSheep==true) {
			NoSheep=false;
			answer+=PlayerLanguage.NotEnoughSheep;
		}
		if(NoPigs==true) {
			NoPigs=false;
			answer+=PlayerLanguage.NotEnoughPigs;
		}
		if(NoCows==true) {
			NoCows=false;
			answer+=PlayerLanguage.NotEnoughCows;
		}
		if(NoHorses==true) {
			NoHorses=false;
			answer+=PlayerLanguage.NotEnoughHorses;
		}
		
	
		
		
		return answer;
	
}


}
