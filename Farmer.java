
import java.util.Scanner;
//Main class

public class Farmer {

	public static void main(String[] args) {
			
//		GreenDice GD = new GreenDice();
//		System.out.println(GD.ThrowDice(3));
//		
		
		Scanner scanner = new Scanner(System.in);
		try {
		System.out.println("FARMER");
		
		boolean game = true;
		int option;
		while(game ==true) {
			System.out.println("Type 1 to start new game");
			System.out.println("Type 2 to end");
			
			option=scanner.nextInt();
			
			if(option==1) {
				System.out.println("How many players? ( 2 - 6)");
				int nop=scanner.nextInt();
				
				if(nop>=2 && nop<=6) {
									
					Game first= new Game(nop);
					first.moves();
				}
				
			} else if (option==2){
				break;
			} else {
				System.out.println("Write correct command");
			}
			
		}
		} finally {
			scanner.close();
		}
		
    }

}

