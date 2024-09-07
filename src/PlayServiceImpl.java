import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayServiceImpl implements PlayService {
    private int n;
    private CarManager carManager = new CarManager();
    private InputCheck inputCheck = new InputCheck();

    @Override
    public void start() { // 경주 시작 전 정보 입력
        Scanner scanner = new Scanner(System.in);
        List<String> carNames = new ArrayList<>();

        System.out.print("자동차 이름 쉼표로 구분하여 입력: ");
        String input = scanner.nextLine();

        String[] names = input.split(","); // 쉼표를 기준으로 문자열을 나눔

        try {
            for (String name : names) {
                carNames.add(name.trim());
            }
            inputCheck.checkCarNames(carNames);

            System.out.print("시도할 횟수를 입력: ");
            n = scanner.nextInt();
            inputCheck.checkNumberOfAttempts(n);

        } catch (IllegalArgumentException e) {
            System.out.println("에러: " + e.getMessage());
        } finally {
            scanner.close();
        }

        carManager.createCars(carNames);
    }

    @Override
    public void playRound() { // 경주 시작
        Race race = new Race(n, carManager);
        race.playRound();
    }
}
