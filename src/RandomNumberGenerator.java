import java.util.Random;

public class RandomNumberGenerator {

    private static final int MAX_NUM = 10;
    private static final Random random = new Random();


    private RandomNumberGenerator() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static int generateRandomInt() {
        return random.nextInt(MAX_NUM);
    }
}
