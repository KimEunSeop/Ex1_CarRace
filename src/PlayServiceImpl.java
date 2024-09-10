import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PlayServiceImpl implements PlayService {

    private List<Car> createCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        carNames.stream()
                .map(Car::new)          // 각 문자열을 Car 객체로 변환
                .forEach(carList::add);  // carList에 각 Car 객체를 추가
        return carList;
    }

    @Override
    public void start() {
        InputData inputData = getInputData();
        playRound(inputData.getAttempts(), createCars(inputData.getCarNames()));
    }

    private List<String> parseCarNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)   // 각 문자열의 앞뒤 공백을 제거
                .collect(Collectors.toList());  // 결과를 리스트로 수집
    }

    private InputData getInputData() {
        InputValidator inputValidator = new InputValidator();
        Scanner scanner = new Scanner(System.in);

        System.out.print("자동차 이름 쉼표로 구분하여 입력: ");
        String input = scanner.nextLine();
        List<String> carNames = parseCarNames(input);  // 이름 파싱 함수 호출
        inputValidator.checkCarNames(carNames);  // 자동차 이름 검증

        System.out.print("시도할 횟수를 입력: ");
        int attempts = scanner.nextInt();
        inputValidator.checkNumberOfAttempts(attempts);  // 시도 횟수 검증

        scanner.close();
        return new InputData(carNames, attempts);
    }

    @Override
    public void playRound(int attempts, List<Car> carList) { // 경주 시작
        Race race = new Race(attempts, carList);
        race.play();
    }
}
