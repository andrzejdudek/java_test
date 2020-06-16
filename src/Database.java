import java.util.LinkedList;
import java.util.List;

import GameHistory.GameHistory;
import model.Game;
import model.Move;

public class Database {
	GameHistory GH;
	
	List<Move> Moves;
	List<Game> Games;
	
	ActualDate date = new ActualDate();
	
	public Database() {
		GH = new GameHistory();
		GH.OpenConnection();
		Games = GH.selectGame();
		GH.closeConnection();
	}
	
	void AddNewGame(String []Names) {
		GH.OpenConnection();
		String Player1 = Names[0];
		String Player2 = Names[1];
		String Player3 = "";
		String Player4 = "";
		String Player5 = "";
		String Player6 = "";
		
		if(Names.length>=3) Player3=Names[2];
		if(Names.length>=4) Player4=Names[3];
		if(Names.length>=5) Player5=Names[4];
		if(Names.length>=6) Player6=Names[5];
		
		
		GH.insertGame(date.getDate(), Player1, Player2, Player3, Player4, Player5, Player6);
		Games = GH.selectGame();
		GH.closeConnection();
	}
	
	int getLastGameID() {
		return Games.get(Games.size()-1).getId();
//			if(Games.size()==0) {
//					return 1;
//			} else {
//				return Games.get(Games.size()).getId();
//			}
	}
	
	
	void AddNewMove( String GD, String RD, Player Pl) {
		GH.OpenConnection();
		GH.insertMove(getLastGameID(), Pl.name, GD, RD, Pl.rabbits, Pl.sheep, Pl.pigs, Pl.cows, Pl.horses, Pl.smalldog, Pl.bigdog);
		GH.closeConnection();
	}
	
	String NameOfGame(int ID) {
		if(ID<Games.size()) {
		String name = "ID: ";
		name+=String.valueOf(Games.get(ID).getId());
		name +=" Date: ";
		name+=Games.get(ID).getDate();
		return name;
		} else {
			return "";
		}
	} 
	
	String NameOfMoves(int ID) {
		if(ID<Moves.size()) {
		String name = "ID: ";
		name+=String.valueOf(Moves.get(ID).getId());
		name+=" Name: ";
		name+=Moves.get(ID).getname();
		name+=" Dice: ";
		name+=Moves.get(ID).getGD();
		name+=", ";
		name+=Moves.get(ID).getRD();
		name+=" R: ";
		name+=String.valueOf(Moves.get(ID).getRabbits());
		name+=" S: ";
		name+=String.valueOf(Moves.get(ID).getSheep());
		name+=" P: ";
		name+=String.valueOf(Moves.get(ID).getPigs());
		name+=" C: ";
		name+=String.valueOf(Moves.get(ID).getCows());
		name+=" H: ";
		name+=String.valueOf(Moves.get(ID).getHorses());
		name+=" SD: ";
		name+=String.valueOf(Moves.get(ID).getSmallDog());
		name+=" BD: ";
		name+=String.valueOf(Moves.get(ID).getBigDog());
		
		return name;
		} else {
			return "";
		}
		
	}
	
	boolean getGameMoves(int ID) {
		if (ID <=Games.size()) {
			GH.OpenConnection();
			Moves = new LinkedList<Move>();
			Moves = GH.selectMove(ID);
			GH.closeConnection();
			return true;
		} else {
			return false;
		}
	}

}
