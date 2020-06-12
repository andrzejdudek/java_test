import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class Language {
	String LanguageName = new String();

	String NewGame = new String();
	String GameHistory = new String();
	String Exit = new String();

	String HowManyPlayers = new String();
	String Accept = new String();

	String Player = new String();
	String Name = new String();

	String turn = new String();
	String RollTheDice = new String();

	String DiceRoll = new String();

	String Rabbit = new String();
	String Pig = new String();
	String Cow = new String();
	String Horse = new String();
	String Wolf = new String();
	String Fox = new String();

	String Rabbits = new String();
	String Sheep = new String();
	String Pigs = new String();
	String Cows = new String();
	String Horses = new String();
	String SmallDog = new String();
	String BigDog = new String();
	String Farm = new String();

	String BuySmallDogOneSheep = new String();
	String BuyBigDogOneCow = new String();

	String EndRound = new String();

	String NotEnoughRabbits = new String();
	String NotEnoughSheep = new String();
	String NotEnoughPigs = new String();
	String NotEnoughCows = new String();
	String NotEnoughHorses = new String();
	String NotEnoughSmallDogs = new String();
	String NotEnoughBigDogs = new String();
	String OnFarm = new String();

	String YouWin = new String();
	String End = new String();

	public Language() {
	}

	public Language(String language) {
		SetLanguage(language);
	}

	void SetLanguage(String language) {
		
		FileInputStream fis = null;
		File LanguageFile = null;
		String FileName = language + ".properties";
		
		try {
			LanguageFile = new File(FileName);
			fis = new FileInputStream(LanguageFile);
			Properties prop = new Properties();
			
			prop.load(new InputStreamReader(fis, Charset.forName("UTF-8")));
			
			LanguageName = prop.getProperty("Language");
			
			NewGame = prop.getProperty("NewGame");
			GameHistory = prop.getProperty("GameHistory");
			Exit = prop.getProperty("Exit");
			HowManyPlayers = prop.getProperty("HowManyPlayers");
			Accept = prop.getProperty("Accept");

			Player = prop.getProperty("Player");
			Name = prop.getProperty("Name");

			turn = prop.getProperty("turn");
			RollTheDice = prop.getProperty("RollTheDice");

			DiceRoll = prop.getProperty("DiceRoll");

			Rabbit = prop.getProperty("Rabbit");
			Pig = prop.getProperty("Pig");
			Cow = prop.getProperty("Cow");
			Horse = prop.getProperty("Horse");
			Wolf = prop.getProperty("Wolf");
			Fox = prop.getProperty("Fox");
			
			Rabbits = prop.getProperty("Rabbits");
			Sheep = prop.getProperty("Sheep");
			Pigs = prop.getProperty("Pigs");
			Cows = prop.getProperty("Cows");
			Horses = prop.getProperty("Horses");
			SmallDog = prop.getProperty("SmallDog");
			BigDog = prop.getProperty("BigDog");
			Farm = prop.getProperty("Farm");

			BuySmallDogOneSheep = prop.getProperty("BuySmallDogOneSheep");
			BuyBigDogOneCow = prop.getProperty("BuyBigDogOneCow");

			EndRound = prop.getProperty("EndRound");

			NotEnoughRabbits = prop.getProperty("NotEnoughRabbits");
			NotEnoughSheep = prop.getProperty("NotEnoughSheep");
			NotEnoughPigs = prop.getProperty("NotEnoughPigs");
			NotEnoughCows = prop.getProperty("NotEnoughCows");
			NotEnoughHorses = prop.getProperty("NotEnoughHorses");
			NotEnoughSmallDogs = prop.getProperty("NotEnoughSmallDogs");
			NotEnoughBigDogs = prop.getProperty("NotEnoughBigDogs");
			OnFarm = prop.getProperty("OnFarm");

			YouWin = prop.getProperty("YouWin");
			End = prop.getProperty("End");

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
