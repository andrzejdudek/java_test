//Player class. Include data about his animals, and trading 
import java.util.Scanner;

public class Player {
	String name;
	int rabbits=0;
	int sheep=0;
	int pigs=0;
	int cows=0;
	int horses=0;
	int smalldog=0;
	int bigdog=0;
	Scanner scanner = new Scanner(System.in);
	
	public Player() {
		System.out.println("Write your name");
		name=scanner.next();
	}
	public Player(String s) {
		name=s;
	}
	
void traderabbits(String wanted) {
	//Check which animal player want to change to.
		if (wanted.equals("sheep")) {
			
			//Checking if he has enough aniamls
			if(rabbits>=6){
				rabbits-=6;
				sheep++;
				
			} else {
				System.out.println("Not enough rabbits");
			}
			
		} else {
			System.out.println("Wrong name");
		}
	}
	
void tradesheep(String wanted) {
		switch(wanted) {
		
		case "rabbits":
			
			if(sheep>=1) {
				sheep--;
				rabbits+=6;
			} else {
				System.out.println("Not enough sheep");
			}
			
			break;
		
		case "pigs":
			if(sheep>=2) {
				sheep-=2;
				pigs++;
			} else {
				System.out.println("Not enough sheep");
			}
			
			break;
		
		case "small dog":
			if(sheep>=1) {
				smalldog++;
				sheep--;
			} else {
				System.out.println("Not enough sheep");
			}
			
			break;
			
		default:
			System.out.println("Wrong name");	
		}
	}
	
void tradepigs(String wanted) {
		
		switch (wanted) {
		
		case "sheep":
			
			if(pigs>=1) {
				pigs--;
				sheep+=2;
			} else {
				System.out.println("Not enough pigs");
			}
			
			break;
			
		case "cows":
			
			if(pigs>=3) {
				pigs-=3;
				cows++;
			} else {
				System.out.println("Not enough pigs");
			}
			break;
			
		default:
			System.out.println("Wrong name");	
		}
	}

void tradecows(String wanted) {
	switch(wanted) {
	
	case "pigs":
		
		if(cows>=1) {
			cows--;
			pigs+=3;
		} else {
			System.out.println("Not enough cows");
		}
		
		break;
	
	case "horses":
		if(cows>=2) {
			cows-=2;
			horses++;
		} else {
			System.out.println("Not enough cows");
		}
		
		break;
	
	case "big dog":
		if(sheep>=1) {
//			if(bigdog==0) {
				bigdog++;
				cows--;
//			} else {
//				System.out.println("You already have big dog");
//			}
		} else {
			System.out.println("Not enough sheep");
		}
		
		break; 
		
	default:
		System.out.println("Wrong name");	
	}
}

void tradehorses(String wanted) {
	if (wanted.equals("cows")) {
		
		if(horses>=1){
			horses--;
			cows+=2;
			
		} else {
			System.out.println("Not enough horses");
		}
		
	} else {
		System.out.println("Wrong name");
	}
}


void tradeUnits(String given, String wanted) {
		//Checking which animals player wants to change
		switch (given) {
		
		case "rabbits":
			traderabbits(wanted);
			
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
			tradehorses(wanted);
			
			break;
			
			default:
				System.out.println("Wrong name");
		}
	}





}
