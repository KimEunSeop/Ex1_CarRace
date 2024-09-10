import java.util.Random;

public class GenerateRandomInt implements GeneratNumber{

    Random random = new Random();
    @Override
    public int generateNumber() {
        int randomIntNum = random.nextInt(10);
        return randomIntNum;
    }
}
