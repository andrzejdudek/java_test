import java.util.Random;

public class Rand {
	Random generator = new Random();
	
	int DiceThrow() {
		return generator.nextInt(120)%12;
	}
}
