import java.util.Scanner;

public class GameLogic {
	
	int players;
	int index=0;
	
	GreenDice GD;
	RedDice RD;
	Participants gamers;
	String GreenThrow;
	String RedThrow;
	
	Farm ranch;
	
	Rand rand;
	
	
	Scanner scanner = new Scanner(System.in);
	
	public GameLogic(int a) {
		players =a;
		gamers = new Participants(a);
		GD = new GreenDice();
		RD = new RedDice();
		GreenThrow=new String();
		RedThrow= new String();
		
		ranch=new Farm();
		
		rand=new Rand();
	}
	
	void AddUnits(int index) {
		
		if(GreenThrow=="wolf") {
			
			if(gamers.players[index].bigdog>=1) {
				
				gamers.players[index].bigdog--;
				ranch.bigdog++;
				
				if(RedThrow=="fox" && gamers.players[index].smalldog>=1) {
					
					gamers.players[index].smalldog--;
					ranch.smalldog++;
					
				} else if(RedThrow=="fox" && gamers.players[index].smalldog==0) {
					ranch.rabbits+=gamers.players[index].rabbits;
					gamers.players[index].rabbits=0;
				}
			} else {
				ranch.rabbits+=gamers.players[index].rabbits;
				ranch.sheep+=gamers.players[index].sheep;
				ranch.pigs+=gamers.players[index].pigs;
				ranch.cows+=gamers.players[index].cows;
				ranch.smalldog+=gamers.players[index].smalldog;
				
				
				gamers.players[index].rabbits=0;
				gamers.players[index].sheep=0;
				gamers.players[index].pigs=0;
				gamers.players[index].cows=0;
				gamers.players[index].smalldog=0;
			}
			
		} else if(RedThrow=="fox" && GreenThrow!="wolf") {
			
			if(gamers.players[index].smalldog>=1) {
				
				gamers.players[index].smalldog--;
				ranch.smalldog++;
				
			} else {
				ranch.rabbits+=gamers.players[index].rabbits;
				gamers.players[index].rabbits=0;
			}
		} else {
			Player A= new Player("help");
			A.rabbits=gamers.players[index].rabbits;
			A.sheep=gamers.players[index].sheep;
			A.pigs=gamers.players[index].pigs;
			A.cows=gamers.players[index].cows;
			A.horses=gamers.players[index].horses;
			
			
			String HelpThrow=GreenThrow;
			for(int i=0;i<2;i++) {
				
				switch(HelpThrow) {
				case "rabbit":
					A.rabbits++;
					break;
					
				case "sheep":
					A.sheep++;
					break;
				
				case "pig":
					A.pigs++;
					break;
				
				case "cow":
					A.cows++;
					break;
				
				case "horse":
					A.horses++;
					break;				
				}
				
				HelpThrow=RedThrow;
			}
			if(A.rabbits!=gamers.players[index].rabbits) {
				
				if(ranch.rabbits>=A.rabbits/2) {
			
					gamers.players[index].rabbits+=A.rabbits/2;
					ranch.rabbits-=A.rabbits/2;
							
				} else if(ranch.rabbits<A.rabbits/2) {
					
					gamers.players[index].rabbits+=ranch.rabbits;
					ranch.rabbits=0;
					gamers.players[index].NoRabbits=true;
					
				} else {
					gamers.players[index].NoRabbits=true;
					
				}
			}
			
			if(A.sheep!=gamers.players[index].sheep) {
				
				if(ranch.sheep>=A.sheep/2) {

					gamers.players[index].sheep+=A.sheep/2;
					ranch.sheep-=A.sheep/2;
					
				} else if(ranch.sheep<A.sheep/2) {
					
					gamers.players[index].sheep+=ranch.sheep;
					ranch.sheep=0;
					gamers.players[index].NoSheep=true;
					
				} else {
					gamers.players[index].NoSheep=true;
					
				}
			}
			
			if(A.pigs!=gamers.players[index].pigs) {
				
				if(ranch.pigs>=A.pigs/2) {

					gamers.players[index].pigs+=A.pigs/2;
					ranch.pigs-=A.pigs/2;
					
				} else if(ranch.pigs<A.pigs/2) {
					
					gamers.players[index].pigs+=ranch.pigs;
					ranch.pigs=0;
					gamers.players[index].NoPigs=true;
					
				} else {
					gamers.players[index].NoPigs=true;
					
				}
			}
			
			if(A.cows!=gamers.players[index].cows) {
				
				if(ranch.cows>=A.cows/2) {

					gamers.players[index].cows+=A.cows/2;
					ranch.cows-=A.cows/2;
					
				} else if(ranch.cows<A.cows/2) {
					
					gamers.players[index].cows+=ranch.cows;
					ranch.cows=0;
					gamers.players[index].NoCows=true;

					
				} else {
					gamers.players[index].NoCows=true;
				}
			}
			
			if(A.horses!=gamers.players[index].horses) {
				
				if(ranch.horses>=A.horses/2) {

					gamers.players[index].horses+=A.horses/2;
					ranch.horses-=A.horses/2;
					
				} else if(ranch.horses<A.horses/2) {
					
					gamers.players[index].horses+=ranch.horses;
					ranch.horses=0;
					gamers.players[index].NoHorses=true;
					
				} else {
					
					gamers.players[index].NoHorses=true;
				}
			}
		}
		
		
		
		
		
		
		
		
			
	}
	
	
	boolean CheckIfWin(int index) {
		boolean win = false;
		
		if(gamers.players[index].horses>0) {
			if(gamers.players[index].cows>0) {
				if(gamers.players[index].pigs>0) {
					if(gamers.players[index].sheep>0) {
						if(gamers.players[index].rabbits>0) {
							win = true;
						}
					}
				}
			}
		}
		return win;
	}
	
	
	void moves() {

		
		boolean game=true;
		
		while(game==true) {
			
			if(index==players) {
				index=0;
			}
			
			System.out.println(gamers.players[index].name + "' turn");
		
			GreenThrow=GD.ThrowDice(rand.DiceThrow());
			RedThrow=RD.ThrowDice(rand.DiceThrow());
			
//			GreenThrow=GD.ThrowDice(6);
//			RedThrow=RD.ThrowDice(6);
//			
			
			System.out.println("Dice roll:"+ GreenThrow +", " + RedThrow );
			
			AddUnits(index);
			
			System.out.print("You have: " + gamers.players[index].rabbits + " rabbits,");
			System.out.print(gamers.players[index].sheep + " sheep,");
			System.out.print(gamers.players[index].pigs + " pigs,");
			System.out.print(gamers.players[index].cows + " cows,");
			System.out.print(gamers.players[index].horses + " horses");
			if(gamers.players[index].smalldog>0) {
				System.out.print(", ");
				System.out.print(gamers.players[index].smalldog + " small dog");
			}
			if(gamers.players[index].bigdog>0) {
				System.out.print(", ");
				System.out.print(gamers.players[index].bigdog + " big dog");
			}
			System.out.print(".");
			System.out.println("");
			
			if(GreenThrow=="wolf"||RedThrow=="fox") {
			} else {
			
				//Beginning trading
				System.out.println("Time for trading!");
				
				String given = null;
				String wanted = null;
				
				boolean trading =true;
				boolean names = true;
				while(trading= true) {
					
					
					
					System.out.println("6 rabbits = 1 sheep");
					System.out.println("2 sheep = 1 pig");
					System.out.println("3 pigs = 1 cow");
					System.out.println("2 cows = 1 horse");			
			
					System.out.println("1 sheep = 1 small dog");
					System.out.println("1 cow = 1 big dog");
					System.out.println("Type: \"end\" to finish exchanging as answer for any question");
					
					while(names==true) {
						System.out.println("What animals do you want to exchange?");
						given=scanner.nextLine();
						
						if(given.equals("end")==true) {
							trading = false;
							given = null;
							wanted = null;
							break;
						}
						
						System.out.println("What animals do you want to exchange for?");
						wanted=scanner.nextLine();
						
						if(wanted.equals("end")==true) {
							trading = false;
							given = null;
							wanted = null;
							break;
						}
						
						if(ranch.checkUnits(given, wanted)==true) {
							break;
						}
					}
					
					if(trading==false) {
						break;
					}
					
					ranch.tradeUnits(given, wanted);
					gamers.players[index].tradeUnits(given, wanted);
					
					if( CheckIfWin(index)==true) {
						System.out.println("Player " + gamers.players[index].name + " win!!!");
						game=false;
						break;
					}
					
					System.out.print("You have: " + gamers.players[index].rabbits + " rabbits,");
					System.out.print(gamers.players[index].sheep + " sheep,");
					System.out.print(gamers.players[index].pigs + " pigs,");
					System.out.print(gamers.players[index].cows + " cows,");
					System.out.print(gamers.players[index].horses + " horses");
					if(gamers.players[index].smalldog>0) {
						System.out.print(", ");
						System.out.print(gamers.players[index].smalldog + " small dog");
					}
					if(gamers.players[index].bigdog>0) {
						System.out.print(", ");
						System.out.print(gamers.players[index].bigdog + " big dog");
					}
					System.out.print(".");
					System.out.println("");
				}
				
			}
			System.out.println("Type anything to end round");
			scanner.next();
			index++;
		}
	}


	void DiceThrow(){
		GreenThrow = GD.ThrowDice(rand.DiceThrow());
		RedThrow = RD.ThrowDice(rand.DiceThrow());
	}
}
