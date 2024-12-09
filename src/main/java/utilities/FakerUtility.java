package utilities;

import java.util.Random;

public class FakerUtility {
	 public static int randomNumberGenerator() {
		Random random = new Random();
		int ranNumber = random.nextInt(10000);
		return ranNumber;
	}
}
