import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PlayService {// 얜 뭐하는 클래스지

    public void play() {
        InputData inputData = getInputData();
        CarManager carManager = new CarManager(inputData.getCarNames());
        Race race = new Race(inputData.getAttempts(), carManager.getCarList());
        race.play();
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
}
