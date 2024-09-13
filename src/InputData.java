import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputData {
    private List<String> carNames;
    private int attempts;

    public InputData() {
        setInputData();
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getAttempts() {
        return attempts;
    }

    private void setInputData() {
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

        this.carNames = carNames;
        this.attempts = attempts;
    }

    private List<String> parseCarNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)   // 각 문자열의 앞뒤 공백을 제거
                .collect(Collectors.toList());  // 결과를 리스트로 수집
    }
}
