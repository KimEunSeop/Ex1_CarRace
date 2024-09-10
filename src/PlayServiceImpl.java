import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PlayServiceImpl implements PlayService {
    private List<Car> carList = new ArrayList<>();

    private void createCars(List<String> carNames) {
        carNames.stream()
                .map(Car::new)          // 각 문자열을 Car 객체로 변환
                .forEach(carList::add);  // carList에 각 Car 객체를 추가

    }

    @Override
    public void start() {
        InputData inputData = getInputData();
        createCars(inputData.getCarNames());
        int attempts = inputData.getAttempts();
        playRace(attempts);
    }

    private InputData getInputData() {
        InputValidator inputValidator = new InputValidator();
        Scanner scanner = new Scanner(System.in);
        List<String> carNames = new ArrayList<>();
        int attempts = 0;

        try {
            // 자동차 이름 입력
            System.out.print("자동차 이름 쉼표로 구분하여 입력: ");
            String input = scanner.nextLine();
            String[] names = input.split(",");

            carNames.addAll(Arrays.stream(names)
                    .map(String::trim)   // 각 문자열의 앞뒤 공백을 제거
                    .collect(Collectors.toList()));  // 결과를 리스트로 수집

            inputValidator.checkCarNames(carNames);

            // 시도 횟수 입력
            System.out.print("시도할 횟수를 입력: ");
            attempts = scanner.nextInt();
            inputValidator.checkNumberOfAttempts(attempts);

        } catch (IllegalArgumentException e) {
            System.out.println("에러: " + e.getMessage());
            return getInputData();  // 잘못된 입력이 있으면 다시 입력받음
        } finally {
            scanner.close();
        }

        return new InputData(carNames, attempts);
    }

    @Override
    public void playRace(int attempts) { // 경주 시작
        Race race = new Race(attempts, carList);
        race.play();
    }
}
