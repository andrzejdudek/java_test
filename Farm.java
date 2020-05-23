
public class Farm {
	int rabbits;
	int sheep;
	int pigs;
	int cows;
	int horses;
	int smalldog;
	int bigdog;
	
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
			
			if(rabbits>=6){
				answer=true;
				
			} else {
				System.out.println("Not enough rabbits");
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
				System.out.println("Not enough sheep");
				answer=false;
			}
			
			break;
		
		case "pigs":
			if(sheep>=2) {
				answer=true;
				} else {
				System.out.println("Not enough sheep");
				answer=false;
			}
			
			break;
		
		case "small dog":
			if(sheep>=1) {
				answer=true;
				} else {
				System.out.println("Not enough sheep");
				answer=false;

			}
			
			break;
			
		default:
			System.out.println("Wrong name");
			answer=false;
			
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
	
	case "small dog":
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
			System.out.println("Not enough pigs");
			answer=false;
		}
			
		break;
			
	case "cows":
			
		if(pigs>=3) {
			answer=true;
		} else {
			System.out.println("Not enough pigs");
			answer=false;
		}
		break;
			
	default:
		System.out.println("Wrong name");	
		answer=false;
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
			System.out.println("Not enough cows");
			answer = false;
		}
		
		break;
	
	case "horses":
		if(cows>=2) {
			answer = true;
		} else {
			System.out.println("Not enough cows");
			answer = false;
		}
		
		break;
	
	case "big dog":
		if(sheep>=1) {
			answer = true;
		} else {
			System.out.println("Not enough sheep");
			answer = false;
		}
		
		break; 
		
	default:
		System.out.println("Wrong name");	
		answer = false;
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
	
	case "big dog":
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
			System.out.println("Not enough horses");
			answer = false;
		}
		
	} else {
		System.out.println("Wrong name");
		answer = false;
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
			
		case "horse":
			if(checkhorses(wanted)==true) {
				answer =true;
			}
			
			break;
			
			default:
				System.out.println("Wrong name");
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
		
	case "horse":
		tradehorses();
		
		break;
		
	}
}
	
}
