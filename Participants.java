//Class that include data about all players in game.

import java.util.Scanner;
import java.util.Arrays;

public class Participants {
	
	//Scanner is class needed to put info from terminal
	Scanner scanner = new Scanner(System.in);
	
	
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
