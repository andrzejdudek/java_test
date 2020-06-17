import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CLayout {
	
	JFrame frame;
	JFrame win;
	JPanel pCont;
	
	JPanel panelMenu; 
	JPanel panelGameInitialization1;
	JPanel panelGameInitialization2;
	JPanel panelGame;
	JPanel panelGame2;
	JPanel panelGameHistory1;
	JPanel panelGameHistory2;
	
	//Menu elements
	JButton bmNewGame;
	JButton bmGameHistory;
	JButton bmExit;
	JComboBox<String> cbmLanguage;
	
	//Game initialization 1 elements
	JButton bgi1Accept;
	TextField gi1text;
	JLabel lgi1info;
	
	//Game initialization 2 elements
	TextField gi2text;
	JButton bgi2Accept;
	JLabel lgi2info;
	JComboBox<String> cbgi2Language;
	
	// Game elements
	// Labels
	JLabel lgPlayerName;
	JLabel lgDice;
	JLabel lgAnimalsError;
	JLabel lgRabbits;
	JLabel lgSheep;
	JLabel lgPigs;
	JLabel lgCows;
	JLabel lgHorses;
	JLabel lgSmallDog;
	JLabel lgBigDog;
	
	//Farm Labels
	JLabel lgFarm;
	JLabel lgFarmRabbits;
	JLabel lgFarmSheep;
	JLabel lgFarmPigs;
	JLabel lgFarmCows;
	JLabel lgFarmHorses;
	JLabel lgFarmSmallDog;
	JLabel lgFarmBigDog;
	
	//Buttons only for view
	JButton bgRabbits;
	JButton bgSheep1;
	JButton bgSheep2;
	JButton bgPigs1;
	JButton bgPigs2;
	JButton bgCows1;
	JButton bgCows2;
	JButton bgHorses;
	
	//Buttons for exchanging
	JButton bgRabbitsToSheep;
	JButton bgSheepToRabbits;
	JButton bgSheepToPigs;
	JButton bgPigsToSheep;
	JButton bgPigsToCows;
	JButton bgCowsToPigs;
	JButton bgCowsToHorses;
	JButton bgHorsesToCows;
	JButton bgBuySmallDog;
	JButton bgBuyBigDog;
	JButton bgEndRound;
	
	// Exchanging prices
	JLabel RabbitsSheep;
	JLabel SheepPigs;
	JLabel PigsCows;
	JLabel CowsHorses;
	
	//Game 2
	JButton bg2Roll;
	JLabel lg2Player;
	
	
	//Win
	JLabel lwinfo;
	JButton bwclose;
	
	//GameHistory 1 
	JButton bgh1BackToMenu;
	JButton bgh1game1;
	JButton bgh1game2;
	JButton bgh1game3;
	JButton bgh1game4;
	JButton bgh1game5;
	JButton bgh1previous;
	JButton bgh1next;
	
	//GameHistory 2
	JButton bgh2BackToGames;
	JButton bgh2Next;
	JButton bgh2Previous;
	JLabel lgh2move1;
	JLabel lgh2move2;
	JLabel lgh2move3;
	JLabel lgh2move4;
	JLabel lgh2move5;
	
	
	Language MenuLanguage;
	ListOfLanguages LOF;
	
	GameLogic logic;
	Database DB;
	
	//Card Layout and dimension of window
	CardLayout cl; 
	Dimension dim;
	Dimension winframe;
	
	int players = 6;
	int index =0;
	int ghindex = 0;
	int mhindex =0;
	String [] names;

	
	public CLayout() {
		
		ElementsInitialization();
		
		pCont.setLayout(cl);
		
		MenuInitialization();
		GameInitialization1();
		GameInitialization2();
		Game();
		Game2();
		GameHistory1();
		GameHistory2();
		//Win();	
		
		
		pCont.add(panelMenu,"1");
		pCont.add(panelGameInitialization1, "2");
		pCont.add(panelGameInitialization2, "3");
		pCont.add(panelGame2, "4");
		pCont.add(panelGame, "5");
		pCont.add(panelGameHistory1, "6");
		pCont.add(panelGameHistory2, "7");
		
		cl.show(pCont, "1");
		
		frame.add(pCont);
		frame.setTitle("Farmer");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setResizable(true);
		frame.setVisible(true);
		
		
		
		
	}
	
	void ElementsInitialization() {
		frame = new JFrame();
		
		
		pCont = new JPanel();
		
		panelMenu = new JPanel();
		panelGameInitialization1 = new JPanel();
		panelGameInitialization2 = new JPanel();
		panelGame = new JPanel();
		panelGame2= new JPanel();
		panelGameHistory1 = new JPanel();
		panelGameHistory2 = new JPanel();
		
		//Menu
		bmNewGame = new JButton();
		bmGameHistory = new JButton();
		bmExit = new JButton();
		cbmLanguage = new JComboBox<String>();
		
		//Game Initialization 1
		bgi1Accept = new JButton();
		gi1text = new TextField();
		lgi1info = new JLabel();
		
		//GameInitialization 2
		gi2text = new TextField();
		bgi2Accept = new JButton();
		lgi2info = new JLabel();
		cbgi2Language = new JComboBox<String>();
		
		//Game
		lgPlayerName = new JLabel();
		lgDice = new JLabel();
		lgAnimalsError = new JLabel();
		lgRabbits = new JLabel();
		lgSheep = new JLabel();
		lgPigs = new JLabel();
		lgCows = new JLabel();
		lgHorses = new JLabel();
		lgSmallDog = new JLabel();
		lgBigDog = new JLabel();
		
		lgFarm = new JLabel();
		lgFarmRabbits = new JLabel();;
		lgFarmSheep = new JLabel();
		lgFarmPigs = new JLabel();
		lgFarmCows = new JLabel();
		lgFarmHorses = new JLabel();
		lgFarmSmallDog = new JLabel();
		lgFarmBigDog = new JLabel();
		
		bgRabbits = new JButton();
		bgSheep1 = new JButton();
		bgSheep2 = new JButton();
		bgPigs1 = new JButton();
		bgPigs2 = new JButton();
		bgCows1 = new JButton();
		bgCows2 = new JButton();
		bgHorses = new JButton();
		
		bgRabbitsToSheep = new JButton("-->");
		bgSheepToRabbits = new JButton("<--");
		bgSheepToPigs = new JButton("-->");
		bgPigsToSheep = new JButton("<--");
		bgPigsToCows = new JButton("-->");
		bgCowsToPigs = new JButton("<--");
		bgCowsToHorses = new JButton("-->");
		bgHorsesToCows = new JButton("<--");
		bgBuySmallDog = new JButton();
		bgBuyBigDog = new JButton();
		bgEndRound = new JButton();
		
		RabbitsSheep = new JLabel();
		SheepPigs = new JLabel();
		PigsCows = new JLabel();
		CowsHorses = new JLabel();
		
		
		//Game 2
		bg2Roll = new JButton();
		lg2Player = new JLabel();
		
		//GameHistory 1
		bgh1BackToMenu = new JButton("Back to Menu");
		bgh1game1 = new JButton();
		bgh1game2 = new JButton();
		bgh1game3 = new JButton();
		bgh1game4 = new JButton();
		bgh1game5 = new JButton();
		bgh1previous = new JButton("Previous");
		bgh1next = new JButton("Next");
		
		//GameHistory2
		bgh2BackToGames = new JButton("back");
		bgh2Next = new JButton("Next");
		bgh2Previous = new JButton("Previous");
		
		lgh2move1 = new JLabel();
		lgh2move2 = new JLabel();
		lgh2move3 = new JLabel();
		lgh2move4 = new JLabel();
		lgh2move5 = new JLabel();
		
		
		//Win
		lwinfo = new JLabel();
		bwclose = new JButton();
		
		cl = new CardLayout();
		
		dim= new Dimension(1280,720);
		
		MenuLanguage = new Language("English");
		LOF = new ListOfLanguages();
		
		DB = new Database();
	}
	
	
	void MenuInitialization() {
	//Panel Menu
	panelMenu.setLayout(null);
	panelMenu.setPreferredSize(dim);
	panelMenu.setBackground(Color.GREEN);
	
	
	panelMenu.add(bmNewGame);
	panelMenu.add(bmGameHistory);
	panelMenu.add(bmExit);
	panelMenu.add(cbmLanguage);
	
	bmNewGame.setBounds(dim.width/2-dim.width/12, dim.height/2, dim.width/6, dim.height/10);
	bmNewGame.setFont(new Font("SansSerif",Font.BOLD, 18));
	bmNewGame.setText(MenuLanguage.NewGame);
	
	bmGameHistory.setFont(new Font("SansSerif",Font.BOLD, 18));
	bmGameHistory.setBounds(dim.width/2-dim.width/12, dim.height/2+dim.height*5/40, dim.width/6, dim.height/10);
	bmGameHistory.setText(MenuLanguage.GameHistory);
	
	bmExit.setBounds(dim.width/2-dim.width/12, dim.height/2+dim.height/4, dim.width/6, dim.height/10);
	bmExit.setFont(new Font("SansSerif",Font.BOLD, 18));
	bmExit.setText(MenuLanguage.Exit);
	
	cbmLanguage.setBounds(dim.height/40,dim.height/40,dim.width/10,dim.height/24);
	LOF.getList();
	for(int i=0;i<LOF.pathnames.length;i++) {
		cbmLanguage.addItem(LOF.pathnames[i]);
	}
	cbmLanguage.setSelectedItem(MenuLanguage.LanguageName);

	
	
	bmNewGame.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			bgi1Accept.setText(MenuLanguage.Accept);
			lgi1info.setText(MenuLanguage.HowManyPlayers);
			bgi2Accept.setText(MenuLanguage.Accept);
			lgi2info.setText(MenuLanguage.Player + " " + String.valueOf(index+1) + " " + MenuLanguage.Name);
			cbgi2Language.setSelectedItem(MenuLanguage.LanguageName);
			cl.show(pCont,"2");
		}
	});
	
	bmGameHistory.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			DB.GH.OpenConnection();
			DB.GH.selectGame();
			DB.GH.closeConnection();
			ghindex = 0;
			
			
			bgh1game1.setText(DB.NameOfGame(ghindex));
			bgh1game2.setText(DB.NameOfGame(ghindex+1));
			bgh1game3.setText(DB.NameOfGame(ghindex+2));
			bgh1game4.setText(DB.NameOfGame(ghindex+3));
			bgh1game5.setText(DB.NameOfGame(ghindex+4));
			
			cl.show(pCont, "6");
			
		}
	});
	
	bmExit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
		}
	});
	
	cbmLanguage.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String lan = cbmLanguage.getSelectedItem().toString();
			for(int i=0;i<LOF.pathnames.length;i++) {
				if(lan.equals(LOF.pathnames[i])) {
					MenuLanguage.SetLanguage(LOF.pathnames[i]);
					break;
				}
			}
			bmNewGame.setText(MenuLanguage.NewGame);
			bmGameHistory.setText(MenuLanguage.GameHistory);
			bmExit.setText(MenuLanguage.Exit);
		}
	});
	
	}
	
	
	void GameInitialization1() {
		//Panel Game Initialization 1
		panelGameInitialization1.setLayout(null);
		panelGameInitialization1.setBackground(Color.PINK);
		
		panelGameInitialization1.add(bgi1Accept);
		bgi1Accept.setBounds(dim.width/2-dim.width/12, dim.height/2 + dim.height/12, dim.width/6, dim.height/10);		
		bgi1Accept.setFont(new Font("SansSerif",Font.BOLD, 22));
		
		panelGameInitialization1.add(gi1text);
		gi1text.setBounds(dim.width/2-dim.width/48, dim.height/2 - dim.height/12, dim.width/24, dim.height/10);
		gi1text.setFont(new Font("SansSerif",Font.BOLD, 40));
		
		panelGameInitialization1.add(lgi1info);		
		lgi1info.setBounds(0, dim.height/2-dim.height/10- dim.height/12, dim.width, dim.height/10);
		lgi1info.setFont(new Font("SansSerif",Font.BOLD, 22));
		lgi1info.setHorizontalAlignment(JLabel.CENTER);
		
		bgi1Accept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//Creating game logic based on player number
				if((int)Double.parseDouble(gi1text.getText())>1 && (int)Double.parseDouble(gi1text.getText()) <7){
					names = new String[(int)Double.parseDouble(gi1text.getText())];
					logic = new GameLogic((int)Double.parseDouble(gi1text.getText()));
					players = (int)Double.parseDouble(gi1text.getText());
					cl.show(pCont,"3");
				}
			}
		});
	}
	
	
	void GameInitialization2(){
		//Panel Game Initialization 1
		panelGameInitialization2.setLayout(null);
		panelGameInitialization2.setBackground(Color.RED);
		
		panelGameInitialization2.add(bgi2Accept);
		bgi2Accept.setBounds(dim.width/2-dim.width/12, dim.height/2 + dim.height*5/49 , dim.width/6, dim.height/10);
		bgi2Accept.setFont(new Font("SansSerif",Font.BOLD, 22));
		
		panelGameInitialization2.add(gi2text);
		gi2text.setFont(new Font("SansSerif",Font.BOLD, 22));
		gi2text.setBounds(dim.width/2-dim.width/12, dim.height/2 - dim.height/12, dim.width/6, dim.height/10);
		
		panelGameInitialization2.add(lgi2info);
		lgi2info.setBounds(0, dim.height/2-dim.height/10- dim.height/12, dim.width, dim.height/10);
		lgi2info.setFont(new Font("SansSerif",Font.BOLD, 22));
		lgi2info.setHorizontalAlignment(JLabel.CENTER);
		
		panelGameInitialization2.add(cbgi2Language);
		cbgi2Language.setBounds(dim.width/2-dim.width/12,dim.height/2 + dim.height/24,dim.width/6,dim.height/24);
		
		for(int i=0;i<LOF.pathnames.length;i++) {
			cbgi2Language.addItem(LOF.pathnames[i]);
		}
		
		
		bgi2Accept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Przypisanie imienia
				logic.gamers.players[index].name=gi2text.getText();
				names[index]=gi2text.getText();
				
				String lan = cbgi2Language.getSelectedItem().toString();
				for(int i=0;i<LOF.pathnames.length;i++) {
					if(lan.equals(LOF.pathnames[i])) {
						logic.gamers.players[index].PlayerLanguage.SetLanguage(LOF.pathnames[i]);
						break;
					
					}
				}
				
				if(index==logic.players-1) {
					index=0;
					DB.AddNewGame(names);
					
					
					lg2Player.setText(logic.gamers.players[index].name + " "+ logic.gamers.players[index].PlayerLanguage.turn);
					bg2Roll.setText(logic.gamers.players[index].PlayerLanguage.RollTheDice );
					DB.GH.OpenConnection();
					DB.GH.selectGame();
					DB.GH.closeConnection();
					
					cl.show(pCont,"4");
				} else {
				gi2text.setText("");
				
				index++;
				lgi2info.setText(MenuLanguage.Player + " " + String.valueOf(index +1) + " " + MenuLanguage.Name);
			
				}
			}
		});
		
		}
	
	
	void Game() {
		//PanelGame
		panelGame.setLayout(null);
		panelGame.setBackground(Color.YELLOW);
		
		panelGame.add(lgPlayerName);
		lgPlayerName.setBounds(0, dim.height/100, dim.width, dim.height/15);
		lgPlayerName.setFont(new Font("SansSerif",Font.BOLD,40));
		lgPlayerName.setHorizontalAlignment(JLabel.CENTER);
		
		panelGame.add(lgDice);
		lgDice.setBounds(0, dim.height/200+dim.height/12, dim.width, dim.height/20);
		lgDice.setFont(new Font("SansSerif",Font.BOLD,30));
		lgDice.setHorizontalAlignment(JLabel.CENTER);

		panelGame.add(lgAnimalsError);
		lgAnimalsError.setBounds(0, dim.height/200+dim.height/12+dim.height/20, dim.width, dim.height/20);
		lgAnimalsError.setFont(new Font("SansSerif",Font.BOLD,20));
		lgAnimalsError.setText("lol lol lol");
		lgAnimalsError.setHorizontalAlignment(JLabel.CENTER);
		
		panelGame.add(lgRabbits);
		lgRabbits.setBounds(dim.width/4-dim.width/6, dim.height/5, dim.width/3, dim.height/26);
		lgRabbits.setText("Rabbits - 0");
		lgRabbits.setFont(new Font("SansSerif",Font.BOLD,25));
//		lgRabbits.setHorizontalAlignment(JLabel.CENTER);
		
		panelGame.add(lgSheep);
		lgSheep.setBounds(dim.width/4-dim.width/6, dim.height/5+dim.height/20, dim.width/3, dim.height/26);
		lgSheep.setText("Sheep - 0");
		lgSheep.setFont(new Font("SansSerif",Font.BOLD,25));
//		lgSheep.setHorizontalAlignment(JLabel.CENTER);
		
		panelGame.add(lgPigs);
		lgPigs.setBounds(dim.width/4-dim.width/6, dim.height/5+dim.height/10, dim.width/3, dim.height/26);
		lgPigs.setText("Pigs - 0");
		lgPigs.setFont(new Font("SansSerif",Font.BOLD,25));
//		lgPigs.setHorizontalAlignment(JLabel.CENTER);
		
		panelGame.add(lgCows);
		lgCows.setBounds(dim.width/4-dim.width/6, dim.height/5+dim.height*3/20, dim.width/3, dim.height/26);
		lgCows.setText("Cows - 0");
		lgCows.setFont(new Font("SansSerif",Font.BOLD,25));
//		lgCows.setHorizontalAlignment(JLabel.CENTER);
		
		panelGame.add(lgHorses);
		lgHorses.setBounds(dim.width/4-dim.width/6, dim.height/5+dim.height/5, dim.width/3, dim.height/26);
		lgHorses.setText("Horses - 0");
		lgHorses.setFont(new Font("SansSerif",Font.BOLD,25));
//		lgHorses.setHorizontalAlignment(JLabel.CENTER);
		
		panelGame.add(lgSmallDog);
		lgSmallDog.setBounds(dim.width/4-dim.width/6, dim.height/5+dim.height*3/10, dim.width/3, dim.height/26);
		lgSmallDog.setText("Small Dog - 0");
		lgSmallDog.setFont(new Font("SansSerif",Font.BOLD,25));
//		lgSmallDog.setHorizontalAlignment(JLabel.CENTER);
		
		panelGame.add(lgBigDog);
		lgBigDog.setBounds(dim.width/4-dim.width/6, dim.height/5+dim.height*21/60, dim.width/3, dim.height/26);
		lgBigDog.setText("Big Dog - 0");
		lgBigDog.setFont(new Font("SansSerif",Font.BOLD,25));
//		lgBigDog.setHorizontalAlignment(JLabel.CENTER);
		
		panelGame.add(lgFarm);
		lgFarm.setBounds(dim.width/4-dim.width/6, dim.height*51/80, dim.width/10, dim.height/30);
		lgFarm.setText("Farm");
		lgFarm.setFont(new Font("SansSerif",Font.BOLD,18));
		
		panelGame.add(lgFarmRabbits);
		lgFarmRabbits.setBounds(dim.width/4-dim.width/6, dim.height*54/80, dim.width/7, dim.height/30);
		lgFarmRabbits.setFont(new Font("SansSerif",Font.BOLD,18));
		

		panelGame.add(lgFarmSheep);
		lgFarmSheep.setBounds(dim.width/4-dim.width/6, dim.height*57/80, dim.width/7, dim.height/30);
		lgFarmSheep.setFont(new Font("SansSerif",Font.BOLD,18));
		
		panelGame.add(lgFarmPigs);
		lgFarmPigs.setBounds(dim.width/4-dim.width/6, dim.height*60/80, dim.width/7, dim.height/30);
		lgFarmPigs.setFont(new Font("SansSerif",Font.BOLD,18));
		
		panelGame.add(lgFarmCows);
		lgFarmCows.setBounds(dim.width/4-dim.width/6, dim.height*63/80, dim.width/7, dim.height/30);
		lgFarmCows.setFont(new Font("SansSerif",Font.BOLD,18));
		
		panelGame.add(lgFarmHorses);
		lgFarmHorses.setBounds(dim.width/4-dim.width/6, dim.height*66/80, dim.width/7, dim.height/30);
		lgFarmHorses.setFont(new Font("SansSerif",Font.BOLD,18));
		
		panelGame.add(lgFarmSmallDog);
		lgFarmSmallDog.setBounds(dim.width/4-dim.width/6, dim.height*69/80, dim.width/7, dim.height/30);
		lgFarmSmallDog.setFont(new Font("SansSerif",Font.BOLD,18));
		
		panelGame.add(lgFarmBigDog);
		lgFarmBigDog.setBounds(dim.width/4-dim.width/6, dim.height*72/80, dim.width/7, dim.height/30);
		lgFarmBigDog.setFont(new Font("SansSerif",Font.BOLD,18));
		
		
		
		
		//Buttons
		panelGame.add(bgRabbitsToSheep);
		bgRabbitsToSheep.setBounds(dim.width*3/4-dim.width/24, dim.height/5, dim.width/12, dim.height/24);
		bgRabbitsToSheep.setFont(new Font("SansSerif",Font.BOLD,25));
		bgRabbitsToSheep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(logic.ranch.checkUnits("rabbits", "sheep")==true && logic.gamers.players[index].checkUnits("rabbits", "sheep")==true) {
					logic.ranch.tradeUnits("sheep","rabbits");
					logic.gamers.players[index].tradeUnits("rabbits", "sheep");
						
						
				} else {
						lgAnimalsError.setText(logic.gamers.players[index].ErrorMessage()+logic.ranch.ErrorMessage());
				}
					
				
				
				lgRabbits.setText(logic.gamers.players[index].PlayerLanguage.Rabbits + " - "+logic.gamers.players[index].rabbits);
				lgSheep.setText(logic.gamers.players[index].PlayerLanguage.Sheep + " - "+logic.gamers.players[index].sheep);
				UpdateFarm();
				if(logic.CheckIfWin(index)==true) {
					Win();
				}
			}
		});
		
		
		panelGame.add(RabbitsSheep);
		RabbitsSheep.setBounds(dim.width*3/4-dim.width/24, dim.height/5+dim.height/24, dim.width/12, dim.height/24);
		RabbitsSheep.setText("6 <---> 1");
		RabbitsSheep.setFont(new Font("SansSerif",Font.BOLD,20));
		RabbitsSheep.setHorizontalAlignment(JLabel.CENTER);
		
		
		
		panelGame.add(bgSheepToRabbits);
		bgSheepToRabbits.setBounds(dim.width*3/4-dim.width/24, dim.height/5+dim.height*2/24, dim.width/12, dim.height/24);
		bgSheepToRabbits.setFont(new Font("SansSerif",Font.BOLD,25));
		bgSheepToRabbits.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(logic.ranch.checkUnits("sheep","rabbits")==true && logic.gamers.players[index].checkUnits("sheep","rabbits")==true) {
					logic.ranch.tradeUnits("rabbits","sheep");
					logic.gamers.players[index].tradeUnits("sheep","rabbits");
					lgAnimalsError.setText("");	
						
				} else {
						lgAnimalsError.setText(logic.gamers.players[index].ErrorMessage()+logic.ranch.ErrorMessage());
				}
					
				
				
				lgRabbits.setText(logic.gamers.players[index].PlayerLanguage.Rabbits + " - "+logic.gamers.players[index].rabbits);
				lgSheep.setText(logic.gamers.players[index].PlayerLanguage.Sheep + " - "+logic.gamers.players[index].sheep);
				
				UpdateFarm();
				if(logic.CheckIfWin(index)==true) {
					Win();
				}
				
			}
		});
		
		
		
		panelGame.add(bgSheepToPigs);
		bgSheepToPigs.setBounds(dim.width*3/4-dim.width/24, dim.height/5+dim.height*4/24, dim.width/12, dim.height/24);
		bgSheepToPigs.setFont(new Font("SansSerif",Font.BOLD,25));
		bgSheepToPigs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(logic.ranch.checkUnits("sheep","pigs")==true && logic.gamers.players[index].checkUnits("sheep","pigs")==true) {
					logic.ranch.tradeUnits("pigs","sheep");
					logic.gamers.players[index].tradeUnits("sheep","pigs");
					lgAnimalsError.setText("");	
						
				} else {
						lgAnimalsError.setText(logic.gamers.players[index].ErrorMessage()+logic.ranch.ErrorMessage());
				}
					
				
				
				lgPigs.setText(logic.gamers.players[index].PlayerLanguage.Pigs + " - "+logic.gamers.players[index].pigs);
				lgSheep.setText(logic.gamers.players[index].PlayerLanguage.Sheep + " - "+logic.gamers.players[index].sheep);
				UpdateFarm();
				if(logic.CheckIfWin(index)==true) {
					Win();
				}
				
			}
		});
		
		panelGame.add(SheepPigs);
		SheepPigs.setBounds(dim.width*3/4-dim.width/24, dim.height/5+dim.height*5/24, dim.width/12, dim.height/24);
		SheepPigs.setText("2 <---> 1");
		SheepPigs.setFont(new Font("SansSerif",Font.BOLD,20));
		SheepPigs.setHorizontalAlignment(JLabel.CENTER);

		
		
		panelGame.add(bgPigsToSheep);
		bgPigsToSheep.setBounds(dim.width*3/4-dim.width/24, dim.height/5+dim.height*6/24, dim.width/12, dim.height/24);
		bgPigsToSheep.setFont(new Font("SansSerif",Font.BOLD,25));
		bgPigsToSheep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(logic.ranch.checkUnits("pigs","sheep")==true && logic.gamers.players[index].checkUnits("pigs","sheep")==true) {
					logic.ranch.tradeUnits("sheep","pigs");
					logic.gamers.players[index].tradeUnits("pigs","sheep");
					lgAnimalsError.setText("");	
						
				} else {
						lgAnimalsError.setText(logic.gamers.players[index].ErrorMessage()+logic.ranch.ErrorMessage());
				}
					
				
				
				lgPigs.setText(logic.gamers.players[index].PlayerLanguage.Pigs + " - "+logic.gamers.players[index].pigs);
				lgSheep.setText(logic.gamers.players[index].PlayerLanguage.Sheep + " - "+logic.gamers.players[index].sheep);
				UpdateFarm();
				if(logic.CheckIfWin(index)==true) {
					Win();
				}
				
			}
		});
		
		panelGame.add(bgPigsToCows);
		bgPigsToCows.setBounds(dim.width*3/4-dim.width/24, dim.height/5+dim.height*8/24, dim.width/12, dim.height/24);
		bgPigsToCows.setFont(new Font("SansSerif",Font.BOLD,25));
		bgPigsToCows.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(logic.ranch.checkUnits("pigs","cows")==true && logic.gamers.players[index].checkUnits("pigs","cows")==true) {
					logic.ranch.tradeUnits("cows","pigs");
					logic.gamers.players[index].tradeUnits("pigs","cows");
					lgAnimalsError.setText("");	
						
				} else {
						lgAnimalsError.setText(logic.gamers.players[index].ErrorMessage()+logic.ranch.ErrorMessage());
				}
					
				
				
				lgPigs.setText(logic.gamers.players[index].PlayerLanguage.Pigs + " - "+logic.gamers.players[index].pigs);
				lgCows.setText(logic.gamers.players[index].PlayerLanguage.Cows + " - "+logic.gamers.players[index].cows);
				UpdateFarm();
				if(logic.CheckIfWin(index)==true) {
					Win();
				}
			}
		});
		
		panelGame.add(PigsCows);
		PigsCows.setBounds(dim.width*3/4-dim.width/24, dim.height/5+dim.height*9/24, dim.width/12, dim.height/24);
		PigsCows.setText("3 <---> 1");
		PigsCows.setFont(new Font("SansSerif",Font.BOLD,20));
		PigsCows.setHorizontalAlignment(JLabel.CENTER);
		
		panelGame.add(bgCowsToPigs);
		bgCowsToPigs.setBounds(dim.width*3/4-dim.width/24, dim.height/5+dim.height*10/24, dim.width/12, dim.height/24);
		bgCowsToPigs.setFont(new Font("SansSerif",Font.BOLD,25));
		bgCowsToPigs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(logic.ranch.checkUnits("cows","pigs")==true && logic.gamers.players[index].checkUnits("cows","pigs")==true) {
					logic.ranch.tradeUnits("pigs","cows");
					logic.gamers.players[index].tradeUnits("cows","pigs");
					lgAnimalsError.setText("");	
						
				} else {
						lgAnimalsError.setText(logic.gamers.players[index].ErrorMessage()+logic.ranch.ErrorMessage());
				}
					
				
				
				lgPigs.setText(logic.gamers.players[index].PlayerLanguage.Pigs + " - "+logic.gamers.players[index].pigs);
				lgCows.setText(logic.gamers.players[index].PlayerLanguage.Cows + " - "+logic.gamers.players[index].cows);
				UpdateFarm();
				if(logic.CheckIfWin(index)==true) {
					Win();
				}
				
			}
		});
		
		panelGame.add(bgCowsToHorses);
		bgCowsToHorses.setBounds(dim.width*3/4-dim.width/24, dim.height/5+dim.height*12/24, dim.width/12, dim.height/24);
		bgCowsToHorses.setFont(new Font("SansSerif",Font.BOLD,25));
		bgCowsToHorses.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(logic.ranch.checkUnits("cows","horses")==true && logic.gamers.players[index].checkUnits("cows","horses")==true) {
					logic.ranch.tradeUnits("horses","cows");
					logic.gamers.players[index].tradeUnits("cows","horses");
					lgAnimalsError.setText("");	
						
				} else {
						lgAnimalsError.setText(logic.gamers.players[index].ErrorMessage()+logic.ranch.ErrorMessage());
				}
					
				
				
				lgHorses.setText(logic.gamers.players[index].PlayerLanguage.Horses + " - "+logic.gamers.players[index].horses);
				lgCows.setText(logic.gamers.players[index].PlayerLanguage.Cows + " - "+logic.gamers.players[index].cows);
				UpdateFarm();
				if(logic.CheckIfWin(index)==true) {
					Win();
				}
				
			}
		});
		
		panelGame.add(CowsHorses);
		CowsHorses.setBounds(dim.width*3/4-dim.width/24, dim.height/5+dim.height*13/24, dim.width/12, dim.height/24);
		CowsHorses.setText("2 <---> 1");
		CowsHorses.setFont(new Font("SansSerif",Font.BOLD,20));
		CowsHorses.setHorizontalAlignment(JLabel.CENTER);
		
		panelGame.add(bgHorsesToCows);
		bgHorsesToCows.setBounds(dim.width*3/4-dim.width/24, dim.height/5+dim.height*14/24, dim.width/12, dim.height/24);
		bgHorsesToCows.setFont(new Font("SansSerif",Font.BOLD,25));
		bgHorsesToCows.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(logic.ranch.checkUnits("horses", "cows")==true && logic.gamers.players[index].checkUnits("horses", "cows")==true) {
					logic.ranch.tradeUnits("cows", "horses");
					logic.gamers.players[index].tradeUnits("horses", "cows");
					lgAnimalsError.setText("");	
						
				} else {
						lgAnimalsError.setText(logic.gamers.players[index].ErrorMessage()+logic.ranch.ErrorMessage());
				}
					
				
				
				lgHorses.setText(logic.gamers.players[index].PlayerLanguage.Horses + " - "+logic.gamers.players[index].horses);
				lgCows.setText(logic.gamers.players[index].PlayerLanguage.Cows + " - "+logic.gamers.players[index].cows);
				UpdateFarm();
				if(logic.CheckIfWin(index)==true) {
					Win();
				}
				
			}
		});
		
		panelGame.add(bgBuySmallDog);
		bgBuySmallDog.setBounds(dim.width*3/4-dim.width/6, dim.height/5+dim.height*16/24, dim.width*3/24, dim.height/24);
		bgBuySmallDog.setFont(new Font("SansSerif",Font.BOLD,9));
		bgBuySmallDog.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(logic.gamers.players[index].smalldog==0) {
					if(logic.ranch.checkUnits("sheep","smalldog")==true && logic.gamers.players[index].checkUnits("sheep","smalldog")==true) {
						logic.ranch.smalldog--;
						logic.ranch.sheep++;
						logic.gamers.players[index].tradeUnits("sheep","smalldog");
						lgAnimalsError.setText("");	
							
					} else {
							lgAnimalsError.setText(logic.gamers.players[index].ErrorMessage()+logic.ranch.ErrorMessage());
					}
				
				}	else {
					
					lgAnimalsError.setText("You already have small dog");
				}
				
				
				lgSmallDog.setText(logic.gamers.players[index].PlayerLanguage.SmallDog + " - "+logic.gamers.players[index].smalldog);
				lgSheep.setText(logic.gamers.players[index].PlayerLanguage.Sheep + " - "+logic.gamers.players[index].sheep);
				UpdateFarm();
				
			}
		});
		
		panelGame.add(bgBuyBigDog);
		bgBuyBigDog.setBounds(dim.width*3/4+dim.width/24, dim.height/5+dim.height*16/24, dim.width*3/24, dim.height/24);
		bgBuyBigDog.setFont(new Font("SansSerif",Font.BOLD,9));
		bgBuyBigDog.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(logic.gamers.players[index].bigdog==0) {
					if(logic.ranch.checkUnits("cows","bigdog")==true && logic.gamers.players[index].checkUnits("cows","bigdog")==true) {
						logic.ranch.bigdog--;
						logic.ranch.cows++;
						logic.gamers.players[index].tradeUnits("cows","bigdog");
						lgAnimalsError.setText("");	
							
					} else {
							lgAnimalsError.setText(logic.gamers.players[index].ErrorMessage()+logic.ranch.ErrorMessage());
					}
				
				}	else {
					
					lgAnimalsError.setText("You already have big dog");
				}
				
				
				lgBigDog.setText(logic.gamers.players[index].PlayerLanguage.BigDog + " - "+logic.gamers.players[index].bigdog);
				lgCows.setText(logic.gamers.players[index].PlayerLanguage.Cows + " - "+logic.gamers.players[index].cows);
				UpdateFarm();
				
			}
		});
		
		//Buttons without Function
		
		panelGame.add(bgRabbits);
		bgRabbits.setBounds(dim.width*3/4-dim.width/6, dim.height/5 , dim.height*3/24, dim.height*3/24);
		bgRabbits.setFont(new Font("SansSerif",Font.BOLD,12));
		
		panelGame.add(bgSheep1);
		bgSheep1.setBounds(dim.width*3/4+dim.width/6-dim.height*3/24, dim.height/5, dim.height*3/24, dim.height*3/24);
		bgSheep1.setFont(new Font("SansSerif",Font.BOLD,12));
		
		panelGame.add(bgSheep2);
		bgSheep2.setBounds(dim.width*3/4-dim.width/6, dim.height/5+dim.height*4/24 , dim.height*3/24, dim.height*3/24);
		bgSheep2.setFont(new Font("SansSerif",Font.BOLD,12));
		
		panelGame.add(bgPigs1);
		bgPigs1.setBounds(dim.width*3/4+dim.width/6-dim.height*3/24, dim.height/5+dim.height*4/24, dim.height*3/24, dim.height*3/24);
		bgPigs1.setFont(new Font("SansSerif",Font.BOLD,12));
		
		panelGame.add(bgPigs2);
		bgPigs2.setBounds(dim.width*3/4-dim.width/6, dim.height/5+dim.height*8/24, dim.height*3/24, dim.height*3/24);
		bgPigs2.setFont(new Font("SansSerif",Font.BOLD,12));
		
		panelGame.add(bgCows1);
		bgCows1.setBounds(dim.width*3/4+dim.width/6-dim.height*3/24, dim.height/5+dim.height*8/24, dim.height*3/24, dim.height*3/24);
		bgCows1.setFont(new Font("SansSerif",Font.BOLD,12));
		
		panelGame.add(bgCows2);
		bgCows2.setBounds(dim.width*3/4-dim.width/6, dim.height/5+dim.height*12/24 , dim.height*3/24, dim.height*3/24);
		bgCows2.setFont(new Font("SansSerif",Font.BOLD,12));
		
		panelGame.add(bgHorses);
		bgHorses.setBounds(dim.width*3/4+dim.width/6-dim.height*3/24, dim.height/5+dim.height*12/24, dim.height*3/24, dim.height*3/24);
		bgHorses.setFont(new Font("SansSerif",Font.BOLD,12));
		
		
		
		panelGame.add(bgEndRound);
		bgEndRound.setBounds(dim.width/2-dim.width/12,dim.height/5+dim.height*3/4,dim.width/6,dim.height/24);
		bgEndRound.setFont(new Font("SansSerif",Font.BOLD,12));
		bgEndRound.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DB.AddNewMove(logic.GreenThrow, logic.RedThrow, logic.gamers.players[index]);
				index++;
				if(index==players) {
					index=0;
				} 
				lgAnimalsError.setText("");
				lg2Player.setText(logic.gamers.players[index].name +" "+ logic.gamers.players[index].PlayerLanguage.turn);
				bg2Roll.setText(logic.gamers.players[index].PlayerLanguage.RollTheDice);
				cl.show(pCont, "4");
			}
		});
	}
	
	

	void Game2() {
		//Panel Game 2
		panelGame2.setLayout(null);
		panelGame2.setBackground(Color.CYAN);
		
		panelGame2.add(bg2Roll);
		panelGame2.add(lg2Player);
		
		bg2Roll.setBounds(dim.width/2-dim.width/12, dim.height/2 + dim.height/12, dim.width/6, dim.height/10);
		lg2Player.setBounds(dim.width/2-dim.width/12, dim.height/2 - dim.height/12, dim.width/6, dim.height/10);
		
		bg2Roll.setFont(new Font("SansSerif",Font.BOLD, 22));
		lg2Player.setFont(new Font("SansSerif",Font.BOLD, 22));
		
		lg2Player.setHorizontalAlignment(JLabel.CENTER);
		
		bg2Roll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Player and dice roll
				lgPlayerName.setText(logic.gamers.players[index].name +" "+ logic.gamers.players[index].PlayerLanguage.turn);
				logic.DiceThrow();
				
				lgDice.setText(logic.gamers.players[index].PlayerLanguage.DiceRoll + LanguageDiceThrow(logic.GreenThrow)+", "+ LanguageDiceThrow(logic.RedThrow));
				
				logic.AddUnits(index);
				lgAnimalsError.setText(logic.ranch.ErrorMessage());
				
				lgRabbits.setText(logic.gamers.players[index].PlayerLanguage.Rabbits + " - " +logic.gamers.players[index].rabbits);
				lgSheep.setText(logic.gamers.players[index].PlayerLanguage.Sheep + " - " +logic.gamers.players[index].sheep);
				lgPigs.setText(logic.gamers.players[index].PlayerLanguage.Pigs + " - " +logic.gamers.players[index].pigs);
				lgCows.setText(logic.gamers.players[index].PlayerLanguage.Cows + " - " +logic.gamers.players[index].cows);
				lgHorses.setText(logic.gamers.players[index].PlayerLanguage.Horses + " - " +logic.gamers.players[index].horses);
				lgSmallDog.setText(logic.gamers.players[index].PlayerLanguage.SmallDog + " - " +logic.gamers.players[index].smalldog);
				lgBigDog.setText(logic.gamers.players[index].PlayerLanguage.BigDog + " - " +logic.gamers.players[index].bigdog);
				bgRabbits.setText(logic.gamers.players[index].PlayerLanguage.Rabbits);
				bgSheep1.setText(logic.gamers.players[index].PlayerLanguage.Sheep);
				bgSheep2.setText(logic.gamers.players[index].PlayerLanguage.Sheep);
				bgPigs1.setText(logic.gamers.players[index].PlayerLanguage.Pigs);
				bgPigs2.setText(logic.gamers.players[index].PlayerLanguage.Pigs);
				bgCows1.setText(logic.gamers.players[index].PlayerLanguage.Cows);
				bgCows2.setText(logic.gamers.players[index].PlayerLanguage.Cows);
				bgHorses.setText(logic.gamers.players[index].PlayerLanguage.Horses);
				bgBuySmallDog.setText(logic.gamers.players[index].PlayerLanguage.BuySmallDogOneSheep);
				bgBuyBigDog.setText(logic.gamers.players[index].PlayerLanguage.BuyBigDogOneCow);
				bgEndRound.setText(logic.gamers.players[index].PlayerLanguage.EndRound);
				
				
				UpdateFarm();
				
				cl.show(pCont, "5");
				
			}
		});
		
		
	}

	void GameHistory1() {
		panelGameHistory1.setLayout(null);
		panelGameHistory1.setBackground(Color.MAGENTA);
		
		panelGameHistory1.add(bgh1BackToMenu);
		panelGameHistory1.add(bgh1game1);
		panelGameHistory1.add(bgh1game2);
		panelGameHistory1.add(bgh1game3);
		panelGameHistory1.add(bgh1game4);
		panelGameHistory1.add(bgh1game5);
		panelGameHistory1.add(bgh1previous);
		panelGameHistory1.add(bgh1next);
		
		bgh1BackToMenu.setBounds(dim.height/20, dim.height/20, dim.width/8, dim.height/24);
		bgh1BackToMenu.setFont(new Font("SansSerif",Font.BOLD, 14));
		bgh1BackToMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				cl.show(pCont, "1");
				
			}
		});
		
		
		bgh1game1.setFont(new Font("SansSerif",Font.BOLD, 14));
		bgh1game1.setBounds(dim.width/4,dim.height/3,dim.width/2,dim.height/24);
		bgh1game1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(DB.getGameMoves(index+1)==true) {
					
					mhindex=0;
					MovesNameUpdate();
					cl.show(pCont, "7");
				}
			}
			
		});
		
		
		bgh1game2.setFont(new Font("SansSerif",Font.BOLD, 14));
		bgh1game2.setBounds(dim.width/4,dim.height/3+dim.height*2/24,dim.width/2,dim.height/24);
		bgh1game2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(DB.getGameMoves(index+2)==true) {
					mhindex=0;
					MovesNameUpdate();
					cl.show(pCont, "7");
				}
			}
		});
		
		
		
		bgh1game3.setFont(new Font("SansSerif",Font.BOLD, 14));
		bgh1game3.setBounds(dim.width/4,dim.height/3+dim.height*4/24,dim.width/2,dim.height/24);
		bgh1game3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(DB.getGameMoves(index+3)==true) {
					mhindex=0;
					MovesNameUpdate();
					cl.show(pCont, "7");
				}
			}
		});
		
		
		bgh1game4.setFont(new Font("SansSerif",Font.BOLD, 14));
		bgh1game4.setBounds(dim.width/4,dim.height/3+dim.height*6/24,dim.width/2,dim.height/24);
		bgh1game4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(DB.getGameMoves(index+4)==true) {
					mhindex=0;
					MovesNameUpdate();
					cl.show(pCont, "7");
				}
			}
		});
		
		
		bgh1game5.setFont(new Font("SansSerif",Font.BOLD, 14));
		bgh1game5.setBounds(dim.width/4,dim.height/3+dim.height*8/24,dim.width/2,dim.height/24);
		bgh1game5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(DB.getGameMoves(index+5)==true) {
					mhindex=0;
					MovesNameUpdate();
					cl.show(pCont, "7");
				}
			}
		});
		
		bgh1previous.setFont(new Font("SansSerif",Font.BOLD, 14));
		bgh1previous.setBounds(dim.width/4,dim.height/3+dim.height*10/24,dim.width/6,dim.height/24);
		bgh1previous.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (ghindex > 0) {
					ghindex -= 5;
					bgh1game1.setText(DB.NameOfGame(ghindex));
					bgh1game2.setText(DB.NameOfGame(ghindex+1));
					bgh1game3.setText(DB.NameOfGame(ghindex+2));
					bgh1game4.setText(DB.NameOfGame(ghindex+3));
					bgh1game5.setText(DB.NameOfGame(ghindex+4));
				}
			}
		});
		
		
		bgh1next.setFont(new Font("SansSerif",Font.BOLD, 14));
		bgh1next.setBounds(dim.width*3/4-dim.width/6,dim.height/3+dim.height*10/24,dim.width/6,dim.height/24);
		bgh1next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ghindex+=5;
				bgh1game1.setText(DB.NameOfGame(ghindex));
				bgh1game2.setText(DB.NameOfGame(ghindex+1));
				bgh1game3.setText(DB.NameOfGame(ghindex+2));
				bgh1game4.setText(DB.NameOfGame(ghindex+3));
				bgh1game5.setText(DB.NameOfGame(ghindex+4));
				
			}
		});
	}
	
	void GameHistory2() {
		panelGameHistory2.setLayout(null);
		panelGameHistory2.setBackground(Color.MAGENTA);
		
		panelGameHistory2.add(bgh2BackToGames);
		panelGameHistory2.add(lgh2move1);
		panelGameHistory2.add(lgh2move2);
		panelGameHistory2.add(lgh2move3);
		panelGameHistory2.add(lgh2move4);
		panelGameHistory2.add(lgh2move5);
		
		panelGameHistory2.add(bgh2Previous);
		panelGameHistory2.add(bgh2Next);
		
		
		
		bgh2BackToGames.setBounds(dim.height/20, dim.height/20, dim.width/8, dim.height/24);
		bgh2BackToGames.setFont(new Font("SansSerif",Font.BOLD, 14));
		bgh2BackToGames.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(pCont, "6");
				
			}
		});
		
		
		lgh2move1.setFont(new Font("SansSerif",Font.BOLD, 14));
		lgh2move1.setBounds(dim.width/6,dim.height/3,dim.width*2/3,dim.height/24);
		
				
		lgh2move2.setFont(new Font("SansSerif",Font.BOLD, 14));
		lgh2move2.setBounds(dim.width/6,dim.height/3+dim.height*2/24,dim.width*2/3,dim.height/24);		
		
		
		lgh2move3.setFont(new Font("SansSerif",Font.BOLD, 14));
		lgh2move3.setBounds(dim.width/6,dim.height/3+dim.height*4/24,dim.width*2/3,dim.height/24);
		
				
		lgh2move4.setFont(new Font("SansSerif",Font.BOLD, 14));
		lgh2move4.setBounds(dim.width/6,dim.height/3+dim.height*6/24,dim.width*2/3,dim.height/24);
		
				
		lgh2move5.setFont(new Font("SansSerif",Font.BOLD, 14));
		lgh2move5.setBounds(dim.width/6,dim.height/3+dim.height*8/24,dim.width*2/3,dim.height/24);
		
		
		bgh2Previous.setFont(new Font("SansSerif",Font.BOLD, 14));
		bgh2Previous.setBounds(dim.width/4,dim.height/3+dim.height*10/24,dim.width/6,dim.height/24);
		bgh2Previous.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (mhindex > 0) {
					mhindex -= 5;
					MovesNameUpdate();
				}
			}
		});
		
		
		bgh2Next.setFont(new Font("SansSerif",Font.BOLD, 14));
		bgh2Next.setBounds(dim.width*3/4-dim.width/6,dim.height/3+dim.height*10/24,dim.width/6,dim.height/24);
		bgh2Next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mhindex+=5;
				MovesNameUpdate();
				
			}
		});
		
		
	}
	
	void Win() {
		win = new JFrame();
		win.setTitle("WIN!");
		win.pack();
		win.setResizable(true);
		win.setVisible(true);
		
		winframe=new Dimension(dim.width*10/32,dim.height*10/36);
		win.setMinimumSize(winframe);
		
		win.add(lwinfo);
	    lwinfo.setBounds(0, winframe.height/5, winframe.width, winframe.height/5);
	    lwinfo.setText(logic.gamers.players[index].PlayerLanguage.YouWin);
	    lwinfo.setFont(new Font("SansSerif",Font.BOLD, 22));
	    lwinfo.setHorizontalAlignment(JLabel.CENTER);
	    
	    
		win.add(bwclose);
		bwclose.setText(logic.gamers.players[index].PlayerLanguage.End);
		bwclose.setBounds(winframe.width/4, winframe.height/5+winframe.height/5, winframe.width/2, winframe.height/5);
		bwclose.setFont(new Font("SansSerif",Font.BOLD, 22));
		bwclose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cl.show(pCont, "1");
				win.dispose();
			}
		});
		
		win.setLayout(null);
		
	}
	
	void UpdateFarm() {
		lgFarmRabbits.setText(logic.gamers.players[index].PlayerLanguage.Rabbits + " - " + logic.ranch.rabbits);
		lgFarmSheep.setText(logic.gamers.players[index].PlayerLanguage.Sheep + " - " + logic.ranch.sheep);
		lgFarmPigs.setText(logic.gamers.players[index].PlayerLanguage.Pigs + " - " + logic.ranch.pigs);
		lgFarmCows.setText(logic.gamers.players[index].PlayerLanguage.Cows + " - " + logic.ranch.cows);
		lgFarmHorses.setText(logic.gamers.players[index].PlayerLanguage.Horses + " - " + logic.ranch.horses);
		lgFarmSmallDog.setText(logic.gamers.players[index].PlayerLanguage.SmallDog + " - " + logic.ranch.smalldog);
		lgFarmBigDog.setText(logic.gamers.players[index].PlayerLanguage.BigDog + " - " + logic.ranch.bigdog);
	}
	void MovesNameUpdate() {
		lgh2move1.setText(DB.NameOfMoves(mhindex));
		lgh2move2.setText(DB.NameOfMoves(mhindex+1));
		lgh2move3.setText(DB.NameOfMoves(mhindex+2));
		lgh2move4.setText(DB.NameOfMoves(mhindex+3));
		lgh2move5.setText(DB.NameOfMoves(mhindex+4));
	}
	
	String LanguageDiceThrow(String name) {
		String a = new String();
		switch(name) {
		case "rabbit":
			a = logic.gamers.players[index].PlayerLanguage.Rabbit;
			break;
		case "sheep":
			a = logic.gamers.players[index].PlayerLanguage.Sheep;
			break;
		case "pig":
			a = logic.gamers.players[index].PlayerLanguage.Pig;
			break;
		case "cow":
			a = logic.gamers.players[index].PlayerLanguage.Cow;
			break;
		case "horse":
			a = logic.gamers.players[index].PlayerLanguage.Horse;
			break;
		case "fox":
			a = logic.gamers.players[index].PlayerLanguage.Fox;
			break;
		case "wolf":
			a = logic.gamers.players[index].PlayerLanguage.Wolf;
			break;
		}
		return a;
		
		
	}
}
