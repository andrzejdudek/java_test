package model;

public class Game {
	
		private int id;
		private String Date;
		private String Player1;
		private String Player2;
		private String Player3;
		private String Player4;
		private String Player5;
		private String Player6;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getDate() {
			return Date;
		}

		public void setDate(String Date) {
			this.Date = Date;
		}

		public String getPlayer1() {
			return Player1;
		}

		public void setPlayer1(String Player1) {
			this.Player1 = Player1;
		}
		
		public String getPlayer2() {
			return Player2;
		}

		public void setPlayer2(String Player2) {
			this.Player2 = Player2;
		}
		
		public String getPlayer3() {
			return Player3;
		}

		public void setPlayer3(String Player3) {
			this.Player3 = Player3;
		}
		
		public String getPlayer4() {
			return Player4;
		}

		public void setPlayer4(String Player4) {
			this.Player4 = Player4;
		}
		
		public String getPlayer5() {
			return Player5;
		}

		public void setPlayer5(String Player5) {
			this.Player5 = Player5;
		}
		public String getPlayer6() {
			return Player6;
		}

		public void setPlayer6(String Player6) {
			this.Player6 = Player6;
		}
		
		public Game() {}
		
		public Game(int id, String Date, String Player1, String Player2, String Player3, String Player4, String Player5, String Player6) {
		          this.id = id;
		          this.Date = Date;
		          this.Player1 = Player1;
		          this.Player2 = Player2;
		          this.Player3 = Player3;
		          this.Player4 = Player4;
		          this.Player5 = Player5;
		         this.Player6 = Player6;
		      }

		//@Override
//		public String toString() {
////			return "[" + id + "] - " + Date + " - " + autor;
//		}
//	  }

}
