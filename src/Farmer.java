import javax.swing.SwingUtilities;


//Main class

public class Farmer {
	
	
	
	public static void main(String[] args) {
		
	
	
		
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new CLayout();
				
			}
		});
		
		
//		ListOfLanguages first = new ListOfLanguages();
//		first.getList();
//		
//		for(int i =0; i<first.pathnames.length;i++) {
//			System.out.println(first.pathnames[i]);
//		}
//		
		
		
		
//		Window okno = new Window(); 
//		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		okno.setVisible(true);
		
		
//		GreenDice GD = new GreenDice();
//		System.out.println(GD.ThrowDice(3));
//		
		
//		System.out.println("FARMER");
//		Scanner scanner = new Scanner(System.in);
//		try {
//		
//		boolean game = true;
//		int option;
//		while(game ==true) {
//			System.out.println("Type 1 to start new game");
//			System.out.println("Type 2 to end");
//			
//			option=scanner.nextInt();
//			
//			if(option==1) {
//				System.out.println("How many players? ( 2 - 6)");
//				int nop=scanner.nextInt();
//				
//				if(nop>=2 && nop<=6) {
//									
//					Game first= new Game(nop);
//					first.moves();
//				}
//				
//			} else if (option==2){
//				break;
//			} else {
//				System.out.println("Write correct command");
//			}
//			
//		}
//		} finally {
//			scanner.close();
//		}
		
    }

}

