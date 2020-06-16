//Class that include data about all players in game.


public class Participants {
	
	
	
	Player[] players;
	
	//constructor which create array of players and take from user their names
	public Participants(int number) {
		
		players= new Player[number];
//		Arrays.fill(players, new Player());
		for(int i=0;i<number;i++) {
			players[i]= new Player();
		}
	

	}
	
	
	
}
