import java.util.Random;

public class RandomNumberGenerator {

    private static int MAX_NUM = 10;
    Random random = new Random();
    public int generateRandomInt() {
        return random.nextInt(MAX_NUM);
    }
}
