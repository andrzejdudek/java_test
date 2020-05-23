
public class GreenDice {
	
	String[] fields;
	
	public GreenDice(){
		fields = new String[12];
//		for(int i=0;i<12;i++) {
//			fields[i]=new String();
//		}
		int index=0;
		for(int i=0;i<6;i++) {
			fields[index++]="rabbit";
		}
		for(int i=0;i<3;i++) {
			fields[index++]="sheep";
		}
		fields[index++]="pig";
		fields[index++]="cow";
		fields[index++]="wolf";
		
		//{"rabbit","rabbit","rabbit","rabbit","rabbit","rabbit","sheep","sheep","sheep","pig","cow","wolf"};
	}
	
	String ThrowDice(int a) {
		return fields[a];
	}


}

