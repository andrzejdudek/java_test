package GameHistory;
  
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.sql.SQLException;
  import java.sql.Statement;
  import java.util.LinkedList;
  import java.util.List;
  
  import model.Move;
  import model.Game;
  
  public class GameHistory {
  
      public static final String DRIVER = "org.sqlite.JDBC";
      public static final String DB_URL = "jdbc:sqlite:farmer.db";
  
      private Connection conn;
      private Statement stat;
  

      
      public  void OpenConnection() {
    	  try {
              Class.forName(GameHistory.DRIVER);
          } catch (ClassNotFoundException e) {
              System.err.println("Brak sterownika JDBC");
              e.printStackTrace();
          }
  
          try {
              conn = DriverManager.getConnection(DB_URL);
              stat = conn.createStatement();
          } catch (SQLException e) {
              System.err.println("Problem z otwarciem polaczenia");
              e.printStackTrace();
          }
          createTables();
      }
      
      public boolean createTables()  {
    	  
          String createMove = "CREATE TABLE IF NOT EXISTS moves (id_move INTEGER PRIMARY KEY AUTOINCREMENT, gameid int, name varchar(255), gd varchar(255), rd varchar(255), rabbits int, sheep int, pigs int, cows int, horses int, smalldog int, bigdog int)";
          String createGame = "CREATE TABLE IF NOT EXISTS games (id_game INTEGER PRIMARY KEY AUTOINCREMENT, date varchar(255), player_one varchar(255), player_two varchar(255), player_three varchar(255), player_four varchar(255), player_five varchar(255), player_six varchar(255))";
         
          try {
              stat.execute(createMove);
              stat.execute(createGame);
          } catch (SQLException e) {
              System.err.println("Blad przy tworzeniu tabeli");
              e.printStackTrace();
              return false;
          }
          return true;
      }
  
      
      
      public boolean insertMove(int GameID, String name, String GD, String RD, int Rabbits, int Sheep, int Pigs, int Cows, int Horses, int SmallDog, int BigDog) {
          try {
              PreparedStatement prepStmt = conn.prepareStatement(
                      "insert into moves values (NULL,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? );");
              prepStmt.setInt(1, GameID);
              prepStmt.setString(2, name);
              prepStmt.setString(3, GD);
              prepStmt.setString(4, RD);
              prepStmt.setInt(5, Rabbits);
              prepStmt.setInt(6, Sheep);
              prepStmt.setInt(7, Pigs);
              prepStmt.setInt(8, Cows);
              prepStmt.setInt(9, Horses);
              prepStmt.setInt(10, SmallDog);
              prepStmt.setInt(11, BigDog);
              prepStmt.execute();
          } catch (SQLException e) {
              System.err.println("Move Error");
              e.printStackTrace();
              return false;
          }
          return true;
      }
  
      public boolean insertGame(String Date, String Player1, String Player2, String Player3, String Player4, String Player5, String Player6) {
          try {
              PreparedStatement prepStmt = conn.prepareStatement(
                      "insert into games values (NULL, ?, ?, ?, ?, ?, ?, ?);");
              prepStmt.setString(1, Date);
              prepStmt.setString(2, Player1);
              prepStmt.setString(3, Player2);
              prepStmt.setString(4, Player3);
              prepStmt.setString(5, Player4);
              prepStmt.setString(6, Player5);
              prepStmt.setString(7, Player6);
              prepStmt.execute();
          } catch (SQLException e) {
              System.err.println("Game Error");
              e.printStackTrace();
              return false;
          }
          return true;
      }
  
     
      
  
      public List<Move> selectMove() {
    	  
          List<Move> Moves = new LinkedList<Move>();
          try {
              ResultSet result = stat.executeQuery("SELECT * FROM moves");
              int id, GameID, rabbits, sheep, pigs, cows, horses, smalldog, bigdog;
              String name, gd, rd;
              while(result.next()) {
                  id = result.getInt("id_move");
                  GameID = result.getInt("gameid");
                  rabbits = result.getInt("rabbits");
                  sheep = result.getInt("sheep");
                  pigs = result.getInt("pigs");
                  cows = result.getInt("cows");
                  horses = result.getInt("horses");
                  smalldog = result.getInt("smalldog");
                  bigdog = result.getInt("bigdog");
                  
                  name = result.getString("name");
                  gd = result.getString("gd");
                  rd = result.getString("rd");
                  Moves.add(new Move(id, GameID, name,gd, rd, rabbits, sheep, pigs,cows,horses,smalldog,bigdog));
              }
          } catch (SQLException e) {
              e.printStackTrace();
              return null;
          }
          return Moves;
      }
      
      public List<Move> selectMove(int GameIDa) {
    	  
          List<Move> Moves = new LinkedList<Move>();
          try {
        	  String command = "SELECT * FROM moves WHERE gameid=" + String.valueOf(GameIDa);
              ResultSet result = stat.executeQuery(command);
              int id, GameID, rabbits, sheep, pigs, cows, horses, smalldog, bigdog;
              String name, gd, rd;
              while(result.next()) {
                  id = result.getInt("id_move");
                  GameID = result.getInt("gameid");
                  rabbits = result.getInt("rabbits");
                  sheep = result.getInt("sheep");
                  pigs = result.getInt("pigs");
                  cows = result.getInt("cows");
                  horses = result.getInt("horses");
                  smalldog = result.getInt("smalldog");
                  bigdog = result.getInt("bigdog");
                  
                  name = result.getString("name");
                  gd = result.getString("gd");
                  rd = result.getString("rd");
                  Moves.add(new Move(id, GameID, name,gd, rd, rabbits, sheep, pigs,cows,horses,smalldog,bigdog));
              }
          } catch (SQLException e) {
              e.printStackTrace();
              return null;
          }
          return Moves;
      }
  
      public List<Game> selectGame() {
          List<Game> Games = new LinkedList<Game>();
          try {
              ResultSet result = stat.executeQuery("SELECT * FROM games");
              int id;
              String date, player1, player2,player3,player4,player5,player6;
              while(result.next()) {
                  id = result.getInt("id_game");
                  date = result.getString("date");
                  player1 = result.getString("player_one");
                  player2 = result.getString("player_two");
                  player3 = result.getString("player_three");
                  player4 = result.getString("player_four");
                  player5 = result.getString("player_five");
                  player6 = result.getString("player_six");
                  
                  Games.add(new Game(id, date, player1,player2,player3,player4,player5,player6));
              }
          } catch (SQLException e) {
              e.printStackTrace();
              return null;
          }
          return Games;
      }
  
      public void closeConnection() {
          try {
              conn.close();
          } catch (SQLException e) {
              System.err.println("Problem z zamknieciem polaczenia");
              e.printStackTrace();
          }
      }
      
	
  }
