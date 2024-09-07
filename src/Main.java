import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlayServiceImpl playService = new PlayServiceImpl();

        playService.start();

        playService.playRound();

    }
}