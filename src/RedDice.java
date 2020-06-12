
public class RedDice {
	
	private	String[] fields;
	public RedDice(){
		fields = new String[12];
		int index=0;
		for(int i=0;i<6;i++) {
			fields[index++]="rabbit";
			
		}
		for(int i=0;i<2;i++) {
			fields[index++]="sheep";
		}
		for(int i=0;i<2;i++) {
			fields[index++]="pig";
		}
		fields[index++]="horse";
		fields[index++]="fox";
		
//		 = {"rabbit","rabbit","rabbit","rabbit","rabbit","rabbit","sheep","sheep","pig","pig","horse","fox"};
	}	
	
	String ThrowDice(int a) {
		return fields[a];
	}


}
