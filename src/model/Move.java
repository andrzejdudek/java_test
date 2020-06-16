package model;
	  
public class Move {
	private int id;
	private int GameID;
	private String name;
	private String GD;
	private String RD;
	private int Rabbits;
	private int Sheep;
	private int Pigs;
	private int Cows;
	private int Horses;
	private int SmallDog;
	private int BigDog;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getGameID() {
		return GameID;
	}

	public void setGameId(int GameID) {
		this.GameID = GameID;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getGD() {
		return GD;
	}

	public void setGD(String GD) {
		this.GD = GD;
	}
	
	public String getRD() {
		return RD;
	}

	public void setRD(String RD) {
		this.RD = RD;
	}
	
	public int getRabbits() {
		return Rabbits;
	}

	public void setRabbits(int Rabbits) {
		this.Rabbits = Rabbits;
	}
	
	public int getSheep() {
		return Sheep;
	}

	public void setSheep(int Sheep) {
		this.Sheep = Sheep;
	}
	
	public int getPigs() {
		return Pigs;
	}

	public void setPigs(int Pigs) {
		this.Pigs = Pigs;
	}
	public int getCows() {
		return Cows;
	}

	public void setCows(int Cows) {
		this.Cows = Cows;
	}
	public int getHorses() {
		return Horses;
	}

	public void setHorses(int Horses) {
		this.Horses = Horses;
	}
	public int getSmallDog() {
		return SmallDog;
	}

	public void setSmallDog(int SmallDog) {
		this.SmallDog = SmallDog;
	}
	public int getBigDog() {
		return BigDog;
	}

	public void setBigDog(int BigDog) {
		this.BigDog = BigDog;
	}
	
	public Move() {}

	public Move(int id, int GameID, String name, String GD, String RD, int Rabbits, int Sheep, int Pigs, int Cows, int Horses, int SmallDog, int BigDog) {
	          this.id = id;
	          this.GameID = GameID;
	          this.name = name;
	          this.GD = GD;
	          this.RD = RD;
	          this.Rabbits = Rabbits;
	          this.Sheep = Sheep;
	          this.Pigs = Pigs;
	          this.Cows = Cows;
	          this.Horses = Horses;
	          this.SmallDog = SmallDog;
	          this.BigDog = BigDog;
	      }

	//@Override
//	public String toString() {
////		return "[" + id + "] - " + name + " - " + autor;
//	}
  }
